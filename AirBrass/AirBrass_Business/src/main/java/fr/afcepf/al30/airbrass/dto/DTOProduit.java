package fr.afcepf.al30.airbrass.dto;

import fr.afcepf.al30.airbrass.entities.Produit;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * La DTO représentant l'{@link Produit} en base de données.
 */
@Getter
@Setter
public class DTOProduit implements Serializable {

    private int id;

    private String intitule;

    private String description;

    private Double prix;

    private String photo;

    private String reference;

    private Integer stock;

    private DTOSpecialisationProduit dtoSpecialisationProduit;

    private DTOMarque dtoMarque;
    
    private DTOPromotion dtoPromotion;

    /**
     * Default constructor.
     */
    public DTOProduit() {
        //Default constructor
    }

    public DTOProduit(String intitule, String description, Double prix,
            String photo, String reference, Integer stock) {
        this.intitule = intitule;
        this.description = description;
        this.prix = prix;
        this.photo = photo;
        this.reference = reference;
        this.stock = stock;
    }

}
