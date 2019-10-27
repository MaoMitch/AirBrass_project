/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al30.assembleur;

import fr.afcepf.al30.dto.FormateurDTO;
import fr.afcepf.al30.dto.FormationDTO;
import fr.afcepf.al30.entity.Disponibilite;
import fr.afcepf.al30.entity.Formateur;
import fr.afcepf.al30.entity.Formation;
import fr.afcepf.al30.entity.Niveau;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

/**
 *
 * @author Max Michel
 */
public class AssembleurDTOTest {
    
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    
    private static Formation formationEntity;
    private static Formation formationEntityWithFormateur;
    private static FormationDTO formationDto;
    
    private static Formateur formateurEntity;
    private static FormateurDTO formateurDto;
    
    public static void init_All() throws ParseException {
        init_Formateurs();
        init_Formations();
    }

    public static void init_Formateurs() {
        formateurEntity = new Formateur();
        formateurEntity.setId(1);
        formateurEntity.setNom("Georges");
        formateurEntity.setFormations(new ArrayList<>());
        formateurEntity.getFormations().add(new Formation());
        
        formateurDto = new FormateurDTO();
        formateurDto.setId(2);
        formateurDto.setNom("Paul");
    }
    
    public static void init_Formations() throws ParseException {
        formationDto = new FormationDTO();
        formationDto.setDate(SDF.parse("17/04/1991"));
        formationDto.setDisponibilite(Disponibilite.DISPONIBLE);
        formationDto.setFormateur(formateurDto);
        formationDto.setId(1);
        formationDto.setIntitule("formation");
        formationDto.setNiveau(Niveau.DEBUTANT);
        formationDto.setPrix(32.2);
        
        formationEntity = new Formation();
        formationEntity.setDate(SDF.parse("17/04/1991"));
        formationEntity.setDisponibilite(Disponibilite.DISPONIBLE);
        formationEntity.setId(1);
        formationEntity.setIntitule("formation");
        formationEntity.setNiveau(Niveau.DEBUTANT);
        formationEntity.setPrix(32.2);
        
        formationEntityWithFormateur = new Formation();
        formationEntityWithFormateur.setDate(SDF.parse("17/04/1991"));
        formationEntityWithFormateur.setDisponibilite(Disponibilite.DISPONIBLE);
        formationEntityWithFormateur.setId(1);
        formationEntityWithFormateur.setFormateur(formateurEntity);
        formationEntityWithFormateur.setIntitule("formation");
        formationEntityWithFormateur.setNiveau(Niveau.DEBUTANT);
        formationEntityWithFormateur.setPrix(32.2);
    }
    
    @Before
    public void init() throws ParseException {
        init_All();
    }
    @Test
    public void entityToDto_formationWithFormateur() {
        FormationDTO resultat = AssembleurDTO.entityToDTO(formationEntityWithFormateur);
        Assert.assertNotNull(resultat);
        Assert.assertEquals(formationEntityWithFormateur.getDate(), resultat.getDate());
        Assert.assertEquals(formationEntityWithFormateur.getDisponibilite().getDispo(), resultat.getDisponibilite().getDispo());
        Assert.assertEquals(formationEntityWithFormateur.getId(), resultat.getId());
        Assert.assertNotNull(resultat.getFormateur());
        Assert.assertEquals(formationEntityWithFormateur.getFormateur().getId(), resultat.getFormateur().getId());
        Assert.assertEquals(formationEntityWithFormateur.getFormateur().getNom(), resultat.getFormateur().getNom());
        Assert.assertEquals(formationEntityWithFormateur.getIntitule(), resultat.getIntitule());
        Assert.assertEquals(formationEntityWithFormateur.getNiveau().getNiveauDePratique(), resultat.getNiveau().getNiveauDePratique());
        Assert.assertEquals(formationEntityWithFormateur.getPrix(), resultat.getPrix());
    }
    
    @Test
    public void entityToDto_formation() {
        FormationDTO resultat = AssembleurDTO.entityToDTO(formationEntity);
        Assert.assertNotNull(resultat);
        Assert.assertEquals(formationEntity.getDate(), resultat.getDate());
        Assert.assertEquals(formationEntity.getDisponibilite(), resultat.getDisponibilite());
        Assert.assertEquals(formationEntity.getId(), resultat.getId());
        Assert.assertNull(resultat.getFormateur());
        Assert.assertEquals(formationEntity.getIntitule(), resultat.getIntitule());
        Assert.assertEquals(formationEntity.getNiveau(), resultat.getNiveau());
        Assert.assertEquals(formationEntity.getPrix(), resultat.getPrix());
    }
    
    @Test
    public void dtoToEntity_formation() {
        Formation resultat = AssembleurDTO.dtoToEntity(formationDto);
        Assert.assertNotNull(resultat);
        Assert.assertEquals(formationDto.getDate(), resultat.getDate());
        Assert.assertEquals(formationDto.getDisponibilite(), resultat.getDisponibilite());
        Assert.assertEquals(formationDto.getId(), resultat.getId());
        Assert.assertNull(resultat.getFormateur());
        Assert.assertEquals(formationDto.getIntitule(), resultat.getIntitule());
        Assert.assertEquals(formationDto.getNiveau(), resultat.getNiveau());
        Assert.assertEquals(formationDto.getPrix(), resultat.getPrix());
    }
    
    @Test
    public void entityToDto_formateur() {
        FormateurDTO resultat = AssembleurDTO.entityToDTO(formateurEntity);
        Assert.assertNotNull(resultat);
        Assert.assertEquals(formateurEntity.getId(), resultat.getId());
        Assert.assertEquals(formateurEntity.getNom(), resultat.getNom());
    }
    
    @Test
    public void dtoToEntity_formateur() {
        Formateur resultat = AssembleurDTO.dtoToEntity(formateurDto);
        Assert.assertNotNull(resultat);
        Assert.assertEquals(formateurDto.getId(), resultat.getId());
        Assert.assertEquals(formateurDto.getNom(), resultat.getNom());
    }
    
}
