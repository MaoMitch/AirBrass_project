package fr.afcepf.al30.managedBean;


import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.google.gson.Gson;

import fr.afcepf.al30.banque.Banque;
import fr.afcepf.al30.banque.ServiceBanqueService;
import fr.afcepf.al30.stock.airbrass.CommandeDTO;
import fr.afcepf.al30.stock.airbrass.FournisseurDTO;
import fr.afcepf.al30.stock.airbrass.GestionStockIHMService;
import fr.afcepf.al30.stock.airbrass.LigneCommandeDTO;
import fr.afcepf.al30.stock.airbrass.ProduitDTO;
import fr.afcepf.al30.stock.airbrass.StockIHM;
import fr.afcepf.al30.stock.airbrass.UtilisateurDTO;
import lombok.Data;

@ManagedBean(name="stock")
@SessionScoped
@Data
public class ManagedBeanStock {

	@ManagedProperty(value="#{utilisateur}")
	private ManagedBeanUtilisateur managedBeanUtilisateur = new ManagedBeanUtilisateur();
	private StockIHM proxyStock;
	private List<ProduitDTO> listeProduit = new ArrayList<ProduitDTO>();
	private ProduitDTO produit = new ProduitDTO();
	private ProduitDTO produitSelected;
	private int quantite;
	private String stock;
	private AlerteStock alert;
	private List<ProduitDTO> stockVide;
	private List<CommandeDTO> commande;
	private CommandeDTO commandeDetail = new CommandeDTO();
	private CommandeDTO commandeSelected;
	private List<LigneCommandeDTO> lignes;
	private List<String> test;
	private List<LigneCommandeDTO> lignesNewCommande;
	private LigneCommandeDTO ligneAjout;
	private int idProduit;
	private int quantiteProduit;
	private CommandeDTO newCommande = new CommandeDTO();
	private UtilisateurDTO utilisateur;
	private int activeIndex;
	private String page;
	private List<FournisseurDTO> fournisseurs;
	private int idFournisseur;
	private FournisseurDTO fournisseurDetail;
	private List<ProduitDTO> produitByFournisseur;
	private static final int QUANTITE_PRODUIT = 0;
	private static final int STOCK_VIDE = 0;
	private List<CommandeDTO> commandeValide;
	private Double prix;
	private Double prixCommande;
	private Banque proxyBanque;
	private Double prixCommande2;
	private Double prixCommandeLivre = 0d;

	@PostConstruct
	public void init() {
		proxyStock = new GestionStockIHMService().getGestionStockIHMPort();
		listeProduit = proxyStock.getAllProduit();
		stockVide= proxyStock.produitsStockVide();
		commande = proxyStock.getCommandeByStatut(StatutCommande.EN_COURS.getValue());
		lignesNewCommande = new ArrayList<>();
		utilisateur = managedBeanUtilisateur.getUser();
		fournisseurs = proxyStock.getAllFournisseur();
		prix = 0d;
		prixCommande = 0d;
		prixCommande2 = 0d;
		idFournisseur = 1;
		fournisseurDetail = proxyStock.getFournisseurById(idFournisseur);
		produitByFournisseur = proxyStock.getProduitByFournisseur(idFournisseur);
		commandeValide = proxyStock.getCommandeByStatut(StatutCommande.RECEPTIONNE.getValue());
		proxyBanque = new ServiceBanqueService().getServiceBanquePort();


	}
	
	
	public int infoProduit() {
		produitByFournisseur = proxyStock.getProduitByFournisseur(idFournisseur);
		fournisseurDetail = proxyStock.getFournisseurById(idFournisseur);
		return idProduit;
	}
	
	public void majProduit(ProduitDTO produit) {
		proxyStock.majProduit(produit);
		init();
	}

	public String deconnect() {
		managedBeanUtilisateur.setUser(null);
		return "/index.xhtml?faces-redirect=true";
	}

	public void cliqueCommande() {
		commandeDetail = commandeSelected;
		lignes = proxyStock.getLigneByCommande(commandeDetail.getId());
		
	}
	
	
	public Double prixCommande(int idCommande) {
		prixCommandeLivre = 0d;
		List<LigneCommandeDTO> ligneCommande = proxyStock.getLigneByCommande(idCommande);
		for (LigneCommandeDTO ligneCommandeDTO : ligneCommande) {
			prixCommandeLivre += (ligneCommandeDTO.getQuantite() * ligneCommandeDTO.getProduit().getPrixFournisseur());
		}
		return prixCommandeLivre;
	}

