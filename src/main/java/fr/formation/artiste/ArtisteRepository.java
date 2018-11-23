package fr.formation.artiste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author adminHOC
 */
public interface ArtisteRepository extends JpaRepository<Artiste, Long> {

    @Query(value = "Select * from user INNER JOIN artiste ON user.artiste_id = artiste.id WHERE user.code_departement = :deptcode",
            nativeQuery = true)
    List<Artiste> findArtistsByUser_DepartmentCode(@Param("deptcode") String department_code);

    /**
     * Find user by artiste id
     *
     * @param id the user_id
     * @return Artist artist
     */
    @Query(value = "SELECT * from user WHERE user.artiste_id = :id", nativeQuery = true)
    Artiste findUserByArtiste_Id(@Param("id") Long id);

    /**
     * Find artist by user id
     *
     * @param id the user_id
     * @return Artist artist
     */
    @Query(value = "SELECT * from artiste INNER JOIN user ON artiste.id = user.artiste_id WHERE user.id = :id", nativeQuery = true)
    Artiste findArtistByUser_Id(@Param("id") Long id);

    Artiste findByArtisteNom(String nomArtiste);
}
