/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al30.airbrass.business.impl;

import com.google.gson.Gson;
import fr.afcepf.al30.airbrass.dto.DTOCommande;
import fr.afcepf.al30.airbrass.dto.DTOLigneCommande;
import fr.afcepf.al30.airbrass.dto.OrchestrateurCarteBanquaire;
import fr.afcepf.al30.airbrass.dto.OrchestrateurCommande;
import fr.afcepf.al30.airbrass.dto.OrchestrateurCompte;
import fr.afcepf.al30.airbrass.enums.Comptes;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.xml.ws.BindingProvider;
import orchestrateur.airbrass.al30.afcepf.fr.Achat;
import orchestrateur.airbrass.al30.afcepf.fr.AchatPortType;
import orchestrateur.airbrass.al30.afcepf.fr.AchatRequest;
import orchestrateur.airbrass.al30.afcepf.fr.AchatResponse;
import fr.afcepf.al30.airbrass.business.api.ISOAPAccess;
import fr.afcepf.al30.airbrass.dto.OrchestrateurResponse;
import fr.afcepf.al30.airbrass.enums.WSDLLocation;

/**
 *
 * @author Max Michel
 */
@Stateless
public class SOAPAccess implements ISOAPAccess {

    private AchatPortType achatPortType;

    public SOAPAccess() {
        achatPortType = new Achat().getAchatPort();
        ((BindingProvider) achatPortType).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WSDLLocation.ODE_ADDRESS);
    }

    @Override
    public OrchestrateurResponse makeCommand(DTOCommande commande) {
        List<OrchestrateurCommande> orchests = new ArrayList<>();
        Double prix = 0d;
        for (DTOLigneCommande ligne : commande.getDtoLigneCommandes()) {
            OrchestrateurCommande orchest = new OrchestrateurCommande();
            orchest.setQteProduit(ligne.getQuantite());
            orchest.setRefProduit(ligne.getDtoProduit().getReference());
            orchests.add(orchest);
            prix += (ligne.getQuantite() * ligne.getDtoProduit().getPrix());
        }
        OrchestrateurCarteBanquaire cb = new OrchestrateurCarteBanquaire();
        cb.setNom(commande.getDtoCb().getIdentite());
        cb.setNumero(commande.getDtoCb().getNumero());
        cb.setPictogrammeSecurite(Integer.toString(commande.getDtoCb().getCle()));
        OrchestrateurCompte compte = Comptes.AIRBRASS_COMPTE.getCompte();
        Gson jsonCommande = new Gson();
        jsonCommande.toJson(orchests);
        Gson jsonCB = new Gson();
        jsonCB.toJson(cb);
        Gson jsonCompte = new Gson();
        jsonCompte.toJson(compte);

        AchatRequest request = new AchatRequest();

        request.setJsonCB(jsonCB.toJson(cb));
        request.setJsonCompte(jsonCompte.toJson(compte));
        request.setJsonCommande(jsonCommande.toJson(orchests));
        request.setPrix(prix);

        AchatResponse response = achatPortType.process(request);
        return new OrchestrateurResponse(response);

    }

}
