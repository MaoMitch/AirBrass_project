package fr.afcepf.al30.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import fr.afcepf.al30.stock.data.IDaoProduit;
import fr.afcepf.al30.stock.dto.OrchestrateurCommandeDTO;
import fr.afcepf.al30.stock.dto.ProduitDTO;
import org.apache.log4j.Logger;

@WebService(targetNamespace = "http://airbrass.stock.al30.afcepf.fr",
        endpointInterface = "fr.afcepf.al30.ws.IGestionStock")
public class GestionStock implements IGestionStock {

    private static Logger log = Logger.getLogger(GestionStock.class);
    private IDaoProduit daoProduit;

    @Override
    public List<ProduitDTO> getAll() {
        return daoProduit.getAll();
    }

    @Override
    public String checkStock(String commande) {
        List<String> produit = new ArrayList<>();
        Gson gson = new Gson();
        TypeToken<List<OrchestrateurCommandeDTO>> token = new TypeToken<List<OrchestrateurCommandeDTO>>() {
        };
        List<OrchestrateurCommandeDTO> commandes = gson.fromJson(commande, token.getType());
        for (OrchestrateurCommandeDTO orchestrateurCommandeDTO : commandes) {
            if (daoProduit.getStockByProduit(orchestrateurCommandeDTO.getRefProduit()) < orchestrateurCommandeDTO.getQteProduit()) {
                produit.add(orchestrateurCommandeDTO.getRefProduit());
            }
        }
        return gson.toJson(produit);
    }

    @Override
    public boolean decrementStock(String commande) {
        boolean decrement = true;
        try {
            if ("[]".equals(checkStock(commande))) {
                Gson gson = new Gson();
                TypeToken<List<OrchestrateurCommandeDTO>> token = new TypeToken<List<OrchestrateurCommandeDTO>>() {
                };
                List<OrchestrateurCommandeDTO> commandes = gson.fromJson(commande, token.getType());
                for (OrchestrateurCommandeDTO orchestrateurCommandeDTO : commandes) {
                    ProduitDTO dto = daoProduit.getProduitByReference(orchestrateurCommandeDTO.getRefProduit());
                    dto.setStock((dto.getStock() - orchestrateurCommandeDTO.getQteProduit()));
                    daoProduit.majProduit(dto);
                }
            } else {
                decrement = false;
            }
        } catch (JsonSyntaxException e) {
            decrement = false;
            log.error(e);
        }

        return decrement;
    }

    public void setDaoProduit(IDaoProduit daoProduit) {
        this.daoProduit = daoProduit;
    }

}
