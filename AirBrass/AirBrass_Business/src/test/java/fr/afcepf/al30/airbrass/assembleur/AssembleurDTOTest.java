package fr.afcepf.al30.airbrass.assembleur;

import fr.afcepf.al30.airbrass.dto.DTOAdresse;
import fr.afcepf.al30.airbrass.dto.DTOAvisClient;
import fr.afcepf.al30.airbrass.dto.DTOCB;
import fr.afcepf.al30.airbrass.dto.DTOCommande;
import fr.afcepf.al30.airbrass.dto.DTOLigneCommande;
import fr.afcepf.al30.airbrass.dto.DTOMarque;
import fr.afcepf.al30.airbrass.dto.DTOPays;
import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.dto.DTOProduit;
import fr.afcepf.al30.airbrass.dto.DTOPromotion;
import fr.afcepf.al30.airbrass.dto.DTOSpecialisationProduit;
import fr.afcepf.al30.airbrass.dto.DTOVille;
import fr.afcepf.al30.airbrass.dto.DTOVues;
import fr.afcepf.al30.airbrass.entities.Adresse;
import fr.afcepf.al30.airbrass.entities.AvisClient;
import fr.afcepf.al30.airbrass.entities.CB;
import fr.afcepf.al30.airbrass.entities.Commande;
import fr.afcepf.al30.airbrass.entities.LigneCommande;
import fr.afcepf.al30.airbrass.entities.Marque;
import fr.afcepf.al30.airbrass.entities.Pays;
import fr.afcepf.al30.airbrass.entities.Personne;
import fr.afcepf.al30.airbrass.entities.Produit;
import fr.afcepf.al30.airbrass.entities.Promotion;
import fr.afcepf.al30.airbrass.entities.SpecialisationProduit;
import fr.afcepf.al30.airbrass.entities.Ville;
import fr.afcepf.al30.airbrass.entities.Vues;
import fr.afcepf.al30.airbrass.enums.DTOEnumPromotion;
import fr.afcepf.al30.airbrass.enums.DTOTypeProduit;
import fr.afcepf.al30.airbrass.enums.EnumPromotion;
import fr.afcepf.al30.airbrass.enums.TypeProduit;
import fr.afcepf.al30.airbrass.exceptions.AssembleurException;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Max Michel
 */
public class AssembleurDTOTest {

    private static Logger log = Logger.getLogger(AssembleurDTOTest.class);
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    private static Pays paysEntityToDto_Adresse;
    private static Ville villeEntityToDto_Adresse;
    private static Adresse adresseEntityToDto_Adresse;
    private static DTOPays dtoPaysEntityToDto_Adresse;
    private static DTOVille dtoVilleEntityToDto_Adresse;
    private static DTOAdresse expResult_AvisClientEntityToDto_Adresse;

    private static DTOAdresse dtoAdresseWithoutVille;
    private static Adresse adresseWithoutVille;

    private static DTOVille dtoVilleWithoutPays;
    private static Ville villeWithoutPays;

    private static Marque marque_AvisClient;
    private static SpecialisationProduit specialisationProduit_AvisClient;
    private static Produit produit_AvisClient;
    private static Personne personne_AvisClient;
    private static AvisClient avis_AvisClient;
    private static DTOMarque marqueDto_AvisClient;
    private static DTOSpecialisationProduit specialisationProduitDto_AvisClient;
    private static DTOProduit produitDto_AvisClient;
    private static DTOPersonne personneDto_AvisClient;
    private static DTOAvisClient expResult_AvisClient;

    private static CB EntityToDTO_CB;
    private static DTOCB expResult_CB;

    private static Commande commande;
    private static LigneCommande ligne_LignCommande;
    private static DTOCommande commandeDto;
    private static DTOLigneCommande expResult_LigneCommande;

    private static DTOPersonne dtoPersonneSansAdresse;

    private static Personne personneSansAdresse;

    private static Adresse adresseNull;
    private static DTOAdresse dtoAdresseNull;
    private static AvisClient avisClientNull;
    private static DTOAvisClient dtoAvisClientNull;
    private static CB cbNull;
    private static DTOCB dtocbNull;
    private static Commande commandeNull;
    private static DTOCommande dTOCommandeNull;
    private static LigneCommande ligneCommandeNull;
    private static DTOLigneCommande dTOLigneCommandeNull;
    private static Marque marqueNull;
    private static DTOMarque dTOMarqueNull;
    private static Pays paysNull;
    private static DTOPays dtoPaysNull;
    private static Personne personneNull;
    private static DTOPersonne dtoPersonneNull;
    private static Produit produitNull;
    private static DTOProduit dtoProduitNull;
    private static SpecialisationProduit specialisationProduitNull;
    private static DTOSpecialisationProduit dTOSpecialisationProduitNull;
    private static Ville villeNull;
    private static DTOVille dtoVilleNull;

    private static AvisClient avisSansPersonneSansProduit;
    private static DTOAvisClient dtoAvisSansPersonneSansProduit;

    private static CB cbSansPersonne;
    private static DTOCB dtoCbSansPersonne;

    private static LigneCommande ligneCommandeSansProduit;
    private static DTOLigneCommande dtoLigneCommandeSansProduit;

    private static Produit produitSansMarqueSansSpecialisation;
    private static DTOProduit dtoProduitSansMarqueSansSpecialisation;

    private static Produit produitSansPromo;
    private static DTOProduit dtoProduitSansPromotion;

    private static Promotion promotion;
    private static DTOPromotion dtoPromotion;

    private static Promotion promotionNull;
    private static DTOPromotion dtoPromotionNull;

    private static Vues vues;
    private static DTOVues dtoVues;

    private static Vues vuesProduitNull;
    private static DTOVues dtoVuesProduitNull;

    private static Vues vuesNull;
    private static DTOVues dtoVuesNull;

    @BeforeClass
    public static void init() throws ParseException {
        init_null();
        init_sansRelation();
    }

    public static void init_sansRelation() throws ParseException {
        avisSansPersonneSansProduit = new AvisClient(12, 4, "commentaire", null, null);
        dtoAvisSansPersonneSansProduit = new DTOAvisClient(4, "commentaire", null, null);

        cbSansPersonne = new CB(4, "identite", "intitule", "numero", SDF.parse("24/12/2019"), null);
        dtoCbSansPersonne = new DTOCB("identite", "intitule", "numero", SDF.parse("24/12/2019"), 123, null);
        ligneCommandeSansProduit = new LigneCommande(6, 2, null, commande);
        dtoLigneCommandeSansProduit = new DTOLigneCommande(2, null, commandeDto);
        produitSansMarqueSansSpecialisation = new Produit(12, "intitule", "description", 12d, "photo", "reference", null, null, null, null);
        dtoProduitSansMarqueSansSpecialisation = new DTOProduit("intitule", "description", 12d, "photo", "reference", 254);

        vues = new Vues();
        vues.setDateClique(SDF.parse("21/05/2017"));
        vues.setId(1);
        vues.setProduit(produitSansMarqueSansSpecialisation);

        dtoVues = new DTOVues();
        dtoVues.setDateClique(SDF.parse("21/05/2017"));
        dtoVues.setId(1);
        dtoVues.setDtoProduit(dtoProduitSansMarqueSansSpecialisation);

        vuesProduitNull = new Vues(vues.getId(), vues.getDateClique(), null);
        dtoVuesProduitNull = new DTOVues(dtoVues.getDateClique(), null);
        dtoVuesProduitNull.setId(1);
    }

