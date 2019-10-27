/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al30.ws;

import fr.afcepf.al30.stock.data.IDaoCommande;
import fr.afcepf.al30.stock.data.IDaoFournisseur;
import fr.afcepf.al30.stock.data.IDaoProduit;
import fr.afcepf.al30.stock.data.IDaoUtilisateur;
import fr.afcepf.al30.stock.dto.CommandeDTO;
import fr.afcepf.al30.stock.dto.FournisseurDTO;
import fr.afcepf.al30.stock.dto.LigneCommandeDTO;
import fr.afcepf.al30.stock.dto.ProduitDTO;
import fr.afcepf.al30.stock.dto.UtilisateurDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;

/**
 *
 * @author Max Michel
 */
public class GestionStockIHMTest {

    private static final Logger LOG = Logger.getLogger(GestionStockIHMTest.class);
    private static GestionStockIHM instance;
    private static Class<?> clazz;

    private static IDaoCommande mockDaoCommande;
    private static IDaoFournisseur mockDaoFournisseur;
    private static IDaoProduit mockDaoProduit;
    private static IDaoUtilisateur mockDaoUtilisateur;
    
    private static final int COMMANDE_ID_GET_LIGNE = 7;
    private static List<LigneCommandeDTO> lignes;
    private static LigneCommandeDTO ligne1;
    private static LigneCommandeDTO ligne2;
    
    private static final int PRODUIT_ID_GET_BY = 12;
    private static ProduitDTO produit12;
    
    private static CommandeDTO commandeToAdd;
    private static CommandeDTO resultCommandeToAdd;
    
    private static CommandeDTO commandeToMaj;
    private static CommandeDTO resultCommandeToMaj;
    
    private static LigneCommandeDTO ligneCommandeToAdd;
    private static LigneCommandeDTO resultLigneCommandeToAdd;
    
    private static ProduitDTO produitAjoutStock;
    private static final int AJOUT_STOCK = 5;
    
    private static UtilisateurDTO utilisateurLogin;
    
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    
    private static List<ProduitDTO> listProduitsStockVide;
    private static ProduitDTO produitStockVide1;
    private static ProduitDTO produitStockVide2;
    
    private static List<CommandeDTO> listAllCommande;
    private static CommandeDTO commande1;
    private static CommandeDTO commande2;
    
    private static List<ProduitDTO> listAllProduits;
    private static ProduitDTO produit1;
    private static ProduitDTO produit2;
    
    private static ProduitDTO produitToMaj;
    private static ProduitDTO produitMaj;
    
    private static List<FournisseurDTO> allFournisseur;
    private static FournisseurDTO fournisseur1;
    private static FournisseurDTO fournisseur2;
    
