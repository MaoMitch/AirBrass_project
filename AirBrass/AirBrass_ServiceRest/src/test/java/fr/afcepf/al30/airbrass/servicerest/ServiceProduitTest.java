package fr.afcepf.al30.airbrass.servicerest;

import fr.afcepf.al30.airbrass.business.api.IBusinessProduit;
import fr.afcepf.al30.airbrass.dto.DTOMarque;
import fr.afcepf.al30.airbrass.dto.DTOProduit;
import fr.afcepf.al30.airbrass.dto.DTOSpecialisationProduit;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.DaoException;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import java.lang.reflect.Field;
import java.util.ArrayList;
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
public class ServiceProduitTest {

    private static ServiceProduit service;
    private static Class<?> clazz;

    private static IBusinessProduit buProduitMock;

    private static List<DTOProduit> getAllProduitResult;
    private static DTOProduit getAllProduit1;
    private static DTOProduit getAllProduit2;
    private static DTOProduit getAllProduit3;
    
    private static List<DTOMarque> getAllMarqueResult;
    private static DTOMarque getAllMarque1;
    private static DTOMarque getAllMarque2;
    
    private static List<DTOSpecialisationProduit> getAllSpecsResult;
    private static DTOSpecialisationProduit getAllSpecialisationProduit1;
    private static DTOSpecialisationProduit getAllSpecialisationProduit2;
    
    private static String specialisations;
    private static String marques;
    
    private static List<DTOProduit> getParOptionResult;
    private static DTOProduit getParOption1;
    private static DTOProduit getParOption2;
    
    private static List<DTOProduit> getParOptionResultNull;
    private static DTOProduit getParOptionNull1;
    private static DTOProduit getParOptionNull2;
    
    private static final String ID_GET_BY_ID_NOMINAL = "1";
    private static DTOProduit getByIdNominal;
    
    private static final String ID_GET_BY_ID_ERREUR = "254";
    
    public static void initEntity() {
        getAllProduitResult = new ArrayList<>();
        getAllProduit1 = new DTOProduit("intitule1", "description1", 12.5, "photo", "reference1", 135);
        getAllProduit2 = new DTOProduit("intitule2", "description2", 22.5, "photo", "reference2", 235);
        getAllProduit3 = new DTOProduit("intitule3", "description3", 33.5, "photo", "reference3", 335);
        getAllProduitResult.add(getAllProduit1);
        getAllProduitResult.add(getAllProduit2);
        getAllProduitResult.add(getAllProduit3);
        
        getAllMarqueResult = new ArrayList<>();
        getAllMarque1 = new DTOMarque("intitule1", "logo1");
        getAllMarque2 = new DTOMarque("intitule2", "logo2");
        getAllMarqueResult.add(getAllMarque1);
        getAllMarqueResult.add(getAllMarque2);
        
        getAllSpecsResult = new ArrayList<>();
        getAllSpecialisationProduit1 = new DTOSpecialisationProduit("intitule1", "Guitare");
        getAllSpecialisationProduit2 = new DTOSpecialisationProduit("intitule2", "Guitare");
        getAllSpecsResult.add(getAllSpecialisationProduit1);
        getAllSpecsResult.add(getAllSpecialisationProduit2);
        
        specialisations = "guitare";
        marques = "Gibson,Fender";
        
        getParOptionResult = new ArrayList<>();
        getParOption1 = new DTOProduit("intitule1", "description1", 12.5, "photo", "reference1", 135);
        getParOption2 = new DTOProduit("intitule2", "description2", 22.5, "photo", "reference2", 235);
        getParOptionResult.add(getParOption1);
        getParOptionResult.add(getParOption2);
        
        getParOptionResultNull = new ArrayList<>();
        getParOptionNull1 = new DTOProduit("intitule3", "description3", 12.5, "photo", "reference3", 135);
        getParOptionNull2 = new DTOProduit("intitule4", "description4", 22.5, "photo", "reference4", 235);
        getParOptionResultNull.add(getParOptionNull1);
        getParOptionResultNull.add(getParOptionNull2);
        
        getByIdNominal = new DTOProduit("intitule1", "description1", 12.5, "photo", "reference1", 135);
        getByIdNominal.setId(Integer.parseInt(ID_GET_BY_ID_NOMINAL));
    }

