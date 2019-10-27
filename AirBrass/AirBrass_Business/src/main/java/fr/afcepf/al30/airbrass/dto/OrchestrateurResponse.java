/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al30.airbrass.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import orchestrateur.airbrass.al30.afcepf.fr.AchatResponse;

/**
 *
 * @author Max Michel
 */
@Getter
@Setter
public class OrchestrateurResponse implements Serializable{
    private AchatResponse achatResponse;

    public OrchestrateurResponse(AchatResponse achatResponse) {
        this.achatResponse = achatResponse;
    }
    
    
}
