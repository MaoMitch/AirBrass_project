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
public class LigneCommandeDTO {

	private int id;
	private int quantite;
	private CommandeDTO commande;
	private ProduitDTO produit;
        
        public LigneCommandeDTO() {
            //Empty constructor
	}

	public LigneCommandeDTO(int id, int quantite, CommandeDTO commande, ProduitDTO produit) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.commande = commande;
		this.produit = produit;
	}

}
