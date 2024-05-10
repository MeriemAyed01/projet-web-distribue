package tn.esprit.services;

import tn.esprit.client.FullProduitResponse;
import tn.esprit.client.StockFeignClient;
import tn.esprit.dto.Event;
import tn.esprit.dto.EventType;
import tn.esprit.dto.ProduitDto;
import tn.esprit.entities.Produit;
import tn.esprit.events.KafkaProd;
import tn.esprit.repositories.ProduitRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j


public class ProduitService implements IProduitService {

     ProduitRepository productRepository;

    StockFeignClient clientStock;

    KafkaProd kafkaProd;

    @Override
    public Produit addProduct(Produit product) {

        Produit prod = productRepository.save(product);

        ProduitDto prodDto = ProduitDto.mapToProductDto(prod);

       kafkaProd.produceEvent(new Event(EventType.CREATED_PRODUCT_EVENT, prodDto, LocalDateTime.now()));

        return prod;
    }

    @Override
    public FullProduitResponse getProductById(String id) {

        var produit = productRepository.findById(id).get();

        var stock = clientStock.findStock(produit.getIdStock());


         return FullProduitResponse.builder()
                 .id(produit.getId())
                 .name(produit.getName())
                 .quantity(produit.getQuantity())
                 .stock(stock)
                 .build();
    }
}
