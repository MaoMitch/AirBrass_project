package fr.afcepf.al30.airbrass.dao.api;

import fr.afcepf.al30.airbrass.dto.DTOProduit;
import fr.afcepf.al30.airbrass.entities.Produit;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.AssembleurException;

import java.util.List;

import javax.ejb.Local;

/**
 * La classe contenant les methodes d'accès aux données pour les {@link Produit}.
 */
@Local
public interface IDAOProduit {

    /**
     * Method pour récupérer tous les {@link Produit} présent dans la base, sous
     * forme de {@link DTOProduit}.
     *
     * @return une liste de tous les {@link DTOProduit} de la base, null si la
     * base est vide.
     * @throws AirBrassException
     * <ul>
     * <li>Si le contact avec la base de donnée est perdu.</li>
     * </ul>
     */
    public List<DTOProduit> getAll() throws AirBrassException;

    /**
     * Method pour récupérer tous les {@link Produit} présent dans la base ayant
     * la spécialisation spécifié, sous forme de {@link DTOProduit}.
     *
     * @param specialisationProduit spécalisation des produit à récupérer.
     * @return une liste de tous les {@link DTOProduit} de la base ayant la
     * spécification désigné, null si la base est vide.
     * @throws AirBrassException
     * <ul>
     * <li>Si le contact avec la base de donnée est perdu.</li>
     * </ul>
     */
    public List<DTOProduit> getAllArticleBySpecialisation(String specialisationProduit) throws AirBrassException;

    /**
     * Method d'ajout d'un produit dans l'unité de persistence.
     *
     * @param produit le {@link DTOProduit} à ajouter dans la base.
     * @return le {@link DTOProduit} le produit une fois ajouté à la base.
     * @throws AirBrassException <ul>
     * <li>Si le produit est déjà présent en base</li>
     * <li>Si le contact avec la base de donnée est perdu.</li>
     * </ul>
     */
    public DTOProduit addProduit(DTOProduit produit) throws AirBrassException;

    /**
     * Methode de mise à jour du produit.
     *
     * @param produit le {@link DTOProduit} à metre à jour.
     * @return le {@link DTOProduit} une fois mise à jour.
     * @throws AirBrassException <ul>
     * <li>Si le contact avec la base de donnée est perdu.</li>
     * </ul>
     */
    public DTOProduit updateProduit(DTOProduit produit) throws AirBrassException;

    /**
     * Methode de retrait d'un produit de la base.
     *
     * @param produit le {@link DTOProduit} à retirer.
     * @return le {@link DTOProduit} à retirer
     * @throws AirBrassException <ul>
     * <li>Si le contact avec la base de donnée est perdu.</li>
     * </ul>
     */
    public DTOProduit removeProduit(DTOProduit produit) throws AirBrassException;

    /**
     * Methode d'obtention d'un {@link DTOProduit} par son id.
     *
     * @param idProduit l'id du {@link DTOProduit} à récuperer.
     * @return le {@link DTOProduit} correspondant à l'id.
     * @throws AirBrassException <ul>
     * <li>Si l'id n'est pas présent en basse</li>
     * <li>Si le contact avec la base de donnée est perdu.</li>
     * </ul>
     */
    public DTOProduit getArticleById(int idProduit) throws AirBrassException;

    /**
     * Methode de récupération d'un liste de produit correspondant au prix.
     *
     * @param prixMinimum le prix minimum cherché.
     * @param prixMaximum le prix maximum cherché.
     * @return la liste de {@link DTOProduit} correspondant à la gamme de prix
     * recherché, null si aucun produit ne correspont.
     * @throws AirBrassException <ul>
     * <li>Si le contact avec la base de donnée est perdu.</li>
     * </ul>
     */
    List<DTOProduit> getProduitByGammePrix(double prixMinimum, double prixMaximum) throws AirBrassException;

	List<DTOProduit> getProduitByMarque(String marqueIntitule) throws AssembleurException;

	List<DTOProduit> getProduitPromotion() throws AssembleurException;

	List<DTOProduit> getAccessoiretPromotion() throws AssembleurException;

}
