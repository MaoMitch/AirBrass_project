
package fr.afcepf.al30.stock.airbrass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ajoutStock complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ajoutStock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="produit" type="{http://airbrass.stock.al30.afcepf.fr}produitDTO" minOccurs="0"/>
 *         &lt;element name="quantite" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ajoutStock", propOrder = {
    "produit",
    "quantite"
})
public class AjoutStock {

    protected ProduitDTO produit;
    protected int quantite;

    /**
     * Obtient la valeur de la propriété produit.
     * 
     * @return
     *     possible object is
     *     {@link ProduitDTO }
     *     
     */
    public ProduitDTO getProduit() {
        return produit;
    }

    /**
     * Définit la valeur de la propriété produit.
     * 
     * @param value
     *     allowed object is
     *     {@link ProduitDTO }
     *     
     */
    public void setProduit(ProduitDTO value) {
        this.produit = value;
    }

    /**
     * Obtient la valeur de la propriété quantite.
     * 
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Définit la valeur de la propriété quantite.
     * 
     */
    public void setQuantite(int value) {
        this.quantite = value;
    }

}
