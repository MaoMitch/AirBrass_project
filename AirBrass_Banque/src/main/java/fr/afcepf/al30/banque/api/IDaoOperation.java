package fr.afcepf.al30.banque.api;

import fr.afcepf.al30.banque.entity.Operation;
/**
 * Acces à l'unité de persistance pour les {@link Operation}.
 * @author Stagiaire
 *
 */
@FunctionalInterface
public interface IDaoOperation {
  /**
   * Enregistre l'operation.
   * @param operation
   */
  Boolean saveOperation(Operation operation);

}
