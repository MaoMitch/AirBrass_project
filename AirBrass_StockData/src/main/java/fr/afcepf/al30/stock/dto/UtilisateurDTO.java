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
public class UtilisateurDTO {

    private int id;
    private String login;
    private String password;
    private String name;

    public UtilisateurDTO() {
        //Empty constructor
    }

    public UtilisateurDTO(int id, String login, String password, String name) {
        super();
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
    }

}
