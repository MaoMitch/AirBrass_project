package fr.afcepf.al30.airbrass.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vues")
@Getter
@Setter
public class Vues implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_clique")
    private Date dateClique;

    @ManyToOne
    private Produit produit;

    public Vues() {
        //Empty constructor
    }

    public Vues(int id, Date dateClique, Produit produit) {
        super();
        this.id = id;
        this.dateClique = dateClique;
        this.produit = produit;
    }

}
