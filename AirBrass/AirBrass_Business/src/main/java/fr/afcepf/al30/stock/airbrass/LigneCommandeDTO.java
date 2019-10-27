
package fr.afcepf.al30.stock.airbrass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ligneCommandeDTO complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ligneCommandeDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="quantite" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="commande" type="{http://airbrass.stock.al30.afcepf.fr}commandeDTO" minOccurs="0"/>
 *         &lt;element name="produit" type="{http://airbrass.stock.al30.afcepf.fr}produitDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ligneCommandeDTO", propOrder = {
    "id",
    "quantite",
    "commande",
    "produit"
})
public class LigneCommandeDTO {

    protected int id;
    protected int quantite;
    protected CommandeDTO commande;
    protected ProduitDTO produit;

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

    /**
     * Obtient la valeur de la propriété commande.
     * 
     * @return
     *     possible object is
     *     {@link CommandeDTO }
     *     
     */
    public CommandeDTO getCommande() {
        return commande;
    }

    /**
     * Définit la valeur de la propriété commande.
     * 
     * @param value
     *     allowed object is
     *     {@link CommandeDTO }
     *     
     */
    public void setCommande(CommandeDTO value) {
        this.commande = value;
    }

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

}
