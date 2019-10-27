/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al30.airbrass.enums;

import fr.afcepf.al30.airbrass.dto.OrchestrateurCompte;

/**
 *
 * @author Max Michel
 */
public enum Comptes {
    AIRBRASS_COMPTE(new OrchestrateurCompte("AirBrass", "2222"));

    private OrchestrateurCompte compte;

    private Comptes(OrchestrateurCompte compte) {
        this.compte = compte;
    }

    public OrchestrateurCompte getCompte() {
        return compte;
    }

}
