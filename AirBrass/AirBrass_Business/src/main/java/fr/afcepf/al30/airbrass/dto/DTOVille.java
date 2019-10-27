package fr.afcepf.al30.airbrass.dto;

import fr.afcepf.al30.airbrass.entities.Ville;
import java.util.List;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * La DTO représentant l'{@link Ville} en base de données.
 */
@Getter
@Setter
public class DTOVille implements Serializable {

    private int id;

    private String nom;

    private String codePostal;

    private DTOPays dtoPays;

    private List<DTOAdresse> dtoAdresses;

    /**
     * Default constructor.
     */
    public DTOVille() {
        //Default constructor
    }

    public DTOVille(String nom, String codePostal, DTOPays dtoPays) {
        this.nom = nom;
        this.codePostal = codePostal;
        this.dtoPays = dtoPays;
    }

}
