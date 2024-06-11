package GreetGo.CRUDtelephony.repository;

import GreetGo.CRUDtelephony.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity,Long> {
    ClientEntity findByPhone(String phone);
    void deleteByPhone(String phone);
}
