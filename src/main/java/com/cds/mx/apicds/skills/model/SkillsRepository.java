package com.cds.mx.apicds.skills.model;

import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.projects.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillsRepository extends JpaRepository<Skills,Long> {
    Skills findByDescription(String description);
    Skills findById(long id);

    boolean existsById(long id);
   // List<Skills>findAllByPersonId(long id);


}
