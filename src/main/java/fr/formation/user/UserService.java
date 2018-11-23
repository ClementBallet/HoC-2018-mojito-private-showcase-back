package fr.formation.user;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.formation.artiste.Artiste;
import fr.formation.artiste.ArtisteRepository;
import fr.formation.user.dto.UserUpdateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import fr.formation.security.SecurityConstants;


/**
 * @author Tareq
 * The type User service.
 */
@Service
public class UserService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private static final  String strRegEx = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    private UserRoleRepository userRoleRepository;

    private ArtisteRepository artisteRepository;

    /**
     * Instantiates a new User service.
     *
     * @param userRepository     the user repository
     * @param userRoleRepository the user role repository
     */
    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * transform a list of roles (as {@link String}) into a list of
     * {@link GrantedAuthority}
     *
     * @param userRoles
     * @return
     */
    private static Collection<? extends GrantedAuthority> transformToAuthorities(List<String> userRoles) {
        String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user != null) {
            List<String> roles = userRoleRepository.findRoleByUserName(username);
            return new org.springframework.security.core.userdetails.User(username, user.getPassword(),
                    transformToAuthorities(roles));
        } else {
            throw new UsernameNotFoundException("No user exists with username: " + username);
        }

    }

    /**
     * add new user.
     * @param user
     * @return
     */
    public User addNewUser(User user) {

        // 1- controles
        // Check validité du password, si non valide => jette une erreur
        if (user.getPassword() == null || !user.getPassword().matches(UserService.strRegEx)) {
            throw new IllegalArgumentException("Le format du mot de passe n'est pas valide");
        }

        // TODO: Add control to non nullable column

        // 2- Encrypt password
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        try {
            user = userRepository.save(user);
        } catch (Exception ex) {
            // TODO: Specialize exception
            log.error("column contraint" , ex);
        }

        // 3- Création du role associé au user
        UserRole userRole = new UserRole();
        userRole.setRole(SecurityConstants.ROLE_USER);
        userRole.setUserId(user.getId());
        userRoleRepository.save(userRole);

        return user;
    }

    /**
     * récuperation du user par son username
     * @param username
     * @return
     */
    public User getUserByUsername(final String username) {


        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user;
        }

        throw new UsernameNotFoundException("Le user avec le username " + username + " n'existe pas");
    }

    /**
     * update user
     */
    public void updateUser(User user, UserUpdateDTO updateUser) {

        String currentPassword = user.getPassword();
        String currentEmail = user.getEmail();

        if (passwordEncoder.matches(updateUser.getAncien_password(), currentPassword))
        {
            if (currentEmail.equals(updateUser.getNouveau_email()))
            {
                if (updateUser.getNouveau_password().matches(strRegEx))
                {
                    user.setPassword(passwordEncoder.encode(updateUser.getNouveau_password()));
                    userRepository.save(user);
                }
                else
                {
                    log.info("Le mot de pass ne rempli pas les critères");
                }
            }
            else
            {
                log.info("Email est invalide");
            }
        }
        else
        {
            log.info("Mot de pass actuel invalide");
        }
    }

    /**
     * @param user
     */
    public void deleteUser(User user) {

        this.userRepository.delete(user);

    }
}