package fr.afcepf.al30.airbrass.dto;

import fr.afcepf.al30.airbrass.entities.Marque;
import java.util.List;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * La DTO représentant l'{@link Marque} en base de données.
 */
@Getter
@Setter
public class DTOMarque implements Serializable {

    private int id;

    private String intitule;

    private String logo;

    private List<DTOProduit> dtoProduits;

    /**
     * Default constructor.
     */
    public DTOMarque() {
        //Default constructor
    }

    public DTOMarque(String intitule, String logo) {
        this.intitule = intitule;
        this.logo = logo;
    }
}
