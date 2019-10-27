package fr.afcepf.al30.airbrass.serviceentities;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe de l'utilissateur fournis par Angular lors de la création d'un compte.
 */
@Getter
@Setter
@XmlRootElement(name="utilisateur")
public class Utilisateur {
    private String prenom;
    private String nom;
    private String dateNaissance;
    private String numRue;
    private String rue;
    private String complement;
    private String email;
    private String mdp;
    private String mdpConfirm;
    private String telephone;
    private String cp;
    private String ville;
}
