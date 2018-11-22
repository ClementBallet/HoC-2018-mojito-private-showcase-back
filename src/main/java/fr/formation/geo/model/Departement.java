package fr.formation.geo.model;

import fr.formation.artiste.Artiste;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Departement.
 */
@Entity
@Table(name = "departement")
public class Departement implements Serializable {

    private static final long serialVersionUID = 3803217955823414799L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom", nullable = false, unique = true)
    private String nom;

    @Column(name = "code_region", nullable = false, unique = true)
    private String codeRegion;


//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_artist", nullable = true)
//    private Artiste artiste;

    /**
     * Create a Departement
     *
     * @param nom        the nom
     * @param codeRegion the code region
     */
    public Departement(String nom, String codeRegion) {
        this.nom = nom;
        this.codeRegion = codeRegion;
    }

    /**
     * Create a Departement
     */
    public Departement() {
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


    /**
     * Gets code region.
     *
     * @return the code region
     */
    public String getCodeRegion() {
        return codeRegion;
    }

    /**
     * Sets code region.
     *
     * @param codeRegion the code region
     */
    public void setCodeRegion(String codeRegion) {
        this.codeRegion = codeRegion;
    }

//    /**
//     * get artiste
//     *
//     * @return
//     */
//    public Artiste getArtiste() {
//        return artiste;
//    }
//
//    /**
//     * set artiste.
//     *
//     * @param artiste
//     */
//    public void setArtiste(Artiste artiste) {
//        this.artiste = artiste;
//    }
}
