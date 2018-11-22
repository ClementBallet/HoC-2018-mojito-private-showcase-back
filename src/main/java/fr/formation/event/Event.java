package fr.formation.event;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Clément
 * Model de la table Event
 */
@Entity
@Table(name = "event")
public class Event {

    /**
     * Génération des champs
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date_event", nullable = false)
    private Timestamp dateEvent;

    @Column(name = "nb_pers_max", nullable = false)
    private Integer nbPersMax;

    /**
     * GETTERS & SETTERS
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Timestamp dateEvent) {
        this.dateEvent = dateEvent;
    }

    public Integer getNbPersMax() {
        return nbPersMax;
    }

    public void setNbPersMax(Integer nbPersMax) {
        this.nbPersMax = nbPersMax;
    }
}
