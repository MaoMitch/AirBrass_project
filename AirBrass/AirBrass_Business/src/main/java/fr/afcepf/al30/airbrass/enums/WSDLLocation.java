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
public class WSDLLocation {

    public static final String ODE_ADDRESS = "http://192.168.102.181:18080/ode/processes/Achat";

    public static final String ACHAT = "http://192.168.102.181:18080/ode/processes/Achat?wsdl";

    public static final String FORMATION = "http://192.168.102.181:8080/AirBrass_Formation/airbrass/formations?wsdl";

    private WSDLLocation() {
        //Only static method.
    }
}
