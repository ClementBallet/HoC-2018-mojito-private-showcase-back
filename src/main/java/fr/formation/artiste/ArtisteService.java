package fr.formation.artiste;

import fr.formation.artiste.dto.ArtisteUpdateDTO;
import fr.formation.user.User;
import fr.formation.user.UserService;
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
	private UserService userService;

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
	 */
	public void updateArtiste(User user, ArtisteUpdateDTO artisteUpdate) {

        Artiste artiste = artisteRepository.findArtistByUser_Id(user.getId());

		if (artisteUpdate.getArtisteNom() != null) artiste.setArtisteNom(artisteUpdate.getArtisteNom());
		if (artisteUpdate.getDescriptionCourte() != null) artiste.setDescriptionCourte(artisteUpdate.getDescriptionCourte());
		if (artisteUpdate.getDescription_longue() != null) artiste.setDescription_longue(artisteUpdate.getDescription_longue());
		if (artisteUpdate.getSiteWeb() != null) artiste.setSiteWeb(artisteUpdate.getSiteWeb());
		if (artisteUpdate.getTelephone() != null) artiste.setTelephone(artisteUpdate.getTelephone());
		if (artisteUpdate.getEmail() != null) artiste.setEmail(artisteUpdate.getEmail());
		if (artisteUpdate.getDepartementList() != null) artiste.setDepartementList(artisteUpdate.getDepartementList());

		this.artisteRepository.saveAndFlush(artiste);

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
