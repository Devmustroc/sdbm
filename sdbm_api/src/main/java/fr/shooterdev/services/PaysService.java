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

import fr.shooterdev.dto.PaysRequest;
import fr.shooterdev.entity.PaysEntity;
import fr.shooterdev.repository.PaysRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PaysService {

    private  PaysRepository paysRepository;

    private PaysService() {
        paysRepository = new PaysRepository();
    }


    @Transactional
    public PaysEntity create(PaysRequest request) {
        PaysEntity pays = new PaysEntity();

        pays.setNomPays(request.nomPays());
        paysRepository.persist(pays);

        return pays;
    }

    public PaysEntity getById(int id) {
        return paysRepository.findByIdOptional(id)
                .orElseThrow(() -> new IllegalArgumentException("Couleur with id " + id + " not found"));
    }

    public List<PaysEntity> getAll() {
        return paysRepository.listAll();
    }

    @Transactional
    public void update(int id, PaysRequest request) {
        paysRepository.findByIdOptional(id)
                .ifPresent(pays -> {
                    pays.setNomPays(request.nomPays());
                    paysRepository.persist(pays);
                });
    }

    @Transactional
    public void delete(int id) {
        paysRepository.deleteById(id);
    }
}