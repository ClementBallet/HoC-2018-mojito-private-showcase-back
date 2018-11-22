package fr.formation.artiste;

import fr.formation.controllers.AbstractController;
import fr.formation.security.SecurityConstants;
import fr.formation.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

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
	 * @param nomArtiste
	 * @param descriptionCourte
	 * @param descriptionLongue
	 * @param siteWeb
	 * @param telephone
	 * @param email
	 * @return Artiste
	 * @return
	 */
	@PostMapping("")
	public Artiste createNewArtiste(
			@RequestParam(required = true) String nomArtiste,
			@RequestParam(required = false) String descriptionCourte, 
			@RequestParam(required = false) String descriptionLongue,
			@RequestParam(required = false) String siteWeb, 
			@RequestParam(required = false) String telephone, 
			@RequestParam(required = false) String email,
			@RequestParam(required = false) String[] departementList) {
		return artisteService.createNewArtiste(nomArtiste, descriptionCourte, descriptionLongue, siteWeb, telephone,
				email, departementList);
	}

	/**
	 * Route de l'API de récupération d'un artiste
	 * 
	 * @param artisteNom
	 * @return Artiste
	 */
	@GetMapping("/{artisteNom}")
	public Artiste getArtistByArtistNom(@PathVariable  final String artisteNom) {
		return artisteService.getArtistByArtistNom(artisteNom);
	}

	/**s
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
			@RequestParam(required = false) String email,
			@RequestParam(required = false) String[] departementList) {
		artisteService.updateArtiste(artisteId, nomArtiste, descriptionCourte, descriptionLongue, siteWeb, telephone,
				email, departementList);
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
