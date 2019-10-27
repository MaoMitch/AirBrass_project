package fr.afcepf.al30.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import fr.afcepf.al30.stock.dto.ProduitDTO;

@WebService(targetNamespace = "http://airbrass.stock.al30.afcepf.fr",
name = "stock")
public interface IGestionStock {

	@WebMethod(operationName="getAllProduit")
	@WebResult(name="listeProduit")
	List<ProduitDTO> getAll();
	
	@WebMethod(operationName="checkStock")
	@WebResult(name="listeArticle")
	String checkStock(@WebParam(name="commande")String commande);
	
	@WebMethod(operationName="decrementeStock")
	@WebResult(name="decrement")
	boolean decrementStock(@WebParam(name="commande")String commande);
}
