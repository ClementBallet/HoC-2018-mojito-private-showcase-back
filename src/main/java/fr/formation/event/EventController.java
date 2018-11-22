package fr.formation.event;

import fr.formation.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

/**
 * @author Clément
 * Rest Controller Event
 * Envoie les infos relatives aux events
 */
@RestController
@Secured(SecurityConstants.ROLE_USER)
@RequestMapping("/events")
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("")
    public Event createNewEvent(Timestamp dateEvent, Integer nbPersMax) {
        return eventService.createNewEvent(dateEvent, nbPersMax);
    }

    @GetMapping("/{idEvent}")
    public Event getEvent(@PathVariable Long idEvent) {
        return eventService.getEvent(idEvent);
    }

    @PutMapping("/{idEvent}")
    public void updateEvent(@PathVariable Long idEvent,
                            @RequestParam("dateEvent") Timestamp dateEvent,
                            @RequestParam("nbPersMax") Integer nbPersMax) {
        eventService.updateEvent(idEvent, dateEvent, nbPersMax);
    }

    @DeleteMapping("/{idEvent}")
    public void deleteEvent(@PathVariable Long idEvent) {
        eventService.deleteEvent(idEvent);
    }
}
