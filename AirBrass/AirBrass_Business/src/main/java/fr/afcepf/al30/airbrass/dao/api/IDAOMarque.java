package fr.afcepf.al30.airbrass.dao.api;

import fr.afcepf.al30.airbrass.dto.DTOMarque;
import fr.afcepf.al30.airbrass.entities.Marque;
import fr.afcepf.al30.airbrass.enums.DTOTypeProduit;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import java.util.List;

import javax.ejb.Local;

/**
 * La classe contenant les methodes d'accès aux données pour les {@link Marque}.
 */
@Local
public interface IDAOMarque {

    /**
     * Methode d'obtention de toutes les marques présent dans la base de
     * données.
     *
     * @return la liste des marques
     * @throws AirBrassException Si erreur
     */
    List<DTOMarque> getAll() throws AirBrassException;

    /**
     * Methode d'obtention d'une marque par son id.
     *
     * @param id l'id de la marque à récupérer
     * @return la marque correspondant à l'id
     * @throws AirBrassException Si erreur
     */
    DTOMarque getMarqueById(int id) throws AirBrassException;

    /**
     * methode d'obtention de touts les marques proposant un produit
     * correspondant à la spécialisation.
     *
     * @param specialisationProduit la spécialisation souhaité
     * @return la liste de toutes les marques correspondantes à la
     * spécialisation
     * @throws AirBrassException Si erreur
     */
    List<DTOMarque> getMarqueBySpecialisationProduit(String specialisationProduit) throws AirBrassException;
    
    /**
     * methode d'obtention de touts les marques proposant un produit
     * correspondant au type produit souhaité.
     *
     * @param typeProduit  la {@link DTOTypeProduit} souhaité
     * @return la liste de toutes les marques correspondantes à la
     * spécialisation
     * @throws AirBrassException Si erreur
     */
    List<DTOMarque> getMarqueByTypeProduit(DTOTypeProduit typeProduit) throws AirBrassException;
}
