package fr.afcepf.al30.stock.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class ProduitDTO {

    private int id;
    private String refProduit;
    private int stock;
    private int seuil;
    private FournisseurDTO fournisseur;
    private Double prixFournisseur;
    private String photo;
    private String intitule;

    public ProduitDTO() {
        //Empty constructor
    }

    public ProduitDTO(int id, String refProduit, int stock, int seuil, FournisseurDTO fournisseur,
            Double prixFournisseur, String photo, String intitule) {

        this.id = id;
        this.refProduit = refProduit;
        this.stock = stock;
        this.seuil = seuil;
        this.fournisseur = fournisseur;
        this.prixFournisseur = prixFournisseur;
        this.photo = photo;
        this.intitule = intitule;
    }

}