    public static void initBuProduit() throws AirBrassException {
        buProduitMock = EasyMock.createMock(IBusinessProduit.class);
        EasyMock.expect(buProduitMock.getAllProduits()).andReturn(getAllProduitResult);
        EasyMock.expect(buProduitMock.getAllMarque()).andReturn(getAllMarqueResult);
        EasyMock.expect(buProduitMock.getAllSpecs()).andReturn(getAllSpecsResult);
        EasyMock.expect(buProduitMock.getProduitParOptions(EasyMock.anyObject(ArrayList.class), EasyMock.notNull(ArrayList.class))).andReturn(getParOptionResult);
        EasyMock.expect(buProduitMock.getProduitById(Integer.parseInt(ID_GET_BY_ID_NOMINAL))).andReturn(getByIdNominal);
        EasyMock.expect(buProduitMock.getProduitById(Integer.parseInt(ID_GET_BY_ID_ERREUR))).andThrow(new DaoException(ExceptionEnum.AUCUN_RESULTAT, "produit introuvable"));
        EasyMock.expect(buProduitMock.getProduitParOptions(EasyMock.anyObject(ArrayList.class), EasyMock.isNull(ArrayList.class))).andReturn(getParOptionResultNull);
        EasyMock.expect(buProduitMock.getProduitParOptions(EasyMock.anyObject(ArrayList.class), EasyMock.isNull(ArrayList.class))).andReturn(getParOptionResultNull);
        EasyMock.replay(buProduitMock);
    }

    @BeforeClass
    public static void init() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, AirBrassException {
        service = new ServiceProduit();
        clazz = service.getClass();
        initEntity();
        initBuProduit();
        Field attBuProduit = clazz.getDeclaredField("buProduit");
        attBuProduit.setAccessible(true);
        attBuProduit.set(service, buProduitMock);
    }
    
    @Test
    public void getAllProduitsNominal() {
        List<DTOProduit> results = service.getAllProduits();
        Assert.assertNotNull(results);
        Assert.assertEquals(getAllProduitResult, results);
    }
    
    @Test
    public void getAllMarquesNominal() {
        List<DTOMarque> results = service.getAllMarques();
        Assert.assertNotNull(results);
        Assert.assertEquals(getAllMarqueResult, results);
    }
    
    @Test
    public void getAllSpecsNominal() {
        List<DTOSpecialisationProduit> results = service.getAllSpecs();
        Assert.assertNotNull(results);
        Assert.assertEquals(getAllSpecsResult, results);
    }
    
    @Test
    public void getProduitParOptionsNominal() {
        List<DTOProduit> results = service.getProduitParOptions(specialisations, marques);
        Assert.assertNotNull(results);
        Assert.assertEquals(getParOptionResult.get(0).getDescription(), results.get(0).getDescription());
    }
    
    @Test
    public void getProduitParOptionsMarquesNull() {
        List<DTOProduit> results = service.getProduitParOptions(specialisations, null);
        Assert.assertNotNull(results);
        Assert.assertEquals(getParOptionResultNull.get(0).getDescription(), results.get(0).getDescription());
    }
    
    @Test
    public void getProduitParOptionsMarquesStringVide() {
        List<DTOProduit> results = service.getProduitParOptions(specialisations, "");
        Assert.assertNotNull(results);
        Assert.assertEquals(getParOptionResultNull.get(0).getDescription(), results.get(0).getDescription());
    }
    
    @Test
    public void getProduitByIdNominal() {
        Response result = service.getProduitById(ID_GET_BY_ID_NOMINAL);
        Assert.assertNotNull(result);
        Assert.assertEquals(200, result.getStatus());
        Assert.assertEquals(getByIdNominal, result.getEntity());
    }
    
    @Test
    public void getProduitByIdError() {
        Response result = service.getProduitById(ID_GET_BY_ID_ERREUR);
        Assert.assertNotNull(result);
        Assert.assertEquals(500, result.getStatus());
        Assert.assertEquals(ExceptionEnum.AUCUN_RESULTAT, result.getEntity());
    }
}
