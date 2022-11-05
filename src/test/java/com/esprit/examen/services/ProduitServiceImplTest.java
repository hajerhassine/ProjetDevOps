package com.esprit.examen.services;

import org.junit.jupiter.api.Test;

import java.util.List;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Produit;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProduitServiceImplTest {

	 @Autowired
	    
	    IProduitService ps;

    @Test
    void retrieveAllProduits() {
    	List<Produit> listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(0, listProduits.size());
    }

}