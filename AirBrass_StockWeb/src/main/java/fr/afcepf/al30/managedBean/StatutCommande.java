package fr.afcepf.al30.managedBean;

import lombok.Getter;

@Getter
public enum StatutCommande {
	
	EN_COURS("En cours"),
	RECEPTIONNE("Reception");
	
	private String value;

	private StatutCommande(String value) {
		this.value = value;
	}
	
	

}
