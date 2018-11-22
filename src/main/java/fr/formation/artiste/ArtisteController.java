package fr.formation.artiste;

import fr.formation.controllers.AbstractController;
import fr.formation.security.SecurityConstants;
import fr.formation.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Clément Rest Controller Artiste Envoie les infos relatives à
 *         l'artiste
 */
@RestController
@Secured(SecurityConstants.ROLE_USER)
@RequestMapping("/artistes")
public class ArtisteController extends AbstractController {

	private ArtisteService artisteService;

	@Autowired
	public ArtisteController(ArtisteService artisteService) {
		this.artisteService = artisteService;
	}

	/**
	 * Route de l'API de création d'un nouvel artiste
	 *
	 * @return
	 */
	@PostMapping("")
	public Artiste createNewArtiste(
			@RequestParam(required = true) String nomArtiste,
			@RequestParam(required = false) String descriptionCourte, 
			@RequestParam(required = false) String descriptionLongue,
			@RequestParam(required = false) String siteWeb, 
			@RequestParam(required = false) String telephone, 
			@RequestParam(required = false) String email) {
		return artisteService.createNewArtiste(nomArtiste, descriptionCourte, descriptionLongue, siteWeb, telephone,
				email);
	}

	/**
	 * Route de l'API de récupération d'un artiste
	 * 
	 * @param artisteId
	 * @return 
	 */
	@GetMapping("/{artisteId}")
	public Artiste getArtiste(@PathVariable Long artisteId) {
		return artisteService.getArtiste(artisteId);
	}

	/**
	 * Route de l'API de mise à jour d'un artiste
	 * 
	 * @param artisteId
	 */
	@PutMapping("/{artisteId}")
	public void updateArtiste(
			@PathVariable Long artisteId, 
			@RequestParam(required = false) String nomArtiste,
			@RequestParam(required = false) String descriptionCourte, 
			@RequestParam(required = false) String descriptionLongue,
			@RequestParam(required = false) String siteWeb, 
			@RequestParam(required = false) String telephone, 
			@RequestParam(required = false) String email) {
		artisteService.updateArtiste(artisteId, nomArtiste, descriptionCourte, descriptionLongue, siteWeb, telephone,
				email);
	}

	/**
	 * Route de l'API de suppression d'un artiste
	 * 
	 * @param artisteId
	 */
	@DeleteMapping("/{artisteId}")
	public void deleteArtiste(@PathVariable Long artisteId) {
		artisteService.deleteArtiste(artisteId);
	}

	/**
	 * Récupère les artistes en fonction de leur département
	 * @return List<Artiste>
	 */
	@GetMapping("/list")
	public List<Artiste> getArtistsFromDepartement() {
		User user = super.getAuthenticatedUser();
		return artisteService.findArtistsByDepartementCode(user.getCodeDepartement());
	}
}
