
package fr.afcepf.al30.banque;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour debiterCarte complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="debiterCarte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sommeadebiter" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="carteADebiter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="compteACrediter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "debiterCarte", propOrder = {
    "sommeadebiter",
    "carteADebiter",
    "compteACrediter"
})
public class DebiterCarte {

    protected double sommeadebiter;
    protected String carteADebiter;
    protected String compteACrediter;

    /**
     * Obtient la valeur de la propriété sommeadebiter.
     * 
     */
    public double getSommeadebiter() {
        return sommeadebiter;
    }

    /**
     * Définit la valeur de la propriété sommeadebiter.
     * 
     */
    public void setSommeadebiter(double value) {
        this.sommeadebiter = value;
    }

    /**
     * Obtient la valeur de la propriété carteADebiter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarteADebiter() {
        return carteADebiter;
    }

    /**
     * Définit la valeur de la propriété carteADebiter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarteADebiter(String value) {
        this.carteADebiter = value;
    }

    /**
     * Obtient la valeur de la propriété compteACrediter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompteACrediter() {
        return compteACrediter;
    }

    /**
     * Définit la valeur de la propriété compteACrediter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompteACrediter(String value) {
        this.compteACrediter = value;
    }

}
