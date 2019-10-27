package fr.afcepf.al30.airbrass.dao.impl;

import fr.afcepf.al30.airbrass.assembleur.AssembleurDTO;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.afcepf.al30.airbrass.dao.api.IDAOProduit;
import fr.afcepf.al30.airbrass.dto.DTOProduit;
import fr.afcepf.al30.airbrass.entities.Produit;
import fr.afcepf.al30.airbrass.enums.TypeProduit;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.AssembleurException;
import fr.afcepf.al30.airbrass.exceptions.DaoException;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import java.util.ArrayList;
import javax.persistence.PersistenceException;
import org.apache.log4j.Logger;

/**
 * Implementation de {@link IDAOProduit}.
 */
@Stateless
public class DAOProduit implements IDAOProduit {

    private static Logger log = Logger.getLogger(DAOProduit.class);

    private static final String NOT_IMPLEMENTED_YET = "Not supported yet.";
    @PersistenceContext(unitName = "AirBrass_PU")
    EntityManager em;

    @Override
    public List<DTOProduit> getAllArticleBySpecialisation(String specialisation) throws AirBrassException {
        try {
            Query query = em.createQuery("FROM Produit  p WHERE p.specialisationProduit.intitule = :specialisation").setParameter("specialisation", specialisation);
            return resultOfQuery(query);
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }

    @Override
    public DTOProduit getArticleById(int idProduit) throws AirBrassException {
        try {
            Produit produit = em.find(Produit.class, idProduit);
            if (produit != null) {
                return AssembleurDTO.entityToDTO(produit);
            } else {
                throw new DaoException(ExceptionEnum.AUCUN_RESULTAT, "L'entité n'a pas étét trouvé.");
            }
        } catch (Exception ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }

    }

    @Override
    public List<DTOProduit> getProduitByGammePrix(double prixMinimum, double prixMaximum) throws AirBrassException {
        try {
            Query query = em.createQuery("FROM Produit p WHERE p.prix < :prixMaxi AND p.prix > :prixMini").setParameter("prixMaxi", prixMaximum).setParameter("prixMini", prixMinimum);
            return resultOfQuery(query);
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }

    @Override
    public List<DTOProduit> getAll() throws AirBrassException {
        try {
            Query query = em.createQuery("FROM Produit p");
            return resultOfQuery(query);
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }
    
    @Override
    public List<DTOProduit> getProduitByMarque(String marqueIntitule) throws AssembleurException {
    	TypedQuery<Produit> typedQuery = em.createQuery("SELECT p FROM Produit p WHERE p.marque.intitule = :marqueIntitule",Produit.class).setParameter("marqueIntitule", marqueIntitule);
    	List<DTOProduit> listDTO = new ArrayList<>();
    	List<Produit> liste = typedQuery.getResultList();
    	for (Produit produit : liste) {
			listDTO.add(AssembleurDTO.entityToDTO(produit));
		}
    	return listDTO;
    }

    private static List<DTOProduit> resultOfQuery(Query query) throws AirBrassException {
        List<Produit> liste = query.getResultList();
        List<DTOProduit> listeDTO = new ArrayList<>();
        for (Produit produit : liste) {
            listeDTO.add(AssembleurDTO.entityToDTO(produit));
        }
        return listeDTO;
    }
    
    @Override
    public List<DTOProduit> getProduitPromotion() throws AssembleurException {
    	TypeProduit type = TypeProduit.GUITARE;
    	TypedQuery<Produit> typedQuery = em.createQuery("SELECT p FROM Produit p WHERE p.specialisationProduit.typeProduit = :type AND p.promotion is not null",Produit.class).setParameter("type", type);
    	List<DTOProduit> listDTO = new ArrayList<>();
    	List<Produit> listProduit = typedQuery.getResultList();
    	for (Produit produit : listProduit) {
			listDTO.add(AssembleurDTO.entityToDTO(produit));
			
		}
    	return listDTO;
    }
    @Override
    public List<DTOProduit> getAccessoiretPromotion() throws AssembleurException {
    	TypeProduit type = TypeProduit.ACCESSOIRE;
    	TypedQuery<Produit> typedQuery = em.createQuery("SELECT p FROM Produit p WHERE p.specialisationProduit.typeProduit = :type AND p.promotion is not null",Produit.class).setParameter("type", type);
    	List<DTOProduit> listDTO = new ArrayList<>();
    	List<Produit> listProduit = typedQuery.getResultList();
    	for (Produit produit : listProduit) {
			listDTO.add(AssembleurDTO.entityToDTO(produit));
			
		}
    	return listDTO;
    }

    @Override
    public DTOProduit addProduit(DTOProduit produit) throws AirBrassException {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED_YET); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DTOProduit updateProduit(DTOProduit produit) throws AirBrassException {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED_YET); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DTOProduit removeProduit(DTOProduit produit) throws AirBrassException {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED_YET); //To change body of generated methods, choose Tools | Templates.
    }
}
