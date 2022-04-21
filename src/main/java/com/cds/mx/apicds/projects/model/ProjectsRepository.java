package com.cds.mx.apicds.projects.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects,Long> {
    Optional<Projects> findByName(String name);
    Projects findById(long id);
    boolean existsById(long id);
  //  List<Projects>findAllById(long id);
    // Optional<Projects> findAllByPersonId(long id);


}
