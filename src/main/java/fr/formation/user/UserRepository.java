package fr.formation.user;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Tareq
 * The interface User repository.
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Find by username user.
	 *
	 * @param username the username
	 *
	 * @return the user
	 */
	User findByUsername(String username);


}
