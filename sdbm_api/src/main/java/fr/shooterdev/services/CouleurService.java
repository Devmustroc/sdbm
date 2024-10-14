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

import fr.shooterdev.dto.CouleurRequest;
import fr.shooterdev.entity.CouleurEntity;
import fr.shooterdev.repository.CouleurRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CouleurService {

    private  CouleurRepository couleurRepository;

    private CouleurService() {
        couleurRepository = new CouleurRepository();
    }


    @Transactional
    public CouleurEntity create(CouleurRequest request) {
        CouleurEntity couleur = new CouleurEntity();

        couleur.setNomCouleur(request.nomCouleur());
        couleurRepository.persist(couleur);

        return couleur;
    }

    public CouleurEntity getById(int id) {
        return couleurRepository.findByIdOptional(id)
                .orElseThrow(() -> new IllegalArgumentException("Couleur with id " + id + " not found"));
    }

    public List<CouleurEntity> getAll() {
        return couleurRepository.listAll();
    }

    @Transactional
    public void update(int id, CouleurRequest request) {
        couleurRepository.findByIdOptional(id)
                .ifPresent(couleur -> {
                    couleur.setNomCouleur(request.nomCouleur());
                    couleurRepository.persist(couleur);
                });
    }

    @Transactional
    public void delete(int id) {
        couleurRepository.deleteById(id);
    }
}