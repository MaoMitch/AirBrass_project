package fr.afcepf.al30.stock.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class CommandeDTO {

    private int id;
    private Date date;
    private UtilisateurDTO user;
    private String statut;
    private String intitule;

    public CommandeDTO() {
        //Empty constructor
    }

    public CommandeDTO(int id, Date date, UtilisateurDTO user, String statut) {

        this.id = id;
        this.date = date;
        this.user = user;
        this.statut = statut;
    }

    public CommandeDTO(int id, Date date, UtilisateurDTO user, String statut, String intitule) {
        this(id, date, user, statut);
        this.intitule = intitule;
    }

}