    public static void init_entity() {
        lignes = new ArrayList<>();
        ligne1 = new LigneCommandeDTO(1, 3, new CommandeDTO(), new ProduitDTO());
        ligne2 = new LigneCommandeDTO(2, 5, new CommandeDTO(), new ProduitDTO());
        lignes.add(ligne1);
        lignes.add(ligne2);
        
        produit12 = new ProduitDTO(PRODUIT_ID_GET_BY, "refProduit", 32, 12, null, 321.25, "photo", "intitule");
        
        commandeToAdd = new CommandeDTO();
        resultCommandeToAdd = new CommandeDTO();
        resultCommandeToAdd.setId(32);
        
        ligneCommandeToAdd = new LigneCommandeDTO();
        resultLigneCommandeToAdd = new LigneCommandeDTO();
        resultLigneCommandeToAdd.setId(65);
        
        commandeToAdd = new CommandeDTO();
        resultCommandeToMaj = new CommandeDTO();
        resultCommandeToAdd.setId(32);
        
        produitAjoutStock = new ProduitDTO(35, "refProduit", 12, 15, null, 321d, "photo", "intitule");
        
        utilisateurLogin = new UtilisateurDTO(1, LOGIN, PASSWORD, "Georges");
        
        listProduitsStockVide = new ArrayList<>();
        produitStockVide1 = new ProduitDTO(54, "RefProduit3", 0, 4, null, 235.50, "Photo", "Produit3");
        produitStockVide2 = new ProduitDTO(54, "RefProduit4", 0, 20, null, 5.50, "Photo", "Produit4");
        listProduitsStockVide.add(produitStockVide1);
        listProduitsStockVide.add(produitStockVide2);
        
        listAllCommande = new ArrayList<>();
        commande1 = new CommandeDTO(1, new Date(), utilisateurLogin, "En cours", "intitule");
        commande2 = new CommandeDTO(2, new Date(), utilisateurLogin, "En cours", "intitule2");
        listAllCommande.add(commande1);
        listAllCommande.add(commande2);
        
        listAllProduits = new ArrayList<>();
        produit1 = new ProduitDTO();
        produit2 = new ProduitDTO();
        
        listAllProduits.add(produit1);
        listAllProduits.add(produit2);
        listAllProduits.add(produit12);
        listAllProduits.add(produitAjoutStock);
        listAllProduits.add(produitStockVide1);
        listAllProduits.add(produitStockVide2);
        
        
        produitToMaj = produit12;
        produitMaj = new ProduitDTO(produit12.getId(), produit12.getRefProduit(), produit12.getStock() +5, produit12.getSeuil(), produit12.getFournisseur(), produit12.getPrixFournisseur(), produit12.getPhoto(), produit12.getIntitule());
        
        
        allFournisseur = new ArrayList<>();
        fournisseur1 = new FournisseurDTO(1, "fournisseur1", "fournisseur1@fournisse.ur", "0659595959", "1 rue des fournisseurs");
        fournisseur2 = new FournisseurDTO(2, "fournisseur2", "fournisseur2@fournisse.ur", "0659595959", "2 rue des fournisseurs");
        allFournisseur.add(fournisseur1);
        allFournisseur.add(fournisseur2);
    }
    
    public static void init_daoCommande() {
        mockDaoCommande = EasyMock.createMock(IDaoCommande.class);
        EasyMock.expect(mockDaoCommande.getLigneByCommande(COMMANDE_ID_GET_LIGNE)).andReturn(lignes);
        
        EasyMock.expect(mockDaoCommande.addCommande(commandeToAdd)).andReturn(resultCommandeToAdd);
        EasyMock.expect(mockDaoCommande.addLigneCommande(ligneCommandeToAdd)).andReturn(resultLigneCommandeToAdd);
        EasyMock.expect(mockDaoCommande.maj(commandeToMaj)).andReturn(resultCommandeToMaj);
        
        EasyMock.expect(mockDaoCommande.getAllCommande()).andReturn(listAllCommande);
        EasyMock.expect(mockDaoCommande.getCommandeByStatutCommande("En cours")).andReturn(listAllCommande);
        EasyMock.replay(mockDaoCommande);
    }
    
    public static void init_daoFournisseur() {
        mockDaoFournisseur = EasyMock.createMock(IDaoFournisseur.class);
        EasyMock.expect(mockDaoFournisseur.getAll()).andReturn(allFournisseur);
        EasyMock.expect(mockDaoFournisseur.getFournisseurById(1)).andReturn(fournisseur1);
        EasyMock.replay(mockDaoFournisseur);
    }
    
    public static void init_daoProduit() {
        mockDaoProduit = EasyMock.createMock(IDaoProduit.class);
        EasyMock.expect(mockDaoProduit.getProduitById(PRODUIT_ID_GET_BY)).andReturn(produit12);
        EasyMock.expect(mockDaoProduit.majProduit(produitAjoutStock)).andReturn(produitAjoutStock);
        EasyMock.expect(mockDaoProduit.getProduitStockVide()).andReturn(listProduitsStockVide);
        EasyMock.expect(mockDaoProduit.getAll()).andReturn(listAllProduits);
        EasyMock.expect(mockDaoProduit.majProduit(produitToMaj)).andReturn(produitMaj);
        EasyMock.expect(mockDaoProduit.getProduitsByFournisseur(1)).andReturn(listAllProduits);
        EasyMock.replay(mockDaoProduit);
    }
    
    public static void init_daoUtilisateur() {
        mockDaoUtilisateur = EasyMock.createMock(IDaoUtilisateur.class);
        EasyMock.expect(mockDaoUtilisateur.getUtilisateur(LOGIN, PASSWORD)).andReturn(utilisateurLogin);
        EasyMock.replay(mockDaoUtilisateur);
    }
    
