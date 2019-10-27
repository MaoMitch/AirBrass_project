package fr.afcepf.al30.airbrass.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * l'Addresse dans la base
 */
@Entity
@Table(name = "adresse")
@Getter
@Setter
public class Adresse implements Serializable {

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
    //
    private int numero;

    /**
     *
     */
    private String rue;

    /**
     *
     */
    @Column(nullable = true)
    private String complement;

    /**
     *
     */
    @ManyToMany(mappedBy = "adresses")
    @Column(nullable = true)
    private List<Personne> personnes;

    /**
     *
     */
    @ManyToOne
    private Ville ville;

    /**
     * Default constructor.
     */
    public Adresse() {
        //Empty constructor
    }

    public Adresse(int id, int numero, String rue, String complement, List<Personne> personnes, Ville ville) {
        super();
        this.id = id;
        this.numero = numero;
        this.rue = rue;
        this.complement = complement;
        this.personnes = personnes;
        this.ville = ville;
    }
}
