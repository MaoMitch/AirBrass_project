package fr.afcepf.al30.airbrass.dao.api;

import fr.afcepf.al30.airbrass.dto.DTOCB;
import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.entities.CB;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import java.util.List;

import javax.ejb.Local;

/**
 * La classe contenant les methodes d'accès aux données pour les {@link CB}.
 */
@Local
public interface IDAOCB {

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
