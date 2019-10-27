/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al30.airbrass.business.impl;

import fr.afcepf.al30.airbrass.business.api.IBusinessProduit;
import fr.afcepf.al30.airbrass.dao.api.IDAOMarque;
import fr.afcepf.al30.airbrass.dao.api.IDAOProduit;
import fr.afcepf.al30.airbrass.dao.api.IDAOSpecialisationProduit;
import fr.afcepf.al30.airbrass.dto.DTOMarque;
import fr.afcepf.al30.airbrass.dto.DTOProduit;
import fr.afcepf.al30.airbrass.dto.DTOSpecialisationProduit;
import fr.afcepf.al30.airbrass.enums.DTOTypeProduit;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import java.lang.reflect.Field;
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
public class BusinessProduitTest {

    private static Logger log = Logger.getLogger(BusinessProduitTest.class);

    private static IBusinessProduit buProduit;

    private static Class<?> clazz;

    private static IDAOProduit daoProduitMock;

    private static IDAOMarque daoMarqueMock;

    private static IDAOSpecialisationProduit daoSpecialisationProduitMock;

    private static DTOProduit produitUnGetAll;
    private static DTOProduit produitDeuxGetAll;
    private static DTOProduit produitTroisGetAll;

    private static List<DTOProduit> listProduitGetAll;

    private static DTOMarque marqueUnGetAll;
    private static DTOMarque marqueDeuxGetAll;
    private static DTOMarque marqueTroisGetAll;

    private static List<DTOMarque> listMarqueGetAll;

    private static DTOSpecialisationProduit specUnGetAll;
    private static DTOSpecialisationProduit specDeuxGetAll;
    private static DTOSpecialisationProduit specTroisGetAll;
    private static DTOSpecialisationProduit specQuatreGetAll;

    private static List<DTOSpecialisationProduit> listSpecsGetAll;

    private static DTOProduit produitGetById;

    private static final int ID_GET_BY_ID_NOMINAL = 12;

    private static List<String> listSpecialisations;
    private static List<String> listMarques;

    private static List<String> listNoResultSpecialisations;
    private static List<String> listNoResultMarques;

    private static List<DTOMarque> allMarqueGuitareExpected;
    private static List<DTOMarque> allMarqueAccessoireExpected;

    private static List<DTOSpecialisationProduit> allSpecsGuitareExpected;
    private static List<DTOSpecialisationProduit> allSpecsAccessoireExpected;

    public static void initEntity() {
        produitUnGetAll = new DTOProduit("produit 1", "Premier produit", 30.0, "photo 1", "ref : produit1", 250);
        produitDeuxGetAll = new DTOProduit("produit 2", "Deuxieme produit", 130.0, "photo 2", "ref : produit2", 10);
        produitTroisGetAll = new DTOProduit("produit 3", "Troisieme produit", 50.0, "photo 3", "ref : produit", 3452);
        listProduitGetAll = new ArrayList<>();
        listProduitGetAll.add(produitUnGetAll);
        listProduitGetAll.add(produitDeuxGetAll);
        listProduitGetAll.add(produitTroisGetAll);

        marqueUnGetAll = new DTOMarque("Marque1", "logoMarque1");
        marqueDeuxGetAll = new DTOMarque("Marque2", "logoMarque2");
        marqueTroisGetAll = new DTOMarque("Marque3", "logoMarque3");
        listMarqueGetAll = new ArrayList<>();
        listMarqueGetAll.add(marqueUnGetAll);
        listMarqueGetAll.add(marqueDeuxGetAll);
        listMarqueGetAll.add(marqueTroisGetAll);

        specUnGetAll = new DTOSpecialisationProduit("Guitare acoustique", "Guitare");
        specDeuxGetAll = new DTOSpecialisationProduit("Guitare electrique", "Guitare");
        specTroisGetAll = new DTOSpecialisationProduit("Stand", "Accessoire");
        specQuatreGetAll = new DTOSpecialisationProduit("Mediator", "Accessoire");
        listSpecsGetAll = new ArrayList<>();
        listSpecsGetAll.add(specUnGetAll);
        listSpecsGetAll.add(specDeuxGetAll);
        listSpecsGetAll.add(specTroisGetAll);
        listSpecsGetAll.add(specQuatreGetAll);

        produitGetById = new DTOProduit("Produit get by id", "LE produit à récupérer par l'id", 25.20, "photo", "ref: By Id", 24);
        produitGetById.setId(ID_GET_BY_ID_NOMINAL);

        produitUnGetAll.setDtoMarque(marqueUnGetAll);
        produitUnGetAll.setDtoSpecialisationProduit(specUnGetAll);
        produitDeuxGetAll.setDtoMarque(marqueUnGetAll);
        produitDeuxGetAll.setDtoSpecialisationProduit(specUnGetAll);
        produitTroisGetAll.setDtoMarque(marqueUnGetAll);
        produitTroisGetAll.setDtoSpecialisationProduit(specTroisGetAll);

        listSpecialisations = new ArrayList<>();
        listSpecialisations.add("Guitare acoustique");
        listMarques = new ArrayList<>();
        listMarques.add("Marque1");

        listNoResultSpecialisations = new ArrayList<>();
        listNoResultSpecialisations.add("NoSpé");
        listNoResultMarques = new ArrayList<>();
        listNoResultMarques.add("NoMarque");
        
        allMarqueAccessoireExpected = new ArrayList<>();
        allMarqueGuitareExpected = new ArrayList<>();
        allSpecsAccessoireExpected = new ArrayList<>();
        allSpecsGuitareExpected = new ArrayList<>();
        
    }