    public static void init_mocks() {
        init_daoCommande();
        init_daoFournisseur();
        init_daoProduit();
        init_daoUtilisateur();
    }
    @BeforeClass
    public static void init() {
        instance = new GestionStockIHM();
        clazz = instance.getClass();
        init_entity();
        init_mocks();
        instance.setDaoCommande(mockDaoCommande);
        instance.setDaoFournisseur(mockDaoFournisseur);
        instance.setDaoProduit(mockDaoProduit);
        instance.setDaoUtilisateur(mockDaoUtilisateur);
    }
    
    @AfterClass
    public static void tearDown() {
        EasyMock.verify(mockDaoCommande, mockDaoFournisseur, mockDaoProduit, mockDaoUtilisateur);
    }
    @Test
    public void testGetLigneByCommande() {
        LOG.info("getLigneByCommande");
        List<LigneCommandeDTO> result = instance.getLigneByCommande(COMMANDE_ID_GET_LIGNE);
        Assert.assertEquals(lignes, result);
    }

    @Test
    public void testGetProduitById() {
        LOG.info("getProduitById");
        ProduitDTO result = instance.getProduitById(PRODUIT_ID_GET_BY);
        Assert.assertEquals(produit12, result);
    }

    @Test
    public void testAddCommande_CommandeDTO() {
        LOG.info("addCommande");
        CommandeDTO result = instance.addCommande(commandeToAdd);
        Assert.assertEquals(resultCommandeToAdd, result);
    }

    @Test
    public void testAddCommande_LigneCommandeDTO() {
        LOG.info("addCommande");
        LigneCommandeDTO result = instance.addCommande(ligneCommandeToAdd);
        Assert.assertEquals(resultLigneCommandeToAdd, result);
    }

    @Test
    public void testMajCommande() {
        LOG.info("majCommande");
        CommandeDTO result = instance.majCommande(commandeToMaj);
        Assert.assertEquals(resultCommandeToMaj, result);
    }

    @Test
    public void testAjoutStock() {
        LOG.info("ajoutStock");
        int oldStock = produitAjoutStock.getStock();
        ProduitDTO result = instance.ajoutStock(produitAjoutStock, AJOUT_STOCK);
        
        Assert.assertEquals(produitAjoutStock, result);
        Assert.assertEquals(oldStock + AJOUT_STOCK, result.getStock());
    }

    @Test
    public void testGetUtilisateur() {
        LOG.info("getUtilisateur");
        UtilisateurDTO result = instance.getUtilisateur(LOGIN, PASSWORD);
        Assert.assertEquals(utilisateurLogin, result);
    }

    @Test
    public void testGetProduitStockVide() {
        LOG.info("getProduitStockVide");
        List<ProduitDTO> result = instance.getProduitStockVide();
        Assert.assertEquals(listProduitsStockVide, result);
    }

    @Test
    public void testGetCommande() {
        LOG.info("getCommande");
        List<CommandeDTO> result = instance.getCommande();
        Assert.assertEquals(listAllCommande, result);
    }

    @Test
    public void testGetAll() {
        LOG.info("getAll");
        List<ProduitDTO> result = instance.getAll();
        Assert.assertEquals(listAllProduits, result);
    }

    @Test
    public void testMajProduit() {
        LOG.info("majProduit");
        ProduitDTO result = instance.majProduit(produitToMaj);
        Assert.assertEquals(produitMaj, result);
    }

    @Test
    public void testGetAllFournisseur() {
        LOG.info("getAllFournisseur");
        List<FournisseurDTO> result = instance.getAllFournisseur();
        Assert.assertEquals(allFournisseur, result);
    }

    @Test
    public void testGetProduitByFournisseur() {
        LOG.info("getProduitByFournisseur");
        List<ProduitDTO> result = instance.getProduitByFournisseur(1);
        Assert.assertEquals(listAllProduits, result);
    }

    @Test
    public void testGetFournisseurById() {
        LOG.info("getFournisseurById");
        FournisseurDTO result = instance.getFournisseurById(1);
        Assert.assertEquals(fournisseur1, result);
    }

    @Test
    public void testGetCommandeByStatut() {
        LOG.info("getCommandeByStatut");
        String statutCommande = "En cours";
        List<CommandeDTO> result = instance.getCommandeByStatut(statutCommande);
        Assert.assertEquals(listAllCommande, result);
    }

}
