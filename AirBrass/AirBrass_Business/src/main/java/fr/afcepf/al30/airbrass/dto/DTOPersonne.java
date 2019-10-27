package fr.afcepf.al30.airbrass.dto;

import fr.afcepf.al30.airbrass.entities.Personne;
import java.util.Date;
import java.util.List;

import java.io.Serializable;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 * La DTO représentant l'{@link Personne} en base de données.
 */
@Getter
@Setter
public class DTOPersonne implements Serializable {

    private int id;

    private String nom;

    private String prenom;

    private Date dateNaissance;

    private String adresseMail;

    private String telephone;

    private String password;

    private String statut;

    private List<DTOAvisClient> dtoAvisClients;

    private List<DTOAdresse> dtoAdresses;

    private List<DTOCommande> dtoCommandes;

    private List<DTOCB> dtoCBS;

    /**
     * Default constructor.
     */
    public DTOPersonne() {
        //Default constructor
    }

    public DTOPersonne(String nom, String prenom, Date dateNaissance, String adresseMail, String telephone, String password, List<DTOAdresse> dtoAdresses) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresseMail = adresseMail;
        this.telephone = telephone;
        this.password = password;
        this.dtoAdresses = dtoAdresses;
    }

    public List<DTOAdresse> getDtoAdresses() {
        if (dtoAdresses == null) {
            dtoAdresses = new ArrayList<>();
        }
        return dtoAdresses;
    }
}
