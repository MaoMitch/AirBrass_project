package fr.afcepf.al30.banque.impl;

import fr.afcepf.al30.banque.dto.AssembleurDTOTest;
import java.lang.reflect.Field;
import java.util.Date;

import org.apache.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;

import fr.afcepf.al30.banque.api.IDaoCarteBanquaire;
import fr.afcepf.al30.banque.api.IDaoCompte;
import fr.afcepf.al30.banque.api.IDaoOperation;
import fr.afcepf.al30.banque.api.IServiceBanque;
import fr.afcepf.al30.banque.dto.CarteBanquaireDTO;
import fr.afcepf.al30.banque.entity.CarteBanquaire;
import fr.afcepf.al30.banque.entity.CompteBanquaire;
import fr.afcepf.al30.banque.entity.Operation;
import fr.afcepf.al30.banque.impl.ServiceBanque;

/**
 * Classede test des services de la banque.
 *
 * @author Stagiaire
 *
 */
public class ServiceBanqueTest {

    private static Logger log = Logger.getLogger(AssembleurDTOTest.class);

    private static IServiceBanque service;
    private static IDaoCarteBanquaire mockDaoCarte;
    private static IDaoCompte mockDaoCompte;
    private static IDaoOperation mockDaoOperation;
    private static Class<?> clazz;
    private static CarteBanquaire carteBanquaireExiste;
    private static CarteBanquaire carteBanquaireExistePas;
    private static String nomCarteExiste = "user";
    private static String numeroCarteExiste = "1111222233334444";
    private static String pictogrammeSecuriteCarteExiste = "123";
    private static String nomCarteExistePas = "userX";
    private static String numeroCarteExistePas = "1111222233334444X";
    private static String pictogrammeSecuriteCarteExistePas = "123X";
    
    private static CarteBanquaire carteBanquaire = new CarteBanquaire();
    private static CompteBanquaire compteBanquaire = new CompteBanquaire();

    private static CarteBanquaireDTO carteBanquaireSoldeOk;
    private static CarteBanquaireDTO carteBanquaireSoldePasOk;
    private static CompteBanquaire compteBanquaireSoldeOk;
    private static CompteBanquaire compteBanquaireSoldePasOk;

    public static void init_CarteBanquaireExiste() {

        carteBanquaireExiste = new CarteBanquaire();
        carteBanquaireExiste.setDateValidite(new Date());
        carteBanquaireExiste.setId(1);
        carteBanquaireExiste.setNom(nomCarteExiste);
        carteBanquaireExiste.setNumero(numeroCarteExiste);
        carteBanquaireExiste.setPictogrammeSecurite(pictogrammeSecuriteCarteExiste);

    }

    public static void init_CarteBanquaireExistePas() {

        carteBanquaireExistePas = null;

    }

    public static void init_CompteBanquaireSoldeOk() {
        carteBanquaireSoldeOk = new CarteBanquaireDTO();
        carteBanquaireSoldeOk.setNom(nomCarteExiste + " solde ok");
        carteBanquaireSoldeOk.setNumero(numeroCarteExiste);
        carteBanquaireSoldeOk.setPictogrammeSecurite(pictogrammeSecuriteCarteExiste);

        compteBanquaireSoldeOk = new CompteBanquaire();
        compteBanquaireSoldeOk.setSolde(1000);
    }

    public static void init_CompteBanquaireSoldePasOk() {
        carteBanquaireSoldePasOk = new CarteBanquaireDTO();
        carteBanquaireSoldePasOk.setNom(nomCarteExiste);
        carteBanquaireSoldePasOk.setNumero(numeroCarteExiste);
        carteBanquaireSoldePasOk.setPictogrammeSecurite(pictogrammeSecuriteCarteExiste);

        compteBanquaireSoldePasOk = new CompteBanquaire();
        compteBanquaireSoldePasOk.setSolde(0);
    }

