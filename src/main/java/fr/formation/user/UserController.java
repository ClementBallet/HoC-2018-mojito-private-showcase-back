package fr.formation.user;

import fr.formation.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
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
     * s get user.
     */
    @GetMapping("/authenticated")
    @Secured(SecurityConstants.ROLE_USER)
    public User getUser() {
        return userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    /**
     * update user.
     *
     * @param id_user
     * @param ancien_password
     * @param nouveau_password
     * @param confirm_password
     * @param email
     */
    @PostMapping("/update/{id_user}")
    @Secured(SecurityConstants.ROLE_USER)
    public void updateUser(@PathVariable("id_user") Long id_user, @RequestParam String ancien_password,
                           @RequestParam String nouveau_password, @RequestParam String confirm_password, @RequestParam String email) {

        userService.updateUser(id_user, ancien_password, nouveau_password, confirm_password, email);

    }

    /**
     * delete user.
     *
     * @param id_user
     */
    @DeleteMapping("/{id_user}")
    @Secured(SecurityConstants.ROLE_USER)
    public void deleteUser(@PathVariable("id_user") Long id_user) {

        userService.deleteUser(id_user);

    }

}
