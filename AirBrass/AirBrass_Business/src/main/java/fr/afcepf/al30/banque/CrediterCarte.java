
package fr.afcepf.al30.banque;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour crediterCarte complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="crediterCarte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sommeacrediter" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="carteACrediter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="compteADebiter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crediterCarte", propOrder = {
    "sommeacrediter",
    "carteACrediter",
    "compteADebiter"
})
public class CrediterCarte {

    protected double sommeacrediter;
    protected String carteACrediter;
    protected String compteADebiter;

    /**
     * Obtient la valeur de la propriété sommeacrediter.
     * 
     */
    public double getSommeacrediter() {
        return sommeacrediter;
    }

    /**
     * Définit la valeur de la propriété sommeacrediter.
     * 
     */
    public void setSommeacrediter(double value) {
        this.sommeacrediter = value;
    }

    /**
     * Obtient la valeur de la propriété carteACrediter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarteACrediter() {
        return carteACrediter;
    }

    /**
     * Définit la valeur de la propriété carteACrediter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarteACrediter(String value) {
        this.carteACrediter = value;
    }

    /**
     * Obtient la valeur de la propriété compteADebiter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompteADebiter() {
        return compteADebiter;
    }

    /**
     * Définit la valeur de la propriété compteADebiter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompteADebiter(String value) {
        this.compteADebiter = value;
    }

}
