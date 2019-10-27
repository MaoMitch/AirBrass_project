package fr.afcepf.al30.airbrass.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.afcepf.al30.airbrass.enums.EnumPromotion;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "promotion")
@Getter
@Setter
public class Promotion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date_debut")
    private Date dateDebut;
    @Column(name = "date_fin")
    private Date dateFin;

    @OneToMany(mappedBy = "promotion")
    private List<Produit> produits;

    private EnumPromotion enumPromo;

    public Promotion() {
        //Empty constructor
    }

    public Promotion(int id, Date dateDebut, Date dateFin, List<Produit> produits) {
        super();
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.produits = produits;
    }

}
