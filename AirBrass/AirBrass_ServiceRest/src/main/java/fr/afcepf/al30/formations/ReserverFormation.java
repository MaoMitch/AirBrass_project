
package fr.afcepf.al30.formations;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour reserverFormation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reserverFormation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="formation" type="{http://formations.al30.afcepf.fr}formationDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserverFormation", propOrder = {
    "formation"
})
public class ReserverFormation {

    protected FormationDTO formation;

    /**
     * Obtient la valeur de la propriété formation.
     * 
     * @return
     *     possible object is
     *     {@link FormationDTO }
     *     
     */
    public FormationDTO getFormation() {
        return formation;
    }

    /**
     * Définit la valeur de la propriété formation.
     * 
     * @param value
     *     allowed object is
     *     {@link FormationDTO }
     *     
     */
    public void setFormation(FormationDTO value) {
        this.formation = value;
    }

}
