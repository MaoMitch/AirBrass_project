package fr.afcepf.al30.airbrass.business.api;

import fr.afcepf.al30.airbrass.dao.impl.DAOCommande;
import fr.afcepf.al30.airbrass.dto.DTOCB;
import java.util.List;

import fr.afcepf.al30.airbrass.dto.DTOCommande;
import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.dto.DTOLigneCommande;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;

/**
 * Classe contenant les methode metier pour gérer les commandes.
 */
public interface IBusinessCommande {

    /**
     * Method d'obtention de la liste des {@link DTOCommande} d'une
     * {@link DTOPersonne}.
     *
     * @param pers la {@link DTOPersonne} dont on souhaite obtenir les
     * {@link DTOCommande}.
     * @return la liste des {@link DTOCommande}
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOCommande} remonte une erreur</li>
     * </ul>
     */
    List<DTOCommande> getCommandesByUser(DTOPersonne pers) throws AirBrassException;

    /**
     * Methode d'obtention du prix d'une commande, par addition des prix des
     * différentes ligne composant la commande.
     *
     * @param cmd La {@link DTOCommande} dont on souhaite connaître le prix.
     * @return le prix de la {@link DTOCommande}
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOCommande} remonte une erreur</li>
     * </ul>
     */
    double getPrixByCommande(DTOCommande cmd) throws AirBrassException;

    /**
     * Methode d'ajout d'une {@link DTOLigneCommande}.
     *
     * @param dtoLigneCommande la {@link DTOLigneCommande} à ajouter.
     * @return la {@link DTOLigneCommande} une fois ajouter.
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOCommande} remonte une erreur</li>
     * </ul>
     */
    DTOLigneCommande addLigne(DTOLigneCommande dtoLigneCommande) throws AirBrassException;

    /**
     * Methode de mise à jour d'une commande.
     *
     * @param commande La {@link DTOCommande} à mettre à jour.
     * @return la {@link DTOCommande} mise à jour
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOCommande} remonte une erreur</li>
     * </ul>
     */
    DTOCommande updateCommande(DTOCommande commande) throws AirBrassException;

    /**
     * Methode d'ajout d'une {@link DTOCommande}.
     *
     * @param commande La {@link DTOCommande} à ajouter.
     * @return la {@link DTOCommande} une fois ajouté
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOCommande} remonte une erreur</li>
     * </ul>
     */
    DTOCommande addCommande(DTOCommande commande) throws AirBrassException;

    /**
     * Methode d'obtention de la liste des {@link DTOLigneCommande} d'une
     * {@link DTOCommande}.
     *
     * @param commande la {@link DTOCommande} dont on veux obtenir les listes
     * @return la liste des {@link DTOLigneCommande}
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOCommande} remonte une erreur</li>
     * </ul>
     */
    List<DTOLigneCommande> getLigneByCommande(DTOCommande commande) throws AirBrassException;

    /**
     * Methode d'obtention d'une {@link DTOCommande} par son ID.
     *
     * @param id l'id de la {@link DTOCommande} à obtenir
     * @return la {@link DTOCommande} lié à l'id
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOCommande} remonte une erreur</li>
     * </ul>
     */
    DTOCommande getCommandeById(int id) throws AirBrassException;
    
    /**
     * Methode d'obtention de la liste des cartes banquaire d'un client par son
     * ID.
     *
     * @param idClient l'id de la {@link DTOPersonne} dont on veux la liste des
     * cartes.
     * @return la liste des {@link DTOCB} du client.
     * @throws AirBrassException <ul>
     * <li>Si la base de données plante</li>
     * </ul>
     */
    List<DTOCB> getCBByClient(int idClient) throws AirBrassException;
    
    /**
     * Méthode d'ajout d'une carte en base de données.
     * 
     * @param dtoCb La carte à persister
     * @return la carte une fois persisté.
     * @throws AirBrassException Si erreur.
     */
    DTOCB ajouterCarte(DTOCB dtoCb)throws AirBrassException;
    
   /**
     * Méthode de mise à jour d'une carte en base de données.
     * 
     * @param dtoCb La carte à mettre à jour.
     * @return la carte une fois mise à jour.
     * @throws AirBrassException Si erreur.
     */
    DTOCB majCarte(DTOCB dtoCb)throws AirBrassException;
    
    /**
     * Méthode de supression d'une carte en base de données.
     * 
     * @param dtoCb La carte à supprimer.
     * @return true si la carte à été supprimé.
     * @throws AirBrassException Si erreur.
     */
    boolean suprCarte(DTOCB dtoCb)throws AirBrassException;
}
