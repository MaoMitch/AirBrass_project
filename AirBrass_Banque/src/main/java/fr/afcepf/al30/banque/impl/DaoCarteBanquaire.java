package fr.afcepf.al30.banque.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al30.banque.api.IDaoCarteBanquaire;
import fr.afcepf.al30.banque.entity.CarteBanquaire;

@Component
public class DaoCarteBanquaire implements IDaoCarteBanquaire {

    /**
     * Logger.
     */
    private Logger log = Logger.getLogger(getClass());
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public CarteBanquaire getByNomNumeroPictogramme(String paramNom, String paramNumero,
            String paramPictogrammeSecurite) {
        TypedQuery<CarteBanquaire> hql = em
                .createQuery(
                        "Select c from CarteBanquaire c where c.nom =:nom and c.numero=:numero and c.pictogrammeSecurite=:pictogrammeSecurite",
                        CarteBanquaire.class)
                .setParameter("nom", paramNom).setParameter("numero", paramNumero)
                .setParameter("pictogrammeSecurite", paramPictogrammeSecurite);
        CarteBanquaire carte = null;
        try {
            carte = hql.getSingleResult();
        } catch (Exception e) {
            log.error(e);
            log.info("cette carte n'existe pas");
        }
        return carte;
    }

}
