package fr.afcepf.al30.airbrass.business.api;

import fr.afcepf.al30.airbrass.dao.impl.DAOMarque;
import fr.afcepf.al30.airbrass.dao.impl.DAOProduit;
import fr.afcepf.al30.airbrass.dao.impl.DAOSpecialisationProduit;
import java.util.List;

import fr.afcepf.al30.airbrass.dto.DTOAvisClient;
import fr.afcepf.al30.airbrass.dto.DTOMarque;
import fr.afcepf.al30.airbrass.dto.DTOProduit;
import fr.afcepf.al30.airbrass.dto.DTOSpecialisationProduit;
import fr.afcepf.al30.airbrass.dto.DTOVues;
import fr.afcepf.al30.airbrass.enums.DTOTypeProduit;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.AssembleurException;

/**
 * Classe contenant les methodes metier pour gérer les produits.
 */
public interface IBusinessProduit {

    /**
     * Methode d'obtention de la totalité des {@link DTOProduit} présent dans la
     * base de données.
     *
     * @return la liste des {@link DTOProduit}
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOProduit} remonte une erreur</li>
     * </ul>
     */
    List<DTOProduit> getAllProduits() throws AirBrassException;

    /**
     * Methode d'obtention de la totalité des {@link DTOProduit} de type Guitare
     * présent dans la base de données.
     *
     * @return la liste des {@link DTOProduit} de type Guitare
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOProduit} remonte une erreur</li>
     * </ul>
     */
    List<DTOProduit> getAllGuitares() throws AirBrassException;

    /**
     * Methode d'obtention de la totalité des {@link DTOProduit} de type
     * Accessoire présent dans la base de données.
     *
     * @return la liste des {@link DTOProduit} de type Accessoire
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOProduit} remonte une erreur</li>
     * </ul>
     */
    List<DTOProduit> getAllAccessoire() throws AirBrassException;

    /**
     * Methode d'obtention de la totalité des {@link DTOMarque} présent dans la
     * base de données.
     *
     * @return la liste des {@link DTOMarque}
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOMarque} remonte une erreur</li>
     * </ul>
     */
    List<DTOMarque> getAllMarque() throws AirBrassException;

    /**
     * Methode d'obtention de la totalité des {@link DTOMarque} correspondant au
     * {@link DTOTypeProduit} Guitare présent dans la base de données.
     *
     * @return la liste des {@link DTOMarque}
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOMarque} remonte une erreur</li>
     * </ul>
     */
    List<DTOMarque> getAllMarqueGuitare() throws AirBrassException;
    
    /**
     * Methode d'obtention de la totalité des {@link DTOMarque} correspondant au
     * {@link DTOTypeProduit} Accessoire présent dans la base de données.
     *
     * @return la liste des {@link DTOMarque}
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOMarque} remonte une erreur</li>
     * </ul>
     */
    List<DTOMarque> getAllMarqueAccessoire() throws AirBrassException;

    /**
     * Methode d'obtention de la totalité des {@link DTOSpecialisationProduit}
     * présent dans la base de données.
     *
     * @return la liste des {@link DTOSpecialisationProduit}
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOSpecialisationProduit} remonte une erreur</li>
     * </ul>
     */
    List<DTOSpecialisationProduit> getAllSpecs() throws AirBrassException;

    /**
     * Methode d'obtention de la totalité des {@link DTOSpecialisationProduit}
     * correspondant au {@link DTOTypeProduit} Guitare présent dans la base de données.
     *
     * @return la liste des {@link DTOSpecialisationProduit}
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOSpecialisationProduit} remonte une erreur</li>
     * </ul>
     */
    List<DTOSpecialisationProduit> getAllSpecsGuitare() throws AirBrassException;
    
    /**
     * Methode d'obtention de la totalité des {@link DTOSpecialisationProduit}
     * correspondant au {@link DTOTypeProduit} Accessoire présent dans la base de données.
     *
     * @return la liste des {@link DTOSpecialisationProduit}
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOSpecialisationProduit} remonte une erreur</li>
     * </ul>
     */
    List<DTOSpecialisationProduit> getAllSpecsAccessoire() throws AirBrassException;

    /**
     * Methode d'obtention des produits par {@link DTOMarque} et par
     * {@link DTOSpecialisationProduit}.
     *
     * @param specialisations la liste des intitullées des
     * {@link DTOSpecialisationProduit} à obtenir
     * @param marques la liste des intitullées des {@link DTOMarque} à obtenir
     * @return liste des {@link DTOProduit} correspondant au deux filtres.
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOProduit} remonte une erreur</li>
     * </ul>
     */
    List<DTOProduit> getProduitParOptions(List<String> specialisations, List<String> marques) throws AirBrassException;

    /**
     * Methode d'obtention d'un {@link DTOProduit} par son id.
     *
     * @param idProduit l'id du produit à récuperer
     * @return la liste des {@link DTOProduit}
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOProduit} remonte une erreur</li>
     * </ul>
     */
    DTOProduit getProduitById(int idProduit) throws AirBrassException;
    
    List<DTOVues> getVuesByProduit(int idProduit) throws AirBrassException;

	DTOVues addVues(DTOVues dto) throws AssembleurException;

	List<DTOProduit> gelAllProduitBySpecialisation(String specialisationProduit) throws AirBrassException;

	List<DTOProduit> getProduitsByMarque(String intituleMarque) throws AssembleurException;

	List<DTOAvisClient> getAvisByProduit(int idProduit) throws AirBrassException;

	List<DTOProduit> getProduitPromotion() throws AssembleurException;

	List<DTOProduit> getAccessoirePromotion() throws AssembleurException;
}
