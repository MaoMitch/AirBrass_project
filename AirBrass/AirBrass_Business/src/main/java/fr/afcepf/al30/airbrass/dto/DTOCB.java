package fr.afcepf.al30.airbrass.dto;

import fr.afcepf.al30.airbrass.entities.CB;
import java.util.Date;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * La DTO représentant l'{@link CB} en base de données.
 */
@Getter
@Setter
public class DTOCB implements Serializable {

    private int id;

    private String identite;

    private String intitule;

    private String numero;

    private Date dateExpiration;

    private int cle;
    
    private DTOPersonne dtoPersonne;

    /**
     * Default constructor.
     */
    public DTOCB() {
        //Default constructor
    }

    public DTOCB(String identite, String intitule, String numero, Date dateExpiration, int cle, DTOPersonne dtoPersonne) {
        this.identite = identite;
        this.intitule = intitule;
        this.numero = numero;
        this.dateExpiration = dateExpiration;
        this.cle = cle;
        this.dtoPersonne = dtoPersonne;
    }
    
    
}
