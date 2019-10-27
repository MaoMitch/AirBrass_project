package fr.afcepf.al30.managedBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al30.stock.airbrass.GestionStockIHMService;
import fr.afcepf.al30.stock.airbrass.StockIHM;
import fr.afcepf.al30.stock.airbrass.UtilisateurDTO;
import lombok.Data;
@ManagedBean(name="utilisateur")
@SessionScoped
@Data
public class ManagedBeanUtilisateur {

	private StockIHM proxyStock;
	private UtilisateurDTO user;
	private String login;
	private String password;
	private String page;
	
	@PostConstruct
	public void init() {
		proxyStock = new GestionStockIHMService().getGestionStockIHMPort();
		
	}
	public String connect() {
		user = proxyStock.trouverUtilisateur(login, password);
		if (user.getName() != null) {
			page = "/stock.xhtml?faces-redirect=true";
		} else {
			page ="/index.xhtml";
		}
		return page;
	}	
	
}
