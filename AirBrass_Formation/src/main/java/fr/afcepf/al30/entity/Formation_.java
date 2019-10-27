package fr.afcepf.al30.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Formation.class)
public class Formation_ {
  
  public static volatile SingularAttribute<Formation, Integer> id;
  public static volatile SingularAttribute<Formation, String> intitule;
  public static volatile SingularAttribute<Formation, Date> date;
  public static volatile SingularAttribute<Formation, Double> prix;
  public static volatile SingularAttribute<Formation, String> disponibilite;
  public static volatile SingularAttribute<Formation, String> niveau;
  public static volatile SetAttribute<Formation, Formateur_> formateur;

}
