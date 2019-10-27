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
public class FournisseurDTO {

	private int id;
	private String libelle;
	private String adresseMail;
	private String telephone;
	private String adresse;

        public FournisseurDTO() {
            //Empty constructor
	}
        
	public FournisseurDTO(int id, String libelle, String adresseMail, String telephone, String adresse) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.adresseMail = adresseMail;
		this.telephone = telephone;
		this.adresse = adresse;
	}
}
