package fr.afcepf.al30.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import fr.afcepf.al30.assembleur.AssembleurDTO;
import fr.afcepf.al30.dto.FormateurDTO;
import fr.afcepf.al30.entity.Formateur;

@Component
public class DaoFormateur implements IDaoFormateur {

    private static Logger log = Logger.getLogger(DaoFormateur.class);
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public List<FormateurDTO> getAll() {
        List<FormateurDTO> allFormateursDTO = new ArrayList<>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Formateur> cq = cb.createQuery(Formateur.class);
        Root<Formateur> queryFrom = cq.from(Formateur.class);
        cq.select(queryFrom);
        TypedQuery<Formateur> query = em.createQuery(cq);
        try {
            List<Formateur> allFormateurs = query.getResultList();
            allFormateurs.forEach(formateur -> allFormateursDTO.add(AssembleurDTO.entityToDTO(formateur)));
        } catch (Exception e) {
            log.error(e);
            log.info("erreur getAll<FormateurDTO>");
        }
        return allFormateursDTO;
    }

}
