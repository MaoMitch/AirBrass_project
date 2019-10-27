/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al30.business;

import fr.afcepf.al30.assembleur.AssembleurDTO;
import fr.afcepf.al30.data.IDaoFormateur;
import fr.afcepf.al30.data.IDaoFormation;
import fr.afcepf.al30.dto.FormateurDTO;
import fr.afcepf.al30.dto.FormationDTO;
import fr.afcepf.al30.entity.Disponibilite;
import fr.afcepf.al30.entity.Formation;
import fr.afcepf.al30.entity.Niveau;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author Max Michel
 */
public class ServiceGestionFormationTest {

    private static Logger log = Logger.getLogger(ServiceGestionFormationTest.class);
    private static ServiceGestionFormation service;
    private static Class<?> clazz;

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    private static IDaoFormation mockDaoFormation;
    private static IDaoFormateur mockDaoFormateur;

    private static final String DATE_SELECTION = "19/05/2017";
    private static final String AUTRE_DATE = "20/05/2017";

    private static List<FormationDTO> resultGetAllFormation;
    private static FormationDTO formation1;
    private static FormationDTO formation2;
    private static FormationDTO formation3;

    private static Formation searchFormation;

    private static List<FormationDTO> resultGetFormations;

    private static List<FormateurDTO> resultGetAllFormateur;
    private static FormateurDTO formateur1;
    private static FormateurDTO formateur2;
    private static FormateurDTO formateur3;

    private static Date dateSelection;

    private static List<FormationDTO> resultParDateDispo;

    private static Formation formationDispo;

    public static void init_daoFormation() throws ParseException {
        mockDaoFormation = EasyMock.createMock(IDaoFormation.class);
        resultGetAllFormation = new ArrayList<>();
        formation1 = new FormationDTO();
        formation1.setId(1);
        formation1.setDate(SDF.parse(DATE_SELECTION));
        formation1.setDisponibilite(Disponibilite.DISPONIBLE);
        formation1.setFormateur(formateur1);
        formation1.setIntitule("formation1");
        formation1.setNiveau(Niveau.DEBUTANT);
        formation1.setPrix(50.5);
        formation2 = new FormationDTO();
        formation2.setId(2);
        formation2.setDate(SDF.parse(DATE_SELECTION));
        formation2.setDisponibilite(Disponibilite.RESERVE);
        formation2.setFormateur(formateur2);
        formation2.setIntitule("formation2");
        formation2.setNiveau(Niveau.DEBUTANT);
        formation2.setPrix(50d);
        formation3 = new FormationDTO();
        formation3.setId(3);
        formation3.setDate(SDF.parse(AUTRE_DATE));
        formation3.setDisponibilite(Disponibilite.DISPONIBLE);
        formation3.setFormateur(formateur3);
        formation3.setIntitule("formation3");
        formation3.setNiveau(Niveau.DEBUTANT);
        formation3.setPrix(50d);
        resultGetAllFormation.add(formation1);
        resultGetAllFormation.add(formation2);
        resultGetAllFormation.add(formation3);
        EasyMock.expect(mockDaoFormation.getAll()).andReturn(resultGetAllFormation);

        searchFormation = new Formation();
        searchFormation.setPrix(50d);

        resultGetFormations = new ArrayList<>();
        resultGetFormations.add(formation2);
        resultGetFormations.add(formation3);

        EasyMock.expect(mockDaoFormation.getFormations(searchFormation, false)).andReturn(resultGetFormations);

        dateSelection = SDF.parse(DATE_SELECTION);
        resultParDateDispo = new ArrayList<>();
        resultParDateDispo.add(formation1);

        EasyMock.expect(mockDaoFormation.getDisposByDate(dateSelection, true)).andReturn(resultParDateDispo);

        EasyMock.expect(mockDaoFormation.getFormationById(1)).andReturn(formation1);

        formationDispo = AssembleurDTO.dtoToEntity(formation1);
        EasyMock.expect(mockDaoFormation.verifierDispoFormation(formationDispo)).andReturn(Boolean.TRUE);
        
        EasyMock.expect(mockDaoFormation.reserverFormation(formation1)).andReturn(formation1);

    }

    public static void init_daoFormateur() {
        mockDaoFormateur = EasyMock.createMock(IDaoFormateur.class);
        resultGetAllFormateur = new ArrayList<>();
        formateur1 = new FormateurDTO();
        formateur1.setId(1);
        formateur1.setNom("formateur1");
        formateur2 = new FormateurDTO();
        formateur2.setId(2);
        formateur2.setNom("formateur2");
        formateur3 = new FormateurDTO();
        formateur3.setId(3);
        formateur3.setNom("formateur3");
        resultGetAllFormateur.add(formateur1);
        resultGetAllFormateur.add(formateur2);
        resultGetAllFormateur.add(formateur2);

        EasyMock.expect(mockDaoFormateur.getAll()).andReturn(resultGetAllFormateur);
    }

    @BeforeClass
    public static void setUpClass() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException {
        init_daoFormateur();
        init_daoFormation();
        EasyMock.replay(mockDaoFormation, mockDaoFormateur);
        service = new ServiceGestionFormation();
        clazz = service.getClass();
        Field attDaoFormation = clazz.getDeclaredField("daoFormation");
        attDaoFormation.setAccessible(true);
        attDaoFormation.set(service, mockDaoFormation);
        Field attDaoFormateur = clazz.getDeclaredField("daoFormateur");
        attDaoFormateur.setAccessible(true);
        attDaoFormateur.set(service, mockDaoFormateur);

    }

    @AfterClass
    public static void tearDownClass() {
        EasyMock.verify(mockDaoFormateur, mockDaoFormation);
    }

    @Test
    public void testGetAllFormations() {
        log.info("getAllFormations");
        List<FormationDTO> result = service.getAllFormations();
        Assert.assertEquals(resultGetAllFormation, result);
    }

    @Test
    public void testGetFormations() {
        log.info("getFormations");
        List<FormationDTO> result = service.getFormations(searchFormation, false);
        Assert.assertEquals(resultGetFormations, result);
    }

    @Test
    public void testGetDisposByDate() throws ParseException {
        log.info("getDisposByDate");
        List<FormationDTO> result = service.getDisposByDate(dateSelection, true);
        Assert.assertEquals(resultParDateDispo, result);
    }

    @Test
    public void testGetFormationById() {
        log.info("getFormationById");
        Integer id = 1;
        FormationDTO result = service.getFormationById(id);
        Assert.assertEquals(formation1, result);
    }

    @Test
    public void testVerifierDispoFormation() {
        log.info("verifierDispoFormation");
        Assert.assertTrue(service.verifierDispoFormation(formationDispo));
    }

    @Test
    public void testReserverFormation() {
        log.info("reserverFormation");
        FormationDTO result = service.reserverFormation(formation1);
        Assert.assertEquals(formation1, result);
    }

    @Test
    public void testGetAllFormateurs() {
        log.info("getAllFormateurs");
        List<FormateurDTO> result = service.getAllFormateurs();
        Assert.assertEquals(resultGetAllFormateur, result);
    }

}
