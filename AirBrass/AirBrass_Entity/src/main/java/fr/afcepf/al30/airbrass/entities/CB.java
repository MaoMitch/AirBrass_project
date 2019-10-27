package fr.afcepf.al30.airbrass.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * la CB dans la base
 */
@Getter
@Setter
@Entity
@Table(name = "cb")
public class CB implements Serializable {

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
    private String identite;

    /**
     *
     */
    private String intitule;

    /**
     *
     */
    private String numero;

    /**
     *
     */
    private Date dateExpiration;
    
    @ManyToOne
    private Personne personne;

    /**
     * Default constructor.
     */
    public CB() {
        //Empty constructor
    }

    public CB(int id, String identite, String intitule, String numero, Date dateExpiration, Personne personne) {
        super();
        this.id = id;
        this.identite = identite;
        this.intitule = intitule;
        this.numero = numero;
        this.dateExpiration = dateExpiration;
        this.personne = personne;
    }
}
