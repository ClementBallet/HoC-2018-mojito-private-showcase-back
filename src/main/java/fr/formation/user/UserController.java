package fr.formation.user;

import fr.formation.security.SecurityConstants;
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
public class UserController {

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
        return userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    /**
     * update user.
     *
     * @param ancien_password
     * @param nouveau_password
     * @param confirm_password
     * @param email
     */
    @PutMapping("/authenticated")
    @Secured(SecurityConstants.ROLE_USER)
    public void updateUser(@RequestParam String ancien_password,
                           @RequestParam String nouveau_password,
                           @RequestParam String confirm_password,
                           @RequestParam String email) {

        User user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        userService.updateUser(user, ancien_password, nouveau_password, confirm_password, email);
    }

    /**
     * delete user.
     *
     * @param username
     */
    @DeleteMapping("/authenticated")
    @Secured(SecurityConstants.ROLE_USER)
    public void deleteUser() {

        User user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        userService.deleteUser(user);
    }

}
