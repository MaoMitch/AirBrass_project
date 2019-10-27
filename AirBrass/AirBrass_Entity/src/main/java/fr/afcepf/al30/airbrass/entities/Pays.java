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
 * la Pays dans la base
 */
@Getter
@Setter
@Entity
@Table(name = "pays")
public class Pays implements Serializable {

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
    @OneToMany(mappedBy = "pays")
    private List<Ville> villes;

    /**
     * Default constructor.
     */
    public Pays() {
        //Empty constructor
    }

    public Pays(int id, String nom, List<Ville> villes) {
        super();
        this.id = id;
        this.nom = nom;
        this.villes = villes;
    }

}
