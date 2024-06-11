package GreetGo.CRUDtelephony.repository;

import GreetGo.CRUDtelephony.entity.ClientDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientMongoRepository extends JpaRepository<ClientDocument, String> {
    ClientDocument findByPhone(String phone);
    void deleteByPhone(String phone);
}
