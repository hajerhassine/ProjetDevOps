package com.esprit.examen.services;

import java.util.logging.LogManager;


import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
import static org.junit.Assert.*;


import org.springframework.util.Assert;
@SpringBootTest
@RunWith(SpringRunner.class)
public class FournisseurServiceImplTest {
	//private static final Logger l = LogManager.getLogger(FournisseurServiceImpl.class);
	@Autowired
	IFournisseurService fournisseurservice;
	
	@Autowired
	FournisseurRepository entrepriseRepoistory;
	
	
	
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
	
	
	@Test
	public void testGetAllFournisseurs(){
	
		
		List<Fournisseur> fournisseurs =fournisseurservice.retrieveAllFournisseurs();
		for(int i=0 ; i<fournisseurs.size(); i++){
			//l.info(fournisseurs);
			
		}
		Assert.notNull(fournisseurs,"contrat was null");
	}
	
}


