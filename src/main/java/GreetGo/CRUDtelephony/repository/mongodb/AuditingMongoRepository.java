package GreetGo.CRUDtelephony.repository.mongodb;

import GreetGo.CRUDtelephony.entity.AuditDocument;
import GreetGo.CRUDtelephony.entity.ClientDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditingMongoRepository extends MongoRepository<AuditDocument, String>{
    void deleteAllByClientDocument(ClientDocument clientDocument);
}

