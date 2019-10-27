package fr.afcepf.al30.banque.dto;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.*;

import fr.afcepf.al30.banque.dto.AssembleurDTO;
import fr.afcepf.al30.banque.dto.CarteBanquaireDTO;
import fr.afcepf.al30.banque.dto.CompteBanquaireDTO;
import fr.afcepf.al30.banque.entity.CarteBanquaire;
import fr.afcepf.al30.banque.entity.CompteBanquaire;
import fr.afcepf.al30.banque.entity.Operation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Classe test pour {@link AssembleurDTO}. ()() (^^) LOVE QUALITY !!! °(_()().
 *
 * @author Stagiaire
 *
 */
public class AssembleurDTOTest {

    private static Logger log = Logger.getLogger(AssembleurDTOTest.class);

    private static CarteBanquaire carteBanquaireEntity;
    private static CarteBanquaireDTO carteBanquaireDTO;
    private static CompteBanquaire compteBanquaireEntity;
    private static CompteBanquaireDTO compteBanquaireDTO;
    private static CarteBanquaire carteSansCompte;
    private static CarteBanquaireDTO carteDTOSansCompte;
    
    private static Operation opePourCoverage;
    
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public static void init_CarteBanquaire() throws ParseException {

        carteBanquaireEntity = new CarteBanquaire();
        carteBanquaireEntity.setDateValidite(new Date());
        carteBanquaireEntity.setId(1);
        carteBanquaireEntity.setNom("user");
        carteBanquaireEntity.setNumero("1111222233334444");
        carteBanquaireEntity.setPictogrammeSecurite("123");
        carteBanquaireEntity.setDateValidite(SDF.parse("12/09/2019"));
        
        carteSansCompte = new CarteBanquaire();
        carteSansCompte.setDateValidite(new Date());
        carteSansCompte.setId(1);
        carteSansCompte.setNom("user");
        carteSansCompte.setNumero("1111222233334444");
        carteSansCompte.setPictogrammeSecurite("123");
        carteSansCompte.setDateValidite(SDF.parse("12/09/2019"));
    }

    public static void init_CarteBanquaireDTO() throws ParseException {

        carteBanquaireDTO = new CarteBanquaireDTO();
        carteBanquaireDTO.setDateValidite(SDF.parse("12/09/2019"));
        carteBanquaireDTO.setNom("user");
        carteBanquaireDTO.setNumero("1111222233334444");
        carteBanquaireDTO.setPictogrammeSecurite("123");
        
        carteDTOSansCompte = new CarteBanquaireDTO(carteSansCompte.getNom(), carteSansCompte.getNumero(), carteSansCompte.getPictogrammeSecurite());

    }


    public static void init_CompteBanquaire() throws ParseException {

        compteBanquaireEntity = new CompteBanquaire();
        compteBanquaireEntity.setId(1);
        compteBanquaireEntity.setNomCompte("user");
        compteBanquaireEntity.setNumeroCompte("1111");
        compteBanquaireEntity.setSolde(10000);
        compteBanquaireEntity.setCartesbanquaires(new ArrayList<>());
        compteBanquaireEntity.getCartesbanquaires().add(carteBanquaireEntity);
        carteBanquaireEntity.setCompte(compteBanquaireEntity);
        
         opePourCoverage = new Operation();
        opePourCoverage.setComptePayeur(compteBanquaireEntity);
        opePourCoverage.setCompteReceveur(compteBanquaireEntity);
        opePourCoverage.setDate(SDF.parse(("12/09/2019")));
        opePourCoverage.setId(1);
        opePourCoverage.setSommeTransfere(210);
        
        compteBanquaireEntity.getOperationsPaye().add(opePourCoverage);
    }

    public static void init_CompteBanquaireDTO() {

        compteBanquaireDTO = new CompteBanquaireDTO();
        compteBanquaireDTO.setNomCompte("user");
        compteBanquaireDTO.setNumeroCompte("1111");
        compteBanquaireDTO = new CompteBanquaireDTO(compteBanquaireDTO.getNomCompte(), compteBanquaireDTO.getNumeroCompte());
        carteBanquaireDTO.setCompteDto(compteBanquaireDTO);
        

    }
    
    public static void init_all() throws ParseException {
        init_CarteBanquaire();
        init_CompteBanquaire();
        init_CarteBanquaireDTO();
        init_CompteBanquaireDTO();
    }

    @Test
    public void testEntityToDTO_CarteBanquaire() throws ParseException {
        init_all();
        CarteBanquaireDTO resultat = AssembleurDTO.entityToDto(carteBanquaireEntity);
        Assert.assertNotNull(resultat);
        Assert.assertEquals(carteBanquaireEntity.getDateValidite(), resultat.getDateValidite());
        Assert.assertEquals(carteBanquaireEntity.getId(), resultat.getId());
        Assert.assertEquals(carteBanquaireEntity.getNom(), resultat.getNom());
        Assert.assertEquals(carteBanquaireEntity.getNumero(), resultat.getNumero());
        Assert.assertEquals(carteBanquaireEntity.getPictogrammeSecurite(), resultat.getPictogrammeSecurite());
        Assert.assertEquals(carteBanquaireEntity.getCompte().getNomCompte(), resultat.getCompteDto().getNomCompte());
    }
    
    @Test
    public void testEntityToDTO_CarteBanquaireSansCompte() throws ParseException {
        init_all();
        CarteBanquaireDTO resultat = AssembleurDTO.entityToDto(carteSansCompte);
        Assert.assertNotNull(resultat);
        Assert.assertEquals(carteSansCompte.getDateValidite(), resultat.getDateValidite());
        Assert.assertEquals(carteSansCompte.getId(), resultat.getId());
        Assert.assertEquals(carteSansCompte.getNom(), resultat.getNom());
        Assert.assertEquals(carteSansCompte.getNumero(), resultat.getNumero());
        Assert.assertEquals(carteSansCompte.getPictogrammeSecurite(), resultat.getPictogrammeSecurite());
        Assert.assertNull(resultat.getCompteDto());
    }

    @Test
    public void testDtoToEntity_CarteBanquaire() throws ParseException {
        init_all();
        CarteBanquaire resultat = AssembleurDTO.dtoToEntity(carteBanquaireDTO);
        Assert.assertNotNull(resultat);
        Assert.assertEquals(carteBanquaireDTO.getId(), resultat.getId());
        Assert.assertEquals(carteBanquaireDTO.getDateValidite(), resultat.getDateValidite());
        Assert.assertEquals(carteBanquaireDTO.getNom(), resultat.getNom());
        Assert.assertEquals(carteBanquaireDTO.getNumero(), resultat.getNumero());
        Assert.assertEquals(carteBanquaireDTO.getPictogrammeSecurite(), resultat.getPictogrammeSecurite());
        Assert.assertEquals(carteBanquaireDTO.getCompteDto().getNomCompte(), resultat.getCompte().getNomCompte());
    }
    
    @Test
    public void testDtoToEntity_CarteBanquaireSansCompte() throws ParseException {
        init_all();
        CarteBanquaire resultat = AssembleurDTO.dtoToEntity(carteDTOSansCompte);
        Assert.assertNotNull(resultat);
        Assert.assertEquals(carteDTOSansCompte.getNom(), resultat.getNom());
        Assert.assertEquals(carteDTOSansCompte.getNumero(), resultat.getNumero());
        Assert.assertEquals(carteDTOSansCompte.getPictogrammeSecurite(), resultat.getPictogrammeSecurite());
        Assert.assertNull(resultat.getCompte());
    }

    @Test
    public void testEntityToDTO_compteBanquaire() throws ParseException {
        init_all();
        CompteBanquaireDTO resultat = AssembleurDTO.entityToDto(compteBanquaireEntity);
        Assert.assertNotNull(resultat);
        Assert.assertEquals(compteBanquaireEntity.getId(), resultat.getId());
        Assert.assertEquals(compteBanquaireEntity.getNomCompte(), resultat.getNomCompte());
        Assert.assertEquals(compteBanquaireEntity.getNumeroCompte(), resultat.getNumeroCompte());
        Assert.assertNotNull(compteBanquaireEntity.getOperationsPaye().get(0));
        Assert.assertNotNull(compteBanquaireEntity.getOperationsPaye().get(0).getComptePayeur());
        Assert.assertNotNull(compteBanquaireEntity.getOperationsPaye().get(0).getCompteReceveur());
        Assert.assertNotNull(compteBanquaireEntity.getOperationsPaye().get(0).getDate());
        Assert.assertNotNull(compteBanquaireEntity.getOperationsPaye().get(0).getId());
        Assert.assertNotNull(compteBanquaireEntity.getOperationsPaye().get(0).getSommeTransfere());
    }

    @Test
    public void testDtoToEntity_compteBanquaire() throws ParseException {
        init_all();
        CompteBanquaire resultat = AssembleurDTO.dtoToEntity(compteBanquaireDTO);
        Assert.assertNotNull(resultat);
        Assert.assertEquals(compteBanquaireDTO.getNomCompte(), resultat.getNomCompte());
        Assert.assertEquals(compteBanquaireDTO.getNumeroCompte(), resultat.getNumeroCompte());
    }
}
