package fr.afcepf.al30.airbrass.dao.api;

import fr.afcepf.al30.airbrass.dto.DTOVille;
import fr.afcepf.al30.airbrass.entities.Ville;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;

import javax.ejb.Local;

/**
 * La classe contenant les methodes d'accès aux données pour les {@link Ville}.
 */
@Local
public interface IDAOVille {

    /**
     * Methode de persistence d'une ville en base.
     *
     * @param ville l'{@link DTOVille} à persister.
     * @return l'{@link DTOVille} une fois persisté.
     * @throws AirBrassException <ul>
     * <li>Si l'integrité des données n'est pas respecté</li>
     * <li>Si la base de données plante</li>
     * </ul>
     */
    public DTOVille addVille(DTOVille ville) throws AirBrassException;

    /**
     * Methode de verification de la présence d'une ville dans l'unité de
     * persistence.
     *
     * @param ville l'{@link DTOVille} dont on veux vérifier la présence en
     * base.
     * @return <ul>
     * <li>true si la {@link DTOVille} est déjà en base</li>
     * <li>false sinon</li>
     * </ul>
     * @throws AirBrassException <ul>
     * <li>Si l'integrité des données n'est pas respecté</li>
     * <li>Si la base de données plante</li>
     * </ul>
     */
    boolean villeExist(DTOVille ville) throws AirBrassException;

    /**
     * Methode d'obtention d'une ville dans la base.
     *
     * @param ville l'{@link DTOVille} que l'on veut récuperer.
     * @return l'{@link DTOVille} recherché
     * @throws AirBrassException <ul>
     * <li>Si l'integrité des données n'est pas respecté</li>
     * <li>Si la base de données plante</li>
     * </ul>
     */
    public DTOVille getVille(DTOVille ville) throws AirBrassException;
}
