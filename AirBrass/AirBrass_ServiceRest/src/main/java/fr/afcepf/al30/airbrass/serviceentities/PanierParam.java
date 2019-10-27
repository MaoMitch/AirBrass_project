package fr.afcepf.al30.airbrass.serviceentities;

import fr.afcepf.al30.airbrass.dto.DTOCB;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 * L'objet panier communique via Angular.js.
 */
@Getter
@Setter
@XmlRootElement(name="panierParam")
public class PanierParam {

    private int idPers;
    private String dateCommande;
    private List<LigneComParam> panier = new ArrayList<>();
    private DTOCB cb;
    private Double prixLivraison;
}
