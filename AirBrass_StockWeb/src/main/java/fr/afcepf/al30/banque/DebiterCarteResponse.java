
package fr.afcepf.al30.banque;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour debiterCarteResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="debiterCarteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EtatOperationDebit" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "debiterCarteResponse", propOrder = {
    "etatOperationDebit"
})
public class DebiterCarteResponse {

    @XmlElement(name = "EtatOperationDebit")
    protected Boolean etatOperationDebit;

    /**
     * Obtient la valeur de la propriété etatOperationDebit.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEtatOperationDebit() {
        return etatOperationDebit;
    }

    /**
     * Définit la valeur de la propriété etatOperationDebit.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEtatOperationDebit(Boolean value) {
        this.etatOperationDebit = value;
    }

}
