/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al30.stock.assembleur;

import fr.afcepf.al30.stock.dto.CommandeDTO;
import fr.afcepf.al30.stock.dto.FournisseurDTO;
import fr.afcepf.al30.stock.dto.LigneCommandeDTO;
import fr.afcepf.al30.stock.dto.OrchestrateurCommandeDTO;
import fr.afcepf.al30.stock.dto.ProduitDTO;
import fr.afcepf.al30.stock.dto.UtilisateurDTO;
import fr.afcepf.al30.stock.entity.Commande;
import fr.afcepf.al30.stock.entity.Fournisseur;
import fr.afcepf.al30.stock.entity.LigneCommande;
import fr.afcepf.al30.stock.entity.Produit;
import fr.afcepf.al30.stock.entity.Utilisateur;
import java.util.ArrayList;
import java.util.Date;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author Max Michel
 */
public class AssembleurDTOTest {

    private static Logger log = Logger.getLogger(AssembleurDTOTest.class);

    @Test
    public void testConstructionOrchestrateur() {
        OrchestrateurCommandeDTO orc = new OrchestrateurCommandeDTO();
        orc.setQteProduit(12);
        orc.setRefProduit("refProduit");
        orc = new OrchestrateurCommandeDTO(orc.getRefProduit(), orc.getQteProduit());
        
        Assert.assertEquals(12, orc.getQteProduit());
        Assert.assertEquals("refProduit", orc.getRefProduit());
    }
    @Test
    public void testProduitToProduitDTO() {
        log.info("produitToProduitDTO");
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(1);
        fournisseur.setLibelle("fournisseur");
        fournisseur.setAdresseMail("fournisseur@four.nisseur");
        fournisseur.setTelephone("0606060606");
        fournisseur.setAdresse("2 rue fournisseur");
        fournisseur.setProduits(new ArrayList<>());
        fournisseur = new Fournisseur(fournisseur.getId(), fournisseur.getLibelle(), fournisseur.getAdresseMail(), fournisseur.getTelephone(), fournisseur.getAdresse(), fournisseur.getProduits());
        Produit entity = new Produit();
        entity.setId(1);
        entity.setIntitule("produit");
        entity.setPhoto("photo");
        entity.setPrixFournisseur(250d);
        entity.setRefProduit("refProduit");
        entity.setSeuil(5);
        entity.setStock(12);
        entity.setFournisseur(fournisseur);
        entity.setLignes(new ArrayList<>());
        entity = new Produit(entity.getId(), entity.getIntitule(), entity.getRefProduit(), entity.getStock(), entity.getPhoto(), entity.getSeuil(), entity.getPrixFournisseur(), entity.getFournisseur(), entity.getLignes());
        ProduitDTO result = AssembleurDTO.produitToProduitDTO(entity);
        Assert.assertNotNull(result);
        Assert.assertEquals(entity.getId(), result.getId());
        Assert.assertEquals(entity.getFournisseur().getId(), result.getFournisseur().getId());
        Assert.assertEquals(entity.getFournisseur().getAdresse(), result.getFournisseur().getAdresse());
        Assert.assertEquals(entity.getFournisseur().getAdresseMail(), result.getFournisseur().getAdresseMail());
        Assert.assertEquals(entity.getFournisseur().getLibelle(), result.getFournisseur().getLibelle());
        Assert.assertEquals(entity.getFournisseur().getTelephone(), result.getFournisseur().getTelephone());
        Assert.assertEquals(entity.getIntitule(), result.getIntitule());
        Assert.assertEquals(entity.getPhoto(), result.getPhoto());
        Assert.assertEquals(entity.getPrixFournisseur(), result.getPrixFournisseur());
        Assert.assertEquals(entity.getRefProduit(), result.getRefProduit());
        Assert.assertEquals(entity.getSeuil(), result.getSeuil());
        Assert.assertEquals(entity.getStock(), result.getStock());

    }