    public static void init_null() {
        adresseNull = null;
        dtoAdresseNull = null;
        avisClientNull = null;
        dtoAvisClientNull = null;
        cbNull = null;
        dtocbNull = null;
        commandeNull = null;
        dTOCommandeNull = null;
        ligneCommandeNull = null;
        dTOLigneCommandeNull = null;
        marqueNull = null;
        dTOMarqueNull = null;
        paysNull = null;
        dtoPaysNull = null;
        personneNull = null;
        dtoPersonneNull = null;
        produitNull = null;
        dtoProduitNull = null;
        specialisationProduitNull = null;
        dTOSpecialisationProduitNull = null;
        villeNull = null;
        dtoVilleNull = null;
        promotionNull = null;
        dtoPromotionNull = null;
        vuesNull = null;
        dtoVuesNull = null;
    }

    public static void init_Adresse() {
        paysEntityToDto_Adresse = new Pays();
        paysEntityToDto_Adresse.setId(1);
        paysEntityToDto_Adresse.setNom("France");
        paysEntityToDto_Adresse.setVilles(new ArrayList<>());
        paysEntityToDto_Adresse = new Pays(paysEntityToDto_Adresse.getId(), paysEntityToDto_Adresse.getNom(), paysEntityToDto_Adresse.getVilles());
        villeEntityToDto_Adresse = new Ville();
        villeEntityToDto_Adresse.setId(1);
        villeEntityToDto_Adresse.setNom("Aubervilliers");
        villeEntityToDto_Adresse.setCodePostal("93300");
        villeEntityToDto_Adresse.setPays(paysEntityToDto_Adresse);
        adresseEntityToDto_Adresse = new Adresse();
        adresseEntityToDto_Adresse.setId(1);
        adresseEntityToDto_Adresse.setNumero(60);
        adresseEntityToDto_Adresse.setRue("Sadi Carnot");
        adresseEntityToDto_Adresse.setVille(villeEntityToDto_Adresse);
        dtoPaysEntityToDto_Adresse = new DTOPays();
        dtoPaysEntityToDto_Adresse.setId(1);
        dtoPaysEntityToDto_Adresse.setNom("France");
        dtoVilleEntityToDto_Adresse = new DTOVille();
        dtoVilleEntityToDto_Adresse.setId(1);
        dtoVilleEntityToDto_Adresse.setNom("Aubervilliers");
        dtoVilleEntityToDto_Adresse.setCodePostal("93300");
        dtoVilleEntityToDto_Adresse.setDtoPays(dtoPaysEntityToDto_Adresse);
        expResult_AvisClientEntityToDto_Adresse = new DTOAdresse();
        expResult_AvisClientEntityToDto_Adresse.setId(1);
        expResult_AvisClientEntityToDto_Adresse.setNumero(60);
        expResult_AvisClientEntityToDto_Adresse.setRue("Sadi Carnot");
        expResult_AvisClientEntityToDto_Adresse.setDtoVille(dtoVilleEntityToDto_Adresse);

        dtoAdresseWithoutVille = new DTOAdresse(60, "Sadi Carnot", "", null);
        adresseWithoutVille = new Adresse(12, 60, "Sadi Carnot", "", null, null);

        dtoVilleWithoutPays = new DTOVille("Aubervilliers", "93300", null);
        villeWithoutPays = new Ville(12, "Aubervilliers", "93300", null, null);

    }

