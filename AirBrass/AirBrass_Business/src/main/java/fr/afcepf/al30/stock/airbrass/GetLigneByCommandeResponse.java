
package fr.afcepf.al30.stock.airbrass;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getLigneByCommandeResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getLigneByCommandeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listeLigneCommande" type="{http://airbrass.stock.al30.afcepf.fr}ligneCommandeDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLigneByCommandeResponse", propOrder = {
    "listeLigneCommande"
})
public class GetLigneByCommandeResponse {

    protected List<LigneCommandeDTO> listeLigneCommande;

    /**
     * Gets the value of the listeLigneCommande property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listeLigneCommande property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListeLigneCommande().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LigneCommandeDTO }
     * 
     * 
     */
    public List<LigneCommandeDTO> getListeLigneCommande() {
        if (listeLigneCommande == null) {
            listeLigneCommande = new ArrayList<>();
        }
        return this.listeLigneCommande;
    }

}
