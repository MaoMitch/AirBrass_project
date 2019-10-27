
package fr.afcepf.al30.formations;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour niveau.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="niveau">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DEBUTANT"/>
 *     &lt;enumeration value="CONFIRME"/>
 *     &lt;enumeration value="EXPERT"/>
 *     &lt;enumeration value="TOUTNIVEAU"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "niveau")
@XmlEnum
public enum Niveau {

    DEBUTANT,
    CONFIRME,
    EXPERT,
    TOUTNIVEAU;

    public String value() {
        return name();
    }

    public static Niveau fromValue(String v) {
        return valueOf(v);
    }

}
