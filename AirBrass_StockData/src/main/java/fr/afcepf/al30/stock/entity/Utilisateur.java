package fr.afcepf.al30.stock.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@Entity
@Table(name = "utilisateur")
@Getter
@Setter
public class Utilisateur implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     *
     */
    @Column(name = "login", length = 20, nullable = false)
    private String login;

    /**
     *
     */
    @Column(name = "password", length = 20, nullable = false)
    private String password;

    /**
     *
     */
    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Commande> commandes;

    /**
     * Default constructor
     */
    public Utilisateur() {
        //Empty constructor
    }

    public Utilisateur(int id, String login, String password, String name, List<Commande> commandes) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.commandes = commandes;
    }

}
