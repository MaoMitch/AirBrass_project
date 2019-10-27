/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al30.airbrass.servicerest;

import fr.afcepf.al30.airbrass.serviceentities.LigneComParam;
import fr.afcepf.al30.airbrass.serviceentities.PanierParam;
import fr.afcepf.al30.airbrass.serviceentities.IdParam;
import fr.afcepf.al30.airbrass.business.api.IBusinessCommande;
import fr.afcepf.al30.airbrass.business.api.IBusinessProduit;
import fr.afcepf.al30.airbrass.business.api.IBusinessUtilisateur;
import fr.afcepf.al30.airbrass.dto.DTOCB;
import fr.afcepf.al30.airbrass.dto.DTOCommande;
import fr.afcepf.al30.airbrass.dto.DTOLigneCommande;
import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.dto.DTOProduit;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.serviceentities.CarteAvecUser;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Max Michel
 */
public class ServiceCommandeTest {

    private static ServiceCommande service;

    private static Class<?> clazz;

    private static IBusinessCommande buCommandeMock;
    private static IBusinessProduit buProduitMock;
    private static IBusinessUtilisateur buUtilisateurMock;

    private static Logger log = Logger.getLogger(ServiceCommandeTest.class);

    private static IdParam idParamGetUserCommandeByUserIdNominal;
    private static final String ID_IDPARAM_GET_COMMANDE_BY_USER_ID_NOMINAL = "2";

    private static DTOPersonne personneGetCommandeByUserIdNominal;

    private static DTOProduit produit1;
    private static final int QUANTITE_PRODUIT_1 = 6;
    private static DTOLigneCommande ligneCommande1;

    private static DTOProduit produit2;
    private static final int QUANTITE_PRODUIT_2 = 4;
    private static DTOLigneCommande ligneCommande2;

    private static DTOProduit produit3;
    private static final int QUANTITE_PRODUIT_3 = 1;
    private static DTOLigneCommande ligneCommande3;

    private static DTOCommande dtoCommande1;
    private static List<DTOLigneCommande> ligneDtoCommande1;
    private static DTOCommande dtoCommande2;
    private static List<DTOLigneCommande> ligneDtoCommande2;
    private static List<DTOCommande> resultGetCommandeByUserIdNominal;

    private static final double EXPECTED_SOMME_COMMANDE = 6 * 125;
    private static IdParam idParamCommandeGetPrix;
    private static final String ID_COMMANDE_GET_PRIX = "1";
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    private static final int ID_PERSONNE_SAVE_COMMANDE = 3;
    private static DTOPersonne personneSaveCommande;
    private static PanierParam panier;

    private static LigneComParam ligneComParam1;
    private static final int ID_PRODUIT_LIGNE_COMMANDE_SAVE_1 = 250;
    private static DTOLigneCommande ligneCommandeSave1;
    private static DTOProduit produitSaveCommande1;
    private static final int QUANTITE_PRODUIT_LIGNE_1_SAVE = 2;

    private static LigneComParam ligneComParam2;
    private static final int ID_PRODUIT_LIGNE_COMMANDE_SAVE_2 = 30;
    private static DTOLigneCommande ligneCommandeSave2;
    private static DTOProduit produitSaveCommande2;
    private static final int QUANTITE_PRODUIT_LIGNE_2_SAVE = 1;

    private static List<LigneComParam> listeLignePanier;
    private static DTOCommande commandeSaveCommande;
    private static final int ID_COMMANDE_SAVE_COMMANDE = 654;

    private static final String ID_COMMANDE_DONT_EXIST = "254874";
    private static IdParam idParamCommandeInexistante;

    private static DTOCB cbCommande;

    private static final String ID_USER_WITH_CARTE = "12";

    private static DTOCB cbGetCarteByUser1;
    private static DTOCB cbGetCarteByUser2;
    private static List<DTOCB> resultCbGetCarteByUser;

    private static final String ID_USER_AJOUT_CARTE = "23";
    private static DTOPersonne personneAjoutCarte;
    private static CarteAvecUser cartAvecUser;
    private static DTOCB carteAvantAjout;
    private static DTOCB carteApresAjout;

    private static DTOCB cbAvantMaJ;
    private static DTOCB cbApresMaJ;
    
    private static DTOCB cbASupr;
    
