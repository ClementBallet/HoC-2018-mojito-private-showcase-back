package fr.formation.artiste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author adminHOC
 *
 */
@Service
public class ArtisteService {

	private ArtisteRepository artisteRepository;

	/**
	 * Instancie un nouveau ArtisteRepository
	 * 
	 * @param artisteRepository
	 */
	@Autowired
	public ArtisteService(ArtisteRepository artisteRepository) {

		this.artisteRepository = artisteRepository;

	}

	/**
	 * Sauvegarder un artiste en BDD
	 * 
	 * @param nomArtiste
	 * @param descriptionCourte
	 * @param descriptionLongue
	 * @param siteWeb
	 * @param telephone
	 * @param email
	 */
	public Artiste createNewArtiste(String nomArtiste, String descriptionCourte, String descriptionLongue, String siteWeb,
			String telephone, String email) {

		Artiste artiste = new Artiste();
		artiste.setArtiste_nom(nomArtiste);
		artiste.setDescription_courte(descriptionCourte);
		artiste.setDescription_longue(descriptionLongue);
		artiste.setSite_web(siteWeb);
		artiste.setTelephone(telephone);
		artiste.setEmail(email);
		return this.artisteRepository.save(artiste);

	}

	/**
	 * Retourne les informations d'un artiste inscrits en BDD
	 * 
	 * @param artisteId
	 * @return Artiste
	 */
	public Artiste getArtiste(Long artisteId) {

		return this.artisteRepository.getOne(artisteId);

	}

	/**
	 * Met à jour un artiste en BDD
	 * 
	 * @param artisteId
	 */
	public void updateArtiste(Long artisteId, String nomArtiste, String descriptionCourte, String descriptionLongue, String siteWeb,
			String telephone, String email) {

        String NameArtisteInDatabase = SecurityContextHolder.getContext().getAuthentication().getName();

        if (NameArtisteInDatabase.equals(nomArtiste)) {
            Artiste artiste = this.artisteRepository.getOne(artisteId);
            if (nomArtiste != null) artiste.setArtiste_nom(nomArtiste);
            if (descriptionCourte != null) artiste.setDescription_courte(descriptionCourte);
            if (descriptionLongue != null) artiste.setDescription_longue(descriptionLongue);
            if (siteWeb != null) artiste.setSite_web(siteWeb);
            if (telephone != null) artiste.setTelephone(telephone);
            if (email != null) artiste.setEmail(email);
            this.artisteRepository.saveAndFlush(artiste);
        }

	}

	/**
	 * Supprime un artiste en BDD
	 * 
	 * @param artisteId
	 */
	public void deleteArtiste(Long artisteId) {

		Artiste artiste = this.artisteRepository.getOne(artisteId);
		this.artisteRepository.delete(artiste);

	}
}
