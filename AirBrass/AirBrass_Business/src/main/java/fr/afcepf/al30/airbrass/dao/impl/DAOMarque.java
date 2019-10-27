package fr.afcepf.al30.airbrass.dao.impl;

import fr.afcepf.al30.airbrass.assembleur.AssembleurDTO;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al30.airbrass.dao.api.IDAOMarque;
import fr.afcepf.al30.airbrass.dto.DTOMarque;
import fr.afcepf.al30.airbrass.entities.Marque;
import fr.afcepf.al30.airbrass.enums.DTOTypeProduit;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.DaoException;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import java.util.ArrayList;
import javax.persistence.PersistenceException;
import org.apache.log4j.Logger;

/**
 * Implementation de {@link IDAOMarque}.
 */
@Stateless
public class DAOMarque implements IDAOMarque {

    private static Logger log = Logger.getLogger(DAOMarque.class);

    @PersistenceContext(unitName = "AirBrass_PU")
    EntityManager em;

    @Override
    public List<DTOMarque> getAll() throws AirBrassException {
        try {
            Query query = em.createQuery("FROM Marque m");
            return getResultOfQuery(query);
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }

    @Override
    public List<DTOMarque> getMarqueBySpecialisationProduit(String specialisationProduit) throws AirBrassException {
        try {
            Query query = em.createQuery("SELECT m FROM Marque m INNER JOIN m.produits p WHERE p.specialisationProduit.intitule = :specialisationProduit").setParameter("specialisationProduit", specialisationProduit);
            return getResultOfQuery(query);
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }

    @Override
    public DTOMarque getMarqueById(int id) throws AirBrassException {
        try {
            Marque marque = em.find(Marque.class, id);
            return AssembleurDTO.entityToDTO(marque);
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        }
    }

    private List<DTOMarque> getResultOfQuery(Query query) throws AirBrassException {
        List<Marque> marques = query.getResultList();
        List<DTOMarque> marquesDTO = new ArrayList<>();
        for (Marque marque : marques) {
            marquesDTO.add(AssembleurDTO.entityToDTO(marque));
        }
        return marquesDTO;
    }

    @Override
    public List<DTOMarque> getMarqueByTypeProduit(DTOTypeProduit typeProduit) throws AirBrassException {
       try {
            Query query = em.createQuery("SELECT DISTINCT m FROM Marque m INNER JOIN m.produits p WHERE p.specialisationProduit.typeProduit = :typeProduit").setParameter("typeProduit", AssembleurDTO.dtoToEntity(typeProduit));
            return getResultOfQuery(query);
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }
}
