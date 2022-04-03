package com.cds.mx.apicds.address.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AddressRepository  extends JpaRepository<Address,Long> {
    boolean existsById(Long id);
}
