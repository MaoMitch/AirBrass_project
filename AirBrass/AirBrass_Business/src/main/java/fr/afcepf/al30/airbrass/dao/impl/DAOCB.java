package fr.afcepf.al30.airbrass.dao.impl;

import org.apache.log4j.Logger;
import fr.afcepf.al30.airbrass.assembleur.AssembleurDTO;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al30.airbrass.dao.api.IDAOCB;
import fr.afcepf.al30.airbrass.dto.DTOCB;
import fr.afcepf.al30.airbrass.entities.CB;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.DaoException;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import java.util.ArrayList;
import javax.persistence.PersistenceException;

/**
 * Implementation de {@link IDAOCB}.
 */
@Stateless
public class DAOCB implements IDAOCB {

    private static Logger log = Logger.getLogger(DAOCB.class);

    @PersistenceContext(unitName = "AirBrass_PU")
    EntityManager em;

    @Override
    public List<DTOCB> getCBByClient(int idClient) throws AirBrassException {
        try {
            Query query = em.createQuery("FROM CB c WHERE c.personne.id = :idClient").setParameter("idClient", idClient);
            List<CB> cbs = query.getResultList();
            List<DTOCB> cbsDTO = new ArrayList<>();
            for (CB cb : cbs) {
                cbsDTO.add(AssembleurDTO.entityToDTO(cb));
            }
            return cbsDTO;
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());

        }
    }

    @Override
    public DTOCB ajouterCarte(DTOCB dtoCb) throws AirBrassException {
        CB cb = AssembleurDTO.dtoToEntity(dtoCb);
        em.persist(cb);
        return AssembleurDTO.entityToDTO(cb);
    }

    @Override
    public DTOCB majCarte(DTOCB dtoCb) throws AirBrassException {
        CB cb = AssembleurDTO.dtoToEntity(dtoCb);
        em.merge(cb);
        return AssembleurDTO.entityToDTO(cb);
    }

    @Override
    public boolean suprCarte(DTOCB dtoCb) throws AirBrassException {
        CB cb = em.find(CB.class, dtoCb.getId());
        em.remove(cb);
        return true;
    }

}
