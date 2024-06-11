package GreetGo.CRUDtelephony.entity;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class ClientDocument extends AbstractClient{
    @Id
    private String id;
}
