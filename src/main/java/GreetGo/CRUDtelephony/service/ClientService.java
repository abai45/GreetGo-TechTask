package GreetGo.CRUDtelephony.service;

import GreetGo.CRUDtelephony.dto.ClientEntityDto;
import GreetGo.CRUDtelephony.dto.ClientDocumentDto;

import java.util.List;

public interface ClientService {
    //PostgreSql controller methods
    ClientEntityDto getClientById(Long id);
    ClientEntityDto getClientByPhone(String phone);
    void deleteClientById(Long id);
    void deleteClientByPhone(String phone);
    List<ClientEntityDto> getAllClients(int limit, int offset);
    ClientEntityDto updateClientById(Long id, ClientEntityDto dto);
    ClientEntityDto updateClientByPhone(String phone, ClientEntityDto dto);

    //MongoDb controller methods
    ClientDocumentDto getDocumentById(String id);
    ClientDocumentDto getDocumentByPhone(String phone);
    void deleteDocumentById(String id);
    void deleteDocumentByPhone(String phone);
    List<ClientDocumentDto> getAllDocuments(int limit, int offset);
    ClientDocumentDto updateDocumentById(String id, ClientDocumentDto dto);
    ClientDocumentDto updateDocumentByPhone(String phone, ClientDocumentDto dto);
}