    public static void init_AvisClient() throws ParseException {
        init_Adresse();
        marque_AvisClient = new Marque();
        marque_AvisClient.setId(1);
        marque_AvisClient.setIntitule("intitule");
        marque_AvisClient.setLogo("logo");
        marque_AvisClient.setProduits(new ArrayList<>());
        marque_AvisClient = new Marque(marque_AvisClient.getId(), marque_AvisClient.getIntitule(), marque_AvisClient.getLogo(), marque_AvisClient.getProduits());
        specialisationProduit_AvisClient = new SpecialisationProduit();
        specialisationProduit_AvisClient.setId(1);
        specialisationProduit_AvisClient.setIntitule("intitule");
        specialisationProduit_AvisClient.setTypeProduit(TypeProduit.GUITARE);
        specialisationProduit_AvisClient.setProduits(new ArrayList<>());
        specialisationProduit_AvisClient = new SpecialisationProduit(specialisationProduit_AvisClient.getId(), specialisationProduit_AvisClient.getIntitule(), specialisationProduit_AvisClient.getTypeProduit(), specialisationProduit_AvisClient.getProduits());
        promotion = new Promotion();
        promotion.setId(1);
        promotion.setDateDebut(SDF.parse("21/05/2017"));
        promotion.setDateFin(SDF.parse("21/05/2017"));
        promotion.setProduits(new ArrayList<>());
        promotion.getProduits().add(produitNull);
        promotion = new Promotion(promotion.getId(), promotion.getDateDebut(), promotion.getDateFin(), promotion.getProduits());
        promotion.setEnumPromo(EnumPromotion.QUARANTE);
        produit_AvisClient = new Produit();
        produit_AvisClient.setId(1);
        produit_AvisClient.setIntitule("intitule");
        produit_AvisClient.setDescription("description");
        produit_AvisClient.setMarque(marque_AvisClient);
        produit_AvisClient.setPhoto("photo");
        produit_AvisClient.setPrix(12.0);
        produit_AvisClient.setReference("reference");
        produit_AvisClient.setSpecialisationProduit(specialisationProduit_AvisClient);
        produit_AvisClient.setPromotion(promotion);
        personne_AvisClient = new Personne();
        personne_AvisClient.setId(1);
        personne_AvisClient.setNom("Michel");
        personne_AvisClient.setPrenom("Max");
        personne_AvisClient.setAdresseMail("mao-mitch@hotmail.fr");
        personne_AvisClient.setDateNaissance(SDF.parse("17/04/1991"));
        personne_AvisClient.setPassword("Azerty12");
        personne_AvisClient.setStatut("statut");
        personne_AvisClient.setTelephone("0649388804");
        personne_AvisClient.setAdresses(new ArrayList<>());
        personne_AvisClient.getAdresses().add(adresseEntityToDto_Adresse);
        avis_AvisClient = new AvisClient();
        avis_AvisClient.setId(1);
        avis_AvisClient.setNote(5);
        avis_AvisClient.setProduit(produit_AvisClient);
        avis_AvisClient.setPersonne(personne_AvisClient);
        avis_AvisClient.setCommentaire("commentaire");
        marqueDto_AvisClient = new DTOMarque();
        marqueDto_AvisClient.setId(1);
        marqueDto_AvisClient.setIntitule("intitule");
        marqueDto_AvisClient.setLogo("logo");
        specialisationProduitDto_AvisClient = new DTOSpecialisationProduit();
        specialisationProduitDto_AvisClient.setId(1);
        specialisationProduitDto_AvisClient.setIntitule("intitule");
        specialisationProduitDto_AvisClient.setDtoTypeProduit(DTOTypeProduit.fromValue("Guitare"));
        dtoPromotion = new DTOPromotion();
        dtoPromotion.setId(1);
        dtoPromotion.setDateDebut(SDF.parse("21/05/2017"));
        dtoPromotion.setDateFin(SDF.parse("21/05/2017"));
        dtoPromotion = new DTOPromotion(dtoPromotion.getDateDebut(), dtoPromotion.getDateFin());
        dtoPromotion.setId(1);
        dtoPromotion.setDtoEnumPromotion(DTOEnumPromotion.QUARANTE);
        produitDto_AvisClient = new DTOProduit();
        produitDto_AvisClient.setId(1);
        produitDto_AvisClient.setIntitule("intitule");
        produitDto_AvisClient.setDescription("description");
        produitDto_AvisClient.setDtoMarque(marqueDto_AvisClient);
        produitDto_AvisClient.setPhoto("photo");
        produitDto_AvisClient.setPrix(12.0);
        produitDto_AvisClient.setReference("reference");
        produitDto_AvisClient.setDtoSpecialisationProduit(specialisationProduitDto_AvisClient);
        produitDto_AvisClient.setDtoPromotion(dtoPromotion);
        personneDto_AvisClient = new DTOPersonne();
        personneDto_AvisClient.setId(1);
        personneDto_AvisClient.setNom("Michel");
        personneDto_AvisClient.setPrenom("Max");
        personneDto_AvisClient.setAdresseMail("mao-mitch@hotmail.fr");
        personneDto_AvisClient.setDateNaissance(SDF.parse("17/04/1991"));
        personneDto_AvisClient.setPassword("Azerty12");
        personneDto_AvisClient.setStatut("statut");
        personneDto_AvisClient.setTelephone("0649388804");
        personneDto_AvisClient.setDtoAdresses(new ArrayList<>());
        personneDto_AvisClient.getDtoAdresses().add(expResult_AvisClientEntityToDto_Adresse);
        expResult_AvisClient = new DTOAvisClient();
        expResult_AvisClient.setId(1);
        expResult_AvisClient.setNote(5);
        expResult_AvisClient.setDtoProduit(produitDto_AvisClient);
        expResult_AvisClient.setDtoPersonne(personneDto_AvisClient);
        expResult_AvisClient.setCommentaire("commentaire");

        dtoPersonneSansAdresse = new DTOPersonne("Michel", "Max", SDF.parse("17/04/1991"), "mao-mitch@hotmail.fr", "0649388804", "Azerty12", null);
        personneSansAdresse = new Personne(12, "Michel", "Max", SDF.parse("17/04/1991"), "mao-mitch@hotmail.fr", "0649388804", "Azerty12", null, null, null, null);

        produitSansPromo = new Produit(produit_AvisClient.getId(), produit_AvisClient.getIntitule(), produit_AvisClient.getDescription(), produit_AvisClient.getPrix(), produit_AvisClient.getPhoto(), produit_AvisClient.getReference(), produit_AvisClient.getSpecialisationProduit(), produit_AvisClient.getMarque(), produit_AvisClient.getLigneCommandes(), produit_AvisClient.getAvisClients());
        produitSansPromo.setPromotion(promotionNull);

        dtoProduitSansPromotion = new DTOProduit(produitDto_AvisClient.getIntitule(), produitDto_AvisClient.getDescription(), produitDto_AvisClient.getPrix(), produitDto_AvisClient.getPhoto(), produitDto_AvisClient.getReference(), produitDto_AvisClient.getStock());
        dtoProduitSansPromotion.setId(1);
        dtoProduitSansPromotion.setDtoPromotion(dtoPromotionNull);
    }

    public static void init_CB() throws ParseException {
        EntityToDTO_CB = new CB();
        EntityToDTO_CB.setDateExpiration(SDF.parse("22/07/2018"));
        EntityToDTO_CB.setId(1);
        EntityToDTO_CB.setIdentite("identite");
        EntityToDTO_CB.setIntitule("intitule");
        EntityToDTO_CB.setNumero("numero");
        EntityToDTO_CB.setPersonne(personne_AvisClient);
        expResult_CB = new DTOCB();
        expResult_CB.setCle(32);
        expResult_CB.setDateExpiration(SDF.parse("22/07/2018"));
        expResult_CB.setId(1);
        expResult_CB.setIdentite("identite");
        expResult_CB.setIntitule("intitule");
        expResult_CB.setNumero("numero");
        expResult_CB.setDtoPersonne(personneDto_AvisClient);
    }

    public static void init_LigneCommande() throws ParseException {
        init_AvisClient();
        commande = new Commande();
        commande.setDate(SDF.parse("23/05/2017"));
        commande.setId(1);
        commande.setNumero("numero");
        commande.setPersonne(personne_AvisClient);
        commande.setStatut("statut");
        ligne_LignCommande = new LigneCommande();
        ligne_LignCommande.setId(1);
        ligne_LignCommande.setQuantite(45);
        ligne_LignCommande.setProduit(produit_AvisClient);
        ligne_LignCommande.setCommande(commande);
        List<LigneCommande> listLigneCommande = new ArrayList<>();
        listLigneCommande.add(ligne_LignCommande);
        commande.setLigneCommandes(listLigneCommande);
        commande = new Commande(commande.getId(), commande.getNumero(), commande.getDate(), commande.getStatut(), commande.getPersonne(), commande.getLigneCommandes());
        commandeDto = new DTOCommande();
        commandeDto.setDate(SDF.parse("23/05/2017"));
        commandeDto.setId(1);
        commandeDto.setNumero("numero");
        commandeDto.setDtoPersonne(personneDto_AvisClient);
        commandeDto.setStatut("statut");
        expResult_LigneCommande = new DTOLigneCommande();
        expResult_LigneCommande.setId(1);
        expResult_LigneCommande.setQuantite(45);
        expResult_LigneCommande.setDtoProduit(produitDto_AvisClient);
        expResult_LigneCommande.setDtoCommande(commandeDto);
        List<DTOLigneCommande> listDTOLigneCommande = new ArrayList<>();
        listDTOLigneCommande.add(expResult_LigneCommande);
        commandeDto.setDtoLigneCommandes(listDTOLigneCommande);
    }

