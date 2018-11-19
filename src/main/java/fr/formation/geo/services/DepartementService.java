package fr.formation.geo.services;

import fr.formation.geo.model.Departement;

import java.util.List;

/**
 * The interface Departement service.
 */
public interface DepartementService {

	/**
	 * Gets departement.
	 *
	 * @param nom the nom
	 *
	 * @return the departement
	 */
	List<Departement> getDepartement(final String nom);



	/**
	 * Gets departement by code_region.
	 *
	 * @param codeRegion the code_region
	 *
	 * @return the departement by code_region
	 */
	List<Departement> getDepartementByCodeRegion(final String codeRegion);


}
