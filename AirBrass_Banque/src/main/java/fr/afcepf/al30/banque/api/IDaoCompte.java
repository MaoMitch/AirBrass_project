package fr.afcepf.al30.banque.api;

import fr.afcepf.al30.banque.entity.CarteBanquaire;
import fr.afcepf.al30.banque.entity.CompteBanquaire;
/**
 * Acces à l'unité de persistance pour les {@link CompteBanquaire}.
 * @author Stagiaire
 *
 */
public interface IDaoCompte {
  /**
   * Cherche le compte pour une carte existante.
   * @param cartebanquaire
   * @return
   */
  CompteBanquaire getCompteBanquaireByCarte(CarteBanquaire cartebanquaire);
  /**
   * Cherche un compte à partir de ses informations.
   * @param comptebanquaire
   * @return
   */
  CompteBanquaire getCompteBanquaireByCompte(CompteBanquaire comptebanquaire);
  /**
   * Met à jour le compte.
   * @param compteBanquaire
   */
  Boolean saveCompte(CompteBanquaire compteBanquaire);

}
