package fr.afcepf.al30.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Entity
@Table(name="ws_formation")
@Getter
@Setter
public class Formation {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="intitule")
	private String intitule;
	@Column(name="prix")
	private Double prix;
	@Column(name="date_formation")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Column(name="disponibilite")
	private Disponibilite disponibilite;
	@Column(name="niveau")
	private Niveau niveau;
	@ManyToOne
	@JoinColumn(name="formateur")
	private Formateur formateur;	
}

