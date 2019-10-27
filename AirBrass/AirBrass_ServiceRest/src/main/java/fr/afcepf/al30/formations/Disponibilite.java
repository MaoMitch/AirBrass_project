
package fr.afcepf.al30.formations;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour disponibilite.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="disponibilite">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DISPONIBLE"/>
 *     &lt;enumeration value="RESERVE"/>
 *     &lt;enumeration value="ANNULATION_CLIENT"/>
 *     &lt;enumeration value="ANNULATION_FORMATEUR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "disponibilite")
@XmlEnum
public enum Disponibilite {

    DISPONIBLE,
    RESERVE,
    ANNULATION_CLIENT,
    ANNULATION_FORMATEUR;

    public String value() {
        return name();
    }

    public static Disponibilite fromValue(String v) {
        return valueOf(v);
    }

}
