
package fr.afcepf.al30.stock.airbrass;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al30.stock.airbrass package. 
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

    private final static QName _FournisseurDTO_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "fournisseurDTO");
    private final static QName _GetListeCommandeResponse_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "getListeCommandeResponse");
    private final static QName _MajCommandeResponse_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "majCommandeResponse");
    private final static QName _ProduitsStockVide_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "produitsStockVide");
    private final static QName _GetProduitByIdResponse_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "getProduitByIdResponse");
    private final static QName _GetListeCommande_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "getListeCommande");
    private final static QName _AddCommandeResponse_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "addCommandeResponse");
    private final static QName _GetProduitByFournisseur_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "getProduitByFournisseur");
    private final static QName _GetAllFournisseur_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "getAllFournisseur");
    private final static QName _MajProduit_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "majProduit");
    private final static QName _GetAllProduit_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "getAllProduit");
    private final static QName _GetAllProduitResponse_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "getAllProduitResponse");
    private final static QName _GetProduitById_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "getProduitById");
    private final static QName _AddLigneResponse_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "addLigneResponse");
    private final static QName _GetCommandeByStatut_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "getCommandeByStatut");
    private final static QName _UtilisateurDTO_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "utilisateurDTO");
    private final static QName _MajCommande_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "majCommande");
    private final static QName _TrouverUtilisateur_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "trouverUtilisateur");
    private final static QName _GetCommandeByStatutResponse_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "getCommandeByStatutResponse");
    private final static QName _GetLigneByCommande_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "getLigneByCommande");
    private final static QName _MajProduitResponse_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "majProduitResponse");
    private final static QName _GetFournisseurById_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "getFournisseurById");
    private final static QName _AddCommande_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "addCommande");
    private final static QName _GetFournisseurByIdResponse_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "getFournisseurByIdResponse");
    private final static QName _GetProduitByFournisseurResponse_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "getProduitByFournisseurResponse");
    private final static QName _TrouverUtilisateurResponse_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "trouverUtilisateurResponse");
    private final static QName _LigneCommandeDTO_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "ligneCommandeDTO");
    private final static QName _GetLigneByCommandeResponse_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "getLigneByCommandeResponse");
    private final static QName _AddLigne_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "addLigne");
    private final static QName _ProduitDTO_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "produitDTO");
    private final static QName _GetAllFournisseurResponse_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "getAllFournisseurResponse");
    private final static QName _AjoutStock_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "ajoutStock");
    private final static QName _AjoutStockResponse_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "ajoutStockResponse");
    private final static QName _ProduitsStockVideResponse_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "produitsStockVideResponse");
    private final static QName _CommandeDTO_QNAME = new QName("http://airbrass.stock.al30.afcepf.fr", "commandeDTO");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al30.stock.airbrass
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddLigneResponse }
     * 
     */
    public AddLigneResponse createAddLigneResponse() {
        return new AddLigneResponse();
    }

    /**
     * Create an instance of {@link MajProduit }
     * 
     */
    public MajProduit createMajProduit() {
        return new MajProduit();
    }

    /**
     * Create an instance of {@link GetAllProduit }
     * 
     */
    public GetAllProduit createGetAllProduit() {
        return new GetAllProduit();
    }

    /**
     * Create an instance of {@link GetAllProduitResponse }
     * 
     */
    public GetAllProduitResponse createGetAllProduitResponse() {
        return new GetAllProduitResponse();
    }

    /**
     * Create an instance of {@link GetProduitById }
     * 
     */
    public GetProduitById createGetProduitById() {
        return new GetProduitById();
    }

    /**
     * Create an instance of {@link GetCommandeByStatut }
     * 
     */
    public GetCommandeByStatut createGetCommandeByStatut() {
        return new GetCommandeByStatut();
    }

    /**
     * Create an instance of {@link UtilisateurDTO }
     * 
     */
    public UtilisateurDTO createUtilisateurDTO() {
        return new UtilisateurDTO();
    }

    /**
     * Create an instance of {@link MajCommande }
     * 
     */
    public MajCommande createMajCommande() {
        return new MajCommande();
    }

    /**
     * Create an instance of {@link TrouverUtilisateur }
     * 
     */
    public TrouverUtilisateur createTrouverUtilisateur() {
        return new TrouverUtilisateur();
    }

    /**
     * Create an instance of {@link ProduitsStockVide }
     * 
     */
    public ProduitsStockVide createProduitsStockVide() {
        return new ProduitsStockVide();
    }

    /**
     * Create an instance of {@link GetProduitByIdResponse }
     * 
     */
    public GetProduitByIdResponse createGetProduitByIdResponse() {
        return new GetProduitByIdResponse();
    }

    /**
     * Create an instance of {@link FournisseurDTO }
     * 
     */
    public FournisseurDTO createFournisseurDTO() {
        return new FournisseurDTO();
    }

    /**
     * Create an instance of {@link GetListeCommandeResponse }
     * 
     */
    public GetListeCommandeResponse createGetListeCommandeResponse() {
        return new GetListeCommandeResponse();
    }

    /**
     * Create an instance of {@link MajCommandeResponse }
     * 
     */
    public MajCommandeResponse createMajCommandeResponse() {
        return new MajCommandeResponse();
    }

    /**
     * Create an instance of {@link AddCommandeResponse }
     * 
     */
    public AddCommandeResponse createAddCommandeResponse() {
        return new AddCommandeResponse();
    }

    /**
     * Create an instance of {@link GetProduitByFournisseur }
     * 
     */
    public GetProduitByFournisseur createGetProduitByFournisseur() {
        return new GetProduitByFournisseur();
    }

    /**
     * Create an instance of {@link GetAllFournisseur }
     * 
     */
    public GetAllFournisseur createGetAllFournisseur() {
        return new GetAllFournisseur();
    }

    /**
     * Create an instance of {@link GetListeCommande }
     * 
     */
    public GetListeCommande createGetListeCommande() {
        return new GetListeCommande();
    }

    /**
     * Create an instance of {@link GetAllFournisseurResponse }
     * 
     */
    public GetAllFournisseurResponse createGetAllFournisseurResponse() {
        return new GetAllFournisseurResponse();
    }

    /**
     * Create an instance of {@link GetLigneByCommandeResponse }
     * 
     */
    public GetLigneByCommandeResponse createGetLigneByCommandeResponse() {
        return new GetLigneByCommandeResponse();
    }

    /**
     * Create an instance of {@link AddLigne }
     * 
     */
    public AddLigne createAddLigne() {
        return new AddLigne();
    }

    /**
     * Create an instance of {@link ProduitDTO }
     * 
     */
    public ProduitDTO createProduitDTO() {
        return new ProduitDTO();
    }

    /**
     * Create an instance of {@link AjoutStockResponse }
     * 
     */
    public AjoutStockResponse createAjoutStockResponse() {
        return new AjoutStockResponse();
    }

    /**
     * Create an instance of {@link ProduitsStockVideResponse }
     * 
     */
    public ProduitsStockVideResponse createProduitsStockVideResponse() {
        return new ProduitsStockVideResponse();
    }

    /**
     * Create an instance of {@link CommandeDTO }
     * 
     */
    public CommandeDTO createCommandeDTO() {
        return new CommandeDTO();
    }

    /**
     * Create an instance of {@link AjoutStock }
     * 
     */
    public AjoutStock createAjoutStock() {
        return new AjoutStock();
    }

    /**
     * Create an instance of {@link GetCommandeByStatutResponse }
     * 
     */
    public GetCommandeByStatutResponse createGetCommandeByStatutResponse() {
        return new GetCommandeByStatutResponse();
    }

    /**
     * Create an instance of {@link GetLigneByCommande }
     * 
     */
    public GetLigneByCommande createGetLigneByCommande() {
        return new GetLigneByCommande();
    }

    /**
     * Create an instance of {@link MajProduitResponse }
     * 
     */
    public MajProduitResponse createMajProduitResponse() {
        return new MajProduitResponse();
    }

    /**
     * Create an instance of {@link AddCommande }
     * 
     */
    public AddCommande createAddCommande() {
        return new AddCommande();
    }

    /**
     * Create an instance of {@link GetFournisseurByIdResponse }
     * 
     */
    public GetFournisseurByIdResponse createGetFournisseurByIdResponse() {
        return new GetFournisseurByIdResponse();
    }

    /**
     * Create an instance of {@link GetProduitByFournisseurResponse }
     * 
     */
    public GetProduitByFournisseurResponse createGetProduitByFournisseurResponse() {
        return new GetProduitByFournisseurResponse();
    }

    /**
     * Create an instance of {@link TrouverUtilisateurResponse }
     * 
     */
    public TrouverUtilisateurResponse createTrouverUtilisateurResponse() {
        return new TrouverUtilisateurResponse();
    }

    /**
     * Create an instance of {@link LigneCommandeDTO }
     * 
     */
    public LigneCommandeDTO createLigneCommandeDTO() {
        return new LigneCommandeDTO();
    }

    /**
     * Create an instance of {@link GetFournisseurById }
     * 
     */
    public GetFournisseurById createGetFournisseurById() {
        return new GetFournisseurById();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FournisseurDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "fournisseurDTO")
    public JAXBElement<FournisseurDTO> createFournisseurDTO(FournisseurDTO value) {
        return new JAXBElement<FournisseurDTO>(_FournisseurDTO_QNAME, FournisseurDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListeCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getListeCommandeResponse")
    public JAXBElement<GetListeCommandeResponse> createGetListeCommandeResponse(GetListeCommandeResponse value) {
        return new JAXBElement<GetListeCommandeResponse>(_GetListeCommandeResponse_QNAME, GetListeCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MajCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "majCommandeResponse")
    public JAXBElement<MajCommandeResponse> createMajCommandeResponse(MajCommandeResponse value) {
        return new JAXBElement<MajCommandeResponse>(_MajCommandeResponse_QNAME, MajCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduitsStockVide }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "produitsStockVide")
    public JAXBElement<ProduitsStockVide> createProduitsStockVide(ProduitsStockVide value) {
        return new JAXBElement<ProduitsStockVide>(_ProduitsStockVide_QNAME, ProduitsStockVide.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduitByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getProduitByIdResponse")
    public JAXBElement<GetProduitByIdResponse> createGetProduitByIdResponse(GetProduitByIdResponse value) {
        return new JAXBElement<GetProduitByIdResponse>(_GetProduitByIdResponse_QNAME, GetProduitByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListeCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getListeCommande")
    public JAXBElement<GetListeCommande> createGetListeCommande(GetListeCommande value) {
        return new JAXBElement<GetListeCommande>(_GetListeCommande_QNAME, GetListeCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "addCommandeResponse")
    public JAXBElement<AddCommandeResponse> createAddCommandeResponse(AddCommandeResponse value) {
        return new JAXBElement<AddCommandeResponse>(_AddCommandeResponse_QNAME, AddCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduitByFournisseur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getProduitByFournisseur")
    public JAXBElement<GetProduitByFournisseur> createGetProduitByFournisseur(GetProduitByFournisseur value) {
        return new JAXBElement<GetProduitByFournisseur>(_GetProduitByFournisseur_QNAME, GetProduitByFournisseur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllFournisseur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getAllFournisseur")
    public JAXBElement<GetAllFournisseur> createGetAllFournisseur(GetAllFournisseur value) {
        return new JAXBElement<GetAllFournisseur>(_GetAllFournisseur_QNAME, GetAllFournisseur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MajProduit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "majProduit")
    public JAXBElement<MajProduit> createMajProduit(MajProduit value) {
        return new JAXBElement<MajProduit>(_MajProduit_QNAME, MajProduit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProduit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getAllProduit")
    public JAXBElement<GetAllProduit> createGetAllProduit(GetAllProduit value) {
        return new JAXBElement<GetAllProduit>(_GetAllProduit_QNAME, GetAllProduit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProduitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getAllProduitResponse")
    public JAXBElement<GetAllProduitResponse> createGetAllProduitResponse(GetAllProduitResponse value) {
        return new JAXBElement<GetAllProduitResponse>(_GetAllProduitResponse_QNAME, GetAllProduitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduitById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getProduitById")
    public JAXBElement<GetProduitById> createGetProduitById(GetProduitById value) {
        return new JAXBElement<GetProduitById>(_GetProduitById_QNAME, GetProduitById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLigneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "addLigneResponse")
    public JAXBElement<AddLigneResponse> createAddLigneResponse(AddLigneResponse value) {
        return new JAXBElement<AddLigneResponse>(_AddLigneResponse_QNAME, AddLigneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommandeByStatut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getCommandeByStatut")
    public JAXBElement<GetCommandeByStatut> createGetCommandeByStatut(GetCommandeByStatut value) {
        return new JAXBElement<GetCommandeByStatut>(_GetCommandeByStatut_QNAME, GetCommandeByStatut.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UtilisateurDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "utilisateurDTO")
    public JAXBElement<UtilisateurDTO> createUtilisateurDTO(UtilisateurDTO value) {
        return new JAXBElement<UtilisateurDTO>(_UtilisateurDTO_QNAME, UtilisateurDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MajCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "majCommande")
    public JAXBElement<MajCommande> createMajCommande(MajCommande value) {
        return new JAXBElement<MajCommande>(_MajCommande_QNAME, MajCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrouverUtilisateur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "trouverUtilisateur")
    public JAXBElement<TrouverUtilisateur> createTrouverUtilisateur(TrouverUtilisateur value) {
        return new JAXBElement<TrouverUtilisateur>(_TrouverUtilisateur_QNAME, TrouverUtilisateur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommandeByStatutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getCommandeByStatutResponse")
    public JAXBElement<GetCommandeByStatutResponse> createGetCommandeByStatutResponse(GetCommandeByStatutResponse value) {
        return new JAXBElement<GetCommandeByStatutResponse>(_GetCommandeByStatutResponse_QNAME, GetCommandeByStatutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLigneByCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getLigneByCommande")
    public JAXBElement<GetLigneByCommande> createGetLigneByCommande(GetLigneByCommande value) {
        return new JAXBElement<GetLigneByCommande>(_GetLigneByCommande_QNAME, GetLigneByCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MajProduitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "majProduitResponse")
    public JAXBElement<MajProduitResponse> createMajProduitResponse(MajProduitResponse value) {
        return new JAXBElement<MajProduitResponse>(_MajProduitResponse_QNAME, MajProduitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFournisseurById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getFournisseurById")
    public JAXBElement<GetFournisseurById> createGetFournisseurById(GetFournisseurById value) {
        return new JAXBElement<GetFournisseurById>(_GetFournisseurById_QNAME, GetFournisseurById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "addCommande")
    public JAXBElement<AddCommande> createAddCommande(AddCommande value) {
        return new JAXBElement<AddCommande>(_AddCommande_QNAME, AddCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFournisseurByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getFournisseurByIdResponse")
    public JAXBElement<GetFournisseurByIdResponse> createGetFournisseurByIdResponse(GetFournisseurByIdResponse value) {
        return new JAXBElement<GetFournisseurByIdResponse>(_GetFournisseurByIdResponse_QNAME, GetFournisseurByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduitByFournisseurResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getProduitByFournisseurResponse")
    public JAXBElement<GetProduitByFournisseurResponse> createGetProduitByFournisseurResponse(GetProduitByFournisseurResponse value) {
        return new JAXBElement<GetProduitByFournisseurResponse>(_GetProduitByFournisseurResponse_QNAME, GetProduitByFournisseurResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrouverUtilisateurResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "trouverUtilisateurResponse")
    public JAXBElement<TrouverUtilisateurResponse> createTrouverUtilisateurResponse(TrouverUtilisateurResponse value) {
        return new JAXBElement<TrouverUtilisateurResponse>(_TrouverUtilisateurResponse_QNAME, TrouverUtilisateurResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LigneCommandeDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "ligneCommandeDTO")
    public JAXBElement<LigneCommandeDTO> createLigneCommandeDTO(LigneCommandeDTO value) {
        return new JAXBElement<LigneCommandeDTO>(_LigneCommandeDTO_QNAME, LigneCommandeDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLigneByCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getLigneByCommandeResponse")
    public JAXBElement<GetLigneByCommandeResponse> createGetLigneByCommandeResponse(GetLigneByCommandeResponse value) {
        return new JAXBElement<GetLigneByCommandeResponse>(_GetLigneByCommandeResponse_QNAME, GetLigneByCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLigne }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "addLigne")
    public JAXBElement<AddLigne> createAddLigne(AddLigne value) {
        return new JAXBElement<AddLigne>(_AddLigne_QNAME, AddLigne.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduitDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "produitDTO")
    public JAXBElement<ProduitDTO> createProduitDTO(ProduitDTO value) {
        return new JAXBElement<ProduitDTO>(_ProduitDTO_QNAME, ProduitDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllFournisseurResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getAllFournisseurResponse")
    public JAXBElement<GetAllFournisseurResponse> createGetAllFournisseurResponse(GetAllFournisseurResponse value) {
        return new JAXBElement<GetAllFournisseurResponse>(_GetAllFournisseurResponse_QNAME, GetAllFournisseurResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjoutStock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "ajoutStock")
    public JAXBElement<AjoutStock> createAjoutStock(AjoutStock value) {
        return new JAXBElement<AjoutStock>(_AjoutStock_QNAME, AjoutStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjoutStockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "ajoutStockResponse")
    public JAXBElement<AjoutStockResponse> createAjoutStockResponse(AjoutStockResponse value) {
        return new JAXBElement<AjoutStockResponse>(_AjoutStockResponse_QNAME, AjoutStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduitsStockVideResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "produitsStockVideResponse")
    public JAXBElement<ProduitsStockVideResponse> createProduitsStockVideResponse(ProduitsStockVideResponse value) {
        return new JAXBElement<ProduitsStockVideResponse>(_ProduitsStockVideResponse_QNAME, ProduitsStockVideResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommandeDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "commandeDTO")
    public JAXBElement<CommandeDTO> createCommandeDTO(CommandeDTO value) {
        return new JAXBElement<CommandeDTO>(_CommandeDTO_QNAME, CommandeDTO.class, null, value);
    }

}
