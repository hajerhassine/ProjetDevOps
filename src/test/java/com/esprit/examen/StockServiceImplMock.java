package com.esprit.examen;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

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

@SpringBootTest(classes=StockServiceImplMock.class)
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
    
    @Test
	public void testaddStock() {
		Mockito.when(stockRepository.save(Mockito.any(Stock.class))).thenReturn(stock);
		assertNotNull(StI.addStock(stock));
		//verify(stockRepository).save(s);
	}
    
    @Test
	public void testUpdateStock() {
		Mockito.when(stockRepository.save(Mockito.any(Stock.class))).thenReturn(stock);
		stock.setQte(55);
		assertNotNull(StI.updateStock(stock));	
		assertEquals(55, stock.getQte());
	}
    
    @Test
	public void testDeleteStock() {
    	StI.deleteStock((long)3);
		verify(stockRepository).deleteById((long)3);
	}
    
    

}
