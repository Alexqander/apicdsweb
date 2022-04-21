package com.cds.mx.apicds.admission.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
public interface AdmissionsRepository extends JpaRepository<Admissions,Long> {

    Optional<Admissions>findByDescription(String description);
    Admissions findById(long id);






}
