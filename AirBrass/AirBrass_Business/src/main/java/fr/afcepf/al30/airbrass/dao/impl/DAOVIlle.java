package fr.afcepf.al30.airbrass.dao.impl;

import fr.afcepf.al30.airbrass.assembleur.AssembleurDTO;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al30.airbrass.dao.api.IDAOVille;
import fr.afcepf.al30.airbrass.dto.DTOVille;
import fr.afcepf.al30.airbrass.entities.Ville;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.DaoException;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import javax.persistence.PersistenceException;
import org.apache.log4j.Logger;

/**
 * Implementation de {@link IDAOVille}.
 */
@Stateless
public class DAOVIlle implements IDAOVille {

    private static Logger log = Logger.getLogger(DAOVIlle.class);

    private static final String GET_ONE = "FROM Ville v WHERE v.nom = :pnom AND v.codePostal = :pcodePostal AND v.pays = :ppays";

    @PersistenceContext(unitName = "AirBrass_PU")
    EntityManager em;

    private Query getOneQuery(DTOVille ville) throws AirBrassException {
        Query query = em.createQuery(GET_ONE, Ville.class);
        query.setParameter("pnom", ville.getNom());
        query.setParameter("pcodePostal", ville.getCodePostal());
        query.setParameter("ppays", AssembleurDTO.dtoToEntity(ville.getDtoPays()));
        return query;
    }

    @Override
    public DTOVille addVille(DTOVille villeDTO) throws AirBrassException {
        try {
            Ville ville = AssembleurDTO.dtoToEntity(villeDTO);
            em.persist(ville);
            return AssembleurDTO.entityToDTO(ville);
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }

    @Override
    public boolean villeExist(DTOVille ville) throws AirBrassException {
        try {
            Query query = getOneQuery(ville);
            return !query.getResultList().isEmpty();
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }

    @Override
    public DTOVille getVille(DTOVille ville) throws AirBrassException {
        try {
            Query query = getOneQuery(ville);
            List<Ville> villes = query.getResultList();
            return AssembleurDTO.entityToDTO(villes.get(0));
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }
}
