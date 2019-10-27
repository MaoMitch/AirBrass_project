/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al30.airbrass.business.impl;

import fr.afcepf.al30.airbrass.business.api.IBusinessUtilisateur;
import fr.afcepf.al30.airbrass.dao.api.IDAOAdresse;
import fr.afcepf.al30.airbrass.dao.api.IDAOClient;
import fr.afcepf.al30.airbrass.dao.api.IDAOPays;
import fr.afcepf.al30.airbrass.dao.api.IDAOVille;
import fr.afcepf.al30.airbrass.dto.DTOAdresse;
import fr.afcepf.al30.airbrass.dto.DTOPays;
import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.dto.DTOVille;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.BusinessException;
import fr.afcepf.al30.airbrass.exceptions.DaoException;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Stagiaire
 */
public class BusinessUtilisateurTest {

    private static Logger log = Logger.getLogger(BusinessUtilisateurTest.class);

    private static IBusinessUtilisateur buUtilisateur;

    private static Class<?> clazz;

    private static IDAOClient daoClientMock;

    private static IDAOPays daoPaysMock;

    private static IDAOVille daoVilleMock;

    private static IDAOAdresse daoAdresseMock;

    private static DTOPersonne excpectedGetByIdNominal;
    
    private static DTOPersonne clientNominal;

    private static DTOPersonne clientExist;

    private static final int ID_NEW_CLIENT_RETURN = 12;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    private static DTOPersonne clientDontExistAdresseExist;
    private static DTOPersonne majClient;
    private static DTOPersonne newClientReturnAdresseExist;
    private static DTOPersonne clientDontExistAdresseDontExistVilleExistPaysExist;
    private static DTOPersonne newClientReturnAdresseDontExistVilleExistPaysExist;
    private static DTOPersonne clientDontExistAdresseDontExistVilleDontExistPaysExist;
    private static DTOPersonne newClientReturnAdresseDontExistVilleDontExistPaysExist;
    private static DTOPersonne clientDontExistAdresseDontExistVilleDontExistPaysDontExist;
    private static DTOPersonne newClientReturnAdresseDontExistVilleDontExistPaysDontExist;

    private static final int ID_PAYS_EXIST = 4;
    private static DTOPays paysExistFromAdresseExistVilleExiste;
    private static DTOPays paysExistFromAdresseExistVilleExisteReturn;
    private static final int ID_VILLE_EXIST = 52;
    private static DTOVille villeExistPaysExistFromAdresseExist;
    private static DTOVille villeExistPaysExistFromAdresseExistReturn;
    private static final int ID_ADRESSE_EXIST = 12;
    private static DTOAdresse adresseExist;
    private static DTOAdresse adresseExistReturn;

    private static DTOPays paysExistFromAdresseDontExistVilleExiste;
    private static DTOPays paysExistFromAdresseDontExistVilleExisteReturn;
    private static DTOVille villeExistPaysExistFromAdresseDontExist;
    private static DTOVille villeExistPaysExistFromAdresseDontExistReturn;
    private static final int ID_ADRESSE_DONT_EXIST = 12;
    private static DTOAdresse adresseDontExistVilleExistPaysExist;
    private static DTOAdresse adresseDontExistVilleExistPaysExistReturn;

    private static DTOPays paysExistFromAdresseDontExistVilleDontExiste;
    private static DTOPays paysExistFromAdresseDontExistVilleDontExisteReturn;
    private static final int ID_VILLE_DONT_EXIST = 85;
    private static DTOVille villeDontExistPaysExistFromAdresseDontExist;
    private static DTOVille villeDontExistPaysExistFromAdresseDontExistReturn;
    private static final int ID_ADRESSE_DONT_EXIST_VILLE_DONT_EXIST = 254;
    private static DTOAdresse adresseDontExistVilleDontExistPaysExist;
    private static DTOAdresse adresseDontExistVilleDontExistPaysExistReturn;

