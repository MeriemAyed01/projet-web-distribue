package tn.esprit.services;

import tn.esprit.entities.Stock;

public interface IStockService {

    Stock addStockItem(Stock stockItem);
    Stock getStockItemById(Long id);
}
