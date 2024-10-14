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

import fr.shooterdev.dto.FabricantRequest;
import fr.shooterdev.entity.FabricantEntity;
import fr.shooterdev.repository.FabricantRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class FabricantService {

    private  FabricantRepository fabricantRepository;

    private FabricantService() {
        fabricantRepository = new FabricantRepository();
    }

    @Transactional
    public FabricantEntity create(FabricantRequest request) {
        FabricantEntity fabricant = new FabricantEntity();

        fabricant.setNomFabricant(request.nomFabricant());
        fabricantRepository.persist(fabricant);

        return fabricant;
    }

    public FabricantEntity getById(int id) {
        return fabricantRepository.findByIdOptional(id)
                .orElseThrow(() -> new IllegalArgumentException("Couleur with id " + id + " not found"));
    }

    public List<FabricantEntity> getAll() {
        return fabricantRepository.listAll();
    }

    @Transactional
    public void update(int id, FabricantRequest request) {
        fabricantRepository.findByIdOptional(id)
                .ifPresent(pays -> {
                    pays.setNomFabricant(request.nomFabricant());
                    fabricantRepository.persist(pays);
                });
    }

    @Transactional
    public void delete(int id) {
        fabricantRepository.deleteById(id);
    }
}