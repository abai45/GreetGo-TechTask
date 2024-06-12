package GreetGo.CRUDtelephony.repository;

import GreetGo.CRUDtelephony.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,Long> {
    Optional<ClientEntity> findByPhone(String phone);
    void deleteByPhone(String phone);
}
