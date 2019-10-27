
package fr.afcepf.al30.stock.airbrass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getProduitByIdResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getProduitByIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="produitDTO" type="{http://airbrass.stock.al30.afcepf.fr}produitDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProduitByIdResponse", propOrder = {
    "produitDTO"
})
public class GetProduitByIdResponse {

    protected ProduitDTO produitDTO;

    /**
     * Obtient la valeur de la propriété produitDTO.
     * 
     * @return
     *     possible object is
     *     {@link ProduitDTO }
     *     
     */
    public ProduitDTO getProduitDTO() {
        return produitDTO;
    }

    /**
     * Définit la valeur de la propriété produitDTO.
     * 
     * @param value
     *     allowed object is
     *     {@link ProduitDTO }
     *     
     */
    public void setProduitDTO(ProduitDTO value) {
        this.produitDTO = value;
    }

}
