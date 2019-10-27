package fr.afcepf.al30.airbrass.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrchestrateurCarteBanquaire implements Serializable {

	private String nom;

	private String numero;

	private String pictogrammeSecurite;


	public OrchestrateurCarteBanquaire() {
		super();
	}


	public OrchestrateurCarteBanquaire(String nom, String numero, String pictogrammeSecurite) {
		super();
		this.nom = nom;
		this.numero = numero;
		this.pictogrammeSecurite = pictogrammeSecurite;
	}


}
