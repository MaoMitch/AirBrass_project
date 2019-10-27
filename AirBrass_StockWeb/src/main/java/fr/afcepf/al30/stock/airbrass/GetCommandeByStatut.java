
package fr.afcepf.al30.stock.airbrass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getCommandeByStatut complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getCommandeByStatut">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="statutCommande" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCommandeByStatut", propOrder = {
    "statutCommande"
})
public class GetCommandeByStatut {

    protected String statutCommande;

    /**
     * Obtient la valeur de la propriété statutCommande.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatutCommande() {
        return statutCommande;
    }

    /**
     * Définit la valeur de la propriété statutCommande.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatutCommande(String value) {
        this.statutCommande = value;
    }

}
