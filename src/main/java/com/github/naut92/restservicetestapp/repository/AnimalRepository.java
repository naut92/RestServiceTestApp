package com.github.naut92.restservicetestapp.repository;

import com.github.naut92.restservicetestapp.entities.AnimalsEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "animals", path = "animals")
public interface AnimalRepository extends PagingAndSortingRepository<AnimalsEntity, Long> {
    List<AnimalsEntity> findAll();
}
