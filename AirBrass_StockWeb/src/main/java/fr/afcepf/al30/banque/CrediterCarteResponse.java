
package fr.afcepf.al30.banque;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour crediterCarteResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="crediterCarteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EtatOperationCredit" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crediterCarteResponse", propOrder = {
    "etatOperationCredit"
})
public class CrediterCarteResponse {

    @XmlElement(name = "EtatOperationCredit")
    protected Boolean etatOperationCredit;

    /**
     * Obtient la valeur de la propriété etatOperationCredit.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEtatOperationCredit() {
        return etatOperationCredit;
    }

    /**
     * Définit la valeur de la propriété etatOperationCredit.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEtatOperationCredit(Boolean value) {
        this.etatOperationCredit = value;
    }

}
