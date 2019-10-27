package fr.afcepf.al30.airbrass.dao.api;

import fr.afcepf.al30.airbrass.dto.DTOAvisClient;
import fr.afcepf.al30.airbrass.entities.AvisClient;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.AssembleurException;

import java.util.List;

import javax.ejb.Local;

/**
 * La classe contenant les methodes d'accès aux données pour les {@link AvisClient}.
 */
@Local
public interface IDAOAvisClient {

    /**
     * Methode d'ajout d'un avis client dans la base de données.
     *
     * @param avis {@link DTOAvisClient} à persister.
     * @throws AirBrassException <ul>
     * <li>Si l'integrité des données n'est pas respecté</li>
     * <li>Si l'avis est déjà présent dans la base</li>
     * </ul>
     */
    public void createNewAvisClient(DTOAvisClient avis) throws AirBrassException;

    /**
     * Methode de retrait d'un avis client dans la base de données.
     *
     * @param avisClient {@link DTOAvisClient} à retirer.
     * @throws AirBrassException <ul>
     * <li>Si l'integrité des données n'est pas respecté</li>
     * </ul>
     */
    public void removeAvisClient(DTOAvisClient avisClient) throws AirBrassException;

    /**
     * Methode d'obtention de tous les avis d'un client.
     *
     * @param idClient l'ID du client dont on souhaite les avis
     * @return la liste des {@link DTOAvisClient} appartenant au client
     * @throws AirBrassException <ul>
     * <li>Si la base de données plante</li>
     * </ul>
     */
    public List<DTOAvisClient> getAllAvisByClient(int idClient) throws AirBrassException;

	List<DTOAvisClient> getAvisClientByProduit(int idProduit) throws AssembleurException;

}
