
package fr.afcepf.al30.banque;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "banque", targetNamespace = "http://banque.al30.afcepf.fr")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Banque {


    /**
     * 
     * @param carteJson
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(name = "returnCarteExiste", targetNamespace = "")
    @RequestWrapper(localName = "carteExiste", targetNamespace = "http://banque.al30.afcepf.fr", className = "fr.afcepf.al30.banque.CarteExiste")
    @ResponseWrapper(localName = "carteExisteResponse", targetNamespace = "http://banque.al30.afcepf.fr", className = "fr.afcepf.al30.banque.CarteExisteResponse")
    public Boolean carteExiste(
        @WebParam(name = "carteJson", targetNamespace = "")
        String carteJson);

    /**
     * 
     * @param carteADebiter
     * @param compteACrediter
     * @param sommeadebiter
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(name = "EtatOperationDebit", targetNamespace = "")
    @RequestWrapper(localName = "debiterCarte", targetNamespace = "http://banque.al30.afcepf.fr", className = "fr.afcepf.al30.banque.DebiterCarte")
    @ResponseWrapper(localName = "debiterCarteResponse", targetNamespace = "http://banque.al30.afcepf.fr", className = "fr.afcepf.al30.banque.DebiterCarteResponse")
    public Boolean debiterCarte(
        @WebParam(name = "sommeadebiter", targetNamespace = "")
        double sommeadebiter,
        @WebParam(name = "carteADebiter", targetNamespace = "")
        String carteADebiter,
        @WebParam(name = "compteACrediter", targetNamespace = "")
        String compteACrediter);

    /**
     * 
     * @param carteACrediter
     * @param compteADebiter
     * @param sommeacrediter
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(name = "EtatOperationCredit", targetNamespace = "")
    @RequestWrapper(localName = "crediterCarte", targetNamespace = "http://banque.al30.afcepf.fr", className = "fr.afcepf.al30.banque.CrediterCarte")
    @ResponseWrapper(localName = "crediterCarteResponse", targetNamespace = "http://banque.al30.afcepf.fr", className = "fr.afcepf.al30.banque.CrediterCarteResponse")
    public Boolean crediterCarte(
        @WebParam(name = "sommeacrediter", targetNamespace = "")
        double sommeacrediter,
        @WebParam(name = "carteACrediter", targetNamespace = "")
        String carteACrediter,
        @WebParam(name = "compteADebiter", targetNamespace = "")
        String compteADebiter);

    /**
     * 
     * @param sommeadebite
     * @param carteJson
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(name = "validitesolde", targetNamespace = "")
    @RequestWrapper(localName = "verifiersolde", targetNamespace = "http://banque.al30.afcepf.fr", className = "fr.afcepf.al30.banque.Verifiersolde")
    @ResponseWrapper(localName = "verifiersoldeResponse", targetNamespace = "http://banque.al30.afcepf.fr", className = "fr.afcepf.al30.banque.VerifiersoldeResponse")
    public Boolean verifiersolde(
        @WebParam(name = "sommeadebite", targetNamespace = "")
        double sommeadebite,
        @WebParam(name = "carteJson", targetNamespace = "")
        String carteJson);

}
