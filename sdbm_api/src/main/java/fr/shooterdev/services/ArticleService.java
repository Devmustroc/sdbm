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

import fr.shooterdev.dto.ArticleRequest;
import fr.shooterdev.entity.ArticleEntity;
import fr.shooterdev.repository.ArticleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ArticleService {

    private ArticleRepository articleRepository;

    private ArticleService() {
        articleRepository = new ArticleRepository();
    }


    @Transactional
    public ArticleEntity create(ArticleRequest request) {
        ArticleEntity article = new ArticleEntity();

        article.setNomArticle(request.nomArticle());
        articleRepository.persist(article);

        return article;
    }

    public ArticleEntity getById(int id) {
        return articleRepository.findByIdOptional(id)
                .orElseThrow(() -> new IllegalArgumentException("Couleur with id " + id + " not found"));
    }

    public List<ArticleEntity> getAll() {
        return articleRepository.listAll();
    }

    @Transactional
    public void update(int id, ArticleRequest request) {
        articleRepository.findByIdOptional(id)
                .ifPresent(pays -> {
                    pays.setNomArticle(request.nomArticle());
                    articleRepository.persist(pays);
                });
    }

    @Transactional
    public void delete(int id) {
        articleRepository.deleteById(id);
    }
}