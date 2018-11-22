package fr.formation.artiste;

import javax.persistence.*;

import fr.formation.geo.model.Departement;
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

	@Column(name = "artisteNom", nullable = false, unique = true)
	private String artisteNom;
	
	@Column(name = "descriptionCourte", length = 150, nullable = true)
	private String descriptionCourte;
	
	@Column(name = "description_longue", length = 1000, nullable = true)
	private String description_longue;
	
	@Column(name = "siteWeb", nullable = true)
	private String siteWeb;
	
	@Column(name = "telephone", nullable = true)
	private String telephone;
	
	@Column(name = "email", nullable = true)
	private String email;
	
	/**
	 * Relation One to One avec User.
	 * Un artiste est possédé par un user.
	 */
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private User user;

//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "id_departement", nullable = true)
//	private Departement departement;

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
	 * @return the artisteNom
	 */
	public String getArtisteNom() {
		return artisteNom;
	}

	/**
	 * @param artisteNom the artisteNom to set
	 */
	public void setArtisteNom(String artisteNom) {
		this.artisteNom = artisteNom;
	}

	/**
	 * @return the descriptionCourte
	 */
	public String getDescriptionCourte() {
		return descriptionCourte;
	}

	/**
	 * @param descriptionCourte the descriptionCourte to set
	 */
	public void setDescriptionCourte(String descriptionCourte) {
		this.descriptionCourte = descriptionCourte;
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
	 * @return the siteWeb
	 */
	public String getSiteWeb() {
		return siteWeb;
	}

	/**
	 * @param siteWeb the siteWeb to set
	 */
	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
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

//	/**
//	 * @return the user
//	 */
//	public User getUser() {
//		return user;
//	}
//
//	/**
//	 * @param user the user to set
//	 */
//	public void setUser(User user) {
//		this.user = user;
//	}
}
