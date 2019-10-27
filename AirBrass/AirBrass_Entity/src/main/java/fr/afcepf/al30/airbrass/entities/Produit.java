package fr.afcepf.al30.airbrass.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * la Produit dans la base
 */
@Getter
@Setter
@Entity
@Table(name = "produit")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Produit implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     *
     */
    @Column(length = 2500)
    private String intitule;

    /**
     *
     */
    @Column(length = 25000)
    private String description;

    /**
     *
     */
    private Double prix;

    /**
     *
     */
    private String photo;

    /**
     *
     */
    private String reference;

    /**
     *
     */
    @ManyToOne
    private SpecialisationProduit specialisationProduit;

    /**
     *
     */
    @ManyToOne
    private Marque marque;

    /**
     *
     */
    @OneToMany(mappedBy = "produit")
    private List<LigneCommande> ligneCommandes;

    /**
     *
     */
    @OneToMany(mappedBy = "produit")
    private List<AvisClient> avisClients;

    @OneToMany(mappedBy = "produit")
    private List<Vues> vuesProduit;

    @ManyToOne
    private Promotion promotion;

    /**
     * Default constructor.
     */
    public Produit() {
        //Empty constructor
    }

    public Produit(int id, String intitule, String description, Double prix, String photo, String reference, SpecialisationProduit specialisationProduit, Marque marque, List<LigneCommande> ligneCommandes, List<AvisClient> avisClients) {
        super();
        this.id = id;
        this.intitule = intitule;
        this.description = description;
        this.prix = prix;
        this.photo = photo;
        this.reference = reference;
        this.specialisationProduit = specialisationProduit;
        this.marque = marque;
        this.ligneCommandes = ligneCommandes;
        this.avisClients = avisClients;
    }
}
