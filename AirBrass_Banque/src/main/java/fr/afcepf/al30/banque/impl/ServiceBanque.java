package fr.afcepf.al30.banque.impl;

import java.util.Date;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import fr.afcepf.al30.banque.api.IDaoCarteBanquaire;
import fr.afcepf.al30.banque.api.IDaoCompte;
import fr.afcepf.al30.banque.api.IDaoOperation;
import fr.afcepf.al30.banque.api.IServiceBanque;
import fr.afcepf.al30.banque.dto.AssembleurDTO;
import fr.afcepf.al30.banque.dto.CarteBanquaireDTO;
import fr.afcepf.al30.banque.dto.CompteBanquaireDTO;
import fr.afcepf.al30.banque.entity.CarteBanquaire;
import fr.afcepf.al30.banque.entity.CompteBanquaire;
import fr.afcepf.al30.banque.entity.Operation;
import lombok.Getter;
import lombok.Setter;

@WebService(targetNamespace = "http://banque.al30.afcepf.fr", endpointInterface = "fr.afcepf.al30.banque.api.IServiceBanque")
@Getter
@Setter
public class ServiceBanque implements IServiceBanque {

    private IDaoCarteBanquaire daoCarte;
    private IDaoCompte daoCompte;
    private IDaoOperation daoOperation;
    private Logger log = Logger.getLogger(getClass());

    @Override
    public Boolean existe(String carteJson) {

        //traitement la string json
        Gson gson = new Gson();

        CarteBanquaireDTO paramCarte = gson.fromJson(carteJson, CarteBanquaireDTO.class);

        CarteBanquaire cb = daoCarte.getByNomNumeroPictogramme(paramCarte.getNom(), paramCarte.getNumero(),
                paramCarte.getPictogrammeSecurite());

        if (cb != null) {
            return true;
        }

        return false;
    }

    @Override
    public Boolean verifiersolde(double paramSomme, String carteJson) {

        //traitement de la string json
        Gson gson = new Gson();
        CarteBanquaireDTO paramCarte = gson.fromJson(carteJson, CarteBanquaireDTO.class);

        //recuperation de l'entité compte
        CompteBanquaire compte = daoCompte.getCompteBanquaireByCarte(AssembleurDTO.dtoToEntity(paramCarte));

        if (compte.getSolde() > paramSomme) {
            return true;
        }

        return false;
    }

    @Transactional
    @Override
    public Boolean debiterCarte(double paramSomme, String paramCarteADebiter, String paramCompteACrediter) {
        // traitement des string json
        Gson gson = new Gson();

        CarteBanquaireDTO paramCarte = gson.fromJson(paramCarteADebiter, CarteBanquaireDTO.class);
        CompteBanquaireDTO paramCompte = gson.fromJson(paramCompteACrediter, CompteBanquaireDTO.class);

        // recuperation des entités
        CompteBanquaire compteADebiter = daoCompte.getCompteBanquaireByCarte(AssembleurDTO.dtoToEntity(paramCarte));
        CompteBanquaire compteACrediter = daoCompte.getCompteBanquaireByCompte(AssembleurDTO.dtoToEntity(paramCompte));

        return transfertDArgent(compteADebiter, compteACrediter, paramSomme);
    }

    @Transactional
    @Override
    public Boolean crediterCarte(double paramSomme, String paramCarteACrediter, String paramCompteADebiter) {
        // traitement des string json
        Gson gson = new Gson();

        CarteBanquaireDTO paramCarte = gson.fromJson(paramCarteACrediter, CarteBanquaireDTO.class);
        CompteBanquaireDTO paramCompte = gson.fromJson(paramCompteADebiter, CompteBanquaireDTO.class);

        // recuperation des entités
        CompteBanquaire compteACrediter = daoCompte.getCompteBanquaireByCarte(AssembleurDTO.dtoToEntity(paramCarte));
        CompteBanquaire compteADebiter = daoCompte.getCompteBanquaireByCompte(AssembleurDTO.dtoToEntity(paramCompte));
        
        return transfertDArgent(compteADebiter, compteACrediter, paramSomme);

    }

    /**
     * Methode de transfert d'une somme entre deux compte, pour le débit d'une carte, ou son crédit.
     * @param compteADebiter le compte à débiter
     * @param compteACrediter le compte à créditer
     * @param paramSomme la somme à transférer
     * @return 
     */
    private Boolean transfertDArgent(CompteBanquaire compteADebiter, CompteBanquaire compteACrediter, double paramSomme) {
        try {
            compteADebiter.setSolde(compteADebiter.getSolde() - paramSomme);
            compteACrediter.setSolde(compteACrediter.getSolde() + paramSomme);

            Operation operation = new Operation(paramSomme, new Date(), compteADebiter, compteACrediter);

            compteADebiter.getOperationsPaye().add(operation);
            compteACrediter.getOperationsRecu().add(operation);

            daoCompte.saveCompte(compteADebiter);
            daoCompte.saveCompte(compteACrediter);
            daoOperation.saveOperation(operation);
        } catch (Exception e) {
            log.fatal(e);
            return false;
        }

        return true;
    }

}
