
package fr.afcepf.al30.formations;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getFormationByIdResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getFormationByIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="returnGetFormationById" type="{http://formations.al30.afcepf.fr}formationDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFormationByIdResponse", propOrder = {
    "returnGetFormationById"
})
public class GetFormationByIdResponse {

    protected FormationDTO returnGetFormationById;

    /**
     * Obtient la valeur de la propriété returnGetFormationById.
     * 
     * @return
     *     possible object is
     *     {@link FormationDTO }
     *     
     */
    public FormationDTO getReturnGetFormationById() {
        return returnGetFormationById;
    }

    /**
     * Définit la valeur de la propriété returnGetFormationById.
     * 
     * @param value
     *     allowed object is
     *     {@link FormationDTO }
     *     
     */
    public void setReturnGetFormationById(FormationDTO value) {
        this.returnGetFormationById = value;
    }

}