    public static void initEntity() throws ParseException {
        personneGetCommandeByUserIdNominal = new DTOPersonne("Michel", "Max", SDF.parse("17/04/1991"), "mao-mitch@hotmail.fr", "0649388804", "Azerty12", null);
        cbCommande = new DTOCB("indentite", "intitule", "numero", SDF.parse("17/04/2540"), 342, personneSaveCommande);
        idParamGetUserCommandeByUserIdNominal = new IdParam();
        idParamGetUserCommandeByUserIdNominal.setId(ID_IDPARAM_GET_COMMANDE_BY_USER_ID_NOMINAL);

        ligneDtoCommande1 = new ArrayList<>();
        ligneDtoCommande2 = new ArrayList<>();

        dtoCommande1 = new DTOCommande("CMD2-04042016", SDF.parse("04/04/2016"), "Envoyé", personneGetCommandeByUserIdNominal, cbCommande);
        dtoCommande1.setId(Integer.parseInt(ID_COMMANDE_GET_PRIX));
        produit1 = new DTOProduit("", "", 125.0, "", "", 250);
        ligneCommande1 = new DTOLigneCommande(QUANTITE_PRODUIT_1, produit1, dtoCommande1);
        ligneDtoCommande1.add(ligneCommande1);

        dtoCommande2 = new DTOCommande("CMD2-04072016", SDF.parse("04/04/2016"), "En cours de préparation", personneGetCommandeByUserIdNominal, cbCommande);
        produit2 = new DTOProduit("", "", 125.0, "", "", 250);
        ligneCommande2 = new DTOLigneCommande(QUANTITE_PRODUIT_2, produit2, dtoCommande2);
        ligneDtoCommande2.add(ligneCommande2);

        produit3 = new DTOProduit("", "", 125.0, "", "", 250);
        ligneCommande3 = new DTOLigneCommande(QUANTITE_PRODUIT_3, produit3, dtoCommande2);
        ligneDtoCommande2.add(ligneCommande3);

        resultGetCommandeByUserIdNominal = new ArrayList<>();
        resultGetCommandeByUserIdNominal.add(dtoCommande1);
        resultGetCommandeByUserIdNominal.add(dtoCommande2);

        idParamCommandeGetPrix = new IdParam();
        idParamCommandeGetPrix.setId(ID_COMMANDE_GET_PRIX);

        panier = new PanierParam();
        panier.setIdPers(ID_PERSONNE_SAVE_COMMANDE);
        panier.setDateCommande(new SimpleDateFormat("ddMMyy").format(new Date()));
        personneSaveCommande = new DTOPersonne("Thaedus", "Georges", SDF.parse("12/05/1985"), "seb@gmail.com", "0467572680", "12", null);
        personneSaveCommande.setId(ID_PERSONNE_SAVE_COMMANDE);

        ligneComParam1 = new LigneComParam();
        ligneComParam1.setId(ID_PRODUIT_LIGNE_COMMANDE_SAVE_1);
        produitSaveCommande1 = new DTOProduit("produit 1", "C'est le produit 1", 125.0, "Photo1", "ref : prod1", 12);
        produitSaveCommande1.setId(ID_PRODUIT_LIGNE_COMMANDE_SAVE_1);
        ligneComParam1.setQuantite(QUANTITE_PRODUIT_LIGNE_1_SAVE);
        ligneComParam1.setNom(produitSaveCommande1.getIntitule());
        ligneComParam1.setPhoto(produitSaveCommande1.getPhoto());
        ligneComParam1.setPrix(produitSaveCommande1.getPrix());
        ligneComParam2 = new LigneComParam();
        ligneComParam2.setId(ID_PRODUIT_LIGNE_COMMANDE_SAVE_2);
        produitSaveCommande2 = new DTOProduit("produit 2", "C'est le produit 2", 250.0, "Photo2", "ref : prod2", 35);
        produitSaveCommande2.setId(ID_PRODUIT_LIGNE_COMMANDE_SAVE_2);
        ligneComParam2.setNom(produitSaveCommande2.getIntitule());
        ligneComParam2.setPhoto(produitSaveCommande2.getPhoto());
        ligneComParam2.setPrix(produitSaveCommande2.getPrix());
        ligneComParam2.setQuantite(QUANTITE_PRODUIT_LIGNE_2_SAVE);

        listeLignePanier = new ArrayList<>();
        listeLignePanier.add(ligneComParam1);
        listeLignePanier.add(ligneComParam2);
        panier.setPanier(listeLignePanier);

        commandeSaveCommande = new DTOCommande("", SDF.parse("11/04/2017"), "En cours", personneSaveCommande, cbCommande);
        commandeSaveCommande.setDtoLigneCommandes(new ArrayList<>());
        commandeSaveCommande.setId(ID_COMMANDE_SAVE_COMMANDE);

        ligneCommandeSave1 = new DTOLigneCommande(QUANTITE_PRODUIT_LIGNE_1_SAVE, produitSaveCommande1, commandeSaveCommande);
        ligneCommandeSave1 = new DTOLigneCommande(QUANTITE_PRODUIT_LIGNE_2_SAVE, produitSaveCommande2, commandeSaveCommande);

        idParamCommandeInexistante = new IdParam();
        idParamCommandeInexistante.setId(ID_COMMANDE_DONT_EXIST);

        cbGetCarteByUser1 = new DTOCB();
        cbGetCarteByUser1.setIntitule("intitule1");
        cbGetCarteByUser1.setIdentite("identite1");
        cbGetCarteByUser1.setNumero("numero1");
        cbGetCarteByUser1.setId(45);
        cbGetCarteByUser1.setCle(321);
        cbGetCarteByUser1.setDateExpiration(SDF.parse("17/04/2018"));
        cbGetCarteByUser1.setDtoPersonne(personneSaveCommande);

        cbGetCarteByUser2 = new DTOCB("identite2", "intitule2", "numero2", SDF.parse("17/09/2019"), 324, personneSaveCommande);
        cbGetCarteByUser2.setId(655);
        resultCbGetCarteByUser = new ArrayList<>();
        resultCbGetCarteByUser.add(cbGetCarteByUser1);
        resultCbGetCarteByUser.add(cbGetCarteByUser2);

        personneAjoutCarte = new DTOPersonne("Michel", "Max", SDF.parse("17/04/1991"), "mao-mitch@hotmail.fr", "0649388804", "Azerty12", null);
        personneAjoutCarte.setId(Integer.parseInt(ID_USER_AJOUT_CARTE));

        carteAvantAjout = new DTOCB("Michel", "Ma Carte", "############3456", SDF.parse("24/05/2019"), 321, null);
        cartAvecUser = new CarteAvecUser(carteAvantAjout, ID_USER_AJOUT_CARTE);

        carteApresAjout = new DTOCB("Michel", "Ma Carte", "############3456", SDF.parse("24/05/2019"), 321, personneAjoutCarte);
        carteApresAjout.setId(6547);
        
        cbAvantMaJ = new DTOCB("Michel", "Ma Carte", "############3456", SDF.parse("24/05/2019"), 321, personneAjoutCarte);
        cbAvantMaJ.setId(6547);
        
        cbApresMaJ = new DTOCB("Michel", "Ma Carte", "############3456", SDF.parse("24/05/2019"), 321, personneAjoutCarte);
        cbApresMaJ.setId(6547);
        
        cbASupr = new DTOCB("Michel", "Ma Carte", "############3456", SDF.parse("24/05/2019"), 321, personneAjoutCarte);
        cbASupr.setId(6547);
    }

