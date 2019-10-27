package fr.afcepf.al30.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.afcepf.al30.entity.Disponibilite;
import fr.afcepf.al30.entity.Niveau;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class FormationDTO {
	private Integer id;
	private String intitule;
	private Date date;
	private Double prix;
	private Disponibilite disponibilite;
	private Niveau niveau;
	private FormateurDTO formateur;
}
