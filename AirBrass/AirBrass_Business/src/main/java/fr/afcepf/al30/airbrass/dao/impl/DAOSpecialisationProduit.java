package fr.afcepf.al30.airbrass.dao.impl;

import fr.afcepf.al30.airbrass.assembleur.AssembleurDTO;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al30.airbrass.dao.api.IDAOSpecialisationProduit;
import fr.afcepf.al30.airbrass.dto.DTOSpecialisationProduit;
import fr.afcepf.al30.airbrass.entities.SpecialisationProduit;
import fr.afcepf.al30.airbrass.enums.DTOTypeProduit;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.DaoException;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import java.util.ArrayList;
import javax.persistence.PersistenceException;
import org.apache.log4j.Logger;

/**
 * Implementation de {@link IDAOSpecialisationProduit}.
 */
@Stateless
public class DAOSpecialisationProduit implements IDAOSpecialisationProduit {

    private static Logger log = Logger.getLogger(DAOSpecialisationProduit.class);

    @PersistenceContext(unitName = "AirBrass_PU")
    EntityManager em;

    @Override
    public List<DTOSpecialisationProduit> getSpecialisationProduitByTypeProduit(DTOTypeProduit typeProduit) throws AirBrassException {
        try {
            Query query = em.createQuery("SELECT DISTINCT s FROM SpecialisationProduit s WHERE s.typeProduit = :typeProduit").setParameter("typeProduit", AssembleurDTO.dtoToEntity(typeProduit));
            return resultOfQuery(query);
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }

    @Override
    public List<DTOSpecialisationProduit> getAll() throws AirBrassException {
        try {
            Query query = em.createQuery("FROM SpecialisationProduit s");
            return resultOfQuery(query);
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }

    private static List<DTOSpecialisationProduit> resultOfQuery(Query query) throws AirBrassException {
        List<SpecialisationProduit> liste = query.getResultList();
        List<DTOSpecialisationProduit> listeDTO = new ArrayList<>();
        for (SpecialisationProduit specialisationProduit : liste) {
            listeDTO.add(AssembleurDTO.entityToDTO(specialisationProduit));
        }
        return listeDTO;
    }

}
