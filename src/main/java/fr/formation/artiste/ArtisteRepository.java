package fr.formation.artiste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author adminHOC
 */
public interface ArtisteRepository extends JpaRepository<Artiste, Long> {

//    @Query(value = "Select * from artiste INNER JOIN user ON artiste.user_id = user.id WHERE user.code_departement = :deptcode",
//            nativeQuery = true)
//    List<Artiste> findArtistsByUser_DepartmentCode(@Param("deptcode") String department_code);
//
//    /**
//     * Find by Artist_name user.
//     *
//     * @param id the user_id
//     * @return Artist artist
//     */
//    @Query(value = "SELECT * from artiste WHERE artiste.user_id = :id",
//            nativeQuery = true)
//    Artiste findArtistByUser_Id(@Param("id") Long id);


    @Query(value = "Select * from user INNER JOIN artiste ON user.artiste_id = artiste.id WHERE user.code_departement = :deptcode",
            nativeQuery = true)
    List<Artiste> findArtistsByUser_DepartmentCode(@Param("deptcode") String department_code);

    /**
     * Find by Artist_name user.
     *
     * @param id the user_id
     * @return Artist artist
     */
    @Query(value = "SELECT * from user WHERE user.artiste_id = :id", nativeQuery = true)
    Artiste findArtistByUser_Id(@Param("id") Long id);

}
