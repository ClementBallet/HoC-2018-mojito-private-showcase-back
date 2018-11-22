package fr.formation.event;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Clément
 */
public interface EventRepository extends JpaRepository<Event, Long> {

}
