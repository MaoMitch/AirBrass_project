package fr.afcepf.al30.airbrass.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
 * la Commande dans la base
 */
@Getter
@Setter
@Entity
@Table(name = "commande")
public class Commande implements Serializable {

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
    private String numero;

    /**
     *
     */
    private Date date;

    /**
     *
     */
    private String statut;

    private Double prixLivraison;

    /**
     *
     */
    @ManyToOne
    private Personne personne;

    /**
     *
     */
    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> ligneCommandes;

    /**
     * Default constructor.
     */
    public Commande() {
        //Empty constructor
    }

    public Commande(int id, String numero, Date date, String statut, Personne personne,
            List<LigneCommande> ligneCommandes) {
        super();
        this.id = id;
        this.numero = numero;
        this.date = date;
        this.statut = statut;
        this.personne = personne;
        this.ligneCommandes = ligneCommandes;
    }
}
