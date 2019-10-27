
package fr.afcepf.al30.stock.airbrass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour addLigne complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="addLigne">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ligne" type="{http://airbrass.stock.al30.afcepf.fr}ligneCommandeDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addLigne", propOrder = {
    "ligne"
})
public class AddLigne {

    protected LigneCommandeDTO ligne;

    /**
     * Obtient la valeur de la propriété ligne.
     * 
     * @return
     *     possible object is
     *     {@link LigneCommandeDTO }
     *     
     */
    public LigneCommandeDTO getLigne() {
        return ligne;
    }

    /**
     * Définit la valeur de la propriété ligne.
     * 
     * @param value
     *     allowed object is
     *     {@link LigneCommandeDTO }
     *     
     */
    public void setLigne(LigneCommandeDTO value) {
        this.ligne = value;
    }

}
