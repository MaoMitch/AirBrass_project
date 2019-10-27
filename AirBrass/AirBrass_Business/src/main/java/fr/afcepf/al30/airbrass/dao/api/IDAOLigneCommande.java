package fr.afcepf.al30.airbrass.dao.api;

import fr.afcepf.al30.airbrass.dto.DTOLigneCommande;
import fr.afcepf.al30.airbrass.entities.LigneCommande;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import javax.ejb.Local;

/**
 * La classe contenant les methodes d'accès aux données pour les
 * {@link LigneCommande}.
 */
@Local
@FunctionalInterface
public interface IDAOLigneCommande {

    /**
     * Methode d'ajout d'une ligne dans la base de données.
     *
     * @param newligne la ligne à ajouter
     * @return la ligne une fois persisté
     * @throws AirBrassException Si erreur
     */
    DTOLigneCommande addLigne(DTOLigneCommande newligne) throws AirBrassException;
}
