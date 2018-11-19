package fr.formation.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * The type User.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "pseudo", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	@JsonIgnore
	private String password;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "ville", nullable = false)
	private String ville;

	@Column(name = "code_postaux", nullable = false)
	private String code_postaux;

	@Column(name = "code_ville", nullable = false)
	private String code_ville;

	@Column(name = "code_departement", nullable = true)
	private String code_departement;


//	@OneToOne(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY)
//	@JoinColumn(name="Id_artist")
//	private Artiste artiste;

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
	 * @param password the ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Gets code_postaux.
	 *
	 * @return the code_postaux
	 */
	public String getCodePostaux() {
		return code_postaux;
	}

	/**
	 * Sets code_postaux.
	 *
	 * @param password the code_postaux
	 */
	public void setCodePostaux(String code_postaux) {
		this.code_postaux = code_postaux;
	}

	/**
	 * Gets code_ville.
	 *
	 * @return the code_ville
	 */
	public String getCodeVille() {
		return code_ville;
	}

	/**
	 * Sets code_ville.
	 *
	 * @param code_ville the code_ville
	 */
	public void setCodeVille(String code_ville) {
		this.code_ville = code_ville;
	}

	/**
	 * Gets code_departement.
	 *
	 * @return the code_departement
	 */
	public String getCodeDepartement() {
		return code_departement;
	}

	/**
	 * Sets code_departement.
	 *
	 * @param code_departement the code_departement
	 */
	public void setCodeDepartement(String code_departement) {
		this.code_departement = code_departement;
	}

//	/**
//	 * Gets artiste.
//	 *
//	 * @return the artiste
//	 */
//	public Artiste getArtiste() {
//		return artiste;
//	}
//
//	/**
//	 * Sets artiste.
//	 *
//	 * @param artiste the artiste
//	 */
//	public void setArtiste(String artiste) {
//		this.artiste = artiste;
//	}


}
