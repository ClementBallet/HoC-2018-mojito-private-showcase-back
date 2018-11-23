package fr.formation.user;

import fr.formation.controllers.AbstractController;
import fr.formation.security.SecurityConstants;
import fr.formation.user.dto.UserUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tareq
 * The type User controller.
 */
@RestController
@RequestMapping("/users")
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;


    /**
     * add user.
     * @param user
     */
    @PutMapping("")
    public void signup(@RequestBody(required = true) User user) {

        // 1- Check args
        Assert.notNull(user, "Le user ne peut pas être null");

        // 2- Create User
        userService.addNewUser(user);
    }

    /**
     * get user.
     */
    @GetMapping("/authenticated")
    @Secured(SecurityConstants.ROLE_USER)
    public User getUser() {
        return super.getAuthenticatedUser();
    }

    /**
     * update user
     */
    @PutMapping("/authenticated")
    @Secured(SecurityConstants.ROLE_USER)
    public void updateUser(@RequestBody(required = true) UserUpdateDTO updateUser) {

        Assert.notNull(updateUser, "Les champs de mise à jour de l'utilisateur ne peuvent pas être null.");
        userService.updateUser(super.getAuthenticatedUser(), updateUser);
    }

    /**
     * delete user
     */
    @DeleteMapping("/authenticated")
    @Secured(SecurityConstants.ROLE_USER)
    public void deleteUser() {
      
        User user = super.getAuthenticatedUser();
        userService.deleteUser(user);
    }

}
