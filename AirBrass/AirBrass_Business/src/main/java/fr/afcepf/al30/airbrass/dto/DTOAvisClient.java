package fr.afcepf.al30.airbrass.dto;

import fr.afcepf.al30.airbrass.entities.AvisClient;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * La DTO représentant l'{@link AvisClient} en base de données.
 */
@Getter
@Setter
public class DTOAvisClient implements Serializable {

    private int id;

    private Integer note;

    private String commentaire;

    private DTOProduit dtoProduit;

    private DTOPersonne dtoPersonne;

    /**
     * Default constructor.
     */
    public DTOAvisClient() {
        //Default constructor
    }

    public DTOAvisClient(Integer note, String commentaire, DTOProduit dtoProduit, DTOPersonne dtoPersonne) {
        this.note = note;
        this.commentaire = commentaire;
        this.dtoProduit = dtoProduit;
        this.dtoPersonne = dtoPersonne;
    }
}
