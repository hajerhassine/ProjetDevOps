package com.esprit.examen.repository;

import org.springframework.stereotype.Repository;

import com.esprit.examen.entities.Operateur;

import org.springframework.data.repository.CrudRepository;
@Repository
public interface OperateurRepository   extends CrudRepository<Operateur, Long>{

}
