package fr.afcepf.al30.banque.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import fr.afcepf.al30.banque.api.IDaoOperation;
import fr.afcepf.al30.banque.entity.Operation;

@Component
public class DaoOperation implements IDaoOperation {

    private Logger log = Logger.getLogger(getClass());
    @PersistenceContext
    private EntityManager em;

    @Override
    public Boolean saveOperation(Operation paramOperation) {

        Operation operation = em.merge(paramOperation);
        log.info("Opération Id n° " + operation.getId() + " enregistrée");
        return true;
    }

}
