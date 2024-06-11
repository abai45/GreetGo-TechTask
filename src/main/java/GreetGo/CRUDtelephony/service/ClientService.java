package GreetGo.CRUDtelephony.service;

import GreetGo.CRUDtelephony.dto.BaseClientDto;
import GreetGo.CRUDtelephony.dto.ClientEntityDto;

import java.util.List;

public interface ClientService<T extends BaseClientDto> {

    T getClientById(Long id);
    T getClientByPhone(String phone);
    T updateClientById(Long id);
    T updateClientByPhone(String phone);
    List<T> getAllClients(int limit, int offset);
    void deleteClientById(Long id);
    void deleteClientByPhone(String phone);
}
