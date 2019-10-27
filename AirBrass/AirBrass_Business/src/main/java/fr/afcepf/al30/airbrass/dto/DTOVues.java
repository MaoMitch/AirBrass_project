package fr.afcepf.al30.airbrass.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DTOVues implements Serializable{
	
	
	private int id;
	
	private Date dateClique;
	
	private DTOProduit dtoProduit;

	public DTOVues() {
            //Empty constructor
	}

	public DTOVues(Date dateClique, DTOProduit dtoProduit) {
		this.dateClique = dateClique;
		this.dtoProduit = dtoProduit;
	}

}
