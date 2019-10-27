
package fr.afcepf.al30.stock.airbrass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour addCommandeResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="addCommandeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="commandeAjout" type="{http://airbrass.stock.al30.afcepf.fr}commandeDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addCommandeResponse", propOrder = {
    "commandeAjout"
})
public class AddCommandeResponse {

    protected CommandeDTO commandeAjout;

    /**
     * Obtient la valeur de la propriété commandeAjout.
     * 
     * @return
     *     possible object is
     *     {@link CommandeDTO }
     *     
     */
    public CommandeDTO getCommandeAjout() {
        return commandeAjout;
    }

    /**
     * Définit la valeur de la propriété commandeAjout.
     * 
     * @param value
     *     allowed object is
     *     {@link CommandeDTO }
     *     
     */
    public void setCommandeAjout(CommandeDTO value) {
        this.commandeAjout = value;
    }

}
