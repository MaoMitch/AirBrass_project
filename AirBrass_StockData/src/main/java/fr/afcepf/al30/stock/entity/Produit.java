package fr.afcepf.al30.stock.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@Entity
@Table(name = "produit")
@Getter
@Setter
public class Produit implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "intitule", nullable = false)
    private String intitule;

    /**
     *
     */
    @Column(name = "ref_produit", length = 20, nullable = false)
    private String refProduit;

    /**
     *
     */
    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "photo", nullable = false)
    private String photo;

    /**
     *
     */
    @Column(name = "seuil", nullable = false)
    private int seuil;

    @Column(name = "prix_fournisseur", nullable = true)
    private Double prixFournisseur;

    @ManyToOne
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "produit")
    private List<LigneCommande> lignes;

    /**
     * Default constructor
     */
    public Produit() {
        //Empty constructor
    }

    public Produit(int id, String intitule, String refProduit, int stock, String photo, int seuil,
            Double prixFournisseur, Fournisseur fournisseur, List<LigneCommande> lignes) {
        this.id = id;
        this.intitule = intitule;
        this.refProduit = refProduit;
        this.stock = stock;
        this.photo = photo;
        this.seuil = seuil;
        this.prixFournisseur = prixFournisseur;
        this.fournisseur = fournisseur;
        this.lignes = lignes;
    }

}
