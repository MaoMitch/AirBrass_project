
package fr.afcepf.al30.banque;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour verifiersolde complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="verifiersolde">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sommeadebite" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="carteJson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verifiersolde", propOrder = {
    "sommeadebite",
    "carteJson"
})
public class Verifiersolde {

    protected double sommeadebite;
    protected String carteJson;

    /**
     * Obtient la valeur de la propriété sommeadebite.
     * 
     */
    public double getSommeadebite() {
        return sommeadebite;
    }

    /**
     * Définit la valeur de la propriété sommeadebite.
     * 
     */
    public void setSommeadebite(double value) {
        this.sommeadebite = value;
    }

    /**
     * Obtient la valeur de la propriété carteJson.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarteJson() {
        return carteJson;
    }

    /**
     * Définit la valeur de la propriété carteJson.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarteJson(String value) {
        this.carteJson = value;
    }

}