	public void extend() {
		ligneAjout = new LigneCommandeDTO();
		ProduitDTO dtoProduit = proxyStock.getProduitById(idProduit);
		ligneAjout.setProduit(dtoProduit);
		ligneAjout.setQuantite(quantiteProduit);
		boolean checkPresence = false;
		for (LigneCommandeDTO ligneCommandeDTO : lignesNewCommande) {
			if (ligneCommandeDTO.getProduit().getRefProduit().equals(ligneAjout.getProduit().getRefProduit())) {
				checkPresence = true;
				ligneCommandeDTO.setQuantite(ligneAjout.getQuantite());
			}
		}
		if (!checkPresence) {
			lignesNewCommande.add(ligneAjout);
		}
		
		quantiteProduit = QUANTITE_PRODUIT;

		}

		public void validate() throws DatatypeConfigurationException {
			newCommande.setStatut(StatutCommande.EN_COURS.getValue());
			newCommande.setUser(utilisateur);
			int nbCommandes = proxyStock.getListeCommande().size() + 1;
			String inituleCommande = "CMD " + nbCommandes;
			newCommande.setIntitule(inituleCommande);
			GregorianCalendar greg = new GregorianCalendar();
			greg.setTime(new Date());
			XMLGregorianCalendar xmlGreg =  DatatypeFactory.newInstance().newXMLGregorianCalendar(greg);
			newCommande.setDate(xmlGreg);
			newCommande = proxyStock.addCommande(newCommande);
			for (LigneCommandeDTO ligneCommandeDTO : lignesNewCommande) {
				ligneCommandeDTO.setCommande(newCommande);
				proxyStock.addLigne(ligneCommandeDTO);
				int qte = ligneCommandeDTO.getQuantite();
				double prixFournisseur = ligneCommandeDTO.getProduit().getPrixFournisseur();
				prix += (qte * prixFournisseur);
			}
			init();
			newCommande = new CommandeDTO();
			lignesNewCommande = new ArrayList<>();
		}



		public void accepterCommande() throws DatatypeConfigurationException {
			commandeDetail.setStatut(StatutCommande.RECEPTIONNE.getValue());
			commandeDetail.setUser(utilisateur);
			GregorianCalendar greg = new GregorianCalendar();
			greg.setTime(new Date());
			XMLGregorianCalendar xmlGreg =  DatatypeFactory.newInstance().newXMLGregorianCalendar(greg);
			commandeDetail.setDate(xmlGreg);
			
			List<LigneCommandeDTO> ligneAValider = proxyStock.getLigneByCommande(commandeDetail.getId());
			for (LigneCommandeDTO ligneCommandeDTO : ligneAValider) {
				ProduitDTO produitAModifier = proxyStock.getProduitById(ligneCommandeDTO.getProduit().getId());
				proxyStock.ajoutStock(produitAModifier,ligneCommandeDTO.getQuantite());
				int qte = ligneCommandeDTO.getQuantite();
				double prixFournisseur = ligneCommandeDTO.getProduit().getPrixFournisseur();
				prixCommande2 += ( qte * prixFournisseur );
			}
			CarteBanquaireDTO carteACrediter = new CarteBanquaireDTO("user", "1111", "1111");
			CompteBanquaireDTO compteADebiter = new CompteBanquaireDTO("AirBrass", "2222");
			Gson gson = new Gson();
			String jsonCarte = gson.toJson(carteACrediter);
			String jsonCompte = gson.toJson(compteADebiter);
			
			
			proxyBanque.crediterCarte(prixCommande2, jsonCarte, jsonCompte);
			proxyStock.majCommande(commandeDetail);
			ligneAValider = new ArrayList<>();
			lignes = new ArrayList<>();
			commandeDetail = new CommandeDTO();
			init();

		}

		public void ajoutStock() {
			proxyStock.ajoutStock(produit, quantite);
			init();
			produit = new ProduitDTO();
		}

		public String alerteByProduit(ProduitDTO prod) {
			if(prod.getStock() == 0) {
				stock = AlerteStock.STOCK_VIDE.getDispo();
			} else if ( prod.getStock() < prod.getSeuil() && prod.getStock() != STOCK_VIDE ){
				stock = AlerteStock.STOCK_LIMITE.getDispo();
			}
			else {
				stock = AlerteStock.STOCK_OK.getDispo();
			}
			return stock;
		}
		
		

	}
