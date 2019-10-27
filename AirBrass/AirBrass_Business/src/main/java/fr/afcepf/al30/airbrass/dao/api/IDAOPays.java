package fr.afcepf.al30.airbrass.dao.api;

import fr.afcepf.al30.airbrass.dto.DTOPays;
import fr.afcepf.al30.airbrass.entities.Pays;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;

import javax.ejb.Local;

/**
 * La classe contenant les methodes d'accès aux données pour les {@link Pays}.
 */
@Local
public interface IDAOPays {

    /**
     * Methode de verification de la présence d'un pays dans l'unité de
     * persistence.
     *
     * @param pays l'{@link DTOPays} dont on veux vérifier la présence en base.
     * @return <ul>
     * <li>true si la {@link DTOPays} est déjà en base</li>
     * <li>false sinon</li>
     * </ul>
     * @throws AirBrassException <ul>
     * <li>Si l'integrité des données n'est pas respecté</li>
     * <li>Si la base de données plante</li>
     * </ul>
     */
    boolean paysExist(DTOPays pays) throws AirBrassException;

    /**
     * Methode d'obtention d'un pays dans la base.
     *
     * @param pays l'{@link DTOPays} que l'on veut récuperer.
     * @return l'{@link DTOPays} recherché
     * @throws AirBrassException <ul>
     * <li>Si l'integrité des données n'est pas respecté</li>
     * <li>Si la base de données plante</li>
     * </ul>
     */
    DTOPays getPays(DTOPays pays) throws AirBrassException;

    /**
     * Methode de persistence d'un pays en base.
     *
     * @param dtoPays l'{@link DTOPays} à persister.
     * @return l'{@link DTOPays} une fois persisté.
     * @throws AirBrassException <ul>
     * <li>Si l'integrité des données n'est pas respecté</li>
     * <li>Si la base de données plante</li>
     * </ul>
     */
    public DTOPays addPays(DTOPays dtoPays) throws AirBrassException;
}
