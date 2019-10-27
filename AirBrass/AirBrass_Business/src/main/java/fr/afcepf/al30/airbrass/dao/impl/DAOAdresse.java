package fr.afcepf.al30.airbrass.dao.impl;

import fr.afcepf.al30.airbrass.assembleur.AssembleurDTO;
import java.util.List;

import fr.afcepf.al30.airbrass.dao.api.IDAOAdresse;
import fr.afcepf.al30.airbrass.dto.DTOAdresse;
import fr.afcepf.al30.airbrass.entities.Adresse;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.DaoException;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 * Implementation de {@link IDAOAdresse}.
 */
@Stateless
public class DAOAdresse implements IDAOAdresse {

    private static Logger log = Logger.getLogger(DAOAdresse.class);

    private static final String GET_ONE = "FROM Adresse a WHERE a.numero = :pnumero AND a.rue = :prue AND a.complement = :pcomplement AND a.ville = :pville";

    @PersistenceContext(unitName = "AirBrass_PU")
    private EntityManager em;

    private Query getOneQuery(DTOAdresse adresse) throws AirBrassException {

        Query query = em.createQuery(GET_ONE, Adresse.class);
        query.setParameter("pnumero", adresse.getNumero());
        query.setParameter("prue", adresse.getRue());
        query.setParameter("pcomplement", adresse.getComplement());
        query.setParameter("pville", AssembleurDTO.dtoToEntity(adresse.getDtoVille()));
        return query;
    }

    @Override
    public DTOAdresse createNewAdresse(DTOAdresse adresse) throws AirBrassException {
        try {
            if (adresse.getComplement() == null) {
                adresse.setComplement("");
            }
            Adresse adresseToPersist = AssembleurDTO.dtoToEntity(adresse);
            em.persist(adresseToPersist);
            return AssembleurDTO.entityToDTO(adresseToPersist);
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }

    @Override
    public boolean adresseExist(DTOAdresse adresse) throws AirBrassException {
        try {
            if (adresse.getComplement() == null) {
                adresse.setComplement("");
            }
            Query query = getOneQuery(adresse);
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
    public DTOAdresse getAdresse(DTOAdresse adresse) throws AirBrassException {
        try {
            if (adresse.getComplement() == null) {
                adresse.setComplement("");
            }
            Query query = getOneQuery(adresse);
            List<Adresse> adresses = query.getResultList();
            return AssembleurDTO.entityToDTO(adresses.get(0));
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }
}
