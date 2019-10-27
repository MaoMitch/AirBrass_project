package fr.afcepf.al30.airbrass.dto;

import fr.afcepf.al30.airbrass.entities.Adresse;
import java.util.List;

import java.io.Serializable;
import lombok.Setter;
import lombok.Getter;

/**
 * La DTO représentant l'{@link Adresse} en base de données.
 */
@Getter
@Setter
public class DTOAdresse implements Serializable {

    private int id;

    private int numero;

    private String rue;

    private String complement;

    private List<DTOPersonne> dtoPersonnes;

    private DTOVille dtoVille;

    /**
     * Default constructor.
     */
    public DTOAdresse() {
        //Default constructor
    }

    public DTOAdresse(int numero, String rue, String complement, DTOVille dtoVille) {
        this.numero = numero;
        this.rue = rue;
        this.complement = complement;
        this.dtoVille = dtoVille;
    }
}
