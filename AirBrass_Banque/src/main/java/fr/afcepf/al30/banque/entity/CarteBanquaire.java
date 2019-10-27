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
 * Entite Carte Banquaire.
 * @author Stagiaire
 *
 */
@Entity
@Getter
@Setter
public class CarteBanquaire {
  /**
   * Identifiant unique dans l'unité de persistance.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  /**
   * Nom de la carte.
   */
  private String nom;
  /**
   * Numero de la carte.
   */
  private String numero;
  /**
   * Tryptique de la carte.
   */
  private String pictogrammeSecurite;
  /**
   * Date limite de validité de la carte.
   */
  @Temporal(TemporalType.DATE)
  private Date dateValidite;
  /**
   * {@link CompteBanquaire} de la carte.
   */
  @ManyToOne
  @JoinColumn(name = "id_compte")
  private CompteBanquaire compte;

}