    @Test
    public void testEntityToDTO_Adresse() throws Exception {
        log.info("entityToDTO_Adresse");
        init_Adresse();

        DTOAdresse result = AssembleurDTO.entityToDTO(adresseEntityToDto_Adresse);
        Assert.assertNotNull(result);
        Assert.assertEquals(expResult_AvisClientEntityToDto_Adresse.getId(), result.getId());
        Assert.assertEquals(expResult_AvisClientEntityToDto_Adresse.getNumero(), result.getNumero());
        Assert.assertEquals(expResult_AvisClientEntityToDto_Adresse.getRue(), result.getRue());
        Assert.assertEquals(expResult_AvisClientEntityToDto_Adresse.getDtoVille().getId(), result.getDtoVille().getId());
        Assert.assertEquals(expResult_AvisClientEntityToDto_Adresse.getDtoVille().getNom(), result.getDtoVille().getNom());
        Assert.assertEquals(expResult_AvisClientEntityToDto_Adresse.getDtoVille().getCodePostal(), result.getDtoVille().getCodePostal());
        Assert.assertEquals(expResult_AvisClientEntityToDto_Adresse.getDtoVille().getDtoPays().getId(), result.getDtoVille().getDtoPays().getId());
        Assert.assertEquals(expResult_AvisClientEntityToDto_Adresse.getDtoVille().getDtoPays().getNom(), result.getDtoVille().getDtoPays().getNom());

    }

    @Test
    public void testEntityToDTO_AdresseWithoutVille() throws Exception {
        log.info("entityToDTO_Adresse");
        init_Adresse();

        DTOAdresse result = AssembleurDTO.entityToDTO(adresseWithoutVille);
        Assert.assertNotNull(result);
        Assert.assertEquals(dtoAdresseWithoutVille.getNumero(), result.getNumero());
        Assert.assertEquals(dtoAdresseWithoutVille.getRue(), result.getRue());
        Assert.assertEquals(dtoAdresseWithoutVille.getDtoVille(), result.getDtoVille());

    }

    @Test
    public void testEntityToDTO_VilleWithoutPays() throws Exception {
        log.info("entityToDTO_Adresse");
        init_Adresse();

        DTOVille result = AssembleurDTO.entityToDTO(villeWithoutPays);
        Assert.assertNotNull(result);
        Assert.assertEquals(dtoVilleWithoutPays.getNom(), result.getNom());
        Assert.assertEquals(dtoVilleWithoutPays.getCodePostal(), result.getCodePostal());
        Assert.assertEquals(dtoVilleWithoutPays.getDtoPays(), result.getDtoPays());

    }

    /**
     * Test of dtoToEntity method, of class AssembleurDTO.
     */
    @Test
    public void testDtoToEntity_DTOAdresse() throws Exception {
        log.info("dtoToEntity_DTOAdresse");
        init_Adresse();

        Adresse result = AssembleurDTO.dtoToEntity(expResult_AvisClientEntityToDto_Adresse);
        Assert.assertNotNull(result);
        Assert.assertEquals(adresseEntityToDto_Adresse.getId(), result.getId());
        Assert.assertEquals(adresseEntityToDto_Adresse.getNumero(), result.getNumero());
        Assert.assertEquals(adresseEntityToDto_Adresse.getRue(), result.getRue());
        Assert.assertEquals(adresseEntityToDto_Adresse.getVille().getId(), result.getVille().getId());
        Assert.assertEquals(adresseEntityToDto_Adresse.getVille().getNom(), result.getVille().getNom());
        Assert.assertEquals(adresseEntityToDto_Adresse.getVille().getCodePostal(), result.getVille().getCodePostal());
        Assert.assertEquals(adresseEntityToDto_Adresse.getVille().getPays().getId(), result.getVille().getPays().getId());
        Assert.assertEquals(adresseEntityToDto_Adresse.getVille().getPays().getNom(), result.getVille().getPays().getNom());
    }

    @Test
    public void testDtoToEntity_DtoVilleWithoutPays() throws Exception {
        log.info("entityToDTO_Adresse");
        init_Adresse();

        Ville result = AssembleurDTO.dtoToEntity(dtoVilleWithoutPays);
        Assert.assertNotNull(result);
        Assert.assertEquals(villeWithoutPays.getNom(), result.getNom());
        Assert.assertEquals(villeWithoutPays.getCodePostal(), result.getCodePostal());
        Assert.assertEquals(villeWithoutPays.getPays(), result.getPays());

    }

    @Test
    public void testDtoToEntity_DTOAdresseWithoutVille() throws Exception {
        log.info("entityToDTO_Adresse");
        init_Adresse();

        Adresse result = AssembleurDTO.dtoToEntity(dtoAdresseWithoutVille);
        Assert.assertNotNull(result);
        Assert.assertEquals(adresseWithoutVille.getNumero(), result.getNumero());
        Assert.assertEquals(adresseWithoutVille.getRue(), result.getRue());
        Assert.assertEquals(adresseWithoutVille.getVille(), result.getVille());

    }