    private static final int ID_PAYS_DONT_EXIST = 125;
    private static DTOPays paysDontExistFromAdresseDontExistVilleDontExiste;
    private static DTOPays paysDontExistFromAdresseDontExistVilleDontExisteReturn;
    private static final int ID_VILLE_DONT_EXIST_PAYS_DONT_EXIST = 456;
    private static DTOVille villeDontExistPaysDontExistFromAdresseDontExist;
    private static DTOVille villeDontExistPaysDontExistFromAdresseDontExistReturn;
    private static final int ID_ADRESSE_DONT_EXIST_VILLE_DONT_EXIST_PAYS_DONT_EXIST = 3654;
    private static DTOAdresse adresseDontExistVilleDontExistPaysDontExist;
    private static DTOAdresse adresseDontExistVilleDontExistPaysDontExistReturn;
    
    private static DTOPersonne clientAdresseNull;

    private static void initEntity() throws ParseException {
        excpectedGetByIdNominal = new DTOPersonne("Hartman", "Thaddeus", SDF.parse("08/06/1986"), "seb@gmail.com", "9fa265492b6b6e31342aab95a571abd34bd50cc6f4a392601449f50c33b2cf27207a269e5508cbcc497d09ed5fa9ffc6ce092bc62220b8d064ece0a84eaaedb6", "03 12 73 60 31", null);
        clientNominal = new DTOPersonne("Hartman", "Thaddeus", SDF.parse("08/06/1986"), "seb@gmail.com", "9fa265492b6b6e31342aab95a571abd34bd50cc6f4a392601449f50c33b2cf27207a269e5508cbcc497d09ed5fa9ffc6ce092bc62220b8d064ece0a84eaaedb6", "03 12 73 60 31", null);
        paysExistFromAdresseExistVilleExiste = new DTOPays("France");
        paysExistFromAdresseExistVilleExisteReturn = new DTOPays("France");
        paysExistFromAdresseExistVilleExisteReturn.setId(ID_PAYS_EXIST);
        villeExistPaysExistFromAdresseExist = new DTOVille("Aubervilliers", "93300", paysExistFromAdresseExistVilleExiste);
        villeExistPaysExistFromAdresseExistReturn = new DTOVille("Aubervilliers", "93300", paysExistFromAdresseExistVilleExisteReturn);
        villeExistPaysExistFromAdresseExistReturn.setId(ID_VILLE_EXIST);
        adresseExist = new DTOAdresse(60, "Sadi Carnot", "", villeExistPaysExistFromAdresseExist);
        adresseExistReturn = new DTOAdresse(60, "Sadi Carnot", "", villeExistPaysExistFromAdresseExistReturn);
        adresseExistReturn.setId(ID_ADRESSE_EXIST);

        paysExistFromAdresseDontExistVilleExiste = new DTOPays("France");
        paysExistFromAdresseDontExistVilleExisteReturn = new DTOPays("France");
        paysExistFromAdresseDontExistVilleExisteReturn.setId(ID_PAYS_EXIST);
        villeExistPaysExistFromAdresseDontExist = new DTOVille("Aubervilliers", "93300", paysExistFromAdresseDontExistVilleExiste);
        villeExistPaysExistFromAdresseDontExistReturn = new DTOVille("Aubervilliers", "93300", paysExistFromAdresseDontExistVilleExisteReturn);
        villeExistPaysExistFromAdresseDontExistReturn.setId(ID_VILLE_EXIST);
        adresseDontExistVilleExistPaysExist = new DTOAdresse(42, "Des Ecoles", "", villeExistPaysExistFromAdresseDontExist);
        adresseDontExistVilleExistPaysExistReturn = new DTOAdresse(42, "Des Ecoles", "", villeExistPaysExistFromAdresseDontExistReturn);
        adresseDontExistVilleExistPaysExistReturn.setId(ID_ADRESSE_DONT_EXIST);

        paysExistFromAdresseDontExistVilleDontExiste = new DTOPays("France");
        paysExistFromAdresseDontExistVilleDontExisteReturn = new DTOPays("France");
        paysExistFromAdresseDontExistVilleDontExisteReturn.setId(ID_PAYS_EXIST);
        villeDontExistPaysExistFromAdresseDontExist = new DTOVille("Gignac", "34150", paysExistFromAdresseDontExistVilleDontExiste);
        villeDontExistPaysExistFromAdresseDontExistReturn = new DTOVille("Gignac", "34150", paysExistFromAdresseDontExistVilleDontExisteReturn);
        villeDontExistPaysExistFromAdresseDontExistReturn.setId(ID_VILLE_DONT_EXIST);
        adresseDontExistVilleDontExistPaysExist = new DTOAdresse(39, "Saint Michel", "", villeDontExistPaysExistFromAdresseDontExist);
        adresseDontExistVilleDontExistPaysExistReturn = new DTOAdresse(39, "Saint Michel", "", villeDontExistPaysExistFromAdresseDontExistReturn);
        adresseDontExistVilleDontExistPaysExistReturn.setId(ID_ADRESSE_DONT_EXIST_VILLE_DONT_EXIST);

        paysDontExistFromAdresseDontExistVilleDontExiste = new DTOPays("Autriche");
        paysDontExistFromAdresseDontExistVilleDontExisteReturn = new DTOPays("Autriche");
        paysDontExistFromAdresseDontExistVilleDontExisteReturn.setId(ID_PAYS_DONT_EXIST);
        villeDontExistPaysDontExistFromAdresseDontExist = new DTOVille("Innsbruck", "A-6010 - A-6080", paysDontExistFromAdresseDontExistVilleDontExiste);
        villeDontExistPaysDontExistFromAdresseDontExistReturn = new DTOVille("Innsbruck", "A-6010 - A-6080", paysDontExistFromAdresseDontExistVilleDontExisteReturn);
        villeDontExistPaysDontExistFromAdresseDontExistReturn.setId(ID_VILLE_DONT_EXIST_PAYS_DONT_EXIST);
        adresseDontExistVilleDontExistPaysDontExist = new DTOAdresse(25, "Dont know", "", villeDontExistPaysDontExistFromAdresseDontExist);
        adresseDontExistVilleDontExistPaysDontExistReturn = new DTOAdresse(25, "Dont know", "", villeDontExistPaysDontExistFromAdresseDontExistReturn);
        adresseDontExistVilleDontExistPaysDontExistReturn.setId(ID_ADRESSE_DONT_EXIST_VILLE_DONT_EXIST_PAYS_DONT_EXIST);

        clientExist = new DTOPersonne("Hartman", "Thaddeus", SDF.parse("08/06/1986"), "seb@gmail.com", "9fa265492b6b6e31342aab95a571abd34bd50cc6f4a392601449f50c33b2cf27207a269e5508cbcc497d09ed5fa9ffc6ce092bc62220b8d064ece0a84eaaedb6", "03 12 73 60 31", null);

        clientDontExistAdresseExist = new DTOPersonne("Michel", "Max", SDF.parse("17/04/1991"), "mao-mitch@hotmail.fr", "0649388804", "Azerty12", null);
        clientDontExistAdresseExist.setDtoAdresses(new ArrayList<>());
        clientDontExistAdresseExist.getDtoAdresses().add(adresseExist);
        majClient = new DTOPersonne("Michel", "Max", SDF.parse("17/04/1991"), "mao-mitch@hotmail.fr", "0649388804", "Azerty12", null);
        majClient.setDtoAdresses(new ArrayList<>());
        majClient.getDtoAdresses().add(adresseExist);
        newClientReturnAdresseExist = new DTOPersonne("Michel", "Max", SDF.parse("17/04/1991"), "mao-mitch@hotmail.fr", "0649388804", "Azerty12", null);
        newClientReturnAdresseExist.setDtoAdresses(new ArrayList<>());
        newClientReturnAdresseExist.getDtoAdresses().add(adresseExistReturn);
        newClientReturnAdresseExist.setId(ID_NEW_CLIENT_RETURN);

        clientDontExistAdresseDontExistVilleExistPaysExist = new DTOPersonne("Michel", "Max", SDF.parse("17/04/1991"), "mao-mitch@hotmail.fr", "0649388804", "Azerty12", null);
        clientDontExistAdresseDontExistVilleExistPaysExist.setDtoAdresses(new ArrayList<>());
        clientDontExistAdresseDontExistVilleExistPaysExist.getDtoAdresses().add(adresseDontExistVilleExistPaysExist);
        newClientReturnAdresseDontExistVilleExistPaysExist = new DTOPersonne("Michel", "Max", SDF.parse("17/04/1991"), "mao-mitch@hotmail.fr", "0649388804", "Azerty12", null);
        newClientReturnAdresseDontExistVilleExistPaysExist.setDtoAdresses(new ArrayList<>());
        newClientReturnAdresseDontExistVilleExistPaysExist.getDtoAdresses().add(adresseDontExistVilleExistPaysExistReturn);
        newClientReturnAdresseDontExistVilleExistPaysExist.setId(ID_NEW_CLIENT_RETURN);

        clientDontExistAdresseDontExistVilleDontExistPaysExist = new DTOPersonne("Michel", "Max", SDF.parse("17/04/1991"), "mao-mitch@hotmail.fr", "0649388804", "Azerty12", null);
        clientDontExistAdresseDontExistVilleDontExistPaysExist.setDtoAdresses(new ArrayList<>());
        clientDontExistAdresseDontExistVilleDontExistPaysExist.getDtoAdresses().add(adresseDontExistVilleDontExistPaysExist);
        newClientReturnAdresseDontExistVilleDontExistPaysExist = new DTOPersonne("Michel", "Max", SDF.parse("17/04/1991"), "mao-mitch@hotmail.fr", "0649388804", "Azerty12", null);
        newClientReturnAdresseDontExistVilleDontExistPaysExist.setDtoAdresses(new ArrayList<>());
        newClientReturnAdresseDontExistVilleDontExistPaysExist.getDtoAdresses().add(adresseDontExistVilleDontExistPaysExistReturn);
        newClientReturnAdresseDontExistVilleDontExistPaysExist.setId(ID_NEW_CLIENT_RETURN);

        clientDontExistAdresseDontExistVilleDontExistPaysDontExist = new DTOPersonne("Michel", "Max", SDF.parse("17/04/1991"), "mao-mitch@hotmail.fr", "0649388804", "Azerty12", null);
        clientDontExistAdresseDontExistVilleDontExistPaysDontExist.setDtoAdresses(new ArrayList<>());
        clientDontExistAdresseDontExistVilleDontExistPaysDontExist.getDtoAdresses().add(adresseDontExistVilleDontExistPaysDontExist);
        newClientReturnAdresseDontExistVilleDontExistPaysDontExist = new DTOPersonne("Michel", "Max", SDF.parse("17/04/1991"), "mao-mitch@hotmail.fr", "0649388804", "Azerty12", null);
        newClientReturnAdresseDontExistVilleDontExistPaysDontExist.setDtoAdresses(new ArrayList<>());
        newClientReturnAdresseDontExistVilleDontExistPaysDontExist.getDtoAdresses().add(adresseDontExistVilleDontExistPaysDontExistReturn);
        newClientReturnAdresseDontExistVilleDontExistPaysDontExist.setId(ID_NEW_CLIENT_RETURN);
        
        clientAdresseNull = new DTOPersonne("Michel", "Max", SDF.parse("17/04/1991"), "mao-mitch@hotmail.fr", "0649388804", "Azerty12", null);
        clientAdresseNull.setDtoAdresses(null);
    }

