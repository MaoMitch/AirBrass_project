package fr.afcepf.al30.airbrass.business.impl;

import fr.afcepf.al30.airbrass.business.api.IBusinessCommande;
import fr.afcepf.al30.airbrass.business.api.ISOAPAccess;
import fr.afcepf.al30.airbrass.dao.api.IDAOCommande;
import fr.afcepf.al30.airbrass.dao.api.IDAOLigneCommande;
import fr.afcepf.al30.airbrass.dto.DTOCB;
import fr.afcepf.al30.airbrass.dto.DTOCommande;
import fr.afcepf.al30.airbrass.dto.DTOLigneCommande;
import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.dto.DTOProduit;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Max Michel
 */
public class BusinessCommandeTest {

    private static Logger log = Logger.getLogger(BusinessUtilisateurTest.class);

    private static IBusinessCommande buCommande;

    private static Class<?> clazz;

    private static IDAOCommande daoCommandeMock;

    private static IDAOLigneCommande daoLigneCommandeMock;

    private static DTOPersonne personneAvecCommandeTroisLigne;

    private static DTOPersonne personneAvecCommandeVide;

    private static List<DTOCommande> resultCommandes;
    private static List<DTOLigneCommande> resultLigneCommande;
    private static DTOCommande commandeAvecTroisLignes;

    private static final int NOMBRE_PRODUIT_LIGNE_1 = 3;
    private static final double PRIX_PRODUIT_1 = 250.0;
    private static DTOProduit produitLigneUn;
    private static DTOLigneCommande commandeAvecTroisLignesLigneUn;

    private static final int NOMBRE_PRODUIT_LIGNE_2 = 1;
    private static final double PRIX_PRODUIT_2 = 5.50;
    private static DTOProduit produitLigneDeux;
    private static DTOLigneCommande commandeAvecTroisLignesLigneDeux;

    private static final int NOMBRE_PRODUIT_LIGNE_3 = 1;
    private static final double PRIX_PRODUIT_3 = 650.0;
    private static DTOProduit produitLigneTrois;
    private static DTOLigneCommande commandeAvecTroisLignesLigneTrois;

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    private static final int ID_USER_AVEC_COMMANDE_3_LIGNE = 5;
    private static final int ID_USER_SANS_COMMANDE = 2;
    private static final Double PRIX_ATTENDU = NOMBRE_PRODUIT_LIGNE_1 * PRIX_PRODUIT_1 + NOMBRE_PRODUIT_LIGNE_2 * PRIX_PRODUIT_2 + NOMBRE_PRODUIT_LIGNE_3 * PRIX_PRODUIT_3;

    private static final int NOMBRE_PRODUIT_LIGNE_AJOUT = 5;

    private static final int ID_LIGNE_AJOUT = 26877;

    private static DTOLigneCommande ligneAjout;
    private static DTOLigneCommande returnLigneAjout;
    private static DTOProduit produitLigneAjout;

    private static DTOCommande commandePourAjout;
    private static DTOCommande returnCommandePourAjout;

    private static DTOCommande commandePourUpdate;
    private static DTOCommande returnCommandePourUpdate;
    private static final int ID_COMMANDE_AJOUT = 6985425;
    private static DTOCommande commandePourAjoutLigne;
    private static DTOCommande commandeById;
    private static final int ID_COMMANDE_BY_ID = 123557;
    private static final int ID_COMMANDE_BY_ID_DONT_EXIST = 1254875;
    private static DTOLigneCommande ligneCommandePourAjout;
    
    private static DTOCB cbCommande;
    
    private static ISOAPAccess soapAccesMock;

