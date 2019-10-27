package fr.afcepf.al30.airbrass.business.api;

import fr.afcepf.al30.airbrass.dao.impl.DAOClient;
import java.util.List;

import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;

/**
 * Classe contenant les methodes metier de gestion d'utilisateur.
 */
public interface IBusinessUtilisateur {

    /**
     * Methode d'obtention d'une {@link DTOPersonne} par son id.
     *
     * @param id l'id du {@link DTOPersonne} à obtenir
     * @return la {@link DTOPersonne} correspondante à l'id
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOClient} remonte une erreur</li>
     * </ul>
     */
    DTOPersonne getClientById(int id) throws AirBrassException;

    /**
     * Methode d'obtention de la liste des {@link DTOPersonne} présentes en
     * base.
     *
     * @return la liste des {@link DTOPersonne}
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOClient} remonte une erreur</li>
     * </ul>
     */
    List<DTOPersonne> getAllClient() throws AirBrassException;

    /**
     * Création d'un nouveau client dans la base de données.
     *
     * @param pers la {@link DTOPersonne} à ajouter au programme.
     * @return la {@link DTOPersonne} une fois ajoutée.
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOClient} remonte une erreur</li>
     * </ul>
     */
    DTOPersonne createNewClient(DTOPersonne pers) throws AirBrassException;

    /**
     * Mise à jour d'un client dans la base de données.
     *
     * @param pers la {@link DTOPersonne} à metre à jour.
     * @return la {@link DTOPersonne} mise à jour.
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOClient} remonte une erreur</li>
     * </ul>
     */
    DTOPersonne udapteClient(DTOPersonne pers) throws AirBrassException;

    /**
     * Methode de connection au programme..
     *
     * @param login le login de la {@link DTOPersonne}
     * @param password le password de la {@link DTOPersonne}
     * @return la {@link DTOPersonne} correspondante au login et au password
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOClient} remonte une erreur</li>
     * </ul>
     */
    DTOPersonne connectClient(String login, String password) throws AirBrassException;
}
