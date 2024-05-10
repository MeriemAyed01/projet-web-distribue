package tn.esprit.services;


import tn.esprit.dto.ProduitDto;
import tn.esprit.entities.Produit;

public interface IProduitService {

     Produit addProduct(Produit product);

     ProduitDto getProductById(String id);
}
