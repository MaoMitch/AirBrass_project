
package fr.afcepf.al30.formations;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getFormations complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getFormations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="formation" type="{http://formations.al30.afcepf.fr}formation" minOccurs="0"/>
 *         &lt;element name="seulementDispos" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFormations", propOrder = {
    "formation",
    "seulementDispos"
})
public class GetFormations {

    protected Formation formation;
    protected boolean seulementDispos;

    /**
     * Obtient la valeur de la propriété formation.
     * 
     * @return
     *     possible object is
     *     {@link Formation }
     *     
     */
    public Formation getFormation() {
        return formation;
    }

    /**
     * Définit la valeur de la propriété formation.
     * 
     * @param value
     *     allowed object is
     *     {@link Formation }
     *     
     */
    public void setFormation(Formation value) {
        this.formation = value;
    }

    /**
     * Obtient la valeur de la propriété seulementDispos.
     * 
     */
    public boolean isSeulementDispos() {
        return seulementDispos;
    }

    /**
     * Définit la valeur de la propriété seulementDispos.
     * 
     */
    public void setSeulementDispos(boolean value) {
        this.seulementDispos = value;
    }

}
