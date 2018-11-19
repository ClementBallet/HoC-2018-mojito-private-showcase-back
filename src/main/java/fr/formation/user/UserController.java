package fr.formation.user;

import fr.formation.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type User controller.
 */
@RestController
@Secured(SecurityConstants.ROLE_USER)
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;


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
	 */
	@PutMapping("")
	public User signup(
			@RequestParam(required = true) String username,
			@RequestParam(required = true) String password,
			@RequestParam(required = true) String email,
			@RequestParam(required = true) String ville,
			@RequestParam(required = true) String code_postaux,
			@RequestParam(required = true) String code_ville,
			@RequestParam(required = true) String code_departement) {

		return userService.addNewUser(username, password, email, ville, code_postaux, code_ville, code_departement);

	}

	/**
	 * s get user.
	 *
	 * @param id_user
	 */
	@GetMapping("/{id_user}")
	public User getUser(@PathVariable("id_user") Long id_user) {

		return userService.getUser(id_user);

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
	public void deleteUser(@PathVariable("id_user") Long id_user) {

		userService.deleteUser(id_user);

	}

}