    @Test
    public void testProduitDTOToProduit() {
        log.info("produitDTOToProduit");
        FournisseurDTO fournisseur = new FournisseurDTO();
        fournisseur.setId(1);
        fournisseur.setLibelle("fournisseur");
        fournisseur.setAdresseMail("fournisseur@four.nisseur");
        fournisseur.setTelephone("0606060606");
        fournisseur.setAdresse("2 rue fournisseur");
        fournisseur = new FournisseurDTO(fournisseur.getId(), fournisseur.getLibelle(), fournisseur.getAdresseMail(), fournisseur.getTelephone(), fournisseur.getAdresse());
        ProduitDTO entity = new ProduitDTO();
        entity.setId(1);
        entity.setIntitule("produit");
        entity.setPhoto("photo");
        entity.setPrixFournisseur(250d);
        entity.setRefProduit("refProduit");
        entity.setSeuil(5);
        entity.setStock(12);
        entity.setFournisseur(fournisseur);
        entity = new ProduitDTO(entity.getId(), entity.getRefProduit(), entity.getStock(), entity.getSeuil(), entity.getFournisseur(), entity.getPrixFournisseur(), entity.getPhoto(), entity.getIntitule());
        Produit result = AssembleurDTO.produitDTOToProduit(entity);
        Assert.assertNotNull(result);
        Assert.assertEquals(entity.getId(), result.getId());
        Assert.assertEquals(entity.getFournisseur().getId(), result.getFournisseur().getId());
        Assert.assertEquals(entity.getFournisseur().getAdresse(), result.getFournisseur().getAdresse());
        Assert.assertEquals(entity.getFournisseur().getAdresseMail(), result.getFournisseur().getAdresseMail());
        Assert.assertEquals(entity.getFournisseur().getLibelle(), result.getFournisseur().getLibelle());
        Assert.assertEquals(entity.getFournisseur().getTelephone(), result.getFournisseur().getTelephone());
        Assert.assertEquals(entity.getIntitule(), result.getIntitule());
        Assert.assertEquals(entity.getPhoto(), result.getPhoto());
        Assert.assertEquals(entity.getPrixFournisseur(), result.getPrixFournisseur());
        Assert.assertEquals(entity.getRefProduit(), result.getRefProduit());
        Assert.assertEquals(entity.getSeuil(), result.getSeuil());
        Assert.assertEquals(entity.getStock(), result.getStock());
    }

    @Test
    public void testProduitToProduitDTOFournisseurNull() {
        log.info("produitToProduitDTO");
        Produit entity = new Produit();
        entity.setId(1);
        entity.setIntitule("produit");
        entity.setPhoto("photo");
        entity.setPrixFournisseur(250d);
        entity.setRefProduit("refProduit");
        entity.setSeuil(5);
        entity.setStock(12);
        entity.setFournisseur(null);
        entity.setLignes(new ArrayList<>());
        entity = new Produit(entity.getId(), entity.getIntitule(), entity.getRefProduit(), entity.getStock(), entity.getPhoto(), entity.getSeuil(), entity.getPrixFournisseur(), entity.getFournisseur(), entity.getLignes());
        ProduitDTO result = AssembleurDTO.produitToProduitDTO(entity);
        Assert.assertNotNull(result);
        Assert.assertEquals(entity.getId(), result.getId());
        Assert.assertNull(result.getFournisseur());
        Assert.assertEquals(entity.getIntitule(), result.getIntitule());
        Assert.assertEquals(entity.getPhoto(), result.getPhoto());
        Assert.assertEquals(entity.getPrixFournisseur(), result.getPrixFournisseur());
        Assert.assertEquals(entity.getRefProduit(), result.getRefProduit());
        Assert.assertEquals(entity.getSeuil(), result.getSeuil());
        Assert.assertEquals(entity.getStock(), result.getStock());

    }

    @Test
    public void testProduitDTOToProduitFournisseurNull() {
        log.info("produitDTOToProduit");
        ProduitDTO entity = new ProduitDTO();
        entity.setId(1);
        entity.setIntitule("produit");
        entity.setPhoto("photo");
        entity.setPrixFournisseur(250d);
        entity.setRefProduit("refProduit");
        entity.setSeuil(5);
        entity.setStock(12);
        entity.setFournisseur(null);
        entity = new ProduitDTO(entity.getId(), entity.getRefProduit(), entity.getStock(), entity.getSeuil(), entity.getFournisseur(), entity.getPrixFournisseur(), entity.getPhoto(), entity.getIntitule());
        Produit result = AssembleurDTO.produitDTOToProduit(entity);
        Assert.assertNotNull(result);
        Assert.assertEquals(entity.getId(), result.getId());
        Assert.assertNull(result.getFournisseur());
        Assert.assertEquals(entity.getIntitule(), result.getIntitule());
        Assert.assertEquals(entity.getPhoto(), result.getPhoto());
        Assert.assertEquals(entity.getPrixFournisseur(), result.getPrixFournisseur());
        Assert.assertEquals(entity.getRefProduit(), result.getRefProduit());
        Assert.assertEquals(entity.getSeuil(), result.getSeuil());
        Assert.assertEquals(entity.getStock(), result.getStock());
    }

