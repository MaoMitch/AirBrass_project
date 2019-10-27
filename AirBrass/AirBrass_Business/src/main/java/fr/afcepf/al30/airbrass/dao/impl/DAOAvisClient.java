package fr.afcepf.al30.airbrass.dao.impl;

import org.apache.log4j.Logger;
import fr.afcepf.al30.airbrass.assembleur.AssembleurDTO;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.afcepf.al30.airbrass.dao.api.IDAOAvisClient;
import fr.afcepf.al30.airbrass.dto.DTOAvisClient;
import fr.afcepf.al30.airbrass.entities.AvisClient;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.AssembleurException;
import fr.afcepf.al30.airbrass.exceptions.DaoException;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import java.util.ArrayList;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;

/**
 * Implementation de {@link IDAOAvisClient}.
 */
@Stateless
public class DAOAvisClient implements IDAOAvisClient {

    private static Logger log = Logger.getLogger(DAOAvisClient.class);

    @PersistenceContext(unitName = "AirBrass_PU")
    EntityManager em;

    @Override
    public void createNewAvisClient(DTOAvisClient avis) throws AirBrassException {
        try {
            em.persist(AssembleurDTO.dtoToEntity(avis));
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        } catch (EntityExistsException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_EXIST_DEJA, ex.getMessage());
        }

    }

    @Override
    public void removeAvisClient(DTOAvisClient avisClient) throws AirBrassException {
        try {
            em.remove(AssembleurDTO.dtoToEntity(avisClient));
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        }

    }

    @Override
    public List<DTOAvisClient> getAllAvisByClient(int idClient) throws AirBrassException {
        try {
            Query query = em.createQuery("SELECT a FROM AvisClient a WHERE a.personne.id = :idClient", AvisClient.class).setParameter("idClient", idClient);
            List<AvisClient> avis = query.getResultList();
            List<DTOAvisClient> returnList = new ArrayList<>();
            for (AvisClient avi : avis) {
                returnList.add(AssembleurDTO.entityToDTO(avi));
            }
            return returnList;
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }
    
    @Override
    public List<DTOAvisClient> getAvisClientByProduit(int idProduit) throws AssembleurException {
    	TypedQuery<AvisClient> typedQuery = em.createQuery("SELECT a FROM AvisClient a WHERE a.produit.id = :idProduit",AvisClient.class).setParameter("idProduit", idProduit);
    	List<DTOAvisClient> listAvisDTO = new ArrayList<>();
    	List<AvisClient> listAvis = typedQuery.getResultList();
    	for (AvisClient avisClient : listAvis) {
			listAvisDTO.add(AssembleurDTO.entityToDTO(avisClient));
		}
    	
    	return listAvisDTO;
    	
    }
}
