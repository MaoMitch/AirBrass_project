package fr.afcepf.al30.stock.airbrass;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the fr.afcepf.al30.stock.airbrass package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private static final String NAME_SPACE = "http://airbrass.stock.al30.afcepf.fr";

    private static final QName _FournisseurDTO_QNAME = new QName(NAME_SPACE, "fournisseurDTO");
    private static final QName _GetListeCommandeResponse_QNAME = new QName(NAME_SPACE, "getListeCommandeResponse");
    private static final QName _MajCommandeResponse_QNAME = new QName(NAME_SPACE, "majCommandeResponse");
    private static final QName _ProduitsStockVide_QNAME = new QName(NAME_SPACE, "produitsStockVide");
    private static final QName _GetProduitByIdResponse_QNAME = new QName(NAME_SPACE, "getProduitByIdResponse");
    private static final QName _CheckStock_QNAME = new QName(NAME_SPACE, "checkStock");
    private static final QName _GetListeCommande_QNAME = new QName(NAME_SPACE, "getListeCommande");
    private static final QName _AddCommandeResponse_QNAME = new QName(NAME_SPACE, "addCommandeResponse");
    private static final QName _GetAllProduit_QNAME = new QName(NAME_SPACE, "getAllProduit");
    private static final QName _GetAllProduitResponse_QNAME = new QName(NAME_SPACE, "getAllProduitResponse");
    private static final QName _GetProduitById_QNAME = new QName(NAME_SPACE, "getProduitById");
    private static final QName _AddLigneResponse_QNAME = new QName(NAME_SPACE, "addLigneResponse");
    private static final QName _UtilisateurDTO_QNAME = new QName(NAME_SPACE, "utilisateurDTO");
    private static final QName _MajCommande_QNAME = new QName(NAME_SPACE, "majCommande");
    private static final QName _TrouverUtilisateur_QNAME = new QName(NAME_SPACE, "trouverUtilisateur");
    private static final QName _GetLigneByCommande_QNAME = new QName(NAME_SPACE, "getLigneByCommande");
    private static final QName _DecrementeStock_QNAME = new QName(NAME_SPACE, "decrementeStock");
    private static final QName _CheckStockResponse_QNAME = new QName(NAME_SPACE, "checkStockResponse");
    private static final QName _AddCommande_QNAME = new QName(NAME_SPACE, "addCommande");
    private static final QName _TrouverUtilisateurResponse_QNAME = new QName(NAME_SPACE, "trouverUtilisateurResponse");
    private static final QName _LigneCommandeDTO_QNAME = new QName(NAME_SPACE, "ligneCommandeDTO");
    private static final QName _GetLigneByCommandeResponse_QNAME = new QName(NAME_SPACE, "getLigneByCommandeResponse");
    private static final QName _AddLigne_QNAME = new QName(NAME_SPACE, "addLigne");
    private static final QName _ProduitDTO_QNAME = new QName(NAME_SPACE, "produitDTO");
    private static final QName _DecrementeStockResponse_QNAME = new QName(NAME_SPACE, "decrementeStockResponse");
    private static final QName _AjoutStock_QNAME = new QName(NAME_SPACE, "ajoutStock");
    private static final QName _AjoutStockResponse_QNAME = new QName(NAME_SPACE, "ajoutStockResponse");
    private static final QName _ProduitsStockVideResponse_QNAME = new QName(NAME_SPACE, "produitsStockVideResponse");
    private static final QName _CommandeDTO_QNAME = new QName(NAME_SPACE, "commandeDTO");

    /**
     * Create a new ObjectFactory that can be used to create new instances of
     * schema derived classes for package: fr.afcepf.al30.stock.airbrass
     *
     */
    public ObjectFactory() {
        //Empty constructor
    }

    /**
     * Create an instance of {@link AddLigneResponse }
     *
     */
    public AddLigneResponse createAddLigneResponse() {
        return new AddLigneResponse();
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
     * Create an instance of {@link CheckStock }
     *
     */
    public CheckStock createCheckStock() {
        return new CheckStock();
    }

    /**
     * Create an instance of {@link GetListeCommande }
     *
     */
    public GetListeCommande createGetListeCommande() {
        return new GetListeCommande();
    }

    /**
     * Create an instance of {@link DecrementeStockResponse }
     *
     */
    public DecrementeStockResponse createDecrementeStockResponse() {
        return new DecrementeStockResponse();
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
     * Create an instance of {@link CheckStockResponse }
     *
     */
    public CheckStockResponse createCheckStockResponse() {
        return new CheckStockResponse();
    }

    /**
     * Create an instance of {@link GetLigneByCommande }
     *
     */
    public GetLigneByCommande createGetLigneByCommande() {
        return new GetLigneByCommande();
    }

    /**
     * Create an instance of {@link DecrementeStock }
     *
     */
    public DecrementeStock createDecrementeStock() {
        return new DecrementeStock();
    }

    /**
     * Create an instance of {@link AddCommande }
     *
     */
    public AddCommande createAddCommande() {
        return new AddCommande();
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
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link FournisseurDTO }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "fournisseurDTO")
    public JAXBElement<FournisseurDTO> createFournisseurDTO(FournisseurDTO value) {
        return new JAXBElement<>(_FournisseurDTO_QNAME, FournisseurDTO.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link GetListeCommandeResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getListeCommandeResponse")
    public JAXBElement<GetListeCommandeResponse> createGetListeCommandeResponse(GetListeCommandeResponse value) {
        return new JAXBElement<>(_GetListeCommandeResponse_QNAME, GetListeCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link MajCommandeResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "majCommandeResponse")
    public JAXBElement<MajCommandeResponse> createMajCommandeResponse(MajCommandeResponse value) {
        return new JAXBElement<>(_MajCommandeResponse_QNAME, MajCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link ProduitsStockVide }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "produitsStockVide")
    public JAXBElement<ProduitsStockVide> createProduitsStockVide(ProduitsStockVide value) {
        return new JAXBElement<>(_ProduitsStockVide_QNAME, ProduitsStockVide.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link GetProduitByIdResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getProduitByIdResponse")
    public JAXBElement<GetProduitByIdResponse> createGetProduitByIdResponse(GetProduitByIdResponse value) {
        return new JAXBElement<>(_GetProduitByIdResponse_QNAME, GetProduitByIdResponse.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link CheckStock }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "checkStock")
    public JAXBElement<CheckStock> createCheckStock(CheckStock value) {
        return new JAXBElement<>(_CheckStock_QNAME, CheckStock.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link GetListeCommande }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getListeCommande")
    public JAXBElement<GetListeCommande> createGetListeCommande(GetListeCommande value) {
        return new JAXBElement<>(_GetListeCommande_QNAME, GetListeCommande.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link AddCommandeResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "addCommandeResponse")
    public JAXBElement<AddCommandeResponse> createAddCommandeResponse(AddCommandeResponse value) {
        return new JAXBElement<>(_AddCommandeResponse_QNAME, AddCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link GetAllProduit }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getAllProduit")
    public JAXBElement<GetAllProduit> createGetAllProduit(GetAllProduit value) {
        return new JAXBElement<>(_GetAllProduit_QNAME, GetAllProduit.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link GetAllProduitResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getAllProduitResponse")
    public JAXBElement<GetAllProduitResponse> createGetAllProduitResponse(GetAllProduitResponse value) {
        return new JAXBElement<>(_GetAllProduitResponse_QNAME, GetAllProduitResponse.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link GetProduitById }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getProduitById")
    public JAXBElement<GetProduitById> createGetProduitById(GetProduitById value) {
        return new JAXBElement<>(_GetProduitById_QNAME, GetProduitById.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link AddLigneResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "addLigneResponse")
    public JAXBElement<AddLigneResponse> createAddLigneResponse(AddLigneResponse value) {
        return new JAXBElement<>(_AddLigneResponse_QNAME, AddLigneResponse.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link UtilisateurDTO }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "utilisateurDTO")
    public JAXBElement<UtilisateurDTO> createUtilisateurDTO(UtilisateurDTO value) {
        return new JAXBElement<>(_UtilisateurDTO_QNAME, UtilisateurDTO.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link MajCommande }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "majCommande")
    public JAXBElement<MajCommande> createMajCommande(MajCommande value) {
        return new JAXBElement<>(_MajCommande_QNAME, MajCommande.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link TrouverUtilisateur }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "trouverUtilisateur")
    public JAXBElement<TrouverUtilisateur> createTrouverUtilisateur(TrouverUtilisateur value) {
        return new JAXBElement<>(_TrouverUtilisateur_QNAME, TrouverUtilisateur.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link GetLigneByCommande }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getLigneByCommande")
    public JAXBElement<GetLigneByCommande> createGetLigneByCommande(GetLigneByCommande value) {
        return new JAXBElement<>(_GetLigneByCommande_QNAME, GetLigneByCommande.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link DecrementeStock }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "decrementeStock")
    public JAXBElement<DecrementeStock> createDecrementeStock(DecrementeStock value) {
        return new JAXBElement<>(_DecrementeStock_QNAME, DecrementeStock.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link CheckStockResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "checkStockResponse")
    public JAXBElement<CheckStockResponse> createCheckStockResponse(CheckStockResponse value) {
        return new JAXBElement<>(_CheckStockResponse_QNAME, CheckStockResponse.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link AddCommande }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "addCommande")
    public JAXBElement<AddCommande> createAddCommande(AddCommande value) {
        return new JAXBElement<>(_AddCommande_QNAME, AddCommande.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link TrouverUtilisateurResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "trouverUtilisateurResponse")
    public JAXBElement<TrouverUtilisateurResponse> createTrouverUtilisateurResponse(TrouverUtilisateurResponse value) {
        return new JAXBElement<>(_TrouverUtilisateurResponse_QNAME, TrouverUtilisateurResponse.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link LigneCommandeDTO }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "ligneCommandeDTO")
    public JAXBElement<LigneCommandeDTO> createLigneCommandeDTO(LigneCommandeDTO value) {
        return new JAXBElement<>(_LigneCommandeDTO_QNAME, LigneCommandeDTO.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link GetLigneByCommandeResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "getLigneByCommandeResponse")
    public JAXBElement<GetLigneByCommandeResponse> createGetLigneByCommandeResponse(GetLigneByCommandeResponse value) {
        return new JAXBElement<>(_GetLigneByCommandeResponse_QNAME, GetLigneByCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link AddLigne }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "addLigne")
    public JAXBElement<AddLigne> createAddLigne(AddLigne value) {
        return new JAXBElement<>(_AddLigne_QNAME, AddLigne.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link ProduitDTO }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "produitDTO")
    public JAXBElement<ProduitDTO> createProduitDTO(ProduitDTO value) {
        return new JAXBElement<>(_ProduitDTO_QNAME, ProduitDTO.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link DecrementeStockResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "decrementeStockResponse")
    public JAXBElement<DecrementeStockResponse> createDecrementeStockResponse(DecrementeStockResponse value) {
        return new JAXBElement<>(_DecrementeStockResponse_QNAME, DecrementeStockResponse.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link AjoutStock }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "ajoutStock")
    public JAXBElement<AjoutStock> createAjoutStock(AjoutStock value) {
        return new JAXBElement<>(_AjoutStock_QNAME, AjoutStock.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link AjoutStockResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "ajoutStockResponse")
    public JAXBElement<AjoutStockResponse> createAjoutStockResponse(AjoutStockResponse value) {
        return new JAXBElement<>(_AjoutStockResponse_QNAME, AjoutStockResponse.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link ProduitsStockVideResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "produitsStockVideResponse")
    public JAXBElement<ProduitsStockVideResponse> createProduitsStockVideResponse(ProduitsStockVideResponse value) {
        return new JAXBElement<>(_ProduitsStockVideResponse_QNAME, ProduitsStockVideResponse.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link CommandeDTO }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://airbrass.stock.al30.afcepf.fr", name = "commandeDTO")
    public JAXBElement<CommandeDTO> createCommandeDTO(CommandeDTO value) {
        return new JAXBElement<>(_CommandeDTO_QNAME, CommandeDTO.class, null, value);
    }

}
