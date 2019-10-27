package fr.afcepf.al30.airbrass.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrchestrateurCompte {

	private String nomCompte;

	private String numeroCompte;

	public OrchestrateurCompte() {
		super();
	}

	public OrchestrateurCompte(String nomCompte, String numeroCompte) {
		super();
		this.nomCompte = nomCompte;
		this.numeroCompte = numeroCompte;
	}




}
