
package orchestrateur.airbrass.al30.afcepf.fr;

import java.io.Serializable;
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
 *         &lt;element name="commentaire" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="listeArticle" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "commentaire",
    "listeArticle"
})
@XmlRootElement(name = "AchatResponse")
public class AchatResponse implements Serializable{

    @XmlElement(required = true)
    protected String commentaire;
    @XmlElement(required = true)
    protected String listeArticle;

    /**
     * Obtient la valeur de la propriété commentaire.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * D�finit la valeur de la propriété commentaire.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentaire(String value) {
        this.commentaire = value;
    }

    /**
     * Obtient la valeur de la propriété listeArticle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListeArticle() {
        return listeArticle;
    }

    /**
     * D�finit la valeur de la propriété listeArticle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListeArticle(String value) {
        this.listeArticle = value;
    }

}
