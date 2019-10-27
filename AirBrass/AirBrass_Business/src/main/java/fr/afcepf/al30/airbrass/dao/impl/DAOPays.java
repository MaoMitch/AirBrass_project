package fr.afcepf.al30.airbrass.dao.impl;

import fr.afcepf.al30.airbrass.assembleur.AssembleurDTO;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.al30.airbrass.dao.api.IDAOPays;
import fr.afcepf.al30.airbrass.dto.DTOPays;
import fr.afcepf.al30.airbrass.entities.Pays;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.DaoException;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 * Implementation de {@link IDAOPays}.
 */
@Stateless
public class DAOPays implements IDAOPays {

    private static Logger log = Logger.getLogger(DAOPays.class);

    private static final String GET_ONE = "FROM Pays p WHERE p.nom = :pnom";

    @PersistenceContext(unitName = "AirBrass_PU")
    EntityManager em;

    private Query getOneQuery(DTOPays adresse) throws AirBrassException {
        Query query = em.createQuery(GET_ONE, Pays.class);
        query.setParameter("pnom", adresse.getNom());
        return query;
    }

    @Override
    public boolean paysExist(DTOPays pays) throws AirBrassException {
        try {
            Query query = getOneQuery(pays);
            return !query.getResultList().isEmpty();
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }

    @Override
    public DTOPays getPays(DTOPays pays) throws AirBrassException {
        try {
            Query query = getOneQuery(pays);
            List<Pays> paysList = query.getResultList();
            return AssembleurDTO.entityToDTO(paysList.get(0));
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }

    @Override
    public DTOPays addPays(DTOPays dtoPays) throws AirBrassException {
        try {
            Pays pays = AssembleurDTO.dtoToEntity(dtoPays);
            em.persist(pays);
            return AssembleurDTO.entityToDTO(pays);
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }

}
