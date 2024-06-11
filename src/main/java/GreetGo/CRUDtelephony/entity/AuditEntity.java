package GreetGo.CRUDtelephony.entity;

import jakarta.persistence.*;

public class AuditEntity extends AbstractAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private ClientEntity clientEntity;
}
