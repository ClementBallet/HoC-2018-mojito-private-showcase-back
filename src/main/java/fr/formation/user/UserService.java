package fr.formation.user;

import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import fr.formation.security.SecurityConstants;

/**
 * The type User service.
 */
@Service
public class UserService implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	private UserRepository userRepository;

	private UserRoleRepository userRoleRepository;

	/**
	 * Instantiates a new User service.
	 *
	 * @param userRepository     the user repository
	 * @param userRoleRepository the user role repository
	 */
	@Autowired
	public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
	}

	/**
	 * transform a list of roles (as {@link String}) into a list of
	 * {@link GrantedAuthority}
	 *
	 * @param userRoles
	 *
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
	 * 
	 * @param username
	 * @param password
	 * @param email
	 * @param ville
	 * @param code_postaux
	 * @param code_ville
	 * @param code_departement
	 * @param roles
	 */
	public User addNewUser(String username, String password, String email, String ville, String code_postaux,
			String code_ville, String code_departement) {

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setVille(ville);
		user.setCodePostaux(code_postaux);
		user.setCodeVille(code_ville);
		user.setCodeDepartement(code_departement);
		user = userRepository.save(user);
		
		UserRole userRole = new UserRole();
		userRole.setRole(SecurityConstants.ROLE_USER);
		userRole.setUserId(user.getId());

		userRoleRepository.save(userRole);
	
		
		return user;

	}

	/**
	 * get user by id.
	 * 
	 * @param id_user
	 * @return
	 */
	public User getUser(Long id_user) {

		return this.userRepository.getOne(id_user);

	}

	/**
	 * update user
	 * 
	 * @param id_user
	 * @param ancien_password
	 * @param nouveau_password
	 * @param confirm_password
	 * @param email
	 */
	public void updateUser(Long id_user, String ancien_password, String nouveau_password, String confirm_password,
			String email) {

		User user = this.userRepository.getOne(id_user);
		String currentPassword = user.getPassword();
		String currentEmail = user.getEmail();

		if (currentPassword == ancien_password && currentEmail == email) {

			if (nouveau_password == confirm_password) {

				user.setPassword(nouveau_password);
				userRepository.save(user);
			} else {
				log.info("les deux mots de pass ne sont pas identiques");
			}
		} else {
			log.info("mot de pass et/ou email sont invalides");

		}

	}

	/**
	 * 
	 * @param id_user
	 */
	public void deleteUser(Long id_user) {

		User user = this.userRepository.getOne(id_user);
		this.userRepository.delete(user);

	}
}