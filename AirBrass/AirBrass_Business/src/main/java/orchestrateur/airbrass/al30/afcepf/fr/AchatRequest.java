
package orchestrateur.airbrass.al30.afcepf.fr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="jsonCommande" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsonCB" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jsonCompte" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prix" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "jsonCommande",
    "jsonCB",
    "jsonCompte",
    "prix"
})
@XmlRootElement(name = "AchatRequest")
public class AchatRequest {

    @XmlElement(required = true)
    protected String jsonCommande;
    @XmlElement(required = true)
    protected String jsonCB;
    @XmlElement(required = true)
    protected String jsonCompte;
    protected double prix;

    /**
     * Obtient la valeur de la propriété jsonCommande.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJsonCommande() {
        return jsonCommande;
    }

    /**
     * Définit la valeur de la propriété jsonCommande.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJsonCommande(String value) {
        this.jsonCommande = value;
    }

    /**
     * Obtient la valeur de la propriété jsonCB.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJsonCB() {
        return jsonCB;
    }

    /**
     * Définit la valeur de la propriété jsonCB.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJsonCB(String value) {
        this.jsonCB = value;
    }

    /**
     * Obtient la valeur de la propriété jsonCompte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJsonCompte() {
        return jsonCompte;
    }

    /**
     * Définit la valeur de la propriété jsonCompte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJsonCompte(String value) {
        this.jsonCompte = value;
    }

    /**
     * Obtient la valeur de la propriété prix.
     * 
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Définit la valeur de la propriété prix.
     * 
     */
    public void setPrix(double value) {
        this.prix = value;
    }

}