    @BeforeClass
    public static void avantTousLesTests()
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        init_CarteBanquaireExiste();
        init_CarteBanquaireExistePas();
        init_CompteBanquaireSoldeOk();
        init_CompteBanquaireSoldePasOk();
        mockDaoCarte = EasyMock.createMock(IDaoCarteBanquaire.class);
        mockDaoCompte = EasyMock.createMock(IDaoCompte.class);
        EasyMock
                .expect(
                        mockDaoCarte.getByNomNumeroPictogramme(nomCarteExiste, numeroCarteExiste, pictogrammeSecuriteCarteExiste))
                .andReturn(carteBanquaireExiste);
        EasyMock.expect(mockDaoCarte.getByNomNumeroPictogramme(nomCarteExistePas, numeroCarteExistePas,
                pictogrammeSecuriteCarteExistePas)).andReturn(carteBanquaireExistePas);
        EasyMock.replay(mockDaoCarte);
        EasyMock.expect(mockDaoCompte.getCompteBanquaireByCarte(EasyMock.anyObject(CarteBanquaire.class)))
                .andReturn(compteBanquaireSoldeOk);
        EasyMock.expect(mockDaoCompte.getCompteBanquaireByCarte(EasyMock.anyObject(CarteBanquaire.class)))
                .andReturn(compteBanquaireSoldeOk);
        EasyMock.expect(mockDaoCompte.getCompteBanquaireByCarte(EasyMock.anyObject(CarteBanquaire.class)))
                .andReturn(compteBanquaireSoldeOk);
        EasyMock.expect(mockDaoCompte.getCompteBanquaireByCompte(EasyMock.anyObject(CompteBanquaire.class)))
                .andReturn(compteBanquaireSoldeOk);
        EasyMock.expect(mockDaoCompte.saveCompte(compteBanquaireSoldeOk)).andReturn(true);
        EasyMock.expect(mockDaoCompte.saveCompte(compteBanquaireSoldeOk)).andReturn(true);
        EasyMock.expect(mockDaoCompte.getCompteBanquaireByCarte(EasyMock.anyObject(CarteBanquaire.class)))
                .andReturn(compteBanquaireSoldeOk);
        EasyMock.expect(mockDaoCompte.getCompteBanquaireByCompte(EasyMock.anyObject(CompteBanquaire.class)))
                .andReturn(compteBanquaireSoldeOk);
        EasyMock.expect(mockDaoCompte.saveCompte(compteBanquaireSoldeOk)).andReturn(true);
        EasyMock.expect(mockDaoCompte.saveCompte(compteBanquaireSoldeOk)).andReturn(true);
        EasyMock.replay(mockDaoCompte);
        mockDaoOperation = EasyMock.createMock(IDaoOperation.class);
        EasyMock.expect(mockDaoOperation.saveOperation(EasyMock.anyObject(Operation.class))).andReturn(true);
        EasyMock.expect(mockDaoOperation.saveOperation(EasyMock.anyObject(Operation.class))).andReturn(true);
        EasyMock.replay(mockDaoOperation);
        service = new ServiceBanque();
        clazz = service.getClass();
        Field attDaoCarte = clazz.getDeclaredField("daoCarte");
        attDaoCarte.setAccessible(true);
        attDaoCarte.set(service, mockDaoCarte);
        Field attDaoCompte = clazz.getDeclaredField("daoCompte");
        attDaoCompte.setAccessible(true);
        attDaoCompte.set(service, mockDaoCompte);
        Field attDaoOperation = clazz.getDeclaredField("daoOperation");
        attDaoOperation.setAccessible(true);
        attDaoOperation.set(service, mockDaoOperation);
    }

    @AfterClass
    public static void apresTousLesTests() {
        EasyMock.verify(mockDaoCarte);
        EasyMock.verify(mockDaoCompte);
        EasyMock.verify(mockDaoOperation);
    }

    @Test
    public void testExiste() {
        CarteBanquaire carte = new CarteBanquaire();
        carte.setNom(nomCarteExiste);
        carte.setNumero(numeroCarteExiste);
        carte.setPictogrammeSecurite(pictogrammeSecuriteCarteExiste);
        Gson jsonCB = new Gson();
        String carteJson = jsonCB.toJson(carte);
        log.info(carteJson);
        Assert.assertTrue(service.existe(carteJson));
    }

    @Test
    public void testExistePas() {
        CarteBanquaire carte = new CarteBanquaire();
        carte.setNom(nomCarteExistePas);
        carte.setNumero(numeroCarteExistePas);
        carte.setPictogrammeSecurite(pictogrammeSecuriteCarteExistePas);
        Gson jsonCB = new Gson();
        String carteJson = jsonCB.toJson(carte);
        log.info(carteJson);
        Assert.assertFalse(service.existe(carteJson));
    }

    @Test
    public void testVerifierSolde() {
        Gson jsonCB = new Gson();
        String carteJson = jsonCB.toJson(carteBanquaireSoldeOk);
        log.info(carteJson);
        Assert.assertTrue(service.verifiersolde(10, carteJson));

    }

    @Test
    public void testVerifierSoldePasOk() {
        Gson jsonCB = new Gson();
        String carteJson = jsonCB.toJson(carteBanquaireSoldePasOk);
        log.info(carteJson);
        Assert.assertFalse(service.verifiersolde(10000, carteJson));

    }

    @Test
    public void testCreditCarte() {
        Gson jsonCB = new Gson();
        String carteACrediteJson = jsonCB.toJson(carteBanquaireSoldeOk);
        String compteADebiterJson = jsonCB.toJson(compteBanquaireSoldeOk);
        Assert.assertTrue(service.crediterCarte(200, carteACrediteJson, compteADebiterJson));
    }
    
    @Test
    public void testDebitCarte() {
        Gson jsonCB = new Gson();
        String carteADebiterJson = jsonCB.toJson(carteBanquaire);
        String compteACrediterJson = jsonCB.toJson(compteBanquaire);
        Assert.assertTrue(service.debiterCarte(200, carteADebiterJson, compteACrediterJson));
    }

}
