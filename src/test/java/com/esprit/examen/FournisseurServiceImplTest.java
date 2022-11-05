package com.esprit.examen;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;




import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;




import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.services.IFournisseurService;



@SpringBootTest(classes=FournisseurServiceImplTest.class)
@ExtendWith(MockitoExtension.class)
public class FournisseurServiceImplTest {
	//private static final Logger l = LogManager.getLogger(FournisseurServiceImpl.class);

	 @Mock
	 FournisseurRepository fournisseurRepository;

	    @InjectMocks
	    IFournisseurService fournisseurServiceImpl;

	

	
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
	    


	 
}


