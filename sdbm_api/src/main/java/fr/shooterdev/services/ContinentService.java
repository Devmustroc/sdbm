/*
      _____ __                __                 
     / ___// /_  ____  ____  / /____  _____      
     \__ \/ __ \/ __ \/ __ \/ __/ _ \/ ___/
    ___/ / / / / /_/ / /_/ / /_/  __/ /  __          __
   /____/_/ /_/\____/\____/\__/\___/_/  / /   ____ _/ /_ 
                                       / /   / __ `/ __ \
                                      / /___/ /_/ / /_/ /
   -*- By Shooter Dev -*-            /_____/\__,_/_.___/
   -*- Class package: fr.shooterdev.services -*-
   -*- coding: utf-8 -*- 
*/

package fr.shooterdev.services;

import fr.shooterdev.dto.ContinentRequest;
import fr.shooterdev.entity.ContinentEntity;
import fr.shooterdev.repository.ContinentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ContinentService {

    private  ContinentRepository continentRepository;

    private ContinentService() {
        continentRepository = new ContinentRepository();
    }


    @Transactional
    public ContinentEntity create(ContinentRequest request) {
        ContinentEntity continent = new ContinentEntity();

        continent.setNomContinent(request.nomContinent());
        continentRepository.persist(continent);

        return continent;
    }

    public ContinentEntity getById(int id) {
        return continentRepository.findByIdOptional(id)
                .orElseThrow(() -> new IllegalArgumentException("Couleur with id " + id + " not found"));
    }

    public List<ContinentEntity> getAll() {
        return continentRepository.listAll();
    }

    @Transactional
    public void update(int id, ContinentRequest request) {
        continentRepository.findByIdOptional(id)
                .ifPresent(continent -> {
                    continent.setNomContinent(request.nomContinent());
                    continentRepository.persist(continent);
                });
    }

    @Transactional
    public void delete(int id) {
        continentRepository.deleteById(id);
    }
}