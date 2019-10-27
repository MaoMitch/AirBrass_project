
package fr.afcepf.al30.stock.airbrass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour decrementeStockResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="decrementeStockResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="decrement" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "decrementeStockResponse", propOrder = {
    "decrement"
})
public class DecrementeStockResponse {

    protected boolean decrement;

    /**
     * Obtient la valeur de la propriété decrement.
     * 
     */
    public boolean isDecrement() {
        return decrement;
    }

    /**
     * Définit la valeur de la propriété decrement.
     * 
     */
    public void setDecrement(boolean value) {
        this.decrement = value;
    }

}
