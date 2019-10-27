/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al30.airbrass.servicerest;

import fr.afcepf.al30.airbrass.serviceentities.Credentials;
import fr.afcepf.al30.airbrass.serviceentities.Utilisateur;
import fr.afcepf.al30.airbrass.business.api.IBusinessUtilisateur;
import fr.afcepf.al30.airbrass.dto.DTOAdresse;
import fr.afcepf.al30.airbrass.dto.DTOPays;
import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.dto.DTOVille;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.DaoException;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Response;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Max Michel
 */
public class ServiceUtilisateurTest {

    private static ServiceUtilisateur service;
    private static Class<?> clazz;

    private static IBusinessUtilisateur buUtilisateurMock;

    private static Credentials credNominal;
    private static DTOPersonne personneConnectNominal;

    private static Credentials credErreur;
    private static DaoException utilisateurInconnu;

    private static Utilisateur utilisateurNominal;
    private static List<DTOAdresse> utilisateurNominalAdresses;
    private static DTOAdresse utilisateurNominalAdresse;
    private static DTOVille utilisateurNominalVille;
    private static DTOPays utilisateurNominalPays;
    private static DTOPersonne personneNewUserNominal;

    private static Utilisateur utilisateurErreur;

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    public static void initEntity() throws ParseException {
        credNominal = new Credentials();
        credNominal.setLogin("seb@gmail.com");
        credNominal.setPassword("afcepf2016");
        personneConnectNominal = new DTOPersonne("nom", "prenom", new Date(), "seb@gmail.com", "telephone", "afcepf2016", null);
        credErreur = new Credentials();
        credErreur.setLogin("fauxLogin");
        credErreur.setPassword("fauxPasword");
        utilisateurInconnu = new DaoException(ExceptionEnum.UTILISATEUR_INCONNU, "Utilisateur iconnu");

        utilisateurNominal = new Utilisateur();
        utilisateurNominal.setNom("Michel");
        utilisateurNominal.setPrenom("Max");
        utilisateurNominal.setEmail("mao-mitch@hotmail.fr");
        utilisateurNominal.setMdp("Azerty12");
        utilisateurNominal.setMdpConfirm("Azerty12");
        utilisateurNominal.setNumRue("60");
        utilisateurNominal.setRue("Sadi Carnot");
        utilisateurNominal.setComplement("");
        utilisateurNominal.setDateNaissance("17/04/1991");
        utilisateurNominal.setCp("93300");
        utilisateurNominal.setVille("Auberviliers");
        utilisateurNominal.setTelephone("0649388804");

        utilisateurErreur = new Utilisateur();
        utilisateurErreur.setNom("Michel");
        utilisateurErreur.setPrenom("Max");
        utilisateurErreur.setEmail("mao-mitch@hotmail.fr");
        utilisateurErreur.setMdp("Azerty12");
        utilisateurErreur.setMdpConfirm("Azerty13");
        utilisateurErreur.setNumRue("60");
        utilisateurErreur.setRue("Sadi Carnot");
        utilisateurErreur.setComplement("");
        utilisateurErreur.setDateNaissance("17/04/1991");
        utilisateurErreur.setCp("93300");
        utilisateurErreur.setVille("Auberviliers");
        utilisateurErreur.setTelephone("0649388804");
        
        utilisateurNominalAdresses = new ArrayList<>();
        utilisateurNominalPays = new DTOPays("France");
        utilisateurNominalVille = new DTOVille(utilisateurNominal.getVille(), utilisateurNominal.getCp(), utilisateurNominalPays);
        utilisateurNominalAdresse = new DTOAdresse(Integer.parseInt(utilisateurNominal.getNumRue()), utilisateurNominal.getRue(), utilisateurNominal.getComplement(), utilisateurNominalVille);
        personneNewUserNominal = new DTOPersonne("Michel", "Max", SDF.parse("17/04/1991"), "mao-mitch@hotmail.fr", "0649388804", "Azerty12", utilisateurNominalAdresses);

    }

    public static void initBuUtilisateurMock() throws AirBrassException {
        buUtilisateurMock = EasyMock.createMock(IBusinessUtilisateur.class);
        EasyMock.expect(buUtilisateurMock.connectClient(credNominal.getLogin(), credNominal.getPassword())).andReturn(personneConnectNominal);
        EasyMock.expect(buUtilisateurMock.connectClient(credErreur.getLogin(), credErreur.getPassword())).andThrow(utilisateurInconnu);
        EasyMock.expect(buUtilisateurMock.createNewClient(EasyMock.anyObject(DTOPersonne.class))).andReturn(personneNewUserNominal);
        EasyMock.replay(buUtilisateurMock);
    }

    @BeforeClass
    public static void init() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, AirBrassException, ParseException {
        service = new ServiceUtilisateur();
        clazz = service.getClass();
        initEntity();
        initBuUtilisateurMock();
        Field attBuUtilisateur = clazz.getDeclaredField("buUtilisateur");
        attBuUtilisateur.setAccessible(true);
        attBuUtilisateur.set(service, buUtilisateurMock);
    }

    @Test
    public void connectNominal() {
        Response result = service.connect(credNominal);
        Assert.assertNotNull(result);
        Assert.assertEquals(201, result.getStatus());
        Assert.assertEquals(personneConnectNominal, result.getEntity());
    }

    @Test
    public void connectErreur() {
        Response result = service.connect(credErreur);
        Assert.assertNotNull(result);
        Assert.assertEquals(500, result.getStatus());
        Assert.assertEquals("utilisateur inconnu", result.getEntity());
    }

    @Test
    public void newUserNominal() {
        Response result = service.newUser(utilisateurNominal);
        Assert.assertNotNull(result);
        Assert.assertEquals(201, result.getStatus());
        Assert.assertEquals(personneNewUserNominal, result.getEntity());
    }

    @Test
    public void newUserErreurMotDePasse() {
        Response result = service.newUser(utilisateurErreur);
        Assert.assertNotNull(result);
        Assert.assertEquals(500, result.getStatus());
        Assert.assertEquals("Mot de passe et confirmation non égaux", result.getEntity());
    }
}
