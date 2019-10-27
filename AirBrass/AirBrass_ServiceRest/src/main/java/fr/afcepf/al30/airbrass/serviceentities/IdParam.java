package fr.afcepf.al30.airbrass.serviceentities;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 * Le param contenant l'id.
 * @author Max Michel
 */
@Getter
@Setter
@XmlRootElement(name="idParam")
public class IdParam {
	private String id;
}
