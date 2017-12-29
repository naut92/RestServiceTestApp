/*package com.github.naut92.restservicetestapp.repository;

import com.github.advancedscientificresearchprojects.atlant_inception.entities.UsersEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface UserRepository extends PagingAndSortingRepository<UsersEntity, Long>{

    List<UsersEntity> findByLastname(@Param("name") String name);

    @Override
    List<UsersEntity> findAll();

    //List<UsersEntity> findByLastname(String lastname);
    List<UsersEntity> findByFirstnameAndLastname(String firstName, String lastName);
    UsersEntity findByEmail(String email);
}
*/