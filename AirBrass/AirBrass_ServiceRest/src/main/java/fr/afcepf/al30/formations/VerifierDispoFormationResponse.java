
package fr.afcepf.al30.formations;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour verifierDispoFormationResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="verifierDispoFormationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="returnVerifierDispoFormation" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verifierDispoFormationResponse", propOrder = {
    "returnVerifierDispoFormation"
})
public class VerifierDispoFormationResponse {

    protected boolean returnVerifierDispoFormation;

    /**
     * Obtient la valeur de la propriété returnVerifierDispoFormation.
     * 
     */
    public boolean isReturnVerifierDispoFormation() {
        return returnVerifierDispoFormation;
    }

    /**
     * Définit la valeur de la propriété returnVerifierDispoFormation.
     * 
     */
    public void setReturnVerifierDispoFormation(boolean value) {
        this.returnVerifierDispoFormation = value;
    }

}
