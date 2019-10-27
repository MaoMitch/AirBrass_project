package fr.afcepf.al30.banque.api;

import fr.afcepf.al30.banque.entity.CarteBanquaire;
/**
 * Acces à l'unité de persistance pour les {@link CarteBanquaire}.
 * @author Stagiaire
 *
 */
@FunctionalInterface
public interface IDaoCarteBanquaire {
  /**
   * Cherche une carte à partir de ses informations.
   * @param nom
   * @param numero
   * @param pictogrammeSecurite
   * @return
   */
  CarteBanquaire getByNomNumeroPictogramme(String nom, String numero, String pictogrammeSecurite);
 

}
