/*
      _____ __                __                 
     / ___// /_  ____  ____  / /____  _____      
     \__ \/ __ \/ __ \/ __ \/ __/ _ \/ ___/
    ___/ / / / / /_/ / /_/ / /_/  __/ /  __          __
   /____/_/ /_/\____/\____/\__/\___/_/  / /   ____ _/ /_ 
                                       / /   / __ `/ __ \
                                      / /___/ /_/ / /_/ /
   -*- By Shooter Dev -*-            /_____/\__,_/_.___/
   -*- Class package: fr.shooterdev -*-
   -*- coding: utf-8 -*- 
*/

package fr.shooterdev.repository;

import fr.shooterdev.entity.MarqueEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class MarqueRepository implements PanacheRepositoryBase<MarqueEntity, Integer> {
}
