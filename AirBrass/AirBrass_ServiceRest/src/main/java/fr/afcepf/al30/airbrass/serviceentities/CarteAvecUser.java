/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al30.airbrass.serviceentities;

import fr.afcepf.al30.airbrass.dto.DTOCB;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Max Michel
 */
@Getter
@Setter
public class CarteAvecUser {
    private DTOCB cb;
    private String userId;

    public CarteAvecUser() {
        //Empty constructor
    }
    
    public CarteAvecUser(DTOCB cb, String userId) {
        this.cb = cb;
        this.userId = userId;
    }
    
    
}
