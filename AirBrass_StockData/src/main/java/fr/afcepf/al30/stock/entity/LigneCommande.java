package fr.afcepf.al30.stock.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@Entity
@Table(name = "ligne_commande")
@Getter
@Setter
public class LigneCommande implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     *
     */
    private int quantite;

    @ManyToOne
    private Commande commande;

    @ManyToOne
    private Produit produit;

    /**
     * Default constructor
     */
    public LigneCommande() {
        //Empty constructor
    }

    public LigneCommande(int id, int quantite, Commande commande, Produit produit) {
        this.id = id;
        this.quantite = quantite;
        this.commande = commande;
        this.produit = produit;
    }

}
