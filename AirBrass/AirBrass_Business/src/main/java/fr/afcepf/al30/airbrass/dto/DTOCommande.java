package fr.afcepf.al30.airbrass.dto;

import fr.afcepf.al30.airbrass.entities.Commande;
import java.util.Date;
import java.util.List;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * La DTO représentant l'{@link Commande} en base de données.
 */
@Getter
@Setter
public class DTOCommande implements Serializable {

    private int id;

    private String numero;

    private Date date;

    private String statut;
    
    private Double prixLivraison;

    private DTOPersonne dtoPersonne;

    private List<DTOLigneCommande> dtoLigneCommandes;
    
    private DTOCB dtoCb;

    /**
     * Default constructor.
     */
    public DTOCommande() {
        //Default constructor
    }

    public DTOCommande(String numero, Date date, String statut, DTOPersonne dtoPersonne, DTOCB dtoCb) {
        this.numero = numero;
        this.date = date;
        this.statut = statut;
        this.dtoPersonne = dtoPersonne;
        this.dtoCb = dtoCb;
    }
}
