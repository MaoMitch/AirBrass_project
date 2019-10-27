package fr.afcepf.al30.airbrass.dao.impl;

import fr.afcepf.al30.airbrass.assembleur.AssembleurDTO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.al30.airbrass.dao.api.IDAOLigneCommande;
import fr.afcepf.al30.airbrass.dto.DTOLigneCommande;
import fr.afcepf.al30.airbrass.entities.LigneCommande;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.DaoException;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import org.apache.log4j.Logger;

/**
 * Implementation de {@link IDAOLigneCommande}.
 */
@Stateless
public class DAOLigneCommande implements IDAOLigneCommande {

    private static Logger log = Logger.getLogger(DAOLigneCommande.class);

    @PersistenceContext(unitName = "AirBrass_PU")
    EntityManager em;

    @Override
    public DTOLigneCommande addLigne(DTOLigneCommande ligneDTO) throws AirBrassException {
        try {
            LigneCommande ligne = AssembleurDTO.dtoToEntity(ligneDTO);
            em.merge(ligne);
            return AssembleurDTO.entityToDTO(ligne);
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        }
    }
}
