package fr.afcepf.al30.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Formateur.class)
public class Formateur_ {

	  public static volatile SingularAttribute<Formateur, Integer> id;
	  public static volatile SingularAttribute<Formateur, String> nom;
	  public static volatile SetAttribute<Formateur, Formation> formations;
}
