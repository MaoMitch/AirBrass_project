
package fr.afcepf.al30.stock.airbrass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour produitDTO complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="produitDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="refProduit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stock" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="seuil" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fournisseur" type="{http://airbrass.stock.al30.afcepf.fr}fournisseurDTO" minOccurs="0"/>
 *         &lt;element name="prixFournisseur" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="photo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="intitule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "produitDTO", propOrder = {
    "id",
    "refProduit",
    "stock",
    "seuil",
    "fournisseur",
    "prixFournisseur",
    "photo",
    "intitule"
})
public class ProduitDTO {

    protected int id;
    protected String refProduit;
    protected int stock;
    protected int seuil;
    protected FournisseurDTO fournisseur;
    protected Double prixFournisseur;
    protected String photo;
    protected String intitule;

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété refProduit.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefProduit() {
        return refProduit;
    }

    /**
     * Définit la valeur de la propriété refProduit.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefProduit(String value) {
        this.refProduit = value;
    }

    /**
     * Obtient la valeur de la propriété stock.
     * 
     */
    public int getStock() {
        return stock;
    }

    /**
     * Définit la valeur de la propriété stock.
     * 
     */
    public void setStock(int value) {
        this.stock = value;
    }

    /**
     * Obtient la valeur de la propriété seuil.
     * 
     */
    public int getSeuil() {
        return seuil;
    }

    /**
     * Définit la valeur de la propriété seuil.
     * 
     */
    public void setSeuil(int value) {
        this.seuil = value;
    }

    /**
     * Obtient la valeur de la propriété fournisseur.
     * 
     * @return
     *     possible object is
     *     {@link FournisseurDTO }
     *     
     */
    public FournisseurDTO getFournisseur() {
        return fournisseur;
    }

    /**
     * Définit la valeur de la propriété fournisseur.
     * 
     * @param value
     *     allowed object is
     *     {@link FournisseurDTO }
     *     
     */
    public void setFournisseur(FournisseurDTO value) {
        this.fournisseur = value;
    }

    /**
     * Obtient la valeur de la propriété prixFournisseur.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPrixFournisseur() {
        return prixFournisseur;
    }

    /**
     * Définit la valeur de la propriété prixFournisseur.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPrixFournisseur(Double value) {
        this.prixFournisseur = value;
    }

    /**
     * Obtient la valeur de la propriété photo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Définit la valeur de la propriété photo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoto(String value) {
        this.photo = value;
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

}
