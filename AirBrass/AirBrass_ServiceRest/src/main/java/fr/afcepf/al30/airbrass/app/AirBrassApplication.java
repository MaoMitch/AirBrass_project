package fr.afcepf.al30.airbrass.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

import fr.afcepf.al30.airbrass.servicerest.ServiceCommande;
import fr.afcepf.al30.airbrass.servicerest.ServiceFormation;
import fr.afcepf.al30.airbrass.servicerest.ServiceProduit;
import fr.afcepf.al30.airbrass.servicerest.ServiceUtilisateur;

public class AirBrassApplication extends Application{
    
    private Set<Object> singletons = new HashSet<>();
    private Set<Class<?>> classes = new HashSet<>();

    public AirBrassApplication() {
        
        CorsFilter corsFilter = new CorsFilter();
        corsFilter.getAllowedOrigins().add("*");
        corsFilter.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH");

        singletons.add(corsFilter);
        
        classes.add(ServiceCommande.class);
        classes.add(ServiceProduit.class);
        classes.add(ServiceUtilisateur.class);
        classes.add(ServiceFormation.class);
        singletons.add(new ServiceCommande());
        singletons.add(new ServiceProduit());
        singletons.add(new ServiceUtilisateur());
        singletons.add(new ServiceFormation());
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
    
    
    
    
}
