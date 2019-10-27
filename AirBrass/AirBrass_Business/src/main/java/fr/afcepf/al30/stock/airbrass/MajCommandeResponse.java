
package fr.afcepf.al30.stock.airbrass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour majCommandeResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="majCommandeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="commandeValide" type="{http://airbrass.stock.al30.afcepf.fr}commandeDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "majCommandeResponse", propOrder = {
    "commandeValide"
})
public class MajCommandeResponse {

    protected CommandeDTO commandeValide;

    /**
     * Obtient la valeur de la propriété commandeValide.
     * 
     * @return
     *     possible object is
     *     {@link CommandeDTO }
     *     
     */
    public CommandeDTO getCommandeValide() {
        return commandeValide;
    }

    /**
     * Définit la valeur de la propriété commandeValide.
     * 
     * @param value
     *     allowed object is
     *     {@link CommandeDTO }
     *     
     */
    public void setCommandeValide(CommandeDTO value) {
        this.commandeValide = value;
    }

}
