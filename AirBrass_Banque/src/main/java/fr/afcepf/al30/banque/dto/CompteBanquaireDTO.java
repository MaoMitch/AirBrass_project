package fr.afcepf.al30.banque.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.afcepf.al30.banque.entity.CompteBanquaire;
import lombok.Getter;
import lombok.Setter;

/**
 * Data transfert object pour {@link CompteBanquaire}.
 *
 * @author Stagiaire
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class CompteBanquaireDTO {

    /**
     * L'id du compte.
     */
    private int id;
    /**
     * Nom du compte.
     */
    private String nomCompte;
    /**
     * Numero du compte.
     */
    private String numeroCompte;

    /**
     * Constructeur vide.
     */
    public CompteBanquaireDTO() {
        super();
    }

    /**
     * Constructeur surchargé.
     *
     * @param paramNomCompte
     * @param paramNumeroCompte
     */
    public CompteBanquaireDTO(String paramNomCompte, String paramNumeroCompte) {
        super();
        nomCompte = paramNomCompte;
        numeroCompte = paramNumeroCompte;
    }

}
