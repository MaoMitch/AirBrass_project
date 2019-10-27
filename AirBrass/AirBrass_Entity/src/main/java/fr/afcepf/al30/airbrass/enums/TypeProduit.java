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
public enum TypeProduit {
    GUITARE("Guitare"),
    ACCESSOIRE("Accessoire"),
    FORMATION("Formation");

    private final String value;
    
    private TypeProduit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public static TypeProduit fromValue(String value){
        for (TypeProduit typeProduit : TypeProduit.values()) {
            if(typeProduit.getValue().equalsIgnoreCase(value)) {
                return typeProduit;
            }
        }
        return null;
    }
}
