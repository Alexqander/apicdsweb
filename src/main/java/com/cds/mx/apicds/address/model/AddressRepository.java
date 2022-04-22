package com.cds.mx.apicds.address.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AddressRepository  extends JpaRepository<Address,Long> {
    Address findAddressById(long id);
    boolean existsById(Long id);
}
