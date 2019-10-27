
package fr.afcepf.al30.stock.airbrass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getFournisseurByIdResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getFournisseurByIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fournisseur" type="{http://airbrass.stock.al30.afcepf.fr}fournisseurDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFournisseurByIdResponse", propOrder = {
    "fournisseur"
})
public class GetFournisseurByIdResponse {

    protected FournisseurDTO fournisseur;

    /**
     * Obtient la valeur de la propriété fournisseur.
     * 
     * @return
     *     possible object is
     *     {@link FournisseurDTO }
     *     
     */
    public FournisseurDTO getFournisseur() {
        return fournisseur;
    }

    /**
     * Définit la valeur de la propriété fournisseur.
     * 
     * @param value
     *     allowed object is
     *     {@link FournisseurDTO }
     *     
     */
    public void setFournisseur(FournisseurDTO value) {
        this.fournisseur = value;
    }

}
