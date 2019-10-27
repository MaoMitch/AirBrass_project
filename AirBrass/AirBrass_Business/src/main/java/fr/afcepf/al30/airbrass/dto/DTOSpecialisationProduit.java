package fr.afcepf.al30.airbrass.dto;

import fr.afcepf.al30.airbrass.entities.SpecialisationProduit;
import fr.afcepf.al30.airbrass.enums.DTOTypeProduit;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * La DTO représentant l'{@link SpecialisationProduit} en base de données.
 */
@Getter
@Setter
public class DTOSpecialisationProduit implements Serializable {

    private int id;

    private String intitule;

    private DTOTypeProduit dtoTypeProduit;


    /**
     * Default constructor.
     */
    public DTOSpecialisationProduit() {
        //Default constructor
    }

    public DTOSpecialisationProduit(String intitule, String dtoTypeProduit) {
        this.intitule = intitule;
        this.dtoTypeProduit = DTOTypeProduit.fromValue(dtoTypeProduit);
    }
}
