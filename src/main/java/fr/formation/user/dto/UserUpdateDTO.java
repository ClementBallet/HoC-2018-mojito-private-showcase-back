package fr.formation.user.dto;

import java.io.Serializable;

public class UserUpdateDTO implements Serializable {

    private String ancien_password;

    private String nouveau_password;

    private String nouveau_email;

    public String getAncien_password() {
        return ancien_password;
    }

    public void setAncien_password(String ancien_password) {
        this.ancien_password = ancien_password;
    }

    public String getNouveau_password() {
        return nouveau_password;
    }

    public void setNouveau_password(String nouveau_password) {
        this.nouveau_password = nouveau_password;
    }

    public String getNouveau_email() {
        return nouveau_email;
    }

    public void setNouveau_email(String nouveau_email) {
        this.nouveau_email = nouveau_email;
    }

    public UserUpdateDTO() {
    }

    public UserUpdateDTO(String ancien_password, String nouveau_password, String confirm_password, String nouveau_email) {
        this.ancien_password = ancien_password;
        this.nouveau_password = nouveau_password;
        this.nouveau_email = nouveau_email;
    }
}
