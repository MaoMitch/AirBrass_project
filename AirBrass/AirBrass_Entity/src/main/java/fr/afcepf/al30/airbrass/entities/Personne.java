package fr.afcepf.al30.airbrass.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * la Personne dans la base
 */
@Getter
@Setter
@Entity
@Table(name = "personne")
public class Personne implements Serializable {

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
    private String nom;

    /**
     *
     */
    private String prenom;

    /**
     *
     */
    private Date dateNaissance;

    /**
     *
     */
    private String adresseMail;

    /**
     *
     */
    private String telephone;

    /**
     *
     */
    private String password;

    private String salt;

    /**
     *
     */
    private String statut;

    /**
     *
     */
    @OneToMany(mappedBy = "personne")
    private List<AvisClient> avisClients;

    /**
     *
     */
    @ManyToMany
    private List<Adresse> adresses;

    /**
     *
     */
    @OneToMany(mappedBy = "personne")
    private List<Commande> commandes;

    @OneToMany(mappedBy = "personne")
    private List<CB> cbs;

    /**
     * Default constructor.
     */
    public Personne() {
        //Empty constructor
    }

    public Personne(int id, String nom, String prenom, Date dateNaissance, String adresseMail, String telephone,
            String password, String statut, List<AvisClient> avisClients, List<Adresse> adresses, List<Commande> commandes) {
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresseMail = adresseMail;
        this.telephone = telephone;
        this.password = password;
        this.statut = statut;
        this.avisClients = avisClients;
        this.adresses = adresses;
        this.commandes = commandes;
    }

    public List<Adresse> getAdresses() {
        if (adresses == null) {
            adresses = new ArrayList<>();
        }
        return adresses;
    }
}