    /**
     * Test of entityToDTO method, of class AssembleurDTO.
     */
    @Test
    public void testEntityToDTO_AvisClient() throws Exception {
        log.info("entityToDTO_AvisClient");
        init_AvisClient();

        DTOAvisClient result = AssembleurDTO.entityToDTO(avis_AvisClient);
        Assert.assertEquals(expResult_AvisClient.getId(), result.getId());
        Assert.assertEquals(expResult_AvisClient.getCommentaire(), result.getCommentaire());
        Assert.assertEquals(expResult_AvisClient.getNote(), result.getNote());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getId(), result.getDtoPersonne().getId());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getNom(), result.getDtoPersonne().getNom());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getPrenom(), result.getDtoPersonne().getPrenom());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getAdresseMail(), result.getDtoPersonne().getAdresseMail());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getDateNaissance(), result.getDtoPersonne().getDateNaissance());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getPassword(), result.getDtoPersonne().getPassword());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getStatut(), result.getDtoPersonne().getStatut());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getTelephone(), result.getDtoPersonne().getTelephone());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getDtoAdresses().get(0).getId(), result.getDtoPersonne().getDtoAdresses().get(0).getId());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getDtoAdresses().get(0).getComplement(), result.getDtoPersonne().getDtoAdresses().get(0).getComplement());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getDtoAdresses().get(0).getNumero(), result.getDtoPersonne().getDtoAdresses().get(0).getNumero());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getDtoAdresses().get(0).getRue(), result.getDtoPersonne().getDtoAdresses().get(0).getRue());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getCodePostal(), result.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getCodePostal());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getId(), result.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getId());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getNom(), result.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getNom());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getDtoPays().getId(), result.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getDtoPays().getId());
        Assert.assertEquals(expResult_AvisClient.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getDtoPays().getNom(), result.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getDtoPays().getNom());
        Assert.assertEquals(expResult_AvisClient.getDtoProduit().getDescription(), result.getDtoProduit().getDescription());
        Assert.assertEquals(expResult_AvisClient.getDtoProduit().getId(), result.getDtoProduit().getId());
        Assert.assertEquals(expResult_AvisClient.getDtoProduit().getIntitule(), result.getDtoProduit().getIntitule());
        Assert.assertEquals(expResult_AvisClient.getDtoProduit().getPhoto(), result.getDtoProduit().getPhoto());
        Assert.assertEquals(expResult_AvisClient.getDtoProduit().getPrix(), result.getDtoProduit().getPrix());
        Assert.assertEquals(expResult_AvisClient.getDtoProduit().getReference(), result.getDtoProduit().getReference());
        Assert.assertEquals(expResult_AvisClient.getDtoProduit().getDtoMarque().getId(), result.getDtoProduit().getDtoMarque().getId());
        Assert.assertEquals(expResult_AvisClient.getDtoProduit().getDtoMarque().getIntitule(), result.getDtoProduit().getDtoMarque().getIntitule());
        Assert.assertEquals(expResult_AvisClient.getDtoProduit().getDtoMarque().getLogo(), result.getDtoProduit().getDtoMarque().getLogo());
        Assert.assertEquals(expResult_AvisClient.getDtoProduit().getDtoSpecialisationProduit().getId(), result.getDtoProduit().getDtoSpecialisationProduit().getId());
        Assert.assertEquals(expResult_AvisClient.getDtoProduit().getDtoSpecialisationProduit().getIntitule(), result.getDtoProduit().getDtoSpecialisationProduit().getIntitule());
        Assert.assertEquals(expResult_AvisClient.getDtoProduit().getDtoSpecialisationProduit().getDtoTypeProduit(), result.getDtoProduit().getDtoSpecialisationProduit().getDtoTypeProduit());
        Assert.assertEquals(expResult_AvisClient.getDtoProduit().getDtoPromotion().getId(), result.getDtoProduit().getDtoPromotion().getId());
        Assert.assertEquals(expResult_AvisClient.getDtoProduit().getDtoPromotion().getDateDebut(), result.getDtoProduit().getDtoPromotion().getDateDebut());
        Assert.assertEquals(expResult_AvisClient.getDtoProduit().getDtoPromotion().getDateFin(), result.getDtoProduit().getDtoPromotion().getDateFin());
        Assert.assertEquals(expResult_AvisClient.getDtoProduit().getDtoPromotion().getDtoEnumPromotion(), result.getDtoProduit().getDtoPromotion().getDtoEnumPromotion());
    }

    @Test
    public void testEntityToDTO_PersonneSansAdresse() throws Exception {
        log.info("entityToDTO_AvisClient");
        init_AvisClient();
        DTOPersonne result = AssembleurDTO.entityToDTO(personneSansAdresse);
        Assert.assertNotNull(result);
        Assert.assertEquals(dtoPersonneSansAdresse.getAdresseMail(), result.getAdresseMail());
        Assert.assertEquals(dtoPersonneSansAdresse.getDateNaissance(), result.getDateNaissance());
        Assert.assertEquals(dtoPersonneSansAdresse.getDtoAdresses(), result.getDtoAdresses());
        Assert.assertEquals(dtoPersonneSansAdresse.getNom(), result.getNom());
        Assert.assertEquals(dtoPersonneSansAdresse.getPassword(), result.getPassword());
        Assert.assertEquals(dtoPersonneSansAdresse.getPrenom(), result.getPrenom());
        Assert.assertEquals(dtoPersonneSansAdresse.getStatut(), result.getStatut());
        Assert.assertEquals(dtoPersonneSansAdresse.getTelephone(), result.getTelephone());
    }

    @Test
    public void testDtoToEntity_DtoPersonneSansAdresse() throws Exception {
        log.info("entityToDTO_AvisClient");
        init_AvisClient();
        Personne result = AssembleurDTO.dtoToEntity(dtoPersonneSansAdresse);
        Assert.assertNotNull(result);
        Assert.assertEquals(personneSansAdresse.getAdresseMail(), result.getAdresseMail());
        Assert.assertEquals(personneSansAdresse.getDateNaissance(), result.getDateNaissance());
        Assert.assertEquals(personneSansAdresse.getAdresses(), result.getAdresses());
        Assert.assertEquals(personneSansAdresse.getNom(), result.getNom());
        Assert.assertEquals(personneSansAdresse.getPassword(), result.getPassword());
        Assert.assertEquals(personneSansAdresse.getPrenom(), result.getPrenom());
        Assert.assertEquals(personneSansAdresse.getStatut(), result.getStatut());
        Assert.assertEquals(personneSansAdresse.getTelephone(), result.getTelephone());
    }

    @Test
    public void testDTOToEntity_DtoPersonneSansAdresse() throws Exception {
        log.info("entityToDTO_AvisClient");
        init_AvisClient();
    }

    /**
     * Test of dtoToEntity method, of class AssembleurDTO.
     */
    @Test
    public void testDtoToEntity_DTOAvisClient() throws Exception {
        log.info("dtoToEntity");
        init_AvisClient();

        AvisClient result = AssembleurDTO.dtoToEntity(expResult_AvisClient);
        Assert.assertEquals(avis_AvisClient.getId(), result.getId());
        Assert.assertEquals(avis_AvisClient.getCommentaire(), result.getCommentaire());
        Assert.assertEquals(avis_AvisClient.getNote(), result.getNote());
        Assert.assertEquals(avis_AvisClient.getPersonne().getId(), result.getPersonne().getId());
        Assert.assertEquals(avis_AvisClient.getPersonne().getNom(), result.getPersonne().getNom());
        Assert.assertEquals(avis_AvisClient.getPersonne().getPrenom(), result.getPersonne().getPrenom());
        Assert.assertEquals(avis_AvisClient.getPersonne().getAdresseMail(), result.getPersonne().getAdresseMail());
        Assert.assertEquals(avis_AvisClient.getPersonne().getDateNaissance(), result.getPersonne().getDateNaissance());
        Assert.assertEquals(avis_AvisClient.getPersonne().getPassword(), result.getPersonne().getPassword());
        Assert.assertEquals(avis_AvisClient.getPersonne().getStatut(), result.getPersonne().getStatut());
        Assert.assertEquals(avis_AvisClient.getPersonne().getTelephone(), result.getPersonne().getTelephone());
        Assert.assertEquals(avis_AvisClient.getPersonne().getAdresses().get(0).getId(), result.getPersonne().getAdresses().get(0).getId());
        Assert.assertEquals(avis_AvisClient.getPersonne().getAdresses().get(0).getComplement(), result.getPersonne().getAdresses().get(0).getComplement());
        Assert.assertEquals(avis_AvisClient.getPersonne().getAdresses().get(0).getNumero(), result.getPersonne().getAdresses().get(0).getNumero());
        Assert.assertEquals(avis_AvisClient.getPersonne().getAdresses().get(0).getRue(), result.getPersonne().getAdresses().get(0).getRue());
        Assert.assertEquals(avis_AvisClient.getPersonne().getAdresses().get(0).getVille().getCodePostal(), result.getPersonne().getAdresses().get(0).getVille().getCodePostal());
        Assert.assertEquals(avis_AvisClient.getPersonne().getAdresses().get(0).getVille().getId(), result.getPersonne().getAdresses().get(0).getVille().getId());
        Assert.assertEquals(avis_AvisClient.getPersonne().getAdresses().get(0).getVille().getNom(), result.getPersonne().getAdresses().get(0).getVille().getNom());
        Assert.assertEquals(avis_AvisClient.getPersonne().getAdresses().get(0).getVille().getPays().getId(), result.getPersonne().getAdresses().get(0).getVille().getPays().getId());
        Assert.assertEquals(avis_AvisClient.getPersonne().getAdresses().get(0).getVille().getPays().getNom(), result.getPersonne().getAdresses().get(0).getVille().getPays().getNom());
        Assert.assertEquals(avis_AvisClient.getProduit().getDescription(), result.getProduit().getDescription());
        Assert.assertEquals(avis_AvisClient.getProduit().getId(), result.getProduit().getId());
        Assert.assertEquals(avis_AvisClient.getProduit().getIntitule(), result.getProduit().getIntitule());
        Assert.assertEquals(avis_AvisClient.getProduit().getPhoto(), result.getProduit().getPhoto());
        Assert.assertEquals(avis_AvisClient.getProduit().getPrix(), result.getProduit().getPrix());
        Assert.assertEquals(avis_AvisClient.getProduit().getReference(), result.getProduit().getReference());
        Assert.assertEquals(avis_AvisClient.getProduit().getMarque().getId(), result.getProduit().getMarque().getId());
        Assert.assertEquals(avis_AvisClient.getProduit().getMarque().getIntitule(), result.getProduit().getMarque().getIntitule());
        Assert.assertEquals(avis_AvisClient.getProduit().getMarque().getLogo(), result.getProduit().getMarque().getLogo());
        Assert.assertEquals(avis_AvisClient.getProduit().getSpecialisationProduit().getId(), result.getProduit().getSpecialisationProduit().getId());
        Assert.assertEquals(avis_AvisClient.getProduit().getSpecialisationProduit().getIntitule(), result.getProduit().getSpecialisationProduit().getIntitule());
        Assert.assertEquals(avis_AvisClient.getProduit().getSpecialisationProduit().getTypeProduit(), result.getProduit().getSpecialisationProduit().getTypeProduit());
        Assert.assertEquals(avis_AvisClient.getProduit().getPromotion().getId(), result.getProduit().getPromotion().getId());
        Assert.assertEquals(avis_AvisClient.getProduit().getPromotion().getDateDebut(), result.getProduit().getPromotion().getDateDebut());
        Assert.assertEquals(avis_AvisClient.getProduit().getPromotion().getDateFin(), result.getProduit().getPromotion().getDateFin());
        Assert.assertEquals(avis_AvisClient.getProduit().getPromotion().getEnumPromo(), result.getProduit().getPromotion().getEnumPromo());
    }

    /**
     * Test of entityToDTO method, of class AssembleurDTO.
     */
    @Test
    public void testEntityToDTO_CB() throws Exception {
        log.info("entityToDTO_CB");
        init_CB();
        DTOCB result = AssembleurDTO.entityToDTO(EntityToDTO_CB);
        Assert.assertEquals(expResult_CB.getDateExpiration(), result.getDateExpiration());
        Assert.assertEquals(expResult_CB.getId(), result.getId());
        Assert.assertEquals(expResult_CB.getIdentite(), result.getIdentite());
        Assert.assertEquals(expResult_CB.getIntitule(), result.getIntitule());
        Assert.assertEquals(expResult_CB.getNumero(), result.getNumero());
        Assert.assertEquals(expResult_CB.getNumero(), result.getNumero());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getId(), result.getDtoPersonne().getId());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getNom(), result.getDtoPersonne().getNom());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getPrenom(), result.getDtoPersonne().getPrenom());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getAdresseMail(), result.getDtoPersonne().getAdresseMail());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getDateNaissance(), result.getDtoPersonne().getDateNaissance());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getPassword(), result.getDtoPersonne().getPassword());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getStatut(), result.getDtoPersonne().getStatut());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getTelephone(), result.getDtoPersonne().getTelephone());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getDtoAdresses().get(0).getId(), result.getDtoPersonne().getDtoAdresses().get(0).getId());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getDtoAdresses().get(0).getComplement(), result.getDtoPersonne().getDtoAdresses().get(0).getComplement());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getDtoAdresses().get(0).getNumero(), result.getDtoPersonne().getDtoAdresses().get(0).getNumero());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getDtoAdresses().get(0).getRue(), result.getDtoPersonne().getDtoAdresses().get(0).getRue());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getCodePostal(), result.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getCodePostal());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getId(), result.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getId());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getNom(), result.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getNom());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getDtoPays().getId(), result.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getDtoPays().getId());
        Assert.assertEquals(expResult_CB.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getDtoPays().getNom(), result.getDtoPersonne().getDtoAdresses().get(0).getDtoVille().getDtoPays().getNom());

    }

    /**
     * Test of dtoToEntity method, of class AssembleurDTO.
     */
    @Test
    public void testDtoToEntity_DTOCB() throws Exception {
        log.info("entityToDTO_CB");
        init_CB();
        CB result = AssembleurDTO.dtoToEntity(expResult_CB);
        Assert.assertEquals(EntityToDTO_CB.getDateExpiration(), result.getDateExpiration());
        Assert.assertEquals(EntityToDTO_CB.getId(), result.getId());
        Assert.assertEquals(EntityToDTO_CB.getIdentite(), result.getIdentite());
        Assert.assertEquals(EntityToDTO_CB.getIntitule(), result.getIntitule());
        Assert.assertEquals(EntityToDTO_CB.getNumero(), result.getNumero());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getId(), result.getPersonne().getId());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getNom(), result.getPersonne().getNom());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getPrenom(), result.getPersonne().getPrenom());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getAdresseMail(), result.getPersonne().getAdresseMail());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getDateNaissance(), result.getPersonne().getDateNaissance());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getPassword(), result.getPersonne().getPassword());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getStatut(), result.getPersonne().getStatut());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getTelephone(), result.getPersonne().getTelephone());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getAdresses().get(0).getId(), result.getPersonne().getAdresses().get(0).getId());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getAdresses().get(0).getComplement(), result.getPersonne().getAdresses().get(0).getComplement());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getAdresses().get(0).getNumero(), result.getPersonne().getAdresses().get(0).getNumero());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getAdresses().get(0).getRue(), result.getPersonne().getAdresses().get(0).getRue());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getAdresses().get(0).getVille().getCodePostal(), result.getPersonne().getAdresses().get(0).getVille().getCodePostal());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getAdresses().get(0).getVille().getId(), result.getPersonne().getAdresses().get(0).getVille().getId());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getAdresses().get(0).getVille().getNom(), result.getPersonne().getAdresses().get(0).getVille().getNom());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getAdresses().get(0).getVille().getPays().getId(), result.getPersonne().getAdresses().get(0).getVille().getPays().getId());
        Assert.assertEquals(EntityToDTO_CB.getPersonne().getAdresses().get(0).getVille().getPays().getNom(), result.getPersonne().getAdresses().get(0).getVille().getPays().getNom());

    }

    /**
     * Test of entityToDTO method, of class AssembleurDTO.
     */
    @Test
    public void testEntityToDTO_LigneCommande() throws Exception {
        log.info("entityToDTO");
        init_LigneCommande();
        DTOLigneCommande result = AssembleurDTO.entityToDTO(ligne_LignCommande);
        Assert.assertEquals(expResult_LigneCommande.getId(), result.getId());
        Assert.assertEquals(expResult_LigneCommande.getQuantite(), result.getQuantite());
        Assert.assertEquals(expResult_LigneCommande.getDtoProduit().getDescription(), result.getDtoProduit().getDescription());
        Assert.assertEquals(expResult_LigneCommande.getDtoProduit().getId(), result.getDtoProduit().getId());
        Assert.assertEquals(expResult_LigneCommande.getDtoProduit().getIntitule(), result.getDtoProduit().getIntitule());
        Assert.assertEquals(expResult_LigneCommande.getDtoProduit().getPhoto(), result.getDtoProduit().getPhoto());
        Assert.assertEquals(expResult_LigneCommande.getDtoProduit().getPrix(), result.getDtoProduit().getPrix());
        Assert.assertEquals(expResult_LigneCommande.getDtoProduit().getReference(), result.getDtoProduit().getReference());
        Assert.assertEquals(expResult_LigneCommande.getDtoProduit().getDtoMarque().getId(), result.getDtoProduit().getDtoMarque().getId());
        Assert.assertEquals(expResult_LigneCommande.getDtoProduit().getDtoMarque().getIntitule(), result.getDtoProduit().getDtoMarque().getIntitule());
        Assert.assertEquals(expResult_LigneCommande.getDtoProduit().getDtoMarque().getLogo(), result.getDtoProduit().getDtoMarque().getLogo());
        Assert.assertEquals(expResult_LigneCommande.getDtoProduit().getDtoSpecialisationProduit().getId(), result.getDtoProduit().getDtoSpecialisationProduit().getId());
        Assert.assertEquals(expResult_LigneCommande.getDtoProduit().getDtoSpecialisationProduit().getIntitule(), result.getDtoProduit().getDtoSpecialisationProduit().getIntitule());

    }

    /**
     * Test of dtoToEntity method, of class AssembleurDTO.
     */
    @Test
    public void testDtoToEntity_DTOLigneCommande() throws Exception {
        log.info("dtoToEntity");
        init_LigneCommande();
        LigneCommande result = AssembleurDTO.dtoToEntity(expResult_LigneCommande);
        Assert.assertEquals(ligne_LignCommande.getId(), result.getId());
        Assert.assertEquals(ligne_LignCommande.getQuantite(), result.getQuantite());
        Assert.assertEquals(ligne_LignCommande.getProduit().getDescription(), result.getProduit().getDescription());
        Assert.assertEquals(ligne_LignCommande.getProduit().getId(), result.getProduit().getId());
        Assert.assertEquals(ligne_LignCommande.getProduit().getIntitule(), result.getProduit().getIntitule());
        Assert.assertEquals(ligne_LignCommande.getProduit().getPhoto(), result.getProduit().getPhoto());
        Assert.assertEquals(ligne_LignCommande.getProduit().getPrix(), result.getProduit().getPrix());
        Assert.assertEquals(ligne_LignCommande.getProduit().getReference(), result.getProduit().getReference());
        Assert.assertEquals(ligne_LignCommande.getProduit().getMarque().getId(), result.getProduit().getMarque().getId());
        Assert.assertEquals(ligne_LignCommande.getProduit().getMarque().getIntitule(), result.getProduit().getMarque().getIntitule());
        Assert.assertEquals(ligne_LignCommande.getProduit().getMarque().getLogo(), result.getProduit().getMarque().getLogo());
        Assert.assertEquals(ligne_LignCommande.getProduit().getSpecialisationProduit().getId(), result.getProduit().getSpecialisationProduit().getId());
        Assert.assertEquals(ligne_LignCommande.getProduit().getSpecialisationProduit().getIntitule(), result.getProduit().getSpecialisationProduit().getIntitule());
    }

    @Test
    public void testAdresseNull() {
        try {
            DTOAdresse result = AssembleurDTO.entityToDTO(adresseNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.ENTITTE_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testDTOAdresseNull() {
        try {
            Adresse result = AssembleurDTO.dtoToEntity(dtoAdresseNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.DTO_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testAvisClientNull() {
        try {
            DTOAvisClient result = AssembleurDTO.entityToDTO(avisClientNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.ENTITTE_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testDTOAvisClientNull() {
        try {
            AvisClient result = AssembleurDTO.dtoToEntity(dtoAvisClientNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.DTO_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testCBNull() {
        try {
            DTOCB result = AssembleurDTO.entityToDTO(cbNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.ENTITTE_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testDTOCBNull() {
        try {
            CB result = AssembleurDTO.dtoToEntity(dtocbNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.DTO_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testCommandeNull() {
        try {
            DTOCommande result = AssembleurDTO.entityToDTO(commandeNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.ENTITTE_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testDTOCommandeNull() {
        try {
            Commande result = AssembleurDTO.dtoToEntity(dTOCommandeNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.DTO_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testLigneCommandeNull() {
        try {
            DTOLigneCommande result = AssembleurDTO.entityToDTO(ligneCommandeNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.ENTITTE_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testDTOLigneCommandeNull() {
        try {
            LigneCommande result = AssembleurDTO.dtoToEntity(dTOLigneCommandeNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.DTO_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testMarqueNull() {
        try {
            DTOMarque result = AssembleurDTO.entityToDTO(marqueNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.ENTITTE_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testDTOMarqueNull() {
        try {
            Marque result = AssembleurDTO.dtoToEntity(dTOMarqueNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.DTO_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testPaysNull() {
        try {
            DTOPays result = AssembleurDTO.entityToDTO(paysNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.ENTITTE_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testDTOPaysNull() {
        try {
            Pays result = AssembleurDTO.dtoToEntity(dtoPaysNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.DTO_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testPersonneNull() {
        try {
            DTOPersonne result = AssembleurDTO.entityToDTO(personneNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.ENTITTE_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testDTOPersonneNull() {
        try {
            Personne result = AssembleurDTO.dtoToEntity(dtoPersonneNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.DTO_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testProduitNull() {
        try {
            DTOProduit result = AssembleurDTO.entityToDTO(produitNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.ENTITTE_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testDTOProduitNull() {
        try {
            Produit result = AssembleurDTO.dtoToEntity(dtoProduitNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.DTO_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testSpecialisationProduitNull() {
        try {
            DTOSpecialisationProduit result = AssembleurDTO.entityToDTO(specialisationProduitNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.ENTITTE_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testDTOSpecialisationProduitNull() {
        try {
            SpecialisationProduit result = AssembleurDTO.dtoToEntity(dTOSpecialisationProduitNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.DTO_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testVilleNull() {
        try {
            DTOVille result = AssembleurDTO.entityToDTO(villeNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.ENTITTE_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testDTOVilleNull() {
        try {
            Ville result = AssembleurDTO.dtoToEntity(dtoVilleNull);
            Assert.fail("Ne devrait pas fonctionner");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.DTO_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testAvisClientSansPersonneSansProduit() {
        try {
            DTOAvisClient result = AssembleurDTO.entityToDTO(avisSansPersonneSansProduit);
            Assert.assertNotNull(result);
        } catch (AssembleurException ex) {
            Assert.fail("A planté");
        }
    }

    @Test
    public void testDTOAvisClientSansPersonneSansProduit() {
        try {
            AvisClient result = AssembleurDTO.dtoToEntity(dtoAvisSansPersonneSansProduit);
            Assert.assertNotNull(result);
        } catch (AssembleurException ex) {
            Assert.fail("A planté");
        }
    }

    @Test
    public void testCbSansPersonne() {
        try {
            DTOCB result = AssembleurDTO.entityToDTO(cbSansPersonne);
            Assert.assertNotNull(result);
        } catch (AssembleurException ex) {
            Assert.fail("A planté");
        }
    }

    @Test
    public void testDTOCBSansPersonne() {
        try {
            CB result = AssembleurDTO.dtoToEntity(dtoCbSansPersonne);
            Assert.assertNotNull(result);
        } catch (AssembleurException ex) {
            Assert.fail("A planté");
        }
    }

    @Test
    public void testLigneCommandeSansProduit() {
        try {
            DTOLigneCommande result = AssembleurDTO.entityToDTO(ligneCommandeSansProduit);
            Assert.assertNotNull(result);
        } catch (AssembleurException ex) {
            Assert.fail("A planté");
        }
    }

    @Test
    public void testDTOLigneCommandeSansProduit() {
        try {
            LigneCommande result = AssembleurDTO.dtoToEntity(dtoLigneCommandeSansProduit);
            Assert.assertNotNull(result);
        } catch (AssembleurException ex) {
            Assert.fail("A planté");
        }
    }

    @Test
    public void testProduitSansMarqueSnasSpecialisation() {
        try {
            DTOProduit result = AssembleurDTO.entityToDTO(produitSansMarqueSansSpecialisation);
            Assert.assertNotNull(result);
        } catch (AssembleurException ex) {
            Assert.fail("A planté");
        }
    }

    @Test
    public void testDTOProduitSansMarqueSnasSpecialisation() {
        try {
            Produit result = AssembleurDTO.dtoToEntity(dtoProduitSansMarqueSansSpecialisation);
            Assert.assertNotNull(result);
        } catch (AssembleurException ex) {
            Assert.fail("A planté");
        }
    }

    @Test
    public void testProduitSansPromo() throws ParseException {
        try {
            init_AvisClient();
            DTOProduit result = AssembleurDTO.entityToDTO(produitSansPromo);
            Assert.assertNotNull(result);
        } catch (AssembleurException ex) {
            Assert.fail("A planté");
        }
    }

    @Test
    public void testDTOProduitSansPromo() throws ParseException {
        try {
            init_AvisClient();
            Produit result = AssembleurDTO.dtoToEntity(dtoProduitSansPromotion);
            Assert.assertNotNull(result);
        } catch (AssembleurException ex) {
            Assert.fail("A planté");
        }
    }

    @Test
    public void testCommande() throws ParseException {
        try {
            init_LigneCommande();
            DTOCommande result = AssembleurDTO.entityToDTO(commande);
            Assert.assertNotNull(result);
            Assert.assertEquals(commandeDto.getDate(), result.getDate());
            Assert.assertEquals(commandeDto.getNumero(), result.getNumero());
            Assert.assertEquals(commandeDto.getStatut(), result.getStatut());
            Assert.assertEquals(commandeDto.getDtoLigneCommandes().get(0).getQuantite(), result.getDtoLigneCommandes().get(0).getQuantite());
        } catch (AssembleurException ex) {
            Assert.fail("Marche pas");
        }

    }

    @Test
    public void testDTOCommande() throws ParseException {
        try {
            init_LigneCommande();
            Commande result = AssembleurDTO.dtoToEntity(commandeDto);
            Assert.assertNotNull(result);
            Assert.assertEquals(commande.getDate(), result.getDate());
            Assert.assertEquals(commande.getNumero(), result.getNumero());
            Assert.assertEquals(commande.getStatut(), result.getStatut());
            Assert.assertEquals(commande.getLigneCommandes().get(0).getQuantite(), result.getLigneCommandes().get(0).getQuantite());
        } catch (AssembleurException ex) {
            Assert.fail("Marche pas");
        }
    }

    @Test
    public void testVues() {
        try {
            DTOVues result = AssembleurDTO.entityToDTO(vues);
            Assert.assertNotNull(result);
            Assert.assertEquals(vues.getId(), result.getId());
            Assert.assertEquals(vues.getDateClique(), result.getDateClique());
            Assert.assertEquals(vues.getProduit().getId(), result.getDtoProduit().getId());
        } catch (AssembleurException ex) {
            Assert.fail("Marche pas");
        }
    }

    @Test
    public void testDtoVues() {
        try {
            Vues result = AssembleurDTO.dtoToEntity(dtoVues);
            Assert.assertNotNull(result);
            Assert.assertEquals(dtoVues.getId(), result.getId());
            Assert.assertEquals(dtoVues.getDateClique(), result.getDateClique());
            Assert.assertEquals(dtoVues.getDtoProduit().getId(), result.getProduit().getId());
        } catch (AssembleurException ex) {
            Assert.fail("Marche pas");
        }
    }

    @Test
    public void testVuesProduitNull() {
        try {
            DTOVues result = AssembleurDTO.entityToDTO(vuesProduitNull);
            Assert.assertNotNull(result);
            Assert.assertEquals(vuesProduitNull.getId(), result.getId());
            Assert.assertEquals(vuesProduitNull.getDateClique(), result.getDateClique());
            Assert.assertNull(result.getDtoProduit());
        } catch (AssembleurException ex) {
            Assert.fail("Marche pas");
        }
    }

    @Test
    public void testDtoVuesProduitNull() {
        try {
            Vues result = AssembleurDTO.dtoToEntity(dtoVuesProduitNull);
            Assert.assertNotNull(result);
            Assert.assertEquals(dtoVuesProduitNull.getId(), result.getId());
            Assert.assertEquals(dtoVuesProduitNull.getDateClique(), result.getDateClique());
            Assert.assertNull(result.getProduit());
        } catch (AssembleurException ex) {
            Assert.fail("Marche pas");
        }
    }

    @Test
    public void testVuesNull() {
        try {
            DTOVues result = AssembleurDTO.entityToDTO(vuesNull);
            Assert.fail("Ca ne devrait pas marcher");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.ENTITTE_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testDtoVuesNull() {
        try {
            Vues result = AssembleurDTO.dtoToEntity(dtoVuesNull);
            Assert.fail("Ca ne devrait pas marcher");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.DTO_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testPromotionNull() {
        try {
            DTOPromotion result = AssembleurDTO.entityToDTO(promotionNull);
            Assert.fail("Ca ne devrait pas marcher");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.ENTITTE_NULL, ex.getCodeErreur());
        }
    }

    @Test
    public void testDtoPromotionNull() {
        try {
            Promotion result = AssembleurDTO.dtoToEntity(dtoPromotionNull);
            Assert.fail("Ca ne devrait pas marcher");
        } catch (AssembleurException ex) {
            Assert.assertEquals(ExceptionEnum.DTO_NULL, ex.getCodeErreur());
        }
    }
}
