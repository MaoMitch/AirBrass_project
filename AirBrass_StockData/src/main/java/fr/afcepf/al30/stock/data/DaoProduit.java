package fr.afcepf.al30.stock.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al30.stock.assembleur.AssembleurDTO;
import fr.afcepf.al30.stock.dto.ProduitDTO;
import fr.afcepf.al30.stock.entity.Produit;

@Component
public class DaoProduit implements IDaoProduit {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public List<ProduitDTO> getAll() {
        TypedQuery<Produit> typedQuery = em.createQuery("SELECT p FROM Produit p", Produit.class);
        List<Produit> produits = typedQuery.getResultList();
        List<ProduitDTO> produitsDTO = new ArrayList<>();
        for (Produit produit : produits) {
            produitsDTO.add(AssembleurDTO.produitToProduitDTO(produit));
        }
        return produitsDTO;
    }

    @Transactional
    @Override
    public int getStockByProduit(String refProduit) {
        Query query = em.createQuery("SELECT p.stock FROM Produit p WHERE p.refProduit = :refProduit");
        query.setParameter("refProduit", refProduit);
        return (int) query.getSingleResult();
    }

    @Transactional
    @Override
    public ProduitDTO getProduitByReference(String refProduit) {
        Query query = em.createQuery("SELECT p FROM Produit p WHERE p.refProduit = :refProduit");
        query.setParameter("refProduit", refProduit);
        Produit produit = (Produit) query.getSingleResult();

        return AssembleurDTO.produitToProduitDTO(produit);
    }

    @Transactional
    @Override
    public ProduitDTO majProduit(ProduitDTO produit) {
        Produit entity = AssembleurDTO.produitDTOToProduit(produit);
        em.merge(entity);
        return AssembleurDTO.produitToProduitDTO(entity);
    }

    @Transactional
    @Override
    public List<ProduitDTO> getProduitStockVide() {
        TypedQuery<Produit> typedQuery = em.createQuery("SELECT p FROM Produit p WHERE p.stock < p.seuil", Produit.class);
        List<Produit> produits = typedQuery.getResultList();
        List<ProduitDTO> produitsDTO = new ArrayList<>();
        for (Produit produit : produits) {
            produitsDTO.add(AssembleurDTO.produitToProduitDTO(produit));
        }
        return produitsDTO;
    }

    @Override
    public ProduitDTO getProduitById(int idProduit) {
        TypedQuery<Produit> query = em.createQuery("SELECT p FROM Produit p WHERE p.id = :idProduit", Produit.class).setParameter("idProduit", idProduit);
        Produit produit = query.getSingleResult();
        return AssembleurDTO.produitToProduitDTO(produit);

    }

    @Transactional
    @Override
    public List<ProduitDTO> getProduitsByFournisseur(int idFournisseur) {
        TypedQuery<Produit> typedQuery = em.createQuery("SELECT p FROM Produit p WHERE p.fournisseur.id = :idFournisseur", Produit.class).setParameter("idFournisseur", idFournisseur);
        List<ProduitDTO> dtoProduits = new ArrayList<>();
        List<Produit> produits = typedQuery.getResultList();
        for (Produit produit : produits) {
            dtoProduits.add(AssembleurDTO.produitToProduitDTO(produit));
        }

        return dtoProduits;
    }

}
