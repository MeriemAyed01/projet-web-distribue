package tn.esprit.services;

import tn.esprit.client.FullProduitResponse;
import tn.esprit.entities.Produit;

public interface IProduitService {
     Produit addProduct(Produit product);

     FullProduitResponse getProductById(String id);
}
