
package fr.afcepf.al30.formations;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getFormationsResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getFormationsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="returnGetFormations" type="{http://formations.al30.afcepf.fr}formationDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFormationsResponse", propOrder = {
    "returnGetFormations"
})
public class GetFormationsResponse {

    protected List<FormationDTO> returnGetFormations;

    /**
     * Gets the value of the returnGetFormations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the returnGetFormations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReturnGetFormations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FormationDTO }
     * 
     * 
     */
    public List<FormationDTO> getReturnGetFormations() {
        if (returnGetFormations == null) {
            returnGetFormations = new ArrayList<>();
        }
        return this.returnGetFormations;
    }

}
