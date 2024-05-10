package tn.esprit.services;

import tn.esprit.entities.Stock;
import tn.esprit.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService implements IStockService {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock addStockItem(Stock stockItem) {
        return stockRepository.save(stockItem);
    }

    @Override
    public Stock getStockItemById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }
}

