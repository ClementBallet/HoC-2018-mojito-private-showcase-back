package fr.formation.geo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * The type Departement.
 */
public class Departement implements Serializable {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nom", nullable = false, unique = true)
	private String nom;

	@Column(name = "code_region", nullable = false, unique = true)
	private String codeRegion;

	/**
	 * Create a Departement
	 *
	 * @param nom        the nom
	 * @param codeRegion the code region
	 */
	public Departement(String nom,  String codeRegion) {
		this.nom = nom;
		this.codeRegion = codeRegion;
	}

	/**
	 * Create a Departement
	 */
	public Departement() {
	}

	/**
	 *
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 *
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
}
