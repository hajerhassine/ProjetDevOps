package com.esprit.examen.services;


import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repository.OperateurRepository;
import com.esprit.examen.service.OperateurService;



import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;



@ExtendWith(MockitoExtension.class)

public class OperateurServiceImplTest {

	   @Mock
	    OperateurRepository operateurRepositoryMock;
	    @InjectMocks
	    OperateurService operateurService;



    @Test
    public void retrieveAllOperateur() {
        when(operateurRepositoryMock.findAll()).thenReturn(Stream.of(
                        new Operateur("yasmine", "manita", "pwd"),
                        new Operateur("ines", "alioua", "kkk"),
                        new Operateur("pwd", "fedi", "test"))
                .collect(Collectors.toList()));
        assertEquals(3,operateurService.retrieveAllOperateurs().size());

    }

    @Test
    public void addOperateurTest() {
        Operateur ss = new Operateur("yasmine", "manita", "ccc");
        when(operateurRepositoryMock.save(ss)).thenReturn(ss);
        assertEquals(ss, operateurService.addOperateur(ss));
    }


    @Test
    public void deleteOperateurTest() {
        Operateur ss = new Operateur("yasmine", "manita", "ccc");
        operateurService.deleteOperateur((long) 1);
        verify(operateurRepositoryMock).deleteById((long) 1);

    }

    @Test
    public void updatetStockTest() {
        Operateur ss = new Operateur("yasmine", "manita","ccc") ;
        Mockito.when(operateurRepositoryMock.save(Mockito.any(Operateur.class))).thenReturn(ss);
        ss.setNom("mohamed");
        Operateur exisitingOp= operateurService.updateOperateur(ss) ;

        assertNotNull(exisitingOp);
        assertEquals("mohamed", ss.getNom());
    }






}