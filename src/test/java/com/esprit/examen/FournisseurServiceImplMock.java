package com.esprit.examen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.services.FournisseurServiceImpl;





@ExtendWith(MockitoExtension.class)
public class FournisseurServiceImplMock {
	//private static final Logger l = LogManager.getLogger(FournisseurServiceImpl.class);

	
	
	 @Mock
	 FournisseurRepository fournisseurRepository;

	 
	    @InjectMocks
	    FournisseurServiceImpl fournisseurServiceImpl;

	 

	  //  @Test
	   // public void retrieveAllFournisseurTest() {
	   // when(fournisseurRepository.findAll()).thenReturn(Stream.of(
	    		 
         //       new Fournisseur("libelle2", "20"),
         //       new Fournisseur("libelle3", "30")
          //      .collect(Collectors.toList()));
	//	assertEquals(3,fournisseurServiceImpl.retrieveAllFournisseurs().size());
		

	   // }
	    @Test
	    public void addFournisseurTest() {
	    	Fournisseur ss = new Fournisseur("libelle2", "20");
	    when(fournisseurRepository.save(ss)).thenReturn(ss);
	    assertEquals(ss, fournisseurServiceImpl.addFournisseur(ss));
	    }
	       
	    
	       
	        @Test
	    public void deleteFournisseurTest() {
	        	Fournisseur ss = new Fournisseur("libelle2", "20");
	        	fournisseurServiceImpl.deleteFournisseur((long) 1);
	    verify(fournisseurRepository).deleteById((long) 1);

	    }
	       
	 //       @Test
	   // public void updatetFournisseurTest() {
	    //    	Fournisseur ss = new Fournisseur("libelle2", "20") ;
	    //Mockito.when(fournisseurRepository.save(Mockito.any(Fournisseur.class))).thenReturn(ss);
	   // ss.setLibelle("mohamed");;
	   // Fournisseur exisitingOp= fournisseurServiceImpl.updateFournisseur(ss) ;

	    //assertNotNull(exisitingOp);
	   // assertEquals("mohamed", ss.getLibelle());
	   // }
	       
	       
	       

}


