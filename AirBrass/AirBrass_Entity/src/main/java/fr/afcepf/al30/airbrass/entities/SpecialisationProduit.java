package fr.afcepf.al30.airbrass.entities;

import fr.afcepf.al30.airbrass.enums.TypeProduit;
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
 * la SpecialisationProduit dans la base
 */
@Getter
@Setter
@Entity
@Table(name = "specialisationProduit")
public class SpecialisationProduit implements Serializable {

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

    private TypeProduit typeProduit;

    @OneToMany(mappedBy = "specialisationProduit")
    private List<Produit> produits;

    /**
     * Default constructor.
     */
    public SpecialisationProduit() {
        //Empty constructor
    }

    public SpecialisationProduit(int id, String intitule, TypeProduit typeProduit, List<Produit> produits) {
        super();
        this.id = id;
        this.intitule = intitule;
        this.typeProduit = typeProduit;
        this.produits = produits;
    }
}
