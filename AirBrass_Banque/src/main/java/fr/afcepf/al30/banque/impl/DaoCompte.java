package fr.afcepf.al30.banque.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import fr.afcepf.al30.banque.api.IDaoCompte;
import fr.afcepf.al30.banque.entity.CarteBanquaire;
import fr.afcepf.al30.banque.entity.CompteBanquaire;
import fr.afcepf.al30.banque.entity.Operation;

@Component
public class DaoCompte implements IDaoCompte {

    private Logger log = Logger.getLogger(getClass());
    @PersistenceContext
    private EntityManager em;

    @Override
    public CompteBanquaire getCompteBanquaireByCarte(CarteBanquaire paramCartebanquaire) {

        TypedQuery<CompteBanquaire> hql = em
                .createQuery("Select c from CompteBanquaire c left join fetch c.cartesbanquaires cb where cb.nom =:cbnom and cb.numero=:cbnumero and cb.pictogrammeSecurite=:cbpictogrammeSecurite",
                        CompteBanquaire.class)
                .setParameter("cbnom", paramCartebanquaire.getNom()).setParameter("cbnumero", paramCartebanquaire.getNumero()).setParameter("cbpictogrammeSecurite", paramCartebanquaire.getPictogrammeSecurite());
        CompteBanquaire compte = null;
        try {
            compte = hql.getSingleResult();
            initCollection(compte);
        } catch (Exception e) {
            log.error(e);
            log.info("le compte n'a pas pu être récupérer");
        }

        return compte;
    }

    @Override
    public CompteBanquaire getCompteBanquaireByCompte(CompteBanquaire paramComptebanquaire) {

        TypedQuery<CompteBanquaire> hql = em
                .createQuery("Select c from CompteBanquaire c where c.nomCompte =:cnom and c.numeroCompte=:cnumero",
                        CompteBanquaire.class)
                .setParameter("cnom", paramComptebanquaire.getNomCompte()).setParameter("cnumero", paramComptebanquaire.getNumeroCompte());
        CompteBanquaire compte = null;
        try {
            compte = hql.getSingleResult();
            initCollection(compte);
        } catch (Exception e) {
            log.error(e);
            log.info("le compte n'a pas pu être récupérer");
        }

        return compte;
    }

    @Override
    public Boolean saveCompte(CompteBanquaire paramCompteBanquaire) {

        em.merge(paramCompteBanquaire);
        return true;

    }

    private void initCollection(CompteBanquaire compte) {

        compte.setOperationsPaye(em.createQuery("Select o from Operation o where o.comptePayeur = :compte", Operation.class).setParameter("compte", compte).getResultList());
        compte.setOperationsRecu(em.createQuery("Select o from Operation o where o.compteReceveur = :compte", Operation.class).setParameter("compte", compte).getResultList());

    }

}
