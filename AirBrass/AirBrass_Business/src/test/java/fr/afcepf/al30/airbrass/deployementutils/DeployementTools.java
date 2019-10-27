/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al30.airbrass.deployementutils;

import fr.afcepf.al30.airbrass.entities.Adresse;
import fr.afcepf.al30.airbrass.entities.AvisClient;
import fr.afcepf.al30.airbrass.entities.CB;
import fr.afcepf.al30.airbrass.entities.Commande;
import fr.afcepf.al30.airbrass.entities.LigneCommande;
import fr.afcepf.al30.airbrass.entities.Marque;
import fr.afcepf.al30.airbrass.entities.Pays;
import fr.afcepf.al30.airbrass.entities.Personne;
import fr.afcepf.al30.airbrass.entities.Produit;
import fr.afcepf.al30.airbrass.entities.Promotion;
import fr.afcepf.al30.airbrass.entities.SpecialisationProduit;
import fr.afcepf.al30.airbrass.enums.TypeProduit;
import fr.afcepf.al30.airbrass.entities.Ville;
import fr.afcepf.al30.airbrass.entities.Vues;
import fr.afcepf.al30.airbrass.enums.EnumPromotion;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

/**
 *
 * @author Stagiaire
 */
public class DeployementTools {

    public static WebArchive getDeployementWarArchive() {
        WebArchive daoJarBeans = ShrinkWrap.create(WebArchive.class, "daoBeans.war");
        daoJarBeans.addAsLibraries(
                Maven.resolver().loadPomFromClassLoaderResource("persistence-test-pom.xml")
                        .importRuntimeDependencies().resolve().withTransitivity().asFile());
        daoJarBeans.addPackages(true, "fr.afcepf.al30.airbrass.entities");
        daoJarBeans.addPackages(true, "fr.afcepf.al30.airbrass.dto");
        daoJarBeans.addPackages(true, "fr.afcepf.al30.airbrass.assembleur");
        daoJarBeans.addPackages(true, "fr.afcepf.al30.airbrass.exceptions")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsLibrary(ShrinkWrap.create(JavaArchive.class, "entityBean.jar")
                        .addClasses(Adresse.class, AvisClient.class,
                                CB.class, Commande.class,
                                EnumPromotion.class,
                                LigneCommande.class,
                                Marque.class,
                                Pays.class, Personne.class, Produit.class, Promotion.class,
                                SpecialisationProduit.class,
                                TypeProduit.class,
                                Ville.class,
                                Vues.class).addAsManifestResource("persistence_test.xml", ArchivePaths.create("persistence.xml"))
                        .addAsResource("import.sql").addAsManifestResource(EmptyAsset.INSTANCE, "beansEntity.xml")
                );
        return daoJarBeans;
    }
}
