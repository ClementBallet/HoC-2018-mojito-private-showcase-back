package fr.formation.user;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Signup.
	 *
	 * @param username the username
	 * @param password the password
	 * @param roles    the roles
	 */
	@PostMapping("/add/{userKey}")
	public void signup(@PathVariable("userKey") String username, @RequestParam String password,
										 @RequestParam String... roles) {

		userService.addNewUser(username, password, roles);

	}
	
	/**
	 * getUser.
	 *
	 * @param username the username
	 * @param password the password
	 * @param roles    the roles
	 */
	@PutMapping("/get/{userKey}")
	public void getUser(@PathVariable("userKey") String username, @RequestParam String password,
										 @RequestParam String... roles) {

		userService.getUser(username, password, roles);

	}
	
	
	/**
	 * updateUser.
	 *
	 * @param username the username
	 * @param password the password
	 * @param roles    the roles
	 */
	@PutMapping("/update/{userKey}")
	public void updateUser(@PathVariable("userKey") String username, @RequestParam String password,
										 @RequestParam String... roles) {

		userService.updateUser(username, password, roles);

	}
	
	/**
	 * deleteUser.
	 *
	 * @param username the username
	 * @param password the password
	 * @param roles    the roles
	 */
	@PutMapping("/delete/{userKey}")
	public void deleteUser(@PathVariable("userKey") String username, @RequestParam String password,
										 @RequestParam String... roles) {

		userService.deleteUser(username, password, roles);

	}
	

}
