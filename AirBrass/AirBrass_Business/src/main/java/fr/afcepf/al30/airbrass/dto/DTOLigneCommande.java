package fr.afcepf.al30.airbrass.dto;

import fr.afcepf.al30.airbrass.entities.LigneCommande;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * La DTO représentant l'{@link LigneCommande} en base de données.
 */
@Getter
@Setter
public class DTOLigneCommande implements Serializable {

    private int id;

    private int quantite;

    private DTOProduit dtoProduit;

    private DTOCommande dtoCommande;

    /**
     * Default constructor.
     */
    public DTOLigneCommande() {
        //Default constructor
    }

    public DTOLigneCommande(int quantite, DTOProduit dtoProduit, DTOCommande dtoCommande) {
        this.quantite = quantite;
        this.dtoProduit = dtoProduit;
        this.dtoCommande = dtoCommande;
    }
}