    @BeforeClass
    public static void init() throws AirBrassException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException {
        service = new ServiceCommande();
        clazz = service.getClass();
        initEntity();
        initBuCommandeMock();
        initBuProduitMock();
        initBuUtilisateurMock();
        EasyMock.replay(buCommandeMock, buProduitMock, buUtilisateurMock);
    }

    public static void initBuCommandeMock() throws AirBrassException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        buCommandeMock = EasyMock.createMock(IBusinessCommande.class);
        EasyMock.expect(buCommandeMock.getCommandesByUser(personneGetCommandeByUserIdNominal)).andReturn(resultGetCommandeByUserIdNominal);
        EasyMock.expect(buCommandeMock.getLigneByCommande(dtoCommande1)).andReturn(ligneDtoCommande1);
        EasyMock.expect(buCommandeMock.getLigneByCommande(dtoCommande2)).andReturn(ligneDtoCommande2);
        EasyMock.expect(buCommandeMock.getCommandeById(Integer.parseInt(ID_COMMANDE_GET_PRIX))).andReturn(dtoCommande1);
        EasyMock.expect(buCommandeMock.getPrixByCommande(dtoCommande1)).andReturn(EXPECTED_SOMME_COMMANDE);
        EasyMock.expect(buCommandeMock.addCommande(EasyMock.anyObject(DTOCommande.class))).andReturn(commandeSaveCommande);
        EasyMock.expect(buCommandeMock.addLigne(EasyMock.anyObject(DTOLigneCommande.class))).andReturn(ligneCommandeSave1);
        EasyMock.expect(buCommandeMock.addLigne(EasyMock.anyObject(DTOLigneCommande.class))).andReturn(ligneCommandeSave2);
        EasyMock.expect(buCommandeMock.getCommandeById(Integer.parseInt(ID_COMMANDE_DONT_EXIST))).andReturn(null);
        EasyMock.expect(buCommandeMock.getPrixByCommande(null)).andReturn(0d);
        EasyMock.expect(buCommandeMock.getCBByClient(Integer.parseInt(ID_USER_WITH_CARTE))).andReturn(resultCbGetCarteByUser);
        EasyMock.expect(buCommandeMock.ajouterCarte(EasyMock.anyObject(DTOCB.class))).andReturn(carteApresAjout);
        EasyMock.expect(buCommandeMock.majCarte(cbAvantMaJ)).andReturn(cbApresMaJ);
        EasyMock.expect(buCommandeMock.suprCarte(cbASupr)).andReturn(true);
        