    @BeforeClass
    public static void init() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, AirBrassException {
        buProduit = new BusinessProduit();
        clazz = buProduit.getClass();
        initEntity();
        initDaoProduitMock();
        initDaoMarqueMock();
        initDaoSpecialisationProduitMock();
        EasyMock.replay(daoProduitMock, daoMarqueMock, daoSpecialisationProduitMock);
        Field fieldDaoProduit = clazz.getDeclaredField("daoProduit");
        fieldDaoProduit.setAccessible(true);
        fieldDaoProduit.set(buProduit, daoProduitMock);
        Field fieldDaoMarque = clazz.getDeclaredField("daoMarque");
        fieldDaoMarque.setAccessible(true);
        fieldDaoMarque.set(buProduit, daoMarqueMock);
        Field fieldSpecialisationProduit = clazz.getDeclaredField("daoSpecialisationProduit");
        fieldSpecialisationProduit.setAccessible(true);
        fieldSpecialisationProduit.set(buProduit, daoSpecialisationProduitMock);

    }

    @AfterClass
    public static void tearDown() {
        EasyMock.verify(daoProduitMock, daoMarqueMock, daoSpecialisationProduitMock);
    }

    public static void initDaoProduitMock() throws AirBrassException {
        daoProduitMock = EasyMock.createMock(IDAOProduit.class);
        EasyMock.expect(daoProduitMock.getAll()).andReturn(listProduitGetAll);
        EasyMock.expect(daoProduitMock.getArticleById(ID_GET_BY_ID_NOMINAL)).andReturn(produitGetById);
        EasyMock.expect(daoProduitMock.getAll()).andReturn(listProduitGetAll);
        EasyMock.expect(daoProduitMock.getAll()).andReturn(listProduitGetAll);
        EasyMock.expect(daoProduitMock.getAll()).andReturn(listProduitGetAll);
        EasyMock.expect(daoProduitMock.getAll()).andReturn(listProduitGetAll);
        EasyMock.expect(daoProduitMock.getAll()).andReturn(listProduitGetAll);
        
    }

    public static void initDaoMarqueMock() throws AirBrassException {
        daoMarqueMock = EasyMock.createMock(IDAOMarque.class);
        EasyMock.expect(daoMarqueMock.getAll()).andReturn(listMarqueGetAll);
        EasyMock.expect(daoMarqueMock.getMarqueByTypeProduit(DTOTypeProduit.GUITARE)).andReturn(allMarqueGuitareExpected);
        EasyMock.expect(daoMarqueMock.getMarqueByTypeProduit(DTOTypeProduit.ACCESSOIRE)).andReturn(allMarqueAccessoireExpected);
    }

    public static void initDaoSpecialisationProduitMock() throws AirBrassException {
        daoSpecialisationProduitMock = EasyMock.createMock(IDAOSpecialisationProduit.class);
        EasyMock.expect(daoSpecialisationProduitMock.getAll()).andReturn(listSpecsGetAll);
        EasyMock.expect(daoSpecialisationProduitMock.getSpecialisationProduitByTypeProduit(DTOTypeProduit.GUITARE)).andReturn(allSpecsGuitareExpected);
        EasyMock.expect(daoSpecialisationProduitMock.getSpecialisationProduitByTypeProduit(DTOTypeProduit.ACCESSOIRE)).andReturn(allSpecsAccessoireExpected);
    }

