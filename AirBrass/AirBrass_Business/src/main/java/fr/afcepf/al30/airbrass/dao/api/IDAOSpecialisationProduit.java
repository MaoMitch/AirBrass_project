package fr.afcepf.al30.airbrass.dao.api;

import fr.afcepf.al30.airbrass.dto.DTOSpecialisationProduit;
import fr.afcepf.al30.airbrass.entities.SpecialisationProduit;
import fr.afcepf.al30.airbrass.enums.DTOTypeProduit;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import java.util.List;

import javax.ejb.Local;

/**
 * La classe contenant les methodes d'accès aux données pour les
 * {@link SpecialisationProduit}.
 */
@Local
public interface IDAOSpecialisationProduit {

    /**
     * Methode d'obtention de toutes les spécialisations correspondant à un type
     * de produit.
     *
     * @param typeProduit le {@link DTOTypeProduit} dont on veux les spécialisation
     * @return la liste des spécialisation correspondant au type
     * @throws AirBrassException Si erreur
     */
    List<DTOSpecialisationProduit> getSpecialisationProduitByTypeProduit(DTOTypeProduit typeProduit) throws AirBrassException;

    /**
     * Methode d'obtention de toute les spécialisations présente dans la base.
     *
     * @return la liste des spécialisations de la base
     * @throws AirBrassException Si erreur
     */
    List<DTOSpecialisationProduit> getAll() throws AirBrassException;

}
