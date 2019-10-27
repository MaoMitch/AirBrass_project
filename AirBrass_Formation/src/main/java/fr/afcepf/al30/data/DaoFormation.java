package fr.afcepf.al30.data;

import fr.afcepf.al30.assembleur.AssembleurDTO;
import fr.afcepf.al30.dto.FormationDTO;
import fr.afcepf.al30.entity.Disponibilite;
import fr.afcepf.al30.entity.Formation;
import fr.afcepf.al30.entity.Formation_;
import fr.afcepf.al30.entity.Niveau;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DaoFormation implements IDaoFormation {

    private static Logger log = Logger.getLogger(DaoFormation.class);
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public List<FormationDTO> getAll() {
        List<FormationDTO> allFormationsDTO = new ArrayList<>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Formation> cq = cb.createQuery(Formation.class);
        Root<Formation> queryFrom = cq.from(Formation.class);

        //Constructing list of parameters
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(queryFrom.get(Formation_.disponibilite), Disponibilite.DISPONIBLE));
        Predicate[] predicatesarr = predicates.toArray(new Predicate[predicates.size()]);
        cq.select(queryFrom).where(predicatesarr);

        TypedQuery<Formation> query = em.createQuery(cq);

        try {
            List<Formation> allFormations = query.getResultList();
            allFormations.forEach(formation -> allFormationsDTO.add(AssembleurDTO.entityToDTO(formation)));
        } catch (PersistenceException e) {
            log.error(e);
        }
        return allFormationsDTO;
    }

    @Transactional
    @Override
    public List<FormationDTO> getFormations(Formation formation, boolean onlyDispo) {
        List<FormationDTO> formationsDTO = new ArrayList<>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Formation> cq = cb.createQuery(Formation.class);
        Root<Formation> queryFrom = cq.from(Formation.class);

        //Constructing list of parameters
        List<Predicate> predicates = new ArrayList<>();

        //Adding predicates in case of parameter not being null
        if (formation.getIntitule() != null) {
            predicates.add(cb.like(queryFrom.get(Formation_.intitule), "%" + formation.getIntitule() + "%"));
        }
        if (formation.getNiveau() != null && formation.getNiveau() != Niveau.TOUTNIVEAU) {
            predicates.add(cb.equal(queryFrom.get(Formation_.niveau), formation.getNiveau()));
        }
        if (formation.getFormateur().getNom() != null && !"".equals(formation.getFormateur().getNom())) {
            predicates.add(cb.equal(queryFrom.join("formateur").get("nom"), formation.getFormateur().getNom()));
        }
        if (onlyDispo) {
            predicates.add(cb.equal(queryFrom.get(Formation_.disponibilite), Disponibilite.DISPONIBLE));
        }

        Predicate[] predicatesarr = predicates.toArray(new Predicate[predicates.size()]);
        cq.select(queryFrom).where(predicatesarr);

        TypedQuery<Formation> query = em.createQuery(cq);
        try {
            List<Formation> allFormations = query.getResultList();
            allFormations.forEach(f -> formationsDTO.add(AssembleurDTO.entityToDTO(f)));
        } catch (Exception e) {
            log.fatal(e);
        }
        return formationsDTO;
    }

    @Transactional
    @Override
    public List<FormationDTO> getDisposByDate(Date selectedDate, boolean onlyDispo) {
        List<FormationDTO> allFormationsDTO = new ArrayList<>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Formation> cq = cb.createQuery(Formation.class);
        Root<Formation> queryFrom = cq.from(Formation.class);

        //Constructing list of parameters
        List<Predicate> predicates = new ArrayList<>();
        if (onlyDispo) {
            predicates.add(cb.equal(queryFrom.get(Formation_.disponibilite), Disponibilite.DISPONIBLE));
        }
        Predicate[] predicatesarr = predicates.toArray(new Predicate[predicates.size()]);
        cq.select(queryFrom).where(predicatesarr);
        TypedQuery<Formation> query = em.createQuery(cq);
        try {
            List<Formation> allFormations = query.getResultList();
            allFormations.stream().filter(formation -> compareDate(formation.getDate(), selectedDate)).forEachOrdered(formation
                    -> allFormationsDTO.add(AssembleurDTO.entityToDTO(formation))
            );
        } catch (Exception e) {
            log.fatal(e);
        }
        return allFormationsDTO;
    }

    @Transactional
    @Override
    public boolean verifierDispoFormation(Formation formation) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Formation> cq = cb.createQuery(Formation.class);
        Root<Formation> queryFrom = cq.from(Formation.class);

        //Constructing list of parameters
        List<Predicate> predicates = new ArrayList<>();

        //Adding predicates in case of parameter not being null
        if (formation.getId() != null) {
            predicates.add(cb.equal(queryFrom.get(Formation_.id), formation.getId()));
        }

        Predicate[] predicatesarr = predicates.toArray(new Predicate[predicates.size()]);
        cq.select(queryFrom).where(predicatesarr);

        TypedQuery<Formation> query = em.createQuery(cq);
        try {
            Formation form = query.getSingleResult();
            if (form.getDisponibilite() == Disponibilite.DISPONIBLE) {
                return true;
            }
        } catch (Exception e) {
            log.fatal(e);
        }
        return false;
    }

    @Transactional
    @Override
    public FormationDTO getFormationById(Integer id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Formation> cq = cb.createQuery(Formation.class);
        Root<Formation> queryFrom = cq.from(Formation.class);

        cq.select(queryFrom).where(cb.equal(queryFrom.get(Formation_.id), id));
        TypedQuery<Formation> query = em.createQuery(cq);
        try {
            Formation form = query.getSingleResult();
            return AssembleurDTO.entityToDTO(form);
        } catch (Exception e) {
            log.fatal(e);
        }
        return null;
    }

    @Transactional
    @Override
    public FormationDTO reserverFormation(FormationDTO formationDTO) {
        Formation formation = AssembleurDTO.dtoToEntity(formationDTO);

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Formation> update = cb.createCriteriaUpdate(Formation.class);
        Root<Formation> queryUpdate = update.from(Formation.class);

        //Constructing list of parameters
        List<Predicate> predicates = new ArrayList<>();

        //Adding predicates in case of parameter not being null
        if (formation.getId() != null) {
            predicates.add(cb.equal(queryUpdate.get(Formation_.id), formation.getId()));
        }

        Predicate[] predicatesarr = predicates.toArray(new Predicate[predicates.size()]);

        update.set("disponibilite", Disponibilite.RESERVE).where(predicatesarr);
        em.createQuery(update).executeUpdate();
        return AssembleurDTO.entityToDTO(formation);
    }

    public boolean compareDate(Date dateFormation, Date selectedDate) {

        LocalDate localDateFormation = dateFormation.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int yearDF = localDateFormation.getYear();
        int monthDF = localDateFormation.getMonthValue();
        int dayDF = localDateFormation.getDayOfMonth();

        LocalDate localSelectedDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int yearSD = localSelectedDate.getYear();
        int monthSD = localSelectedDate.getMonthValue();
        int daySD = localSelectedDate.getDayOfMonth();

        return yearDF == yearSD && monthDF == monthSD && dayDF == daySD;

    }

}
