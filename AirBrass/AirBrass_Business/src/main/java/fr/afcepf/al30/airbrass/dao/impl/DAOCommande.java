package fr.afcepf.al30.airbrass.dao.impl;

import fr.afcepf.al30.airbrass.assembleur.AssembleurDTO;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al30.airbrass.dao.api.IDAOCommande;
import fr.afcepf.al30.airbrass.dto.DTOCommande;
import fr.afcepf.al30.airbrass.dto.DTOLigneCommande;
import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.entities.Commande;
import fr.afcepf.al30.airbrass.entities.LigneCommande;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.DaoException;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import org.apache.log4j.Logger;

/**
 * Implementation de {@link IDAOCommande}.
 */
@Stateless
public class DAOCommande implements IDAOCommande {

    private static Logger log = Logger.getLogger(DAOCommande.class);

    @PersistenceContext(unitName = "AirBrass_PU")
    EntityManager em;

    @Override
    public List<DTOCommande> getCommandeByClient(DTOPersonne personne) throws AirBrassException {
        try {
            Query query = em.createQuery("FROM Commande c WHERE c.personne.id = :idClient", Commande.class).setParameter("idClient", personne.getId());
            List<Commande> commandes = query.getResultList();
            List<DTOCommande> commandesDTO = new ArrayList<>();
            for (Commande commande : commandes) {
                commandesDTO.add(AssembleurDTO.entityToDTO(commande));
            }
            return commandesDTO;
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }

    @Override
    public DTOCommande getCommandeById(int numero) throws AirBrassException {
        try {
            Commande commande = em.find(Commande.class, numero);
            return AssembleurDTO.entityToDTO(commande);
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        }
    }

    @Override
    public DTOCommande addCommande(DTOCommande commandeDTO) throws AirBrassException {
        try {
            Commande commande = AssembleurDTO.dtoToEntity(commandeDTO);
            em.persist(commande);
            for (LigneCommande ligneCommande : commande.getLigneCommandes()) {
                ligneCommande.setCommande(commande);
                em.persist(ligneCommande);
            }
            return AssembleurDTO.entityToDTO(commande);
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        } catch (EntityExistsException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_EXIST_DEJA, ex.getMessage());
        }
    }

    @Override
    public List<DTOLigneCommande> getLignesByCommande(DTOCommande commande) throws AirBrassException {
        try {
            Query query = em.createQuery("SELECT l FROM LigneCommande l WHERE l.commande.id = :idCommande").setParameter("idCommande", commande.getId());
            List<LigneCommande> lignes = query.getResultList();
            List<DTOLigneCommande> lignesDTO = new ArrayList<>();
            for (LigneCommande ligne : lignes) {
                lignesDTO.add(AssembleurDTO.entityToDTO(ligne));
            }
            return lignesDTO;
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }

    @Override
    public DTOLigneCommande getLigneById(int idLigne) throws AirBrassException {
        try {
            LigneCommande ligne = em.find(LigneCommande.class, idLigne);
            return AssembleurDTO.entityToDTO(ligne);
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        }
    }

    @Override
    public DTOCommande updateCommande(DTOCommande com) throws AirBrassException {
        try {
            Commande comande = AssembleurDTO.dtoToEntity(com);
            em.merge(comande);
            return AssembleurDTO.entityToDTO(comande);
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        }
    }

}
