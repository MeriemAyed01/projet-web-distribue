package tn.esprit.controller;

import tn.esprit.entities.Stock;
import tn.esprit.services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final IStockService stockService;

    @Autowired
    public StockController(IStockService stockService) {
        this.stockService = stockService;
    }


    @PostMapping
    public Stock addStockItem(@RequestBody Stock stockItem) {
        return stockService.addStockItem(stockItem);
    }

    @GetMapping("/{id}")
    public Stock getStockItemById(@PathVariable("id") Long id) {
        return stockService.getStockItemById(id);
    }
}
