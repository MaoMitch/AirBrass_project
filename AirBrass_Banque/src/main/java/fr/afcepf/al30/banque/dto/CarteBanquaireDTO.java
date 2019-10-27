package fr.afcepf.al30.banque.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.afcepf.al30.banque.entity.CarteBanquaire;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * Data transfert object pour {@link CarteBanquaire}.
 *
 * @author Stagiaire
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class CarteBanquaireDTO {

    /**
     * L'id de la carte.
     */
    private int id;
    /**
     * Nom de la carte.
     */
    private String nom;
    /**
     * Numero de la carte.
     */
    private String numero;
    /**
     * Tryptique de la carte.
     */
    private String pictogrammeSecurite;
    
    /**
     * Date de fin de validité de la carte.
     */
    private Date dateValidite;
    
    /**
     * Le comte lié à la carte.
     */
    private CompteBanquaireDTO compteDto;

    /**
     * Constructeur vide.
     */
    public CarteBanquaireDTO() {
        super();
    }

    /**
     * Contructeur surchargé complet.
     *
     * @param paramNom
     * @param paramNumero
     * @param paramPictogrammeSecurite
     */
    public CarteBanquaireDTO(String paramNom, String paramNumero, String paramPictogrammeSecurite) {
        super();
        nom = paramNom;
        numero = paramNumero;
        pictogrammeSecurite = paramPictogrammeSecurite;
    }

}
