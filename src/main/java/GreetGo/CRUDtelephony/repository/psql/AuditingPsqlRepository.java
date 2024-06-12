package GreetGo.CRUDtelephony.repository.psql;

import GreetGo.CRUDtelephony.entity.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditingPsqlRepository extends JpaRepository<AuditEntity, Long> {
}
