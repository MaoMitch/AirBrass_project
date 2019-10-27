
package fr.afcepf.al30.formations;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour formationDTO complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="formationDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="intitule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="prix" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="disponibilite" type="{http://formations.al30.afcepf.fr}disponibilite" minOccurs="0"/>
 *         &lt;element name="niveau" type="{http://formations.al30.afcepf.fr}niveau" minOccurs="0"/>
 *         &lt;element name="formateur" type="{http://formations.al30.afcepf.fr}formateurDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "formationDTO", propOrder = {
    "id",
    "intitule",
    "date",
    "prix",
    "disponibilite",
    "niveau",
    "formateur"
})
public class FormationDTO {

    protected Integer id;
    protected String intitule;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    protected Double prix;
    @XmlSchemaType(name = "string")
    protected Disponibilite disponibilite;
    @XmlSchemaType(name = "string")
    protected Niveau niveau;
    protected FormateurDTO formateur;

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété intitule.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * Définit la valeur de la propriété intitule.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntitule(String value) {
        this.intitule = value;
    }

    /**
     * Obtient la valeur de la propriété date.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Définit la valeur de la propriété date.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Obtient la valeur de la propriété prix.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPrix() {
        return prix;
    }

    /**
     * Définit la valeur de la propriété prix.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPrix(Double value) {
        this.prix = value;
    }

    /**
     * Obtient la valeur de la propriété disponibilite.
     * 
     * @return
     *     possible object is
     *     {@link Disponibilite }
     *     
     */
    public Disponibilite getDisponibilite() {
        return disponibilite;
    }

    /**
     * Définit la valeur de la propriété disponibilite.
     * 
     * @param value
     *     allowed object is
     *     {@link Disponibilite }
     *     
     */
    public void setDisponibilite(Disponibilite value) {
        this.disponibilite = value;
    }

    /**
     * Obtient la valeur de la propriété niveau.
     * 
     * @return
     *     possible object is
     *     {@link Niveau }
     *     
     */
    public Niveau getNiveau() {
        return niveau;
    }

    /**
     * Définit la valeur de la propriété niveau.
     * 
     * @param value
     *     allowed object is
     *     {@link Niveau }
     *     
     */
    public void setNiveau(Niveau value) {
        this.niveau = value;
    }

    /**
     * Obtient la valeur de la propriété formateur.
     * 
     * @return
     *     possible object is
     *     {@link FormateurDTO }
     *     
     */
    public FormateurDTO getFormateur() {
        return formateur;
    }

    /**
     * Définit la valeur de la propriété formateur.
     * 
     * @param value
     *     allowed object is
     *     {@link FormateurDTO }
     *     
     */
    public void setFormateur(FormateurDTO value) {
        this.formateur = value;
    }

}
