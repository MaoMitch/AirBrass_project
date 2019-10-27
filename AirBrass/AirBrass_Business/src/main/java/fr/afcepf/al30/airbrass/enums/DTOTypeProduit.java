/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al30.airbrass.enums;

/**
 *
 * @author Max Michel
 */
public enum DTOTypeProduit {
    GUITARE("Guitare"),
    ACCESSOIRE("Accessoire"),
    FORMATION("Formation");

    private final String value;
    
    private DTOTypeProduit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public static DTOTypeProduit fromValue(String value){
        for (DTOTypeProduit typeProduit : DTOTypeProduit.values()) {
            if(typeProduit.getValue().equalsIgnoreCase(value)) {
                return typeProduit;
            }
        }
        return null;
    }
}
