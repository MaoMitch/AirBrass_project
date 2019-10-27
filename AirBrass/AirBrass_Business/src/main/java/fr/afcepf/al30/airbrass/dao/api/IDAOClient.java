package fr.afcepf.al30.airbrass.dao.api;

import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.entities.Personne;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import java.util.List;

import javax.ejb.Local;

/**
 * La classe contenant les methodes d'accès aux données pour les {@link Personne}.
 */
@Local
public interface IDAOClient {

    /**
     * Methode d'obtention d'un client par son ID.
     *
     * @param id l'ID du client que l'on veut récupérer
     * @return la {@link DTOPersonne} correspondant à l'ID
     * @throws AirBrassException <ul>
     * <li>Si l'intégrité des données n'est pas respecté</li>
     * </ul>
     */
    public DTOPersonne getClientById(int id) throws AirBrassException;

    /**
     * Methode d'obtention de toute les {@link DTOPersonne} présente dans la
     * base.
     *
     * @return liste des {@link DTOPersonne} présente dans la base
     * @throws AirBrassException jamais
     */
    public List<DTOPersonne> getAllClient() throws AirBrassException;

    /**
     * Methode de persistence d'un client dans la base.
     *
     * @param pers la {@link DTOPersonne} à persister.
     * @return la {@link DTOPersonne} une fois persisté
     * @throws AirBrassException Si ça plante.
     */
    DTOPersonne saveClient(DTOPersonne pers) throws AirBrassException;
    
    /**
     * Methode de vérification qu'un client avec l'adresse mail donnée n'existe
     * pas dans la base avant de le persister.
     *
     * @param adresseMail l'adresse mail dont on veux savoir si elle existe dans
     * la base.
     * @return <ul>
     * <li>true si l'adresse mail n'est pas présente dans la base.</li>
     * <li>false sinon</li>
     * </ul>
     * @throws AirBrassException Si erreur
     */
    boolean clientDontExist(String adresseMail) throws AirBrassException;

    /**
     * Methode de connection d'une {@link DTOPersonne} par son login et son
     * password.
     *
     * @param login le login de connection.
     * @param password le password correspondant au login.
     * @return La {@link DTOPersonne} une fois connecté.
     * @throws AirBrassException <ul>
     * <li>Si l'utilisateur n'existe as dans la base</li>
     * <li>autre erreur</li>
     * </ul>
     */
    public DTOPersonne connectClient(String login, String password) throws AirBrassException;

}
