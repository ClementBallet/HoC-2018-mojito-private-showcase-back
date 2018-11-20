package fr.formation;

//import fr.formation.security.SecurityConstants;
import fr.formation.user.User;
import fr.formation.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


/**
 * This class configure the dataset at application start
 */
@Component
public class BoostrapData {

	private UserService userService;

	/**
	 * Instantiates a new Boostrap data.
	 *
	 * @param userService     the user service
	 */
	@Autowired
	public BoostrapData(UserService userService) {
		this.userService = userService;
	}

	/**
	 * On start.
	 */
	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {

		User userAdmin = new User();
		userAdmin.setUsername("admin");
		userAdmin.setPassword("aA123456");
		userAdmin.setEmail("t@t.fr");
		userAdmin.setVille("Amiens");
		userAdmin.setCodeVille("021");

		User user = new User();
		user.setUsername("user");
		user.setPassword("aA123456");
		user.setEmail("t@t.fr");
		user.setVille("Amiens");
		user.setCodeVille("021");

		userService.addNewUser(userAdmin);
		userService.addNewUser(user);
	}
}

