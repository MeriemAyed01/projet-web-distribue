package tn.esprit.repositories;

import tn.esprit.entities.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProduitRepository extends MongoRepository<Produit,String> {
}


