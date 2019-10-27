/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al30.airbrass.business.api;

import fr.afcepf.al30.airbrass.dto.DTOCommande;
import fr.afcepf.al30.airbrass.dto.OrchestrateurResponse;
import javax.ejb.Remote;

/**
 *
 * @author Max Michel
 */
@Remote
@FunctionalInterface
public interface ISOAPAccess {
     
     public OrchestrateurResponse makeCommand(DTOCommande commande);
}
