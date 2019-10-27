
package fr.afcepf.al30.stock.airbrass;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getAllFournisseurResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getAllFournisseurResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fournisseurs" type="{http://airbrass.stock.al30.afcepf.fr}fournisseurDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllFournisseurResponse", propOrder = {
    "fournisseurs"
})
public class GetAllFournisseurResponse {

    protected List<FournisseurDTO> fournisseurs;

    /**
     * Gets the value of the fournisseurs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fournisseurs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFournisseurs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FournisseurDTO }
     * 
     * 
     */
    public List<FournisseurDTO> getFournisseurs() {
        if (fournisseurs == null) {
            fournisseurs = new ArrayList<FournisseurDTO>();
        }
        return this.fournisseurs;
    }

}
