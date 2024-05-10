package tn.esprit.events;


import tn.esprit.dto.ProduitDto;
import tn.esprit.services.IProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductEventHandler {
    private final IProduitService productService;

    public void handleProductCreatedEvent(ProduitDto productDto) {
        System.out.println(productDto.toString());
        productService.addProduct(productDto.mapToProduct(productDto));
    }

}