    @Test
    public void testCommandeToCommandeDTO() {
        log.info("commandeToCommandeDTO");
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1);
        utilisateur.setLogin("login");
        utilisateur.setName("name");
        utilisateur.setPassword("password");
        utilisateur.setCommandes(new ArrayList<>());
        utilisateur = new Utilisateur(utilisateur.getId(), utilisateur.getLogin(), utilisateur.getPassword(), utilisateur.getName(), utilisateur.getCommandes());
        Commande entity = new Commande();
        entity.setId(1);
        entity.setDate(new Date());
        entity.setIntitule("intitule");
        entity.setLignes(new ArrayList<>());
        entity.setStatut("statut");
        entity.setUser(utilisateur);
        entity = new Commande(entity.getId(), entity.getIntitule(), entity.getDate(), entity.getLignes(), entity.getUser(), entity.getStatut());
        CommandeDTO result = AssembleurDTO.commandeToCommandeDTO(entity);
        Assert.assertEquals(entity.getId(), result.getId());
        Assert.assertEquals(entity.getIntitule(), result.getIntitule());
        Assert.assertEquals(entity.getDate(), result.getDate());
        Assert.assertEquals(entity.getUser().getId(), result.getUser().getId());
        Assert.assertEquals(entity.getUser().getLogin(), result.getUser().getLogin());
        Assert.assertEquals(entity.getUser().getPassword(), result.getUser().getPassword());
        Assert.assertEquals(entity.getUser().getName(), result.getUser().getName());
        Assert.assertEquals(entity.getStatut(), result.getStatut());
    }

    @Test
    public void testCommandeDTOToCommande() {
        log.info("commandeDTOToCommande");
        UtilisateurDTO utilisateur = new UtilisateurDTO();
        utilisateur.setId(1);
        utilisateur.setLogin("login");
        utilisateur.setName("name");
        utilisateur.setPassword("password");
        utilisateur = new UtilisateurDTO(utilisateur.getId(), utilisateur.getLogin(), utilisateur.getPassword(), utilisateur.getName());
        CommandeDTO entity = new CommandeDTO();
        entity.setId(1);
        entity.setDate(new Date());
        entity.setIntitule("intitule");
        entity.setStatut("statut");
        entity.setUser(utilisateur);
        entity = new CommandeDTO(entity.getId(), entity.getDate(), entity.getUser(), entity.getIntitule(), entity.getStatut());
        Commande result = AssembleurDTO.commandeDTOToCommande(entity);
        Assert.assertEquals(entity.getId(), result.getId());
        Assert.assertEquals(entity.getIntitule(), result.getIntitule());
        Assert.assertEquals(entity.getDate(), result.getDate());
        Assert.assertEquals(entity.getUser().getId(), result.getUser().getId());
        Assert.assertEquals(entity.getUser().getLogin(), result.getUser().getLogin());
        Assert.assertEquals(entity.getUser().getPassword(), result.getUser().getPassword());
        Assert.assertEquals(entity.getUser().getName(), result.getUser().getName());
        Assert.assertEquals(entity.getStatut(), result.getStatut());
    }
    
    @Test
    public void testCommandeToCommandeDTOUserNull() {
        log.info("commandeToCommandeDTO");
        Commande entity = new Commande();
        entity.setId(1);
        entity.setDate(new Date());
        entity.setIntitule("intitule");
        entity.setLignes(new ArrayList<>());
        entity.setStatut("statut");
        entity.setUser(null);
        entity = new Commande(entity.getId(), entity.getIntitule(), entity.getDate(), entity.getLignes(), entity.getUser(), entity.getStatut());
        CommandeDTO result = AssembleurDTO.commandeToCommandeDTO(entity);
        Assert.assertEquals(entity.getId(), result.getId());
        Assert.assertEquals(entity.getIntitule(), result.getIntitule());
        Assert.assertEquals(entity.getDate(), result.getDate());
        Assert.assertNull(result.getUser());
        Assert.assertEquals(entity.getStatut(), result.getStatut());
    }

    @Test
    public void testCommandeDTOToCommandeUserNull() {
        log.info("commandeDTOToCommande");
        CommandeDTO entity = new CommandeDTO();
        entity.setId(1);
        entity.setDate(new Date());
        entity.setIntitule("intitule");
        entity.setStatut("statut");
        entity.setUser(null);
        entity = new CommandeDTO(entity.getId(), entity.getDate(), entity.getUser(), entity.getIntitule(), entity.getStatut());
        Commande result = AssembleurDTO.commandeDTOToCommande(entity);
        Assert.assertEquals(entity.getId(), result.getId());
        Assert.assertEquals(entity.getIntitule(), result.getIntitule());
        Assert.assertEquals(entity.getDate(), result.getDate());
        Assert.assertNull(result.getUser());
        Assert.assertEquals(entity.getStatut(), result.getStatut());
    }

    @Test
    public void testLigneCommandeToLigneCommandeDTO() {
        log.info("ligneCommandeToLigneCommandeDTO");
        Commande commande = new Commande();
        commande.setId(1);
        Produit produit = new Produit();
        produit.setId(1);
        LigneCommande entity = new LigneCommande();
        entity.setId(1);
        entity.setQuantite(2);
        entity.setCommande(commande);
        entity.setProduit(produit);
        entity = new LigneCommande(entity.getId(), entity.getQuantite(), entity.getCommande(), entity.getProduit());
        LigneCommandeDTO result = AssembleurDTO.ligneCommandeToLigneCommandeDTO(entity);
        Assert.assertEquals(entity.getId(), result.getId());
        Assert.assertEquals(entity.getQuantite(), result.getQuantite());
        Assert.assertEquals(entity.getCommande().getId(), result.getCommande().getId());
        Assert.assertEquals(entity.getProduit().getId(), result.getProduit().getId());
    }

    @Test
    public void testLigneCommandeDTOToLigneCommande() {
        log.info("ligneCommandeDTOToLigneCommande");
        CommandeDTO commande = new CommandeDTO();
        commande.setId(1);
        ProduitDTO produit = new ProduitDTO();
        produit.setId(1);
        LigneCommandeDTO entity = new LigneCommandeDTO();
        entity.setId(1);
        entity.setQuantite(2);
        entity.setCommande(commande);
        entity.setProduit(produit);
        entity = new LigneCommandeDTO(entity.getId(), entity.getQuantite(), entity.getCommande(), entity.getProduit());
        LigneCommande result = AssembleurDTO.ligneCommandeDTOToLigneCommande(entity);
        Assert.assertEquals(entity.getId(), result.getId());
        Assert.assertEquals(entity.getQuantite(), result.getQuantite());
        Assert.assertEquals(entity.getCommande().getId(), result.getCommande().getId());
        Assert.assertEquals(entity.getProduit().getId(), result.getProduit().getId());
    }
    
    @Test
    public void testLigneCommandeToLigneCommandeDTOWithNull() {
        log.info("ligneCommandeToLigneCommandeDTO");
        LigneCommande entity = new LigneCommande();
        entity.setId(1);
        entity.setQuantite(2);
        entity.setCommande(null);
        entity.setProduit(null);
        entity = new LigneCommande(entity.getId(), entity.getQuantite(), entity.getCommande(), entity.getProduit());
        LigneCommandeDTO result = AssembleurDTO.ligneCommandeToLigneCommandeDTO(entity);
        Assert.assertEquals(entity.getId(), result.getId());
        Assert.assertEquals(entity.getQuantite(), result.getQuantite());
        Assert.assertNull(result.getCommande());
        Assert.assertNull(result.getProduit());
    }

    @Test
    public void testLigneCommandeDTOToLigneCommandeWithNull() {
        log.info("ligneCommandeDTOToLigneCommande");
        LigneCommandeDTO entity = new LigneCommandeDTO();
        entity.setId(1);
        entity.setQuantite(2);
        entity.setCommande(null);
        entity.setProduit(null);
        entity = new LigneCommandeDTO(entity.getId(), entity.getQuantite(), entity.getCommande(), entity.getProduit());
        LigneCommande result = AssembleurDTO.ligneCommandeDTOToLigneCommande(entity);
        Assert.assertEquals(entity.getId(), result.getId());
        Assert.assertEquals(entity.getQuantite(), result.getQuantite());
        Assert.assertNull(result.getCommande());
        Assert.assertNull(result.getProduit());
    }
}
