package com.esprit.examen.services;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FournisseurServiceImplTest {
	//private static final Logger l = LogManager.getLogger(FournisseurServiceImpl.class);

	 @Mock
	 FournisseurRepository fournisseurRepository;

	    @InjectMocks
	    IFournisseurService fournisseurServiceImpl;

	
	//@Test
	//public void testretrieveAllFournisseurs() throws ParseException {
	// dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	//	Date dateNaissance = dateFormat.parse("30/09/2000");
		//List<Fournisseur> fournisseurs = fournisseurservice.retrieveAllFournisseurs();
		//int expected = fournisseurs.size();
		//Fournisseur f = new Fournisseur("code", "libelle", dateNaissance, "ahmed.salhi@esprit.tn", "pwd", Profession.Cadre,
		//		categorieFournisseur.Ordinaire);
		//Fournisseur fournisseur = fournisseurservice.addFournisseur(f);
		//assertEquals(expected + 1, fournisseurservice.retrieveAllFournisseurs().size());
		//fournisseurservice.deleteFournisseur(fournisseur.getIdFournisseur());

	//}
	
	
	    Fournisseur fournisseur = new Fournisseur(1L, "code1", "libelle1", CategorieFournisseur.CONVENTIONNE, null, null, null);

	    List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>() {
	        {
	            add(new Fournisseur(2L, "code2", "libelle2", CategorieFournisseur.CONVENTIONNE, null, null, null));
	            add(new Fournisseur(3L, "code3", "libelle3", CategorieFournisseur.ORDINAIRE, null, null, null));
	        }
	    };

	    @Test
	    public void testretrieveFournisseur(){


	        Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));
	        
			
	        Assertions.assertNotNull(fournisseurServiceImpl.retrieveFournisseur(2L));
	    }
	    
	    //Test
	    
	    @Test
	    public void testaddFournisseur(){

	        Mockito.when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);

	        Assertions.assertNotNull(fournisseurServiceImpl.addFournisseur(fournisseur));
	    }

	    @Test
	    public void testdeleteFournisseur(){

	        fournisseurServiceImpl.deleteFournisseur(3L);

	        Mockito.verify(fournisseurRepository, times(1)).deleteById(3L);

	        assertEquals(null, fournisseurServiceImpl.retrieveFournisseur(3L));
	    }
	
}


