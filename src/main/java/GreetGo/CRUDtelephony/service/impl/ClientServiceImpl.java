package GreetGo.CRUDtelephony.service.impl;

import GreetGo.CRUDtelephony.dto.ClientDocumentDto;
import GreetGo.CRUDtelephony.dto.ClientEntityDto;
import GreetGo.CRUDtelephony.entity.AuditDocument;
import GreetGo.CRUDtelephony.entity.AuditEntity;
import GreetGo.CRUDtelephony.entity.ClientDocument;
import GreetGo.CRUDtelephony.entity.ClientEntity;
import GreetGo.CRUDtelephony.enumeration.OperationEnum;
import GreetGo.CRUDtelephony.exception.ApiException;
import GreetGo.CRUDtelephony.mapper.ClientDocumentMapper;
import GreetGo.CRUDtelephony.mapper.ClientEntityMapper;
import GreetGo.CRUDtelephony.repository.mongodb.AuditingMongoRepository;
import GreetGo.CRUDtelephony.repository.mongodb.ClientMongoRepository;
import GreetGo.CRUDtelephony.repository.psql.AuditingPsqlRepository;
import GreetGo.CRUDtelephony.repository.psql.ClientRepository;
import GreetGo.CRUDtelephony.service.ClientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.*;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMongoRepository clientMongoRepository;
    @Autowired
    private AuditingPsqlRepository auditingPsqlRepository;
    @Autowired
    private AuditingMongoRepository auditingMongoRepository;

    //PostgreSQL methods
    @Override
    public ClientEntityDto createClient(ClientEntityDto dto) {
        var clientEntity = ClientEntityMapper.INSTANCE.toEntity(dto);
        clientRepository.save(clientEntity);
        newOperationAudit(clientEntity, OperationEnum.CREATE.getValue());
        return convertEntityToDto(clientEntity);
    }

    @Override
    public ClientEntityDto getClientById(Long id) {
        var clientEntity = findClientEntityById(id);
        newOperationAudit(clientEntity, OperationEnum.READ.getValue());
        return convertEntityToDto(clientEntity);
    }

    @Override
    public ClientEntityDto getClientByPhone(String phone) {
        var clientEntity = findClientEntityByPhone(phone);
        newOperationAudit(clientEntity, OperationEnum.READ.getValue());
        return convertEntityToDto(clientEntity);
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteClientByPhone(String phone) {
        clientRepository.deleteByPhone(phone);
    }

    @Override
    public List<ClientEntityDto> getAllClients(int limit, int offset) {
        return clientRepository.findAll(PageRequest.of(offset,limit)).stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientEntityDto updateClientById(Long id, ClientEntityDto newClientInfo) {
        var clientEntity = findClientEntityById(id);
        updateClientEntity(clientEntity, newClientInfo);
        newOperationAudit(clientEntity, OperationEnum.UPDATE.getValue());
        return convertEntityToDto(clientEntity);
    }

    @Override
    public ClientEntityDto updateClientByPhone(String phone, ClientEntityDto newClientInfo) {
        var clientEntity = findClientEntityByPhone(phone);
        updateClientEntity(clientEntity, newClientInfo);
        newOperationAudit(clientEntity, OperationEnum.UPDATE.getValue());
        return convertEntityToDto(clientEntity);
    }

    private ClientEntityDto convertEntityToDto(ClientEntity clientEntity) {
        return ClientEntityMapper.INSTANCE.toDto(clientEntity);
    }

    private ClientEntity findClientEntityById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ApiException("User by id not found"));
    }

    private ClientEntity findClientEntityByPhone(String phone) {
        return clientRepository.findByPhone(phone)
                .orElseThrow(() -> new ApiException("User by phone not found"));
    }

    private void updateClientEntity(ClientEntity clientEntity, ClientEntityDto newClientInfo) {
        clientEntity.setFirstName(newClientInfo.getFirstName());
        clientEntity.setLastName(newClientInfo.getLastName());
        clientEntity.setPhone(newClientInfo.getPhone());
        clientEntity.setSecondPhone(newClientInfo.getSecondPhone());
        clientEntity.setBirthday(newClientInfo.getBirthday());
        clientRepository.save(clientEntity);
    }

    private void newOperationAudit(ClientEntity clientEntity, String operationType) {
        auditingPsqlRepository.save(new AuditEntity(null, clientEntity, now(), operationType));
    }

    //MongoDb methods
    @Override
    public ClientDocumentDto createClient(ClientDocumentDto dto) {
        var clientDocument = ClientDocumentMapper.INSTANCE.toDocument(dto);
        clientMongoRepository.save(clientDocument);
        newOperationAuditMongo(clientDocument, OperationEnum.CREATE.getValue());
        return convertDocumentToDto(clientDocument);
    }

    @Override
    public ClientDocumentDto getDocumentById(String id) {
        var clientDocument = findClientDocumentById(id);
        newOperationAuditMongo(clientDocument, OperationEnum.READ.getValue());
        return convertDocumentToDto(clientDocument);
    }

    @Override
    public ClientDocumentDto getDocumentByPhone(String phone) {
        var clientDocument = findClientDocumentByPhone(phone);
        newOperationAuditMongo(clientDocument, OperationEnum.READ.getValue());
        return convertDocumentToDto(clientDocument);
    }

    @Override
    public void deleteDocumentById(String id) {
        var clientDocument = findClientDocumentById(id);
        clientMongoRepository.deleteById(id);
        auditingMongoRepository.deleteAllByClientDocument(clientDocument);
    }

    @Override
    public void deleteDocumentByPhone(String phone) {
        var clientDocument = findClientDocumentByPhone(phone);
        clientMongoRepository.deleteByPhone(phone);
        auditingMongoRepository.deleteAllByClientDocument(clientDocument);
    }

    @Override
    public List<ClientDocumentDto> getAllDocuments(int limit, int offset) {
        return clientMongoRepository.findAll(PageRequest.of(offset,limit)).stream()
                .map(this::convertDocumentToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDocumentDto updateDocumentById(String id, ClientDocumentDto dto) {
        var clientDocument = findClientDocumentById(id);
        updateClientDocument(clientDocument, dto);
        newOperationAuditMongo(clientDocument, OperationEnum.UPDATE.getValue());
        return convertDocumentToDto(clientDocument);
    }

    @Override
    public ClientDocumentDto updateDocumentByPhone(String phone, ClientDocumentDto dto) {
        var clientDocument = findClientDocumentByPhone(phone);
        updateClientDocument(clientDocument, dto);
        newOperationAuditMongo(clientDocument, OperationEnum.UPDATE.getValue());
        return convertDocumentToDto(clientDocument);
    }

    private ClientDocumentDto convertDocumentToDto(ClientDocument clientDocument) {
        return ClientDocumentMapper.INSTANCE.toDto(clientDocument);
    }

    private ClientDocument findClientDocumentById(String id) {
        return clientMongoRepository.findById(id)
                .orElseThrow(() -> new ApiException("User by id not found"));
    }

    private ClientDocument findClientDocumentByPhone(String phone) {
        return clientMongoRepository.findByPhone(phone)
                .orElseThrow(() -> new ApiException("User by phone not found"));
    }

    private void updateClientDocument(ClientDocument clientDocument, ClientDocumentDto newClientInfo) {
        clientDocument.setFirstName(newClientInfo.getFirstName());
        clientDocument.setLastName(newClientInfo.getLastName());
        clientDocument.setPhone(newClientInfo.getPhone());
        clientDocument.setSecondPhone(newClientInfo.getSecondPhone());
        clientDocument.setBirthday(newClientInfo.getBirthday());
        clientMongoRepository.save(clientDocument);
    }
    private void newOperationAuditMongo(ClientDocument clientDocument, String operationType) {
        auditingMongoRepository.save(new AuditDocument(null, clientDocument, now(), operationType));
    }
}
