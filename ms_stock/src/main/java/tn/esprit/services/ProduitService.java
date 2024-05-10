package tn.esprit.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import tn.esprit.dto.ProduitDto;
import tn.esprit.entities.Produit;
import tn.esprit.repositories.ProduitRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j


public class ProduitService implements IProduitService {

     ProduitRepository productRepository;
     ObjectMapper objectMapper;
    @Override
    public Produit addProduct(Produit product) {


        return productRepository.save(product);
    }

    @Override
    public ProduitDto getProductById(String id) {

        var produit = productRepository.findById(id).get();

         return objectMapper.convertValue(produit,ProduitDto.class);
    }
}
