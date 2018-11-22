package fr.formation.artiste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Clément
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
	public ArtisteService(ArtisteRepository artisteRepository) { this.artisteRepository = artisteRepository; }

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
			String telephone, String email, String[] departementList) {

		Artiste artiste = new Artiste();
		artiste.setArtisteNom(nomArtiste);
		artiste.setDescriptionCourte(descriptionCourte);
		artiste.setDescription_longue(descriptionLongue);
		artiste.setSiteWeb(siteWeb);
		artiste.setTelephone(telephone);
		artiste.setEmail(email);
		artiste.setDepartementList(departementList);

		return this.artisteRepository.save(artiste);

	}

	/**
	 * Retourne les informations d'un artiste inscrits en BDD
	 * 
	 * @param nomArtiste
	 * @return Artiste
	 */
	public Artiste getArtistByArtistNom(final String nomArtiste) {

		Artiste artiste = artisteRepository.findByArtisteNom(nomArtiste);
		if (artiste != null) {
			return artiste;
		}

		throw new UsernameNotFoundException("Le user avec le username " + nomArtiste + " n'existe pas");
	}


	/**
	 * Met à jour un artiste en BDD
	 * 
	 * @param artisteId
	 */
	public void updateArtiste(Long artisteId, String nomArtiste, String descriptionCourte, String descriptionLongue, String siteWeb,
			String telephone, String email, String[] departementList) {

        Artiste NameArtisteInDatabase = artisteRepository.getOne(artisteId);

        if (NameArtisteInDatabase.equals(nomArtiste)) {
            Artiste artiste = this.artisteRepository.getOne(artisteId);
            if (nomArtiste != null) artiste.setArtisteNom(nomArtiste);
            if (descriptionCourte != null) artiste.setDescriptionCourte(descriptionCourte);
            if (descriptionLongue != null) artiste.setDescription_longue(descriptionLongue);
            if (siteWeb != null) artiste.setSiteWeb(siteWeb);
            if (telephone != null) artiste.setTelephone(telephone);
            if (email != null) artiste.setEmail(email);
            if(departementList != null) artiste.setDepartementList(departementList);
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

	public List<Artiste> findArtistsByDepartementCode (final String codeDepartement) {
		return artisteRepository.findArtistsByUser_DepartmentCode(codeDepartement);
	}
}
