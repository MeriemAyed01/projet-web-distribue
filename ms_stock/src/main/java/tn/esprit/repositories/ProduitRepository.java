package tn.esprit.repositories;

import tn.esprit.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,String> {
}


