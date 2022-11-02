package com.esprit.examen.service;

import java.util.List;
import com.esprit.examen.entities.Operateur;


public interface IOperateur {
	List<Operateur> retrieveAllOperateurs();

	Operateur addOperateur(Operateur o);

	void deleteOperateur(Long id);

	Operateur updateOperateur(Operateur o);

	Operateur retrieveOperateur(Long id);

}
