package fr.afcepf.al30.airbrass.serviceentities;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 * Un ligne de commande pour la gestion des commande an angular.
 */
@Getter
@Setter
@XmlRootElement(name="ligneComParam")
public class LigneComParam {
	
	private int id;
	private int quantite;
	private String nom;
	private double prix;
	private String photo;

}
