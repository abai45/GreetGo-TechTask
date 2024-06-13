package GreetGo.CRUDtelephony.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class AuditDocument {
    @Id
    private String id;
    @DBRef
    private ClientDocument clientDocument;
    private LocalDateTime date;
    private String operationType;
}