    @Test
    public void getAllProduitsNominal() {
        try {
            List<DTOProduit> produits = buProduit.getAllProduits();
            Assert.assertNotNull(produits);
            Assert.assertEquals(3, produits.size());
            for (int i = 0; i < produits.size(); i++) {
                Assert.assertEquals(listProduitGetAll.get(i), produits.get(i));
            }
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getAllMarquesNominal() {
        try {
            List<DTOMarque> marques = buProduit.getAllMarque();
            Assert.assertNotNull(marques);
            Assert.assertEquals(3, marques.size());
            for (int i = 0; i < marques.size(); i++) {
                Assert.assertEquals(listMarqueGetAll.get(i), marques.get(i));
            }
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getAllSpecialisationProduitNominal() {
        try {
            List<DTOSpecialisationProduit> specialisationProduits = buProduit.getAllSpecs();
            Assert.assertNotNull(specialisationProduits);
            Assert.assertEquals(4, specialisationProduits.size());
            for (int i = 0; i < specialisationProduits.size(); i++) {
                Assert.assertEquals(listSpecsGetAll.get(i), specialisationProduits.get(i));
            }
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getProduitParOptionsNominal() {
        try {
            List<DTOProduit> produits = buProduit.getProduitParOptions(listSpecialisations, listMarques);
            Assert.assertNotNull(produits);
            Assert.assertEquals(2, produits.size());
            for (int i = 0; i < produits.size(); i++) {
                Assert.assertEquals(listProduitGetAll.get(i), produits.get(i));
            }
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getProduitParOptionsMarquesNull() {
        try {
            List<DTOProduit> produits = buProduit.getProduitParOptions(listSpecialisations, null);
            Assert.assertNotNull(produits);
            Assert.assertEquals(2, produits.size());
            for (int i = 0; i < produits.size(); i++) {
                Assert.assertEquals(listProduitGetAll.get(i), produits.get(i));
            }
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getProduitParOptionsSansResultat() {
        try {
            List<DTOProduit> produits = buProduit.getProduitParOptions(listNoResultSpecialisations, listNoResultMarques);
            Assert.assertEquals(0, produits.size());
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getProduitByIdNominal() {
        try {
            DTOProduit result = buProduit.getProduitById(ID_GET_BY_ID_NOMINAL);
            Assert.assertNotNull(result);
            Assert.assertEquals(produitGetById, result);
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getAllGuitaresNominal() {
        try {
            List<DTOProduit> produits = buProduit.getAllGuitares();
            Assert.assertNotNull(produits);
            Assert.assertEquals(2, produits.size());
            for (int i = 0; i < produits.size(); i++) {
                Assert.assertEquals(listProduitGetAll.get(i), produits.get(i));
            }
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getAllAccesoiresNominal() {
        try {
            List<DTOProduit> produits = buProduit.getAllAccessoire();
            Assert.assertNotNull(produits);
            Assert.assertEquals(1, produits.size());
            for (int i = 0; i < produits.size(); i++) {
                Assert.assertEquals(listProduitGetAll.get(i + 2), produits.get(i));
            }
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getAllMarqueGuitareNominal() {
        try {
            List<DTOMarque> result = buProduit.getAllMarqueGuitare();
            Assert.assertNotNull(result);
            Assert.assertEquals(allMarqueGuitareExpected, result);
        } catch (AirBrassException ex) {
            Assert.fail("Ca marche pas");
        }
    }

    @Test
    public void getAllMarqueAccessoire() {
        try {
            List<DTOMarque> result = buProduit.getAllMarqueAccessoire();
            Assert.assertNotNull(result);
            Assert.assertEquals(allMarqueAccessoireExpected, result);
        } catch (AirBrassException ex) {
            Assert.fail("Ca marche pas");
        }

    }

    @Test
    public void getAllSpecsGuitare() {
        try {
            List<DTOSpecialisationProduit> result = buProduit.getAllSpecsGuitare();
            Assert.assertNotNull(result);
            Assert.assertEquals(allSpecsGuitareExpected, result);
        } catch (AirBrassException ex) {
            Assert.fail("Ca marche pas");
        }
    }

    @Test
    public void getAllSpecsAccessoire() {
        try {
            List<DTOSpecialisationProduit> result = buProduit.getAllSpecsAccessoire();
            Assert.assertNotNull(result);
            Assert.assertEquals(allSpecsAccessoireExpected, result);
        } catch (AirBrassException ex) {
            Assert.fail("Ca marche pas");
        }
    }
}
