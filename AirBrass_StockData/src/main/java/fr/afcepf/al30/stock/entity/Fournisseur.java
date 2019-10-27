package fr.afcepf.al30.stock.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@Entity
@Table(name = "fournisseur")
@Getter
@Setter
public class Fournisseur implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     *
     */
    private String libelle;

    /**
     *
     */
    private String adresseMail;

    /**
     *
     */
    private String telephone;

    private String adresse;

    @OneToMany(mappedBy = "fournisseur")
    private List<Produit> produits;

    /**
     * Default constructor
     */
    public Fournisseur() {
        //Empty constructor
    }

    public Fournisseur(int id, String libelle, String adresseMail, String telephone, String adresse, List<Produit> produits) {
        this.id = id;
        this.libelle = libelle;
        this.adresseMail = adresseMail;
        this.telephone = telephone;
        this.produits = produits;
        this.adresse = adresse;
    }

}
