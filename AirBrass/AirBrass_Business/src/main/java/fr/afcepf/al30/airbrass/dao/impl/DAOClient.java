package fr.afcepf.al30.airbrass.dao.impl;

import fr.afcepf.al30.airbrass.assembleur.AssembleurDTO;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al30.airbrass.dao.api.IDAOClient;
import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.entities.Personne;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.DaoException;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import org.apache.log4j.Logger;

/**
 * Implementation de {@link IDAOClient}.
 */
@Stateless
public class DAOClient implements IDAOClient {

    private static Logger log = Logger.getLogger(DAOClient.class);

    @PersistenceContext(unitName = "AirBrass_PU")
    EntityManager em;

    @Override
    public DTOPersonne getClientById(int id) throws AirBrassException {
        try {
            Personne personne = em.find(Personne.class, id);
            return AssembleurDTO.entityToDTO(personne);
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        }
    }

    @Override
    public List<DTOPersonne> getAllClient() {
        Query query = em.createQuery("From Personne p", Personne.class);
        List<DTOPersonne> result = query.getResultList();
        for (DTOPersonne dtoPersonne : result) {
            dtoPersonne.setPassword(null);
        }
        return result;
    }

    @Override
    public DTOPersonne saveClient(DTOPersonne pers) throws AirBrassException {
        try {
            Personne persToPersist = getPersonneWithSecurePassword(AssembleurDTO.dtoToEntity(pers));
            if (0 == pers.getId()) {
                em.persist(persToPersist);
            } else {
                em.merge(persToPersist);
            }
            return AssembleurDTO.entityToDTO(persToPersist);
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.CA_MARCHE_PAS, ex.getMessage());
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }

    private Personne getPersonneWithSecurePassword(Personne personne) throws AirBrassException, NoSuchAlgorithmException {
        byte[] salt = createSalt();
        StringBuilder sb = new StringBuilder();
        for (byte b : salt) {
            sb.append(b);
        }
        personne.setSalt(sb.toString());
        salt = sb.toString().getBytes();
        personne.setPassword(getSecurePassword(personne.getPassword(), salt));
        return personne;
    }

    private static String getSecurePassword(String passwordToHash, byte[] salt) throws AirBrassException {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error(e);
            throw new DaoException(ExceptionEnum.CA_MARCHE_PAS, e.getMessage());
        }
        return generatedPassword;
    }

    private static byte[] createSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private byte[] getSalt(String login) throws AirBrassException {
        try {
            Query query = em.createQuery("SELECT p.salt FROM Personne p WHERE p.adresseMail = :login", String.class).setParameter("login", login);
            String salt = (String) query.getSingleResult();
            return salt.getBytes();
        } catch (ClassCastException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_INTEGRITE_DE_DONNEES, ex.getMessage());
        }
    }

    @Override
    public DTOPersonne connectClient(String login, String password) throws AirBrassException {
        try {
            Query query = em.createQuery("FROM Personne p WHERE p.adresseMail = :login and p.password = :password", Personne.class).setParameter("login", login);
            byte[] salt = getSalt(login);
            String newPassword = getSecurePassword(password, salt);
            query.setParameter("password", newPassword);
            List<Personne> personnes = query.getResultList();
            if (!personnes.isEmpty()) {
                return AssembleurDTO.entityToDTO(personnes.get(0));
            } else {
                throw new DaoException(ExceptionEnum.UTILISATEUR_INCONNU, "Utilisateur iconnu");
            }
        } catch (NoResultException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.UTILISATEUR_INCONNU, "Utilisateur iconnu");
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }

    @Override
    public boolean clientDontExist(String adresseMail) throws AirBrassException {
        try {
            Query query = em.createQuery("FROM Personne p WHERE p.adresseMail = :plogin", Personne.class).setParameter("plogin", adresseMail);
            List<Personne> personnes = query.getResultList();
            return personnes.isEmpty();
        } catch (PersistenceException ex) {
            log.error(ex);
            throw new DaoException(ExceptionEnum.DAO_MYSQL_HS, ex.getMessage());
        }
    }
}
