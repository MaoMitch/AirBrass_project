/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al30.ws;

import com.google.gson.Gson;
import fr.afcepf.al30.stock.data.IDaoProduit;
import fr.afcepf.al30.stock.dto.OrchestrateurCommandeDTO;
import fr.afcepf.al30.stock.dto.ProduitDTO;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Max Michel
 */
public class GestionStockTest {

    private static final Gson GSON = new Gson();
    private static final Logger LOG = Logger.getLogger(GestionStockTest.class);
    private static OrchestrateurCommandeDTO commande1;
    private static OrchestrateurCommandeDTO commande2;
    private static List<OrchestrateurCommandeDTO> commandesOrch;
    private static String commande;
    
    private static OrchestrateurCommandeDTO commandeStockInsuffisantOrch;
    private static List<OrchestrateurCommandeDTO> commandesOrchStockInsuffisant;
    private static String commandeStockInsuffisant;
    
    private static ProduitDTO produit1;
    private static ProduitDTO produit2;

    private static GestionStock service;
    private static Class<?> clazz;

    private static IDaoProduit mockDaoProduit;
    
    private static List<ProduitDTO> resultGetAll;

    @BeforeClass
    public static void init_commande() {
        service = new GestionStock();
        clazz = service.getClass();

        commandesOrch = new ArrayList<>();
        commande1 = new OrchestrateurCommandeDTO();
        commande1.setQteProduit(12);
        commande1.setRefProduit("Produit1");
        commande2 = new OrchestrateurCommandeDTO("Produit2", 42);
        commandesOrch.add(commande1);
        commandesOrch.add(commande2);
        commande = GSON.toJson(commandesOrch);
        
        commandesOrchStockInsuffisant = new ArrayList<>();
        commandeStockInsuffisantOrch = new OrchestrateurCommandeDTO("Produit3", 25);
        commandesOrchStockInsuffisant.add(commandeStockInsuffisantOrch);
        
        commandeStockInsuffisant = GSON.toJson(commandesOrchStockInsuffisant);
       
        produit1 = new ProduitDTO(1, "Produit1", 35, 10, null, 235d, "Photo", "intitulle");
        produit2 = new ProduitDTO(2, "Produit2", 70, 10, null, 235d, "Photo", "intitulle");

        resultGetAll = new ArrayList<>();
        resultGetAll.add(produit1);
        resultGetAll.add(produit2);
        
        mockDaoProduit = EasyMock.createMock(IDaoProduit.class);

        EasyMock.expect(mockDaoProduit.getAll()).andReturn(resultGetAll);
        
        EasyMock.expect(mockDaoProduit.getStockByProduit("Produit1")).andReturn(35);
        EasyMock.expect(mockDaoProduit.getStockByProduit("Produit2")).andReturn(70);

        EasyMock.expect(mockDaoProduit.getStockByProduit("Produit3")).andReturn(2);
        
        EasyMock.expect(mockDaoProduit.getProduitByReference("Produit1")).andReturn(produit1);
        EasyMock.expect(mockDaoProduit.getProduitByReference("Produit2")).andReturn(produit2);
        
        EasyMock.expect(mockDaoProduit.majProduit(produit1)).andReturn(produit1);
        EasyMock.expect(mockDaoProduit.majProduit(produit2)).andReturn(produit2);
        EasyMock.replay(mockDaoProduit);

        service.setDaoProduit(mockDaoProduit);

    }

    @AfterClass
    public static void tearDown() {
        EasyMock.verify(mockDaoProduit);
    }

    @Test
    public void testGetAll() {
        LOG.info("getAll");
        
        List<ProduitDTO> result = service.getAll();
        assertEquals(resultGetAll, result);
    }
    
    @Test
    public void testDecrementStock() {
        LOG.info("decrementStock");
        boolean expResult = true;
        boolean result = service.decrementStock(commande);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDecrementStockStockInsuffisant() {
        LOG.info("decrementStock");
        boolean expResult = false;
        boolean result = service.decrementStock(commandeStockInsuffisant);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDecrementStockWrongJson() {
        LOG.info("decrementStock");
        boolean expResult = false;
        boolean result = service.decrementStock("mauvais json");
        assertEquals(expResult, result);
    }

}
