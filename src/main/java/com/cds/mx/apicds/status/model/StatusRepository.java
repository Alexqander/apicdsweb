package com.cds.mx.apicds.status.model;

import com.cds.mx.apicds.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Long> {
    Status findStatusById(long id);
}
