package fr.formation.artiste.dto;

import java.io.Serializable;

public class ArtisteUpdateDTO implements Serializable {

    private String artisteNom;

    private String descriptionCourte;

    private String description_longue;

    private String siteWeb;

    private String telephone;

    private String email;

    private String[] departementList;

    public ArtisteUpdateDTO() {
    }

    public ArtisteUpdateDTO(String artisteNom,
                            String descriptionCourte,
                            String description_longue,
                            String siteWeb,
                            String telephone,
                            String email,
                            String[] departementList) {
        this.artisteNom = artisteNom;
        this.descriptionCourte = descriptionCourte;
        this.description_longue = description_longue;
        this.siteWeb = siteWeb;
        this.telephone = telephone;
        this.email = email;
        this.departementList = departementList;
    }

    public String getArtisteNom() {
        return artisteNom;
    }

    public void setArtisteNom(String artisteNom) {
        this.artisteNom = artisteNom;
    }

    public String getDescriptionCourte() {
        return descriptionCourte;
    }

    public void setDescriptionCourte(String descriptionCourte) {
        this.descriptionCourte = descriptionCourte;
    }

    public String getDescription_longue() {
        return description_longue;
    }

    public void setDescription_longue(String description_longue) {
        this.description_longue = description_longue;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getDepartementList() {
        return departementList;
    }

    public void setDepartementList(String[] departementList) {
        this.departementList = departementList;
    }
}
