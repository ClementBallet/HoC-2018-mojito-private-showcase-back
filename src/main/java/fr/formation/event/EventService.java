package fr.formation.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @author Clément
 */
@Service
public class EventService {

    private EventRepository eventRepository;

    /**
     * Instancie un nouveau EventRepository
     *
     * @param eventRepository
     */
    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /**
     * Sauvegarder un event en BDD et le retourne
     *
     * @param dateEvent
     * @param nbPersMax
     * @return Event
     */
    public Event createNewEvent(Timestamp dateEvent, Integer nbPersMax) {

        Event event = new Event();
        event.setDateEvent(dateEvent);
        event.setNbPersMax(nbPersMax);

        return eventRepository.save(event);
    }

    /**
     * Retourne les informations d'un event inscrits en BDD
     *
     * @param idEvent
     * @return Event
     */
    public Event getEvent(Long idEvent) {
        return eventRepository.getOne(idEvent);
    }

    /**
     * Met à jour un event en BDD
     *
     * @param idEvent
     * @param dateEvent
     * @param nbPersMax
     */
    public void updateEvent(Long idEvent, Timestamp dateEvent, Integer nbPersMax) {

        Event event = eventRepository.getOne(idEvent);

        if (dateEvent != null) event.setDateEvent(dateEvent);
        if (nbPersMax != null) event.setNbPersMax(nbPersMax);

        eventRepository.saveAndFlush(event);
    }

    /**
     * Supprime un event en BDD
     *
     * @param idEvent
     */
    public void deleteEvent(Long idEvent) {

        Event event = eventRepository.getOne(idEvent);
        eventRepository.delete(event);
    }
}
