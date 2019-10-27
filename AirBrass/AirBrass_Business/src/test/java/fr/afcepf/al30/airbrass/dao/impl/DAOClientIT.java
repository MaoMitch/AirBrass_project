package fr.afcepf.al30.airbrass.dao.impl;

import fr.afcepf.al30.airbrass.dao.api.IDAOClient;
import fr.afcepf.al30.airbrass.deployementutils.DeployementTools;
import fr.afcepf.al30.airbrass.dto.DTOAdresse;
import fr.afcepf.al30.airbrass.dto.DTOPays;
import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.dto.DTOVille;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;

/**
 *
 * @author Stagiaire
 */
@RunWith(Arquillian.class)
public class DAOClientIT {

    @EJB
    private IDAOClient daoClient;

    private static Logger log = Logger.getLogger(DAOClientIT.class);
    
    private DTOPays ajoutPaysNominal;
    private DTOVille ajoutVilleNominal;
    private DTOAdresse ajoutAdresseNominal;
    private DTOPersonne ajoutPersonneNominal;

    private DTOPersonne expectAjoutPersonneNominal;
    
    @Deployment
    public static Archive<?> deploy() {
        return DeployementTools.getDeployementWarArchive()
                .addClass(IDAOClient.class).addClass(DAOClient.class);
    }

    public DAOClientIT() {
    }

    @Before
    public void setUp() {
        ajoutPersonneNominal = new DTOPersonne("nominal test nom", "nominal test prenom", new Date(), "adresseMail", "telephone", "password", new ArrayList<>());
        ajoutPaysNominal = new DTOPays("Tanzania");
        ajoutPaysNominal.setId(67);
        ajoutVilleNominal = new DTOVille("Cape Breton Island", "11618", ajoutPaysNominal);
        ajoutVilleNominal.setId(10);
        ajoutAdresseNominal = new DTOAdresse(1, "Appartement 957-6848 Odio Impasse", "vitae, sodales at,", ajoutVilleNominal);
        ajoutAdresseNominal.setId(1);
        ajoutPersonneNominal.getDtoAdresses().add(ajoutAdresseNominal);

        expectAjoutPersonneNominal = new DTOPersonne("nominal test nom", "nominal test prenom", new Date(), "adresseMail", "telephone", "password", new ArrayList<>());
        expectAjoutPersonneNominal.setId(12);
        expectAjoutPersonneNominal.getDtoAdresses().add(ajoutAdresseNominal);
    }

    /**
     * Test of getClientById method, of class DAOClient.
     */
    @Test
    public void testGetClientById() throws Exception {
        log.info("getClientById");
        int id = 1;
        DTOPersonne result = daoClient.getClientById(id);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getId());
        Assert.assertEquals(Integer.parseInt("1"), result.getId());
    }

    /**
     * Test of getAllClient method, of class DAOClient.
     */
    @Test
    public void testGetAllClient() throws Exception {
        log.info("getAllClient not implemented");
//        List<DTOPersonne> expResult = null;
//        List<DTOPersonne> result = daoClient.getAllClient();
//        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of createNewClient method, of class DAOClient.
     */
    @Test
    public void testCreateNewClient() throws Exception {
        log.info("createNewClient");
        System.out.println(ajoutPersonneNominal);
        System.out.println(ajoutPersonneNominal.getAdresseMail());
        System.out.println(ajoutPersonneNominal.getNom());
        System.out.println(ajoutPersonneNominal.getDateNaissance());
        System.out.println(ajoutPersonneNominal.getPassword());
        System.out.println(ajoutPersonneNominal.getPrenom());
        
        DTOPersonne result = daoClient.saveClient(ajoutPersonneNominal);
        
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getId());
        Assert.assertEquals(result.getId(), expectAjoutPersonneNominal.getId());
        Assert.assertEquals(result.getNom(), expectAjoutPersonneNominal.getNom());
        Assert.assertEquals(result.getPrenom(), expectAjoutPersonneNominal.getPrenom());
        Assert.assertEquals(result.getAdresseMail(), expectAjoutPersonneNominal.getAdresseMail());
        Assert.assertEquals(result.getTelephone(), expectAjoutPersonneNominal.getTelephone());
        Assert.assertNotEquals(result.getPassword(), expectAjoutPersonneNominal.getPassword());
        log.info("Password en clair : " + expectAjoutPersonneNominal.getPassword());
        log.info("Password en base : " + result.getPassword());
        log.info("Fin\n");
    }

    /**
     * Test of updateClient method, of class DAOClient.
     */
    @Test
    public void testUdapteClient() throws Exception {
        log.info("udapteClient not implemented");
//        DTOPersonne pers = null;
//        DTOPersonne expResult = null;
//        DTOPersonne result = daoClient.updateClient(pers);
//        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of connectClient method, of class DAOClient.
     */
    @Test
    public void testConnectClient() throws Exception {
        log.info("connectClient");
        String login = "seb@gmail.com";
        String password = "afcepf2016";
        
        DTOPersonne result = daoClient.connectClient(login, password);
        
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getId());
        Assert.assertEquals(result.getId(), Integer.parseInt("1"));
        
    }

    /**
     * Test of clientDontExist on nominal method, of class DAOClient.
     */
    @Test
    public void testClientDontExistNominal() throws Exception {
        log.info("clientDontExist True");
        String adresseMail = "exotic@adress.fr";
        boolean expResult = true;
        boolean result = daoClient.clientDontExist(adresseMail);
        Assert.assertEquals(expResult, result);
        log.info("Fini\n");
    }
    
    /**
     * Test of clientDontExist on false method, of class DAOClient.
     */
    @Test
    public void testClientDontExistFalse() throws Exception {
        log.info("clientDontExist False");
        String adresseMail = "seb@gmail.com";
        boolean expResult = false;
        boolean result = daoClient.clientDontExist(adresseMail);
        Assert.assertEquals(expResult, result);
        log.info("Fini\n");
    }

}
