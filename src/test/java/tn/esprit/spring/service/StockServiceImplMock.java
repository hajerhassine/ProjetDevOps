package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;
import com.esprit.examen.services.StockServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StockServiceImplMock {
	
	
	@Mock
    StockRepository stockRepository;
    @InjectMocks
    StockServiceImpl StI;
    
    
    Stock stock = new Stock("libelleStock1", 10, 3);
    List<Stock> listStocks = new ArrayList<Stock>() {
        {
            add(new Stock("libelleStock2", 20, 5));
            add(new Stock("libelleStock3", 30, 8));
        }
    };
    
    
    
    @Test
    void retrieveStock() {
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        Stock stock1 = StI.retrieveStock(0L);
        Assertions.assertNotNull(stock1);
    }

    
    @Test
    void retrieveAllStocks()
    {
        Mockito.when(stockRepository.findAll()).thenReturn(listStocks);
        List<Stock> list = StI.retrieveAllStocks();
        Assertions.assertNotNull(list);
    }
    
    

}
