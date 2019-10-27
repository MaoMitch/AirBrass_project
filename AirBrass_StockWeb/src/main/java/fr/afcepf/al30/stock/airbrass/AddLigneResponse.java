
package fr.afcepf.al30.stock.airbrass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour addLigneResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="addLigneResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ligneAjout" type="{http://airbrass.stock.al30.afcepf.fr}ligneCommandeDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addLigneResponse", propOrder = {
    "ligneAjout"
})
public class AddLigneResponse {

    protected LigneCommandeDTO ligneAjout;

    /**
     * Obtient la valeur de la propriété ligneAjout.
     * 
     * @return
     *     possible object is
     *     {@link LigneCommandeDTO }
     *     
     */
    public LigneCommandeDTO getLigneAjout() {
        return ligneAjout;
    }

    /**
     * Définit la valeur de la propriété ligneAjout.
     * 
     * @param value
     *     allowed object is
     *     {@link LigneCommandeDTO }
     *     
     */
    public void setLigneAjout(LigneCommandeDTO value) {
        this.ligneAjout = value;
    }

}
