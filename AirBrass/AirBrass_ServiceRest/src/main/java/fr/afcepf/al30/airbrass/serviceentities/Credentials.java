package fr.afcepf.al30.airbrass.serviceentities;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 * Les crédentials utilisé pour la connection.
 */
@Getter
@Setter
@XmlRootElement(name = "credentials")
public class Credentials {
	private String login;
	private String password;
}
