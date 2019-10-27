
package fr.afcepf.al30.formations;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour getFormationsByDate complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getFormationsByDate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateSelectionnee" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
@XmlType(name = "getFormationsByDate", propOrder = {
    "dateSelectionnee",
    "seulementDispos"
})
public class GetFormationsByDate {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateSelectionnee;
    protected boolean seulementDispos;

    /**
     * Obtient la valeur de la propriété dateSelectionnee.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateSelectionnee() {
        return dateSelectionnee;
    }

    /**
     * Définit la valeur de la propriété dateSelectionnee.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateSelectionnee(XMLGregorianCalendar value) {
        this.dateSelectionnee = value;
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
