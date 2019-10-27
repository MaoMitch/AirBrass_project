package fr.afcepf.al30.managedBean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

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
   * @param paramNomCompte
   * @param paramNumeroCompte
   */
  public CompteBanquaireDTO(String paramNomCompte, String paramNumeroCompte) {
    super();
    nomCompte = paramNomCompte;
    numeroCompte = paramNumeroCompte;
  }
  
}
