package fr.afcepf.al30.airbrass.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al30.airbrass.dao.api.IDAOClient;
import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.business.api.IBusinessUtilisateur;
import fr.afcepf.al30.airbrass.dao.api.IDAOAdresse;
import fr.afcepf.al30.airbrass.dao.api.IDAOPays;
import fr.afcepf.al30.airbrass.dao.api.IDAOVille;
import fr.afcepf.al30.airbrass.dao.impl.DAOAdresse;
import fr.afcepf.al30.airbrass.dao.impl.DAOPays;
import fr.afcepf.al30.airbrass.dto.DTOAdresse;
import fr.afcepf.al30.airbrass.entities.Adresse;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.BusinessException;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 * Implementation du {@link IBusinessUtilisateur}.
 */
@Remote(IBusinessUtilisateur.class)
@Stateless
public class BusinessUtilisateur implements IBusinessUtilisateur {

    /**
     * le dao c'accès aux personnes.
     */
    @EJB
    private IDAOClient daoClient;

    /**
     * le dao d'accès aux pays.
     */
    @EJB
    private IDAOPays daoPays;

    /**
     * le dao d'accès aux villes.
     */
    @EJB
    private IDAOVille daoVille;

    /**
     * le dao d'accès aux addresses.
     */
    @EJB
    private IDAOAdresse daoAdresse;

    @Override
    public DTOPersonne getClientById(int id) throws AirBrassException {
        return daoClient.getClientById(id);
    }

    @Override
    public List<DTOPersonne> getAllClient() throws AirBrassException {
        return daoClient.getAllClient();
    }

    @Override
    public DTOPersonne createNewClient(DTOPersonne pers) throws AirBrassException {
        if (daoClient.clientDontExist(pers.getAdresseMail())) {
            return udapteClient(pers);
        } else {
            throw new BusinessException(ExceptionEnum.UTILISATEUR_DEJA_ENREGISTRER, "L'adresse mail : " + pers.getAdresseMail() + " est déjà utilisée");
        }
    }

    @Override
    public DTOPersonne udapteClient(DTOPersonne pers) throws AirBrassException {
        if (pers.getDtoAdresses() != null) {
            for (DTOAdresse dtoAdresse : pers.getDtoAdresses()) {
                DTOAdresse adr = persistAdresse(dtoAdresse);
                pers.setDtoAdresses(new ArrayList<>());
                pers.getDtoAdresses().add(adr);
            }
        }
        return daoClient.saveClient(pers);
    }

    /**
     * Methode de persistence de l'{@link DTOAdresse} d'une personne, afin
     * d'éviter les doublons dans la base de données.
     *
     * @param adresse l'{@link DTOAdresse} à persister
     * @return l'{@link Adresse} un fois persisté ou obtenu si celle-ci existe
     * déjà en base
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOVille} remonte une erreur</li>
     * <li>Si le {@link DAOPays} remonte une erreur</li>
     * <li>Si le {@link DAOAdresse} remonte une erreur</li>
     * </ul>
     */
    private DTOAdresse persistAdresse(DTOAdresse adresse) throws AirBrassException {
        if (!daoPays.paysExist(adresse.getDtoVille().getDtoPays())) {
            adresse.getDtoVille().setDtoPays(daoPays.addPays(adresse.getDtoVille().getDtoPays()));
        } else {
            adresse.getDtoVille().setDtoPays(daoPays.getPays(adresse.getDtoVille().getDtoPays()));
        }
        if (!daoVille.villeExist(adresse.getDtoVille())) {
            adresse.setDtoVille(daoVille.addVille(adresse.getDtoVille()));
        } else {
            adresse.setDtoVille(daoVille.getVille(adresse.getDtoVille()));
        }
        DTOAdresse returnAdresse;
        if (!daoAdresse.adresseExist(adresse)) {
            returnAdresse = daoAdresse.createNewAdresse(adresse);
        } else {
            returnAdresse = daoAdresse.getAdresse(adresse);
        }
        return returnAdresse;
    }

    @Override
    public DTOPersonne connectClient(String login, String password) throws AirBrassException {
        return daoClient.connectClient(login, password);
    }
}
