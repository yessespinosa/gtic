package org.bedu.gtic.repository;

import org.bedu.gtic.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource(collectionResourceRel = "users", path = "users") JavaII sesion 2 ejemplo 1
// La anotación @RepositoryRestResource es opcional y se usa para personalizar el punto final REST.
// Si decidiéramos omitirlo, Spring crearía automáticamente un punto final en /websiteUsers en lugar de /users.
// Diferentes tipos de repositorios: CrudRepository, PagingAndSortingRepository, JpaRepository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
