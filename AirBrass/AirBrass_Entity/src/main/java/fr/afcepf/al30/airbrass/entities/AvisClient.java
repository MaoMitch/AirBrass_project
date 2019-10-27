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
 * l'AvisClient dans la base
 */
@Getter
@Setter
@Entity
@Table(name = "avisClient")
public class AvisClient implements Serializable {

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
    private Integer note;

    /**
     *
     */
    private String commentaire;

    /**
     *
     */
    @ManyToOne
    private Produit produit;

    /**
     *
     */
    @ManyToOne
    private Personne personne;

    /**
     * Default constructor.
     */
    public AvisClient() {
        //Empty constructor
    }

    public AvisClient(int id, Integer note, String commentaire, Produit produit, Personne personne) {
        super();
        this.id = id;
        this.note = note;
        this.commentaire = commentaire;
        this.produit = produit;
        this.personne = personne;
    }

}
