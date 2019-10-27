
package fr.afcepf.al30.banque;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al30.banque package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CarteExiste_QNAME = new QName("http://banque.al30.afcepf.fr", "carteExiste");
    private final static QName _CrediterCarteResponse_QNAME = new QName("http://banque.al30.afcepf.fr", "crediterCarteResponse");
    private final static QName _DebiterCarteResponse_QNAME = new QName("http://banque.al30.afcepf.fr", "debiterCarteResponse");
    private final static QName _Verifiersolde_QNAME = new QName("http://banque.al30.afcepf.fr", "verifiersolde");
    private final static QName _DebiterCarte_QNAME = new QName("http://banque.al30.afcepf.fr", "debiterCarte");
    private final static QName _CarteExisteResponse_QNAME = new QName("http://banque.al30.afcepf.fr", "carteExisteResponse");
    private final static QName _CrediterCarte_QNAME = new QName("http://banque.al30.afcepf.fr", "crediterCarte");
    private final static QName _VerifiersoldeResponse_QNAME = new QName("http://banque.al30.afcepf.fr", "verifiersoldeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al30.banque
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CrediterCarteResponse }
     * 
     */
    public CrediterCarteResponse createCrediterCarteResponse() {
        return new CrediterCarteResponse();
    }

    /**
     * Create an instance of {@link DebiterCarteResponse }
     * 
     */
    public DebiterCarteResponse createDebiterCarteResponse() {
        return new DebiterCarteResponse();
    }

    /**
     * Create an instance of {@link Verifiersolde }
     * 
     */
    public Verifiersolde createVerifiersolde() {
        return new Verifiersolde();
    }

    /**
     * Create an instance of {@link CarteExiste }
     * 
     */
    public CarteExiste createCarteExiste() {
        return new CarteExiste();
    }

    /**
     * Create an instance of {@link CarteExisteResponse }
     * 
     */
    public CarteExisteResponse createCarteExisteResponse() {
        return new CarteExisteResponse();
    }

    /**
     * Create an instance of {@link CrediterCarte }
     * 
     */
    public CrediterCarte createCrediterCarte() {
        return new CrediterCarte();
    }

    /**
     * Create an instance of {@link VerifiersoldeResponse }
     * 
     */
    public VerifiersoldeResponse createVerifiersoldeResponse() {
        return new VerifiersoldeResponse();
    }

    /**
     * Create an instance of {@link DebiterCarte }
     * 
     */
    public DebiterCarte createDebiterCarte() {
        return new DebiterCarte();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CarteExiste }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://banque.al30.afcepf.fr", name = "carteExiste")
    public JAXBElement<CarteExiste> createCarteExiste(CarteExiste value) {
        return new JAXBElement<CarteExiste>(_CarteExiste_QNAME, CarteExiste.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrediterCarteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://banque.al30.afcepf.fr", name = "crediterCarteResponse")
    public JAXBElement<CrediterCarteResponse> createCrediterCarteResponse(CrediterCarteResponse value) {
        return new JAXBElement<CrediterCarteResponse>(_CrediterCarteResponse_QNAME, CrediterCarteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DebiterCarteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://banque.al30.afcepf.fr", name = "debiterCarteResponse")
    public JAXBElement<DebiterCarteResponse> createDebiterCarteResponse(DebiterCarteResponse value) {
        return new JAXBElement<DebiterCarteResponse>(_DebiterCarteResponse_QNAME, DebiterCarteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Verifiersolde }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://banque.al30.afcepf.fr", name = "verifiersolde")
    public JAXBElement<Verifiersolde> createVerifiersolde(Verifiersolde value) {
        return new JAXBElement<Verifiersolde>(_Verifiersolde_QNAME, Verifiersolde.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DebiterCarte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://banque.al30.afcepf.fr", name = "debiterCarte")
    public JAXBElement<DebiterCarte> createDebiterCarte(DebiterCarte value) {
        return new JAXBElement<DebiterCarte>(_DebiterCarte_QNAME, DebiterCarte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CarteExisteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://banque.al30.afcepf.fr", name = "carteExisteResponse")
    public JAXBElement<CarteExisteResponse> createCarteExisteResponse(CarteExisteResponse value) {
        return new JAXBElement<CarteExisteResponse>(_CarteExisteResponse_QNAME, CarteExisteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrediterCarte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://banque.al30.afcepf.fr", name = "crediterCarte")
    public JAXBElement<CrediterCarte> createCrediterCarte(CrediterCarte value) {
        return new JAXBElement<CrediterCarte>(_CrediterCarte_QNAME, CrediterCarte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifiersoldeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://banque.al30.afcepf.fr", name = "verifiersoldeResponse")
    public JAXBElement<VerifiersoldeResponse> createVerifiersoldeResponse(VerifiersoldeResponse value) {
        return new JAXBElement<VerifiersoldeResponse>(_VerifiersoldeResponse_QNAME, VerifiersoldeResponse.class, null, value);
    }

}
