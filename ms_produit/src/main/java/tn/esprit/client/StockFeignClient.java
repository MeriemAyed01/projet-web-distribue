package tn.esprit.client;
import tn.esprit.dto.StockDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stock-service",url = "http://localhost:8089/stock")
public interface StockFeignClient {

    @GetMapping("/{id}")
    StockDto findStock(@PathVariable("id") Long id );
}
