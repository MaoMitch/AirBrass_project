
package fr.afcepf.al30.stock.airbrass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ajoutStockResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ajoutStockResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ajout" type="{http://airbrass.stock.al30.afcepf.fr}produitDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ajoutStockResponse", propOrder = {
    "ajout"
})
public class AjoutStockResponse {

    protected ProduitDTO ajout;

    /**
     * Obtient la valeur de la propriété ajout.
     * 
     * @return
     *     possible object is
     *     {@link ProduitDTO }
     *     
     */
    public ProduitDTO getAjout() {
        return ajout;
    }

    /**
     * Définit la valeur de la propriété ajout.
     * 
     * @param value
     *     allowed object is
     *     {@link ProduitDTO }
     *     
     */
    public void setAjout(ProduitDTO value) {
        this.ajout = value;
    }

}
