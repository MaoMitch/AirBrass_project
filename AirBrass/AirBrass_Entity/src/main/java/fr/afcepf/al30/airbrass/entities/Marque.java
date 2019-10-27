package fr.afcepf.al30.airbrass.entities;

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
 * la Marque dans la base
 */
@Getter
@Setter
@Entity
@Table(name = "marque")
public class Marque implements Serializable {

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
    private String intitule;

    /**
     *
     */
    private String logo;

    /**
     *
     */
    @OneToMany(mappedBy = "marque")
    private List<Produit> produits;

    /**
     * Default constructor.
     */
    public Marque() {
        //Empty constructor
    }

    public Marque(int id, String intitule, String logo, List<Produit> produits) {
        super();
        this.id = id;
        this.intitule = intitule;
        this.logo = logo;
        this.produits = produits;
    }
}
