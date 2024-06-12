package GreetGo.CRUDtelephony.entity;

import GreetGo.CRUDtelephony.enumeration.OperationEnum;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    @ManyToOne(fetch = FetchType.LAZY)
    private ClientDocument clientDocument;
    private LocalDateTime date;
    private String operationType;
}
