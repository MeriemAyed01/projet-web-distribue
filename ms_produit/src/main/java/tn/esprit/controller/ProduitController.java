package tn.esprit.controller;

import tn.esprit.client.FullProduitResponse;
import tn.esprit.entities.Produit;
import tn.esprit.services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/produit")
public class ProduitController {

    private final IProduitService iProduitService;

    @Autowired
    public ProduitController(IProduitService iProduitService) {
        this.iProduitService = iProduitService;
    }

    @PostMapping
    public Produit addProduct(@RequestBody Produit product)
    {

        System.out.println("***** add produit *****");
        System.out.println(product);
        return iProduitService.addProduct(product);
    }

    @GetMapping("/{id}")
    public FullProduitResponse getProductById(@PathVariable("id") String id) {
        return iProduitService.getProductById(id);
    }
}