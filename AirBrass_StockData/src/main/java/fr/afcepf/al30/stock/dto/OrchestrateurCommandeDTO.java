package fr.afcepf.al30.stock.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrchestrateurCommandeDTO {

    private String refProduit;
    private int qteProduit;

    public OrchestrateurCommandeDTO() {
        //Empty constructor
    }

    public OrchestrateurCommandeDTO(String refProduit, int qteProduit) {
        this.refProduit = refProduit;
        this.qteProduit = qteProduit;
    }
}
