package fr.afcepf.al30.airbrass.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrchestrateurCommande {
	
	private String refProduit;
	private int qteProduit;
	
	
	public OrchestrateurCommande() {
		super();
	}


	public OrchestrateurCommande(String refProduit, int qteProduit) {
		super();
		this.refProduit = refProduit;
		this.qteProduit = qteProduit;
	}


}
