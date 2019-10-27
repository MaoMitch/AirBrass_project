package fr.afcepf.al30.airbrass.dto;

import fr.afcepf.al30.airbrass.entities.Pays;
import java.util.List;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * La DTO représentant l'{@link Pays} en base de données.
 */
@Getter
@Setter
public class DTOPays implements Serializable {

    private Integer id;

    private String nom;

    private List<DTOVille> dtoVlles;

    /**
     * Default constructor.
     */
    public DTOPays() {
        //Default constructor
    }

    public DTOPays(String nom) {
        this.nom = nom;
    }

}
