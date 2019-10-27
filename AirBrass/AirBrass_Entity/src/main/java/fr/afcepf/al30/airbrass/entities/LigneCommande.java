package fr.afcepf.al30.airbrass.entities;

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
 * la LigneCommande dans la base
 */
@Getter
@Setter
@Entity
@Table(name = "ligneCommande")
public class LigneCommande implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     *
     */
    private int quantite;

    /**
     *
     */
    @ManyToOne
    private Produit produit;

    /**
     *
     */
    @ManyToOne
    private Commande commande;

    /**
     * Default constructor.
     */
    public LigneCommande() {
        //Empty constructor
    }

    public LigneCommande(int id, int quantite, Produit produit, Commande commande) {
        super();
        this.id = id;
        this.quantite = quantite;
        this.produit = produit;
        this.commande = commande;
    }
}
