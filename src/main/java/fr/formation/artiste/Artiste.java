package fr.formation.artiste;

import javax.persistence.*;

import fr.formation.user.User;

/**
 * @author Clément
 *	Model de la table Artiste
 */
@Entity
@Table(name = "artiste")
public class Artiste {
	
	/**
	 * Génération des champs
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "artiste_nom", nullable = false, unique = true)
	private String artiste_nom;
	
	@Column(name = "description_courte", length = 150, nullable = true)
	private String description_courte;
	
	@Column(name = "description_longue", length = 1000, nullable = true)
	private String description_longue;
	
	@Column(name = "site_web", nullable = true)
	private String site_web;
	
	@Column(name = "telephone", nullable = true)
	private String telephone;
	
	@Column(name = "email", nullable = true)
	private String email;
	
	/**
	 * Relation One to One avec User.
	 * Un artiste est possédé par un user.
	 */
	@OneToOne
	private User user;

	/**
	 * GETTERS & SETTERS
	 */
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the artiste_nom
	 */
	public String getArtiste_nom() {
		return artiste_nom;
	}

	/**
	 * @param artiste_nom the artiste_nom to set
	 */
	public void setArtiste_nom(String artiste_nom) {
		this.artiste_nom = artiste_nom;
	}

	/**
	 * @return the description_courte
	 */
	public String getDescription_courte() {
		return description_courte;
	}

	/**
	 * @param description_courte the description_courte to set
	 */
	public void setDescription_courte(String description_courte) {
		this.description_courte = description_courte;
	}

	/**
	 * @return the description_longue
	 */
	public String getDescription_longue() {
		return description_longue;
	}

	/**
	 * @param description_longue the description_longue to set
	 */
	public void setDescription_longue(String description_longue) {
		this.description_longue = description_longue;
	}

	/**
	 * @return the site_web
	 */
	public String getSite_web() {
		return site_web;
	}

	/**
	 * @param site_web the site_web to set
	 */
	public void setSite_web(String site_web) {
		this.site_web = site_web;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
