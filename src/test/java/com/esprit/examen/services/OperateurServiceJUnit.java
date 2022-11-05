/*package com.esprit.examen.services;


import com.esprit.examen.entities.Operateur;
import com.esprit.examen.service.OperateurService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OperateurServiceJUnit {


    @Autowired
    OperateurService os;
    @Test
    @Order(2)
     void testretrieveAllOperateurs(){
       int listOperateur = os.retrieveAllOperateurs().size();
        List<Operateur> listOperateurs = os.retrieveAllOperateurs();
        Assertions.assertEquals(listOperateur,listOperateurs.size());
    }

    @Test
    @Order(3)
     void testretrieveOperateur(){
       Operateur op = os.addOperateur(Operateur.builder()
               .nom("Hamdi")
               .prenom("Wedi")
               .password("root")
               .build());
        Assertions.assertEquals(op.getIdOperateur() , os.retrieveOperateur(op.getIdOperateur()).getIdOperateur()) ;
    }



    @Test
    @Order(1)
     void testaddOperateur(){
        Operateur op = os.addOperateur(Operateur.builder()
                .nom("Trifi")
                .prenom("Eya")
                .password("root")
                .build());
        Assertions.assertNotNull(op);


    }

    @Test
    @Order(5)
     void testdeleteOperateur(){
       Operateur op = os.addOperateur(Operateur.builder()
               .nom("Maria")
               .prenom("Trifi")
               .password("root")
               .build());
        os.deleteOperateur(op.getIdOperateur());
        //Assertions.assertEquals(- 1,os.retrieveAllOperateurs().size());
        Assertions.assertNull(os.retrieveOperateur(op.getIdOperateur()));

    }

    @Test
    @Order(4)
     void tesupdateOperateur(){
       Operateur op = os.addOperateur(Operateur.builder()
               .nom("Noura")
               .prenom("Trifi")
               .password("root")
               .build());
        op.setPrenom("Nounou");
        os.updateOperateur(op);
        Assertions.assertEquals("Nounou", os.updateOperateur(op).getPrenom());

    }

}








*/



