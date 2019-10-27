package fr.afcepf.al30.stock.entity;

import java.io.Serializable;
import java.util.*;

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
@Table(name = "commande")
@Getter
@Setter
public class Commande implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "intitule")
    private String intitule;

    /**
     *
     */
    private Date date;

    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> lignes;

    @ManyToOne
    private Utilisateur user;

    private String statut;

    /**
     * Default constructor
     */
    public Commande() {
        //Empty constructor
    }

    public Commande(int id, Date date, List<LigneCommande> lignes, Utilisateur user, String statut) {
        this.id = id;
        this.date = date;
        this.lignes = lignes;
        this.user = user;
        this.statut = statut;
    }

    public Commande(int id, String intitule, Date date, List<LigneCommande> lignes, Utilisateur user, String statut) {
        this(id, date, lignes, user, statut);
        this.intitule = intitule;
    }

}
