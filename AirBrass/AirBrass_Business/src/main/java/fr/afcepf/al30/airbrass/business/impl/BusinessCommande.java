package fr.afcepf.al30.airbrass.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.al30.airbrass.business.api.IBusinessCommande;
import fr.afcepf.al30.airbrass.dao.api.IDAOCB;
import fr.afcepf.al30.airbrass.dao.api.IDAOClient;
import fr.afcepf.al30.airbrass.dao.api.IDAOCommande;
import fr.afcepf.al30.airbrass.dao.api.IDAOLigneCommande;
import fr.afcepf.al30.airbrass.dto.DTOCB;
import fr.afcepf.al30.airbrass.dto.DTOCommande;
import fr.afcepf.al30.airbrass.dto.DTOLigneCommande;
import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.business.api.ISOAPAccess;

/**
 * L'implémentation du {@link IBusinessCommande}.
 */
@Remote(IBusinessCommande.class)
@Stateless
public class BusinessCommande implements IBusinessCommande {

    /**
     * Le dao d'accès au commande.
     */
    @EJB
    private IDAOCommande daoCommande;

    /**
     * Le dao d'accès au ligne de commande.
     */
    @EJB
    private IDAOLigneCommande daoLigneCommande;

    /**
     * Le dao d'accès au cb.
     */
    @EJB
    private IDAOCB daoCb;

    /**
     * Le dao d'accès au personne.
     */
    @EJB
    private IDAOClient daoClient;

    @EJB
    private ISOAPAccess soapAccess;

    @Override
    public List<DTOCommande> getCommandesByUser(DTOPersonne pers) throws AirBrassException {
        return daoCommande.getCommandeByClient(pers);
    }

    @Override
    public double getPrixByCommande(DTOCommande commande) throws AirBrassException {
        double prix = 0;
        List<DTOLigneCommande> dtolignes = getLigneByCommande(commande);
        if (dtolignes != null) {
            for (DTOLigneCommande ligneCommande : dtolignes) {
                prix += ligneCommande.getQuantite() * ligneCommande.getDtoProduit().getPrix();
            }
        }
        return prix;
    }

    @Override
    public DTOLigneCommande addLigne(DTOLigneCommande dTOLigneCommande) throws AirBrassException {
        return daoLigneCommande.addLigne(dTOLigneCommande);
    }

    @Override
    public DTOCommande updateCommande(DTOCommande commande) throws AirBrassException {
        return daoCommande.updateCommande(commande);
    }

    @Override
    public DTOCommande addCommande(DTOCommande commande) throws AirBrassException {
        soapAccess.makeCommand(commande);
        return daoCommande.addCommande(commande);
    }

    @Override
    public List<DTOLigneCommande> getLigneByCommande(DTOCommande commande) throws AirBrassException {
        return daoCommande.getLignesByCommande(commande);
    }

    @Override
    public DTOCommande getCommandeById(int id) throws AirBrassException {
        return daoCommande.getCommandeById(id);
    }

    @Override
    public List<DTOCB> getCBByClient(int idClient) throws AirBrassException {
        return daoCb.getCBByClient(idClient);
    }

    @Override
    public DTOCB ajouterCarte(DTOCB dtoCb) throws AirBrassException {
        return daoCb.ajouterCarte(dtoCb);
    }

    @Override
    public DTOCB majCarte(DTOCB dtoCb) throws AirBrassException {
        return daoCb.majCarte(dtoCb);
    }

    @Override
    public boolean suprCarte(DTOCB dtoCb) throws AirBrassException {
        return daoCb.suprCarte(dtoCb);
    }

}
