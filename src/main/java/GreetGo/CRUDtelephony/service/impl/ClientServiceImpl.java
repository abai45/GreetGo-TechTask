package GreetGo.CRUDtelephony.service.impl;

import GreetGo.CRUDtelephony.dto.ClientDocumentDto;
import GreetGo.CRUDtelephony.dto.ClientEntityDto;
import GreetGo.CRUDtelephony.entity.ClientDocument;
import GreetGo.CRUDtelephony.entity.ClientEntity;
import GreetGo.CRUDtelephony.exception.ApiException;
import GreetGo.CRUDtelephony.mapper.ClientDocumentMapper;
import GreetGo.CRUDtelephony.mapper.ClientEntityMapper;
import GreetGo.CRUDtelephony.repository.mongodb.ClientMongoRepository;
import GreetGo.CRUDtelephony.repository.psql.ClientRepository;
import GreetGo.CRUDtelephony.service.ClientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMongoRepository clientMongoRepository;

    //PostgreSQL methods
    @Override
    public ClientEntityDto createClient(ClientEntityDto dto) {
        var clientEntity = ClientEntityMapper.INSTANCE.toEntity(dto);
        clientRepository.save(clientEntity);
        return convertEntityToDto(clientEntity);
    }

    @Override
    public ClientEntityDto getClientById(Long id) {
        var clientEntity = findClientEntityById(id);
        return convertEntityToDto(clientEntity);
    }

    @Override
    public ClientEntityDto getClientByPhone(String phone) {
        var clientEntity = findClientEntityByPhone(phone);
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
        return convertEntityToDto(clientEntity);
    }

    @Override
    public ClientEntityDto updateClientByPhone(String phone, ClientEntityDto newClientInfo) {
        var clientEntity = findClientEntityByPhone(phone);
        updateClientEntity(clientEntity, newClientInfo);
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

    //MongoDb methods
    @Override
    public ClientDocumentDto createClient(ClientDocumentDto dto) {
        var clientDocument = ClientDocumentMapper.INSTANCE.toDocument(dto);
        clientMongoRepository.save(clientDocument);
        return convertDocumentToDto(clientDocument);
    }

    @Override
    public ClientDocumentDto getDocumentById(String id) {
        var clientDocument = findClientDocumentById(id);
        return convertDocumentToDto(clientDocument);
    }

    @Override
    public ClientDocumentDto getDocumentByPhone(String phone) {
        var clientDocument = findClientDocumentByPhone(phone);
        return convertDocumentToDto(clientDocument);
    }

    @Override
    public void deleteDocumentById(String id) {
        clientMongoRepository.deleteById(id);
    }

    @Override
    public void deleteDocumentByPhone(String phone) {
        clientMongoRepository.deleteByPhone(phone);
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
        return convertDocumentToDto(clientDocument);
    }

    @Override
    public ClientDocumentDto updateDocumentByPhone(String phone, ClientDocumentDto dto) {
        var clientDocument = findClientDocumentByPhone(phone);
        updateClientDocument(clientDocument, dto);
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
        BeanUtils.copyProperties(clientDocument,newClientInfo);
        clientMongoRepository.save(clientDocument);
    }
}