    public static void initEntity() throws ParseException {
        
        personneAvecCommandeTroisLigne = new DTOPersonne("Hartman", "Thaddeus", SDF.parse("08/06/1986"), "seb@gmail.com", "9fa265492b6b6e31342aab95a571abd34bd50cc6f4a392601449f50c33b2cf27207a269e5508cbcc497d09ed5fa9ffc6ce092bc62220b8d064ece0a84eaaedb6", "03 12 73 60 31", null);
        personneAvecCommandeTroisLigne.setId(ID_USER_AVEC_COMMANDE_3_LIGNE);
        cbCommande = new DTOCB("identite", "intitule", "numero", SDF.parse("09/05/2111"), 342, personneAvecCommandeTroisLigne);
        personneAvecCommandeVide = new DTOPersonne("Hartman", "Thaddeus", SDF.parse("08/06/1986"), "seb@gmail.com", "9fa265492b6b6e31342aab95a571abd34bd50cc6f4a392601449f50c33b2cf27207a269e5508cbcc497d09ed5fa9ffc6ce092bc62220b8d064ece0a84eaaedb6", "03 12 73 60 31", null);
        personneAvecCommandeVide.setId(ID_USER_SANS_COMMANDE);
        commandeAvecTroisLignes = new DTOCommande("CMD1-06042017", SDF.parse("06/04/2017"), "En cours",  personneAvecCommandeTroisLigne, cbCommande);
        produitLigneUn = new DTOProduit("Produit1", "Produit1", PRIX_PRODUIT_1, "photo1", "ref1", 250);
        commandeAvecTroisLignesLigneUn = new DTOLigneCommande(NOMBRE_PRODUIT_LIGNE_1, produitLigneUn, commandeAvecTroisLignes);
        produitLigneDeux = new DTOProduit("Produit2", "Produit2", PRIX_PRODUIT_2, "photo2", "ref2", 3000);
        commandeAvecTroisLignesLigneDeux = new DTOLigneCommande(NOMBRE_PRODUIT_LIGNE_2, produitLigneDeux, commandeAvecTroisLignes);
        produitLigneTrois = new DTOProduit("Produit3", "Produit3", PRIX_PRODUIT_3, "photo3", "ref3",  20);
        commandeAvecTroisLignesLigneTrois = new DTOLigneCommande(NOMBRE_PRODUIT_LIGNE_3, produitLigneTrois, commandeAvecTroisLignes);
        resultCommandes = new ArrayList<>();
        resultCommandes.add(commandeAvecTroisLignes);
        resultLigneCommande = new ArrayList<>();
        resultLigneCommande.add(commandeAvecTroisLignesLigneUn);
        resultLigneCommande.add(commandeAvecTroisLignesLigneDeux);
        resultLigneCommande.add(commandeAvecTroisLignesLigneTrois);

        produitLigneAjout = new DTOProduit("Produit3", "Produit3", PRIX_PRODUIT_3, "photo3", "ref3", 20);
        commandePourAjout = new DTOCommande("CMD1-06042017", SDF.parse("06/04/2017"), "En cours", personneAvecCommandeTroisLigne, cbCommande);
        ligneCommandePourAjout = new DTOLigneCommande(12, produitLigneUn, commandePourAjout);
        commandePourAjout.setDtoLigneCommandes(new ArrayList<>());
        commandePourAjout.getDtoLigneCommandes().add(ligneCommandePourAjout);
        commandePourAjoutLigne = new DTOCommande("CMD1-06042017", SDF.parse("06/04/2017"), "En cours", personneAvecCommandeTroisLigne, cbCommande);
        commandeById = new DTOCommande("CMD1-06042017", SDF.parse("06/04/2017"), "En cours", personneAvecCommandeTroisLigne, cbCommande);
        commandeById.setId(ID_COMMANDE_BY_ID);
        returnCommandePourAjout = new DTOCommande("CMD1-06042017", SDF.parse("06/04/2017"), "En cours", personneAvecCommandeTroisLigne, cbCommande);
        returnCommandePourAjout.setId(ID_COMMANDE_AJOUT);

        ligneAjout = new DTOLigneCommande(NOMBRE_PRODUIT_LIGNE_AJOUT, produitLigneAjout, commandePourAjoutLigne);
        returnLigneAjout = new DTOLigneCommande(NOMBRE_PRODUIT_LIGNE_AJOUT, produitLigneAjout, commandePourAjoutLigne);
        returnLigneAjout.setId(ID_LIGNE_AJOUT);

        commandePourUpdate = new DTOCommande("CMD1-06042017", SDF.parse("06/04/2017"), "En cours", personneAvecCommandeTroisLigne, cbCommande);
        returnCommandePourUpdate = new DTOCommande("CMD1-06042017", SDF.parse("06/04/2017"), "En cours", personneAvecCommandeTroisLigne, cbCommande);
    }

    @BeforeClass
    public static void init() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, AirBrassException, ParseException {
        buCommande = new BusinessCommande();
        clazz = buCommande.getClass();
        initEntity();
        initDaoCommandeMock();
        initDaoLigneCommandeMock();
        initSoapAccess();
        EasyMock.replay(daoCommandeMock, daoLigneCommandeMock, soapAccesMock);
    }

    @AfterClass
    public static void tearDown() {
        EasyMock.verify(daoCommandeMock, daoLigneCommandeMock);
    }

