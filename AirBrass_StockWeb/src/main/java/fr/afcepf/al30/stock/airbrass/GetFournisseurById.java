
package fr.afcepf.al30.stock.airbrass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getFournisseurById complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getFournisseurById">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idFournisseur" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFournisseurById", propOrder = {
    "idFournisseur"
})
public class GetFournisseurById {

    protected int idFournisseur;

    /**
     * Obtient la valeur de la propriété idFournisseur.
     * 
     */
    public int getIdFournisseur() {
        return idFournisseur;
    }

    /**
     * Définit la valeur de la propriété idFournisseur.
     * 
     */
    public void setIdFournisseur(int value) {
        this.idFournisseur = value;
    }

}
