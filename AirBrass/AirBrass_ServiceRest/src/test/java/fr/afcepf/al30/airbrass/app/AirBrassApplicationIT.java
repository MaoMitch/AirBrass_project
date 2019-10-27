///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fr.afcepf.al30.airbrass.app;
//
//import fr.afcepf.al30.airbrass.servicerest.ServiceCommande;
//import fr.afcepf.al30.airbrass.servicerest.ServiceFormation;
//import fr.afcepf.al30.airbrass.servicerest.ServiceProduit;
//import fr.afcepf.al30.airbrass.servicerest.ServiceUtilisateur;
//import java.util.HashSet;
//import java.util.Set;
//import org.jboss.resteasy.plugins.interceptors.CorsFilter;
//import org.junit.AfterClass;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
///**
// *
// * @author Max Michel
// */
//public class AirBrassApplicationIT {
//    
//    public AirBrassApplicationIT() {
//    }
//    
//    private static Set<Object> singletons;
//    private static Set<Class<?>> classes;
//    private static AirBrassApplication instance;
//    @BeforeClass
//    public static void setUpClass() {
//        singletons = new HashSet<>();
//        classes = new HashSet<>();
//        CorsFilter corsFilter = new CorsFilter();
//        corsFilter.getAllowedOrigins().add("*");
//        corsFilter.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH");
//
//        singletons.add(corsFilter);
//        
//        classes.add(ServiceCommande.class);
//        classes.add(ServiceProduit.class);
//        classes.add(ServiceUtilisateur.class);
//        classes.add(ServiceFormation.class);
//        singletons.add(new ServiceCommande());
//        singletons.add(new ServiceProduit());
//        singletons.add(new ServiceUtilisateur());
//        singletons.add(new ServiceFormation());
//        
//        instance = new AirBrassApplication();
//    }
//    /**
//     * Test of getClasses method, of class AirBrassApplication.
//     */
//    @Test
//    public void testGetClasses() {
//        System.out.println("getClasses");
//        
//        Set<Class<?>> expResult = classes;
//        Set<Class<?>> result = instance.getClasses();
//        Assert.assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        Assert.fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getSingletons method, of class AirBrassApplication.
//     */
//    @Test
//    public void testGetSingletons() {
//        System.out.println("getSingletons");
//        Set<Object> expResult = singletons;
//        Set<Object> result = instance.getSingletons();
//        Assert.assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        Assert.fail("The test case is a prototype.");
//    }
//    
//}
