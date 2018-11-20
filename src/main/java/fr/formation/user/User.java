package fr.formation.user;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.formation.artiste.Artiste;

/**
 * The type User.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 3803217955823414799L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pseudo", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "ville", nullable = false)
    private String ville;

    @Column(name = "code_ville", nullable = false)
    private String codeVille;

    @Column(name = "code_departement", nullable = true)
    private String codeDepartement;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_artist", nullable = true)
    private Artiste artiste;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets pseudo.
     *
     * @return the pseudo
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets ville.
     *
     * @return the ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * Sets ville.
     *
     * @param ville the ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * Gets code_ville.
     *
     * @return the code_ville
     */
    public String getCodeVille() {
        return codeVille;
    }

    /**
     * Sets code_ville.
     *
     * @param code_ville the code_ville
     */
    public void setCodeVille(String code_ville) {
        this.codeVille = code_ville;
    }

    /**
     * Gets code_departement.
     *
     * @return the code_departement
     */
    public String getCodeDepartement() {
        return codeDepartement;
    }

    /**
     * Sets code_departement.
     *
     * @param code_departement the code_departement
     */
    public void setCodeDepartement(String code_departement) {
        this.codeDepartement = code_departement;
    }

	/**
	 * Gets artiste.
	 *
	 * @return the artiste
	 */
	public Artiste getArtiste() {
		return artiste;
	}

	/**
	 * Sets artiste.
	 *
	 * @param artiste the artiste
	 */
	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}



}
