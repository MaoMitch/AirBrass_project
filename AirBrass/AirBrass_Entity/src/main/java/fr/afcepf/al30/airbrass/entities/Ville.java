package fr.afcepf.al30.airbrass.entities;

import java.io.Serializable;
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
 * la Ville dans la base
 */
@Getter
@Setter
@Entity
@Table(name = "ville")
public class Ville implements Serializable {

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
    private String codePostal;

    /**
     *
     */
    @ManyToOne
    private Pays pays;

    @OneToMany(mappedBy = "ville")
    private List<Adresse> adresses;

    /**
     * Default constructor.
     */
    public Ville() {
        //Empty constructor
    }

    public Ville(int id, String nom, String codePostal, Pays pays, List<Adresse> adresses) {
        super();
        this.id = id;
        this.nom = nom;
        this.codePostal = codePostal;
        this.pays = pays;
        this.adresses = adresses;
    }

}
