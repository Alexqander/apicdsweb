package com.cds.mx.apicds.person.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    Optional<Person> findByDni(String dni);
    Optional<Person> findByEmail(String email);
    Optional<Person> findByEmailInstitutional(String emailInstitucional);
    boolean existsById(long id);

}
