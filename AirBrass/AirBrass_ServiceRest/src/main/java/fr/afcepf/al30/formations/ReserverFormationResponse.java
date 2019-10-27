
package fr.afcepf.al30.formations;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour reserverFormationResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reserverFormationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="returnReservationReussie" type="{http://formations.al30.afcepf.fr}formationDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserverFormationResponse", propOrder = {
    "returnReservationReussie"
})
public class ReserverFormationResponse {

    protected FormationDTO returnReservationReussie;

    /**
     * Obtient la valeur de la propriété returnReservationReussie.
     * 
     * @return
     *     possible object is
     *     {@link FormationDTO }
     *     
     */
    public FormationDTO getReturnReservationReussie() {
        return returnReservationReussie;
    }

    /**
     * Définit la valeur de la propriété returnReservationReussie.
     * 
     * @param value
     *     allowed object is
     *     {@link FormationDTO }
     *     
     */
    public void setReturnReservationReussie(FormationDTO value) {
        this.returnReservationReussie = value;
    }

}
