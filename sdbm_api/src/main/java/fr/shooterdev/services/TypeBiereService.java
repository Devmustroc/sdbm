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

import fr.shooterdev.dto.TypeBiereRequest;
import fr.shooterdev.entity.TypeBiereEntity;
import fr.shooterdev.repository.TypeBiereRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TypeBiereService {

    private  TypeBiereRepository typeBiereRepository;

    private TypeBiereService() {
        typeBiereRepository = new TypeBiereRepository();
    }


    @Transactional
    public TypeBiereEntity create(TypeBiereRequest request) {
        TypeBiereEntity typeBiere = new TypeBiereEntity();

        typeBiere.setNomTypeBiere(request.nomTypeBiere());
        typeBiereRepository.persist(typeBiere);

        return typeBiere;
    }

    public TypeBiereEntity getById(int id) {
        return typeBiereRepository.findByIdOptional(id)
                .orElseThrow(() -> new IllegalArgumentException("Couleur with id " + id + " not found"));
    }

    public List<TypeBiereEntity> getAll() {
        return typeBiereRepository.listAll();
    }

    @Transactional
    public void update(int id, TypeBiereRequest request) {
        typeBiereRepository.findByIdOptional(id)
                .ifPresent(typeBiere -> {
                    typeBiere.setNomTypeBiere(request.nomTypeBiere());
                    typeBiereRepository.persist(typeBiere);
                });
    }

    @Transactional
    public void delete(int id) {
        typeBiereRepository.deleteById(id);
    }
}