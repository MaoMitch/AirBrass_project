
package fr.afcepf.al30.formations;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al30.formations package. 
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

    private static final String SERVICE_NAME = "http://formations.al30.afcepf.fr";
    private static final QName _ReserverFormationResponse_QNAME = new QName(SERVICE_NAME, "reserverFormationResponse");
    private static final QName _GetAllFormations_QNAME = new QName(SERVICE_NAME, "getAllFormations");
    private static final QName _GetFormationsByDateResponse_QNAME = new QName(SERVICE_NAME, "getFormationsByDateResponse");
    private static final QName _VerifierDispoFormationResponse_QNAME = new QName(SERVICE_NAME, "verifierDispoFormationResponse");
    private static final QName _VerifierDispoFormation_QNAME = new QName(SERVICE_NAME, "verifierDispoFormation");
    private static final QName _GetFormationById_QNAME = new QName(SERVICE_NAME, "getFormationById");
    private static final QName _FormateurDTO_QNAME = new QName(SERVICE_NAME, "formateurDTO");
    private static final QName _GetFormationByIdResponse_QNAME = new QName(SERVICE_NAME, "getFormationByIdResponse");
    private static final QName _FormationDTO_QNAME = new QName(SERVICE_NAME, "formationDTO");
    private static final QName _GetFormationsByDate_QNAME = new QName(SERVICE_NAME, "getFormationsByDate");
    private static final QName _ReserverFormation_QNAME = new QName(SERVICE_NAME, "reserverFormation");
    private static final QName _GetAllFormationsResponse_QNAME = new QName(SERVICE_NAME, "getAllFormationsResponse");
    private static final QName _GetFormations_QNAME = new QName(SERVICE_NAME, "getFormations");
    private static final QName _GetAllFormateursResponse_QNAME = new QName(SERVICE_NAME, "getAllFormateursResponse");
    private static final QName _GetFormationsResponse_QNAME = new QName(SERVICE_NAME, "getFormationsResponse");
    private static final QName _GetAllFormateurs_QNAME = new QName(SERVICE_NAME, "getAllFormateurs");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al30.formations
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReserverFormation }
     * 
     */
    public ReserverFormation createReserverFormation() {
        return new ReserverFormation();
    }

    /**
     * Create an instance of {@link FormationDTO }
     * 
     */
    public FormationDTO createFormationDTO() {
        return new FormationDTO();
    }

    /**
     * Create an instance of {@link GetFormationsByDate }
     * 
     */
    public GetFormationsByDate createGetFormationsByDate() {
        return new GetFormationsByDate();
    }

    /**
     * Create an instance of {@link GetAllFormateursResponse }
     * 
     */
    public GetAllFormateursResponse createGetAllFormateursResponse() {
        return new GetAllFormateursResponse();
    }

    /**
     * Create an instance of {@link GetFormationsResponse }
     * 
     */
    public GetFormationsResponse createGetFormationsResponse() {
        return new GetFormationsResponse();
    }

    /**
     * Create an instance of {@link GetAllFormateurs }
     * 
     */
    public GetAllFormateurs createGetAllFormateurs() {
        return new GetAllFormateurs();
    }

    /**
     * Create an instance of {@link GetAllFormationsResponse }
     * 
     */
    public GetAllFormationsResponse createGetAllFormationsResponse() {
        return new GetAllFormationsResponse();
    }

    /**
     * Create an instance of {@link GetFormations }
     * 
     */
    public GetFormations createGetFormations() {
        return new GetFormations();
    }

    /**
     * Create an instance of {@link ReserverFormationResponse }
     * 
     */
    public ReserverFormationResponse createReserverFormationResponse() {
        return new ReserverFormationResponse();
    }

    /**
     * Create an instance of {@link GetFormationsByDateResponse }
     * 
     */
    public GetFormationsByDateResponse createGetFormationsByDateResponse() {
        return new GetFormationsByDateResponse();
    }

    /**
     * Create an instance of {@link GetAllFormations }
     * 
     */
    public GetAllFormations createGetAllFormations() {
        return new GetAllFormations();
    }

    /**
     * Create an instance of {@link FormateurDTO }
     * 
     */
    public FormateurDTO createFormateurDTO() {
        return new FormateurDTO();
    }

    /**
     * Create an instance of {@link GetFormationById }
     * 
     */
    public GetFormationById createGetFormationById() {
        return new GetFormationById();
    }

    /**
     * Create an instance of {@link GetFormationByIdResponse }
     * 
     */
    public GetFormationByIdResponse createGetFormationByIdResponse() {
        return new GetFormationByIdResponse();
    }

    /**
     * Create an instance of {@link VerifierDispoFormationResponse }
     * 
     */
    public VerifierDispoFormationResponse createVerifierDispoFormationResponse() {
        return new VerifierDispoFormationResponse();
    }

    /**
     * Create an instance of {@link VerifierDispoFormation }
     * 
     */
    public VerifierDispoFormation createVerifierDispoFormation() {
        return new VerifierDispoFormation();
    }

    /**
     * Create an instance of {@link Formation }
     * 
     */
    public Formation createFormation() {
        return new Formation();
    }

    /**
     * Create an instance of {@link Formateur }
     * 
     */
    public Formateur createFormateur() {
        return new Formateur();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserverFormationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formations.al30.afcepf.fr", name = "reserverFormationResponse")
    public JAXBElement<ReserverFormationResponse> createReserverFormationResponse(ReserverFormationResponse value) {
        return new JAXBElement<>(_ReserverFormationResponse_QNAME, ReserverFormationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllFormations }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formations.al30.afcepf.fr", name = "getAllFormations")
    public JAXBElement<GetAllFormations> createGetAllFormations(GetAllFormations value) {
        return new JAXBElement<>(_GetAllFormations_QNAME, GetAllFormations.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFormationsByDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formations.al30.afcepf.fr", name = "getFormationsByDateResponse")
    public JAXBElement<GetFormationsByDateResponse> createGetFormationsByDateResponse(GetFormationsByDateResponse value) {
        return new JAXBElement<>(_GetFormationsByDateResponse_QNAME, GetFormationsByDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifierDispoFormationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formations.al30.afcepf.fr", name = "verifierDispoFormationResponse")
    public JAXBElement<VerifierDispoFormationResponse> createVerifierDispoFormationResponse(VerifierDispoFormationResponse value) {
        return new JAXBElement<>(_VerifierDispoFormationResponse_QNAME, VerifierDispoFormationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifierDispoFormation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formations.al30.afcepf.fr", name = "verifierDispoFormation")
    public JAXBElement<VerifierDispoFormation> createVerifierDispoFormation(VerifierDispoFormation value) {
        return new JAXBElement<>(_VerifierDispoFormation_QNAME, VerifierDispoFormation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFormationById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formations.al30.afcepf.fr", name = "getFormationById")
    public JAXBElement<GetFormationById> createGetFormationById(GetFormationById value) {
        return new JAXBElement<>(_GetFormationById_QNAME, GetFormationById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FormateurDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formations.al30.afcepf.fr", name = "formateurDTO")
    public JAXBElement<FormateurDTO> createFormateurDTO(FormateurDTO value) {
        return new JAXBElement<>(_FormateurDTO_QNAME, FormateurDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFormationByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formations.al30.afcepf.fr", name = "getFormationByIdResponse")
    public JAXBElement<GetFormationByIdResponse> createGetFormationByIdResponse(GetFormationByIdResponse value) {
        return new JAXBElement<>(_GetFormationByIdResponse_QNAME, GetFormationByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FormationDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formations.al30.afcepf.fr", name = "formationDTO")
    public JAXBElement<FormationDTO> createFormationDTO(FormationDTO value) {
        return new JAXBElement<>(_FormationDTO_QNAME, FormationDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFormationsByDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formations.al30.afcepf.fr", name = "getFormationsByDate")
    public JAXBElement<GetFormationsByDate> createGetFormationsByDate(GetFormationsByDate value) {
        return new JAXBElement<>(_GetFormationsByDate_QNAME, GetFormationsByDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserverFormation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formations.al30.afcepf.fr", name = "reserverFormation")
    public JAXBElement<ReserverFormation> createReserverFormation(ReserverFormation value) {
        return new JAXBElement<>(_ReserverFormation_QNAME, ReserverFormation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllFormationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formations.al30.afcepf.fr", name = "getAllFormationsResponse")
    public JAXBElement<GetAllFormationsResponse> createGetAllFormationsResponse(GetAllFormationsResponse value) {
        return new JAXBElement<>(_GetAllFormationsResponse_QNAME, GetAllFormationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFormations }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formations.al30.afcepf.fr", name = "getFormations")
    public JAXBElement<GetFormations> createGetFormations(GetFormations value) {
        return new JAXBElement<>(_GetFormations_QNAME, GetFormations.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllFormateursResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formations.al30.afcepf.fr", name = "getAllFormateursResponse")
    public JAXBElement<GetAllFormateursResponse> createGetAllFormateursResponse(GetAllFormateursResponse value) {
        return new JAXBElement<>(_GetAllFormateursResponse_QNAME, GetAllFormateursResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFormationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formations.al30.afcepf.fr", name = "getFormationsResponse")
    public JAXBElement<GetFormationsResponse> createGetFormationsResponse(GetFormationsResponse value) {
        return new JAXBElement<>(_GetFormationsResponse_QNAME, GetFormationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllFormateurs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formations.al30.afcepf.fr", name = "getAllFormateurs")
    public JAXBElement<GetAllFormateurs> createGetAllFormateurs(GetAllFormateurs value) {
        return new JAXBElement<>(_GetAllFormateurs_QNAME, GetAllFormateurs.class, null, value);
    }

}