        Field attBuCommande = clazz.getDeclaredField("buCommande");
        attBuCommande.setAccessible(true);
        attBuCommande.set(service, buCommandeMock);
    }

    public static void initBuProduitMock() throws AirBrassException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        buProduitMock = EasyMock.createMock(IBusinessProduit.class);
        EasyMock.expect(buProduitMock.getProduitById(ID_PRODUIT_LIGNE_COMMANDE_SAVE_1)).andReturn(produitSaveCommande1);
        EasyMock.expect(buProduitMock.getProduitById(ID_PRODUIT_LIGNE_COMMANDE_SAVE_2)).andReturn(produitSaveCommande2);
        Field attBuProduit = clazz.getDeclaredField("buProduit");
        attBuProduit.setAccessible(true);
        attBuProduit.set(service, buProduitMock);
    }

    public static void initBuUtilisateurMock() throws AirBrassException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        buUtilisateurMock = EasyMock.createMock(IBusinessUtilisateur.class);
        EasyMock.expect(buUtilisateurMock.getClientById(Integer.parseInt(ID_IDPARAM_GET_COMMANDE_BY_USER_ID_NOMINAL))).andReturn(personneGetCommandeByUserIdNominal);
        EasyMock.expect(buUtilisateurMock.getClientById(ID_PERSONNE_SAVE_COMMANDE)).andReturn(personneSaveCommande);
        EasyMock.expect(buUtilisateurMock.getClientById(Integer.parseInt(ID_USER_AJOUT_CARTE))).andReturn(personneAjoutCarte);
        Field attBuUtilisateur = clazz.getDeclaredField("buPersonne");
        attBuUtilisateur.setAccessible(true);
        attBuUtilisateur.set(service, buUtilisateurMock);
    }

    @Test
    public void getCommandesByUserIdNominal() {
        Response result = service.getCommandesByUserId(idParamGetUserCommandeByUserIdNominal);
        Assert.assertEquals(201, result.getStatus());
        Object responseContent = result.getEntity();
        Assert.assertTrue(responseContent instanceof List);
        List<DTOCommande> resultContent = (List<DTOCommande>) responseContent;
        Assert.assertNotNull(resultContent);
        Assert.assertEquals(2, resultContent.size());
        for (DTOCommande dTOCommande : resultContent) {
            if (dTOCommande.getNumero().equals("CMD2-04042016")) {
                Assert.assertEquals(ligneDtoCommande1, dTOCommande.getDtoLigneCommandes());
            } else {
                Assert.assertEquals(ligneDtoCommande2, dTOCommande.getDtoLigneCommandes());
            }
        }
    }

    @Test
    public void getPrixByCommandeNominal() {
        Double result = service.getPrixByCommande(idParamCommandeGetPrix);
        Assert.assertNotEquals(0, result);
        Double expected = EXPECTED_SOMME_COMMANDE;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void saveCommandeNominal() {
        Response result = service.saveCommande(panier);
        Assert.assertNotNull(result);
        Assert.assertEquals(201, result.getStatus());
        Assert.assertTrue(panier.getPanier().isEmpty());
    }

    @Test
    public void getPrixByCommandeDontExist() {
        Double result = service.getPrixByCommande(idParamCommandeInexistante);
        Double expected = 0d;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getCarteByUserNominal() {
        Response result = service.getCarteByUser(ID_USER_WITH_CARTE);
        Assert.assertNotNull(result);
        Assert.assertEquals(201, result.getStatus());
        Assert.assertEquals(resultCbGetCarteByUser, result.getEntity());
    }
    
    @Test
    public void ajouterCarteNominal() {
        Response result = service.ajouterCarte(cartAvecUser);
        Assert.assertNotNull(result);
        Assert.assertEquals(201, result.getStatus());
        Assert.assertEquals(carteApresAjout, result.getEntity());
    }
    
    @Test
    public void majCarteNominal() {
        Response result = service.majCarte(cbAvantMaJ);
        Assert.assertNotNull(result);
        Assert.assertEquals(201, result.getStatus());
        Assert.assertEquals(cbApresMaJ, result.getEntity());
    }
    
    public void suprCarteNominal() {
        Response result = service.suprCarte(cbASupr);
        Assert.assertNotNull(result);
        Assert.assertEquals(201, result.getStatus());
        Assert.assertEquals(Boolean.TRUE, result.getEntity());
    }
}
