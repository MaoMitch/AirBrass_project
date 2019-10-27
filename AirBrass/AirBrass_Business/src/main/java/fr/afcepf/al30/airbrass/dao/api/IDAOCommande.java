package fr.afcepf.al30.airbrass.dao.api;

import fr.afcepf.al30.airbrass.dto.DTOCommande;
import fr.afcepf.al30.airbrass.dto.DTOLigneCommande;
import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.entities.Commande;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import java.util.List;

import javax.ejb.Local;

/**
 * La classe contenant les methodes d'accès aux données pour les {@link Commande}.
 */
@Local
public interface IDAOCommande {

    /**
     * Methode d'obtention des commandes d'un client.
     *
     * @param personne la {@link DTOPersonne} dont on veut les commandes
     * @return la liste des {@link DTOCommande}
     * @throws AirBrassException Si erreur
     */
    List<DTOCommande> getCommandeByClient(DTOPersonne personne) throws AirBrassException;

    /**
     * Methode d'obtention d'une commande par son id.
     *
     * @param numero l'id de la commande à récuperer
     * @return la commande correspondant au numéro
     * @throws AirBrassException Si erreur
     */
    DTOCommande getCommandeById(int numero) throws AirBrassException;

    /**
     * Methode d'ajout d'une commande dans la base.
     *
     * @param commande la commande à ajouter dans la base de données.
     * @return la commande une fois ajouté.
     * @throws AirBrassException Si erreur
     */
    DTOCommande addCommande(DTOCommande commande) throws AirBrassException;

    /**
     * Methode d'obtention des lignes d'une commande.
     *
     * @param commande la commande dont on veux récuperer les lignes.
     * @return la liste des ligne de la commande.
     * @throws AirBrassException Si erreur
     */
    List<DTOLigneCommande> getLignesByCommande(DTOCommande commande) throws AirBrassException;

    /**
     * Methode d'obtention d'une ligne d'une commande par son id.
     *
     * @param ligneID l'id de la ligne à récupérer
     * @return la ligne correspondant à l'id
     * @throws AirBrassException Si erreur
     */
    DTOLigneCommande getLigneById(int ligneID) throws AirBrassException;

    /**
     * Methode de mise à jour d'une commande.
     *
     * @param com la commande à mettre à jour
     * @return la commande mise à jour
     * @throws AirBrassException Si erreur
     */
    DTOCommande updateCommande(DTOCommande com) throws AirBrassException;
}