    public static void initDaoClient() throws AirBrassException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        daoClientMock = EasyMock.createMock(IDAOClient.class);
        EasyMock.expect(daoClientMock.getClientById(GET_CLIENT_BY_ID_NOMINAL_ID)).andReturn(excpectedGetByIdNominal);
        EasyMock.expect(daoClientMock.getClientById(GET_CLIENT_BY_ID_NOTFOUND_ID)).andThrow(new DaoException(ExceptionEnum.AUCUN_RESULTAT, "Utilisateur non trouvé"));
        EasyMock.expect(daoClientMock.connectClient(LOGIN_NOMINAL, PASSWORD_NOMINAL)).andReturn(clientNominal);
        EasyMock.expect(daoClientMock.connectClient(LOGIN_INCONNU, PASSWORD_INCONNU)).andThrow(new DaoException(ExceptionEnum.UTILISATEUR_INCONNU, "Utilisateur inconnu"));
        
        EasyMock.expect(daoClientMock.clientDontExist("mao-mitch@hotmail.fr")).andReturn(Boolean.TRUE);
        EasyMock.expect(daoClientMock.clientDontExist("mao-mitch@hotmail.fr")).andReturn(Boolean.TRUE);
        EasyMock.expect(daoClientMock.clientDontExist("mao-mitch@hotmail.fr")).andReturn(Boolean.TRUE);
        EasyMock.expect(daoClientMock.clientDontExist("mao-mitch@hotmail.fr")).andReturn(Boolean.TRUE);
        EasyMock.expect(daoClientMock.clientDontExist("seb@gmail.com")).andReturn(Boolean.FALSE);
        EasyMock.expect(daoClientMock.saveClient(clientDontExistAdresseExist)).andReturn(newClientReturnAdresseExist);
        EasyMock.expect(daoClientMock.saveClient(majClient)).andReturn(newClientReturnAdresseExist);
        EasyMock.expect(daoClientMock.saveClient(clientAdresseNull)).andReturn(clientAdresseNull);
        EasyMock.expect(daoClientMock.saveClient(clientDontExistAdresseDontExistVilleExistPaysExist)).andReturn(newClientReturnAdresseDontExistVilleExistPaysExist);
        EasyMock.expect(daoClientMock.saveClient(clientDontExistAdresseDontExistVilleDontExistPaysExist)).andReturn(newClientReturnAdresseDontExistVilleDontExistPaysExist);
        EasyMock.expect(daoClientMock.saveClient(clientDontExistAdresseDontExistVilleDontExistPaysDontExist)).andReturn(newClientReturnAdresseDontExistVilleDontExistPaysDontExist);
        Field attDaoClient = clazz.getDeclaredField("daoClient");
        attDaoClient.setAccessible(true);
        attDaoClient.set(buUtilisateur, daoClientMock);
    }

    public static void initDaoPays() throws AirBrassException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        daoPaysMock = EasyMock.createMock(IDAOPays.class);
        EasyMock.expect(daoPaysMock.paysExist(paysExistFromAdresseExistVilleExiste)).andReturn(Boolean.TRUE);
        EasyMock.expect(daoPaysMock.paysExist(paysExistFromAdresseExistVilleExiste)).andReturn(Boolean.TRUE);
        EasyMock.expect(daoPaysMock.paysExist(paysExistFromAdresseDontExistVilleExiste)).andReturn(Boolean.TRUE);
        EasyMock.expect(daoPaysMock.paysExist(paysExistFromAdresseDontExistVilleDontExiste)).andReturn(Boolean.TRUE);
        EasyMock.expect(daoPaysMock.paysExist(paysDontExistFromAdresseDontExistVilleDontExiste)).andReturn(Boolean.FALSE);
        EasyMock.expect(daoPaysMock.getPays(paysExistFromAdresseExistVilleExiste)).andReturn(paysExistFromAdresseExistVilleExiste);
        EasyMock.expect(daoPaysMock.getPays(paysExistFromAdresseExistVilleExiste)).andReturn(paysExistFromAdresseExistVilleExiste);
        EasyMock.expect(daoPaysMock.getPays(paysExistFromAdresseDontExistVilleExiste)).andReturn(paysExistFromAdresseDontExistVilleExiste);
        EasyMock.expect(daoPaysMock.getPays(paysExistFromAdresseDontExistVilleDontExiste)).andReturn(paysExistFromAdresseDontExistVilleDontExiste);
        EasyMock.expect(daoPaysMock.addPays(paysDontExistFromAdresseDontExistVilleDontExiste)).andReturn(paysDontExistFromAdresseDontExistVilleDontExiste);
        Field attDaoPays = clazz.getDeclaredField("daoPays");
        attDaoPays.setAccessible(true);
        attDaoPays.set(buUtilisateur, daoPaysMock);
    }

    public static void initDaoVille() throws AirBrassException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        daoVilleMock = EasyMock.createMock(IDAOVille.class);
        EasyMock.expect(daoVilleMock.villeExist(villeExistPaysExistFromAdresseExist)).andReturn(Boolean.TRUE);
        EasyMock.expect(daoVilleMock.villeExist(villeExistPaysExistFromAdresseExist)).andReturn(Boolean.TRUE);
        EasyMock.expect(daoVilleMock.villeExist(villeExistPaysExistFromAdresseDontExist)).andReturn(Boolean.TRUE);
        EasyMock.expect(daoVilleMock.villeExist(villeDontExistPaysExistFromAdresseDontExist)).andReturn(Boolean.FALSE);
        EasyMock.expect(daoVilleMock.villeExist(villeDontExistPaysDontExistFromAdresseDontExist)).andReturn(Boolean.FALSE);
        EasyMock.expect(daoVilleMock.getVille(villeExistPaysExistFromAdresseExist)).andReturn(villeExistPaysExistFromAdresseExist);
        EasyMock.expect(daoVilleMock.getVille(villeExistPaysExistFromAdresseExist)).andReturn(villeExistPaysExistFromAdresseExist);
        EasyMock.expect(daoVilleMock.getVille(villeExistPaysExistFromAdresseDontExist)).andReturn(villeExistPaysExistFromAdresseDontExist);
        EasyMock.expect(daoVilleMock.addVille(villeDontExistPaysExistFromAdresseDontExist)).andReturn(villeDontExistPaysExistFromAdresseDontExist);
        EasyMock.expect(daoVilleMock.addVille(villeDontExistPaysDontExistFromAdresseDontExist)).andReturn(villeDontExistPaysDontExistFromAdresseDontExist);
        Field attDaoVille = clazz.getDeclaredField("daoVille");
        attDaoVille.setAccessible(true);
        attDaoVille.set(buUtilisateur, daoVilleMock);
    }

    public static void initDaoAdresse() throws AirBrassException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        daoAdresseMock = EasyMock.createMock(IDAOAdresse.class);
        EasyMock.expect(daoAdresseMock.adresseExist(adresseExist)).andReturn(Boolean.TRUE);
        EasyMock.expect(daoAdresseMock.adresseExist(adresseExist)).andReturn(Boolean.TRUE);
        EasyMock.expect(daoAdresseMock.adresseExist(adresseDontExistVilleExistPaysExist)).andReturn(Boolean.FALSE);
        EasyMock.expect(daoAdresseMock.adresseExist(adresseDontExistVilleDontExistPaysExist)).andReturn(Boolean.FALSE);
        EasyMock.expect(daoAdresseMock.adresseExist(adresseDontExistVilleDontExistPaysDontExist)).andReturn(Boolean.FALSE);
        EasyMock.expect(daoAdresseMock.getAdresse(adresseExist)).andReturn(adresseExist);
        EasyMock.expect(daoAdresseMock.getAdresse(adresseExist)).andReturn(adresseExist);
        EasyMock.expect(daoAdresseMock.createNewAdresse(adresseDontExistVilleExistPaysExist)).andReturn(adresseDontExistVilleExistPaysExist);
        EasyMock.expect(daoAdresseMock.createNewAdresse(adresseDontExistVilleDontExistPaysExist)).andReturn(adresseDontExistVilleDontExistPaysExist);
        EasyMock.expect(daoAdresseMock.createNewAdresse(adresseDontExistVilleDontExistPaysDontExist)).andReturn(adresseDontExistVilleDontExistPaysDontExist);
        Field attDaoAdresse = clazz.getDeclaredField("daoAdresse");
        attDaoAdresse.setAccessible(true);
        attDaoAdresse.set(buUtilisateur, daoAdresseMock);
    }

    @BeforeClass
    public static void init() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, AirBrassException {

        buUtilisateur = new BusinessUtilisateur();
        clazz = buUtilisateur.getClass();

        initEntity();
        initDaoClient();
        initDaoPays();
        initDaoVille();
        initDaoAdresse();

        EasyMock.replay(daoClientMock, daoPaysMock, daoVilleMock, daoAdresseMock);
    }

    @AfterClass
    public static void tearDown() {
        EasyMock.verify(daoClientMock, daoPaysMock, daoVilleMock, daoAdresseMock);
    }
    private final static int GET_CLIENT_BY_ID_NOMINAL_ID = 1;

    @Test
    public void getClientByIdNominal() {
        try {
            DTOPersonne result = buUtilisateur.getClientById(GET_CLIENT_BY_ID_NOMINAL_ID);
            Assert.assertEquals(excpectedGetByIdNominal, result);
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    private final static int GET_CLIENT_BY_ID_NOTFOUND_ID = 12;

    @Test
    public void getClientByIdNotFound() {
        try {
            buUtilisateur.getClientById(GET_CLIENT_BY_ID_NOTFOUND_ID);
            Assert.fail("Ne devrais pas fonctionner");
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.assertEquals(ex.getCodeErreur(), ExceptionEnum.AUCUN_RESULTAT);
        }
    }

    @Test
    public void createNewClientNominalAdresseExist() {
        try {
            DTOPersonne result = buUtilisateur.createNewClient(clientDontExistAdresseExist);
            Assert.assertNotNull(result);
            Assert.assertNotNull(result.getId());
            Assert.assertEquals(result.getId(), newClientReturnAdresseExist.getId());
            Assert.assertEquals(result.getNom(), newClientReturnAdresseExist.getNom());
            Assert.assertEquals(result.getPrenom(), newClientReturnAdresseExist.getPrenom());
            Assert.assertEquals(result.getAdresseMail(), newClientReturnAdresseExist.getAdresseMail());
            Assert.assertNotNull(result.getDtoAdresses());
            Assert.assertEquals(result.getDtoAdresses().get(0), adresseExistReturn);
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
        }
    }
    
    @Test
    public void MajClient() {
        try {
            DTOPersonne result = buUtilisateur.udapteClient(majClient);
            Assert.assertNotNull(result);
            Assert.assertNotNull(result.getId());
            Assert.assertEquals(result.getId(), newClientReturnAdresseExist.getId());
            Assert.assertEquals(result.getNom(), newClientReturnAdresseExist.getNom());
            Assert.assertEquals(result.getPrenom(), newClientReturnAdresseExist.getPrenom());
            Assert.assertEquals(result.getAdresseMail(), newClientReturnAdresseExist.getAdresseMail());
            Assert.assertNotNull(result.getDtoAdresses());
            Assert.assertEquals(result.getDtoAdresses().get(0), adresseExistReturn);
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
        }
    }
    
    @Test
    public void NewClientAdresseNulle() {
        try {
            DTOPersonne result = buUtilisateur.udapteClient(clientAdresseNull);
            Assert.assertNotNull(result);
            Assert.assertNotNull(result.getId());
            Assert.assertEquals(result.getId(), clientAdresseNull.getId());
            Assert.assertEquals(result.getNom(), clientAdresseNull.getNom());
            Assert.assertEquals(result.getPrenom(), clientAdresseNull.getPrenom());
            Assert.assertEquals(result.getAdresseMail(), clientAdresseNull.getAdresseMail());
            Assert.assertTrue(result.getDtoAdresses().isEmpty());
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
        }
    }

    @Test
    public void createNewClientNominalAdresseDontExistVilleExistPaysExist() {
        try {
            DTOPersonne result = buUtilisateur.createNewClient(clientDontExistAdresseDontExistVilleExistPaysExist);
            Assert.assertNotNull(result);
            Assert.assertNotNull(result.getId());
            Assert.assertEquals(result.getId(), newClientReturnAdresseDontExistVilleExistPaysExist.getId());
            Assert.assertEquals(result.getNom(), newClientReturnAdresseDontExistVilleExistPaysExist.getNom());
            Assert.assertEquals(result.getPrenom(), newClientReturnAdresseDontExistVilleExistPaysExist.getPrenom());
            Assert.assertEquals(result.getAdresseMail(), newClientReturnAdresseDontExistVilleExistPaysExist.getAdresseMail());
            Assert.assertNotNull(result.getDtoAdresses());
            Assert.assertEquals(result.getDtoAdresses().get(0), adresseDontExistVilleExistPaysExistReturn);
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
        }
    }

    @Test
    public void createNewClientNominalAdresseDontExistVilleDontExistPaysExist() {
        try {
            DTOPersonne result = buUtilisateur.createNewClient(clientDontExistAdresseDontExistVilleDontExistPaysExist);
            Assert.assertNotNull(result);
            Assert.assertNotNull(result.getId());
            Assert.assertEquals(result.getId(), newClientReturnAdresseDontExistVilleDontExistPaysExist.getId());
            Assert.assertEquals(result.getNom(), newClientReturnAdresseDontExistVilleDontExistPaysExist.getNom());
            Assert.assertEquals(result.getPrenom(), newClientReturnAdresseDontExistVilleDontExistPaysExist.getPrenom());
            Assert.assertEquals(result.getAdresseMail(), newClientReturnAdresseDontExistVilleDontExistPaysExist.getAdresseMail());
            Assert.assertNotNull(result.getDtoAdresses());
            Assert.assertEquals(result.getDtoAdresses().get(0), adresseDontExistVilleDontExistPaysExistReturn);
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
        }
    }

    @Test
    public void createNewClientNominalAdresseDontExistVilleDontExistPaysDontExist() {
        try {
            DTOPersonne result = buUtilisateur.createNewClient(clientDontExistAdresseDontExistVilleDontExistPaysDontExist);
            Assert.assertNotNull(result);
            Assert.assertNotNull(result.getId());
            Assert.assertEquals(result.getId(), newClientReturnAdresseDontExistVilleDontExistPaysDontExist.getId());
            Assert.assertEquals(result.getNom(), newClientReturnAdresseDontExistVilleDontExistPaysDontExist.getNom());
            Assert.assertEquals(result.getPrenom(), newClientReturnAdresseDontExistVilleDontExistPaysDontExist.getPrenom());
            Assert.assertEquals(result.getAdresseMail(), newClientReturnAdresseDontExistVilleDontExistPaysDontExist.getAdresseMail());
            Assert.assertNotNull(result.getDtoAdresses());
            Assert.assertEquals(result.getDtoAdresses().get(0), adresseDontExistVilleDontExistPaysDontExistReturn);
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
        }
    }

    @Test
    public void createNewClientExisteDeja() {
        try {
            buUtilisateur.createNewClient(clientExist);
            Assert.fail("Ne devrais pas fonctionner");
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.assertEquals(ex.getCodeErreur(), ExceptionEnum.UTILISATEUR_DEJA_ENREGISTRER);
        }
    }

    private static final String LOGIN_NOMINAL = "seb@gmail.com";
    private static final String PASSWORD_NOMINAL = "afcepf2016";

    @Test
    public void connectNominal() {
        try {
            DTOPersonne result = buUtilisateur.connectClient(LOGIN_NOMINAL, PASSWORD_NOMINAL);
            Assert.assertNotNull(result);
            Assert.assertEquals(clientNominal, result);
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.fail();
        }
    }

    private static final String LOGIN_INCONNU = "truc@gmail.com";
    private static final String PASSWORD_INCONNU = "Azerty12";

    @Test
    public void connectInconnu() {
        try {
            buUtilisateur.connectClient(LOGIN_INCONNU, PASSWORD_INCONNU);
            Assert.fail("Ne devrais pas fonctionner");
        } catch (AirBrassException ex) {
            log.error("CODE ERREUR : " + ex.getCodeErreur() + " MESSAGE : " + ex.getMessage());
            Assert.assertEquals(ExceptionEnum.UTILISATEUR_INCONNU, ex.getCodeErreur());
        }
    }
}
