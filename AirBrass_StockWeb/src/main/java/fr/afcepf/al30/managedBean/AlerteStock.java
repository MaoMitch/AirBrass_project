package fr.afcepf.al30.managedBean;

import lombok.Getter;

/**
 * 
 */
@Getter
public enum AlerteStock {
	STOCK_OK("OK"),
	STOCK_VIDE("A commander"),
	STOCK_LIMITE("Faible Stock");
	
	private String dispo;

	private AlerteStock(String dispo) {
		this.dispo = dispo;
	}	
	
}