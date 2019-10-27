package fr.afcepf.al30.airbrass.dao.api;

import fr.afcepf.al30.airbrass.dto.DTOAdresse;
import fr.afcepf.al30.airbrass.entities.Adresse;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;

import javax.ejb.Local;

/**
 * La classe contenant les methodes d'accès aux données pour les {@link Adresse}.
 */
@Local
public interface IDAOAdresse {

    /**
     * Methode de persistence d'une adresse en base.
     *
     * @param adresse l'{@link DTOAdresse} à persister.
     * @return l'{@link DTOAdresse} une fois persisté.
     * @throws AirBrassException <ul>
     * <li>Si l'integrité des données n'est pas respecté</li>
     * <li>Si la base de données plante</li>
     * </ul>
     */
    public DTOAdresse createNewAdresse(DTOAdresse adresse) throws AirBrassException;

    /**
     * Methode de verification de la présence d'une Adresse dans l'unité de
     * persistence.
     *
     * @param adresse l'{@link DTOAdresse} dont on veux vérifier la présence en
     * base.
     * @return <ul>
     * <li>true si la {@link DTOAdresse} est déjà en base</li>
     * <li>false sinon</li>
     * </ul>
     * @throws AirBrassException <ul>
     * <li>Si l'integrité des données n'est pas respecté</li>
     * <li>Si la base de données plante</li>
     * </ul>
     */
    boolean adresseExist(DTOAdresse adresse) throws AirBrassException;

    /**
     * Methode d'obtention d'une adresse dans la base.
     *
     * @param adresse l'{@link DTOAdresse} que l'on veut récuperer.
     * @return l'{@link DTOAdresse} recherché
     * @throws AirBrassException <ul>
     * <li>Si l'integrité des données n'est pas respecté</li>
     * <li>Si la base de données plante</li>
     * </ul>
     */
    DTOAdresse getAdresse(DTOAdresse adresse) throws AirBrassException;

}
