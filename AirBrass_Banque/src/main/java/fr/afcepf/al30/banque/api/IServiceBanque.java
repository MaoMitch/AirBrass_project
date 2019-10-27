package fr.afcepf.al30.banque.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Service web de la banque.
 * @author Stagiaire
 *
 */
@WebService(targetNamespace = "http://banque.al30.afcepf.fr", name = "banque")
public interface IServiceBanque {

  /**
   * Methode permettant de connaitre si une carte existe.
   * @param carteJson Carte à tester.
   * @return true si la carte existe.
   */
  @WebMethod(operationName = "carteExiste")
  @WebResult(name = "returnCarteExiste")
  Boolean existe(@WebParam(name = "carteJson") String carteJson);

  /**
   * Methode permettant de savoir si un solde est supérieur à la somme demandé.
   * @param somme Somme à tester.
   * @param carteJson Carte à tester.
   * @return true si le solde est suffisant.
   */
  @WebMethod(operationName = "verifiersolde")
  @WebResult(name = "validitesolde")
  Boolean verifiersolde(@WebParam(name = "sommeadebite") double somme,@WebParam(name = "carteJson") String carteJson);

  /**
   * Methode pour débiter une carte.
   * @param somme
   * @param paramCarteADebiter Carte qui paye.
   * @param paramCompteACrediter Compte qui recoit l'argent.
   * @return true si l'operation reussi. false si elle echoue.
   */
  @WebMethod(operationName = "debiterCarte")
  @WebResult(name = "EtatOperationDebit")
  Boolean debiterCarte(@WebParam(name = "sommeadebiter") double somme, @WebParam(name = "carteADebiter") String paramCarteADebiter,
	      @WebParam(name = "compteACrediter") String paramCompteACrediter);
  
  /**
   * Methode pour rembourser une carte.
   * @param somme Somme a rembourser.
   * @param paramCarteACrediter Carte à rembourser.
   * @param paramCompteADebiter Compte payeur.
   * @return true si l'opération réussi. false si elle echoue.
   */
  @WebMethod(operationName = "crediterCarte")
  @WebResult(name = "EtatOperationCredit")
  Boolean crediterCarte(@WebParam(name = "sommeacrediter") double somme, @WebParam(name = "carteACrediter") String paramCarteACrediter,
	      @WebParam(name = "compteADebiter") String paramCompteADebiter);

}