    public static void initSoapAccess() throws IllegalArgumentException, NoSuchFieldException, SecurityException, IllegalAccessException {
        soapAccesMock = EasyMock.createMock(SOAPAccess.class);
        EasyMock.expect(soapAccesMock.makeCommand(commandePourAjout)).andReturn(null);
        Field attSoapAccess = clazz.getDeclaredField("soapAccess");
        attSoapAccess.setAccessible(true);
        attSoapAccess.set(buCommande, soapAccesMock);
    }
    public static void initDaoCommandeMock() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, AirBrassException {
        daoCommandeMock = EasyMock.createMock(IDAOCommande.class);
        EasyMock.expect(daoCommandeMock.getCommandeByClient(personneAvecCommandeTroisLigne)).andReturn(resultCommandes);
        EasyMock.expect(daoCommandeMock.getCommandeByClient(personneAvecCommandeVide)).andReturn(null);
        EasyMock.expect(daoCommandeMock.getLignesByCommande(commandeAvecTroisLignes)).andReturn(resultLigneCommande);
        EasyMock.expect(daoCommandeMock.getLignesByCommande(commandeAvecTroisLignes)).andReturn(resultLigneCommande);
        EasyMock.expect(daoCommandeMock.getLignesByCommande(null)).andReturn(new ArrayList<>());
        EasyMock.expect(daoCommandeMock.updateCommande(commandePourUpdate)).andReturn(returnCommandePourUpdate);
        EasyMock.expect(daoCommandeMock.addCommande(commandePourAjout)).andReturn(returnCommandePourAjout);
        EasyMock.expect(daoCommandeMock.getCommandeById(ID_COMMANDE_BY_ID)).andReturn(commandeById);
        EasyMock.expect(daoCommandeMock.getCommandeById(ID_COMMANDE_BY_ID_DONT_EXIST)).andReturn(null);
        Field attDaoAdresse = clazz.getDeclaredField("daoCommande");
        attDaoAdresse.setAccessible(true);
        attDaoAdresse.set(buCommande, daoCommandeMock);
    }

    public static void initDaoLigneCommandeMock() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, AirBrassException {
        daoLigneCommandeMock = EasyMock.createMock(IDAOLigneCommande.class);
        EasyMock.expect(daoLigneCommandeMock.addLigne(ligneAjout)).andReturn(returnLigneAjout);
        Field attDaoAdresse = clazz.getDeclaredField("daoLigneCommande");
        attDaoAdresse.setAccessible(true);
        attDaoAdresse.set(buCommande, daoLigneCommandeMock);
    }

    @Test
    public void getCommandesByUserNominal() {
        try {
            List<DTOCommande> commandes = buCommande.getCommandesByUser(personneAvecCommandeTroisLigne);
            Assert.assertNotNull(commandes);
            Assert.assertEquals(1, commandes.size());
            Assert.assertEquals(commandeAvecTroisLignes, commandes.get(0));
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getCommandesByUserSansCommande() {
        try {
            List<DTOCommande> commandes = buCommande.getCommandesByUser(personneAvecCommandeVide);
            Assert.assertNull(commandes);
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getPrixByCommandeNominal() {
        try {
            Double prix = buCommande.getPrixByCommande(commandeAvecTroisLignes);
            Assert.assertNotEquals(prix, 0);
            Assert.assertEquals(PRIX_ATTENDU, prix);
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }
    
    @Test
    public void getPrixByCommandeNull() {
        try {
            Double prix = buCommande.getPrixByCommande(null);
            Double expected = 0d;
            Assert.assertEquals(expected, prix);
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void addLigneCommandeNominal() {
        try {
            DTOLigneCommande result = buCommande.addLigne(ligneAjout);
            Assert.assertNotNull(result);
            Assert.assertEquals(returnLigneAjout, result);
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void updateCommandeNominal() {
        try {
            DTOCommande result = buCommande.updateCommande(commandePourUpdate);
            Assert.assertEquals(returnCommandePourUpdate, result);
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void addCommandeNominal() {
        try {
            DTOCommande result = buCommande.addCommande(commandePourAjout);
            Assert.assertEquals(returnCommandePourAjout, result);
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getLigneByCommande() {
        try {
            List<DTOLigneCommande> result = buCommande.getLigneByCommande(commandeAvecTroisLignes);
            Assert.assertEquals(3, result.size());
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getCommandeByIdNominal() {
        try {
            DTOCommande result = buCommande.getCommandeById(ID_COMMANDE_BY_ID);
            Assert.assertEquals(commandeById, result);
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }

    }

    @Test
    public void getCommandeByIdNonExist() {
        try {
            DTOCommande result = buCommande.getCommandeById(ID_COMMANDE_BY_ID_DONT_EXIST);
            Assert.assertNull(result);
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }

    }
}
