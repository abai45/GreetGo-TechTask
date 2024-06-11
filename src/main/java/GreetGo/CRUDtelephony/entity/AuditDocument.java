package GreetGo.CRUDtelephony.entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AuditDocument extends AuditEntity{
    @Id
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    private ClientDocument clientDocument;
}
