package fr.afcepf.al30.banque.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
/**
 * Entité opération.
 * @author Stagiaire
 *
 */
@Entity
@Getter
@Setter
public class Operation {
  /**
   * Identifiant unique dans l'unité de persistance.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  /**
   * Somme de l'opération.
   */
  private double sommeTransfere;
  /**
   * Date de l'opération.
   */
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;
  /**
   * Compte qui est débité.
   */
  @ManyToOne
  @JoinColumn(name ="id_compte_payeur")
  private CompteBanquaire comptePayeur;
  /**
   * Compte qui est crédité.
   */
  @ManyToOne
  @JoinColumn(name ="id_compte_receveur")
  private CompteBanquaire compteReceveur;
  
  /**
   * Constructeur vide.
   */
  public Operation() {
    super();
  }

  /**
   * Contructeur complet.
   * @param paramSommeTransfere
   * @param paramDate
   * @param paramComptePayeur
   * @param paramCompteReceveur
   */
  public Operation(double paramSommeTransfere, Date paramDate, CompteBanquaire paramComptePayeur,
      CompteBanquaire paramCompteReceveur) {
    super();
    sommeTransfere = paramSommeTransfere;
    date = paramDate;
    comptePayeur = paramComptePayeur;
    compteReceveur = paramCompteReceveur;
  }
  
}
