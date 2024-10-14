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

import fr.shooterdev.dto.MarqueRequest;
import fr.shooterdev.entity.MarqueEntity;
import fr.shooterdev.repository.MarqueRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class MarqueService {

    private  MarqueRepository marqueRepository;

    private MarqueService() {
        marqueRepository = new MarqueRepository();
    }


    @Transactional
    public MarqueEntity create(MarqueRequest request) {
        MarqueEntity marque = new MarqueEntity();

        marque.setNomMarque(request.nomMarque());
        marqueRepository.persist(marque);

        return marque;
    }

    public MarqueEntity getById(int id) {
        return marqueRepository.findByIdOptional(id)
                .orElseThrow(() -> new IllegalArgumentException("Couleur with id " + id + " not found"));
    }

    public List<MarqueEntity> getAll() {
        return marqueRepository.listAll();
    }

    @Transactional
    public void update(int id, MarqueRequest request) {
        marqueRepository.findByIdOptional(id)
                .ifPresent(marque -> {
                    marque.setNomMarque(request.nomMarque());
                    marqueRepository.persist(marque);
                });
    }

    @Transactional
    public void delete(int id) {
        marqueRepository.deleteById(id);
    }
}