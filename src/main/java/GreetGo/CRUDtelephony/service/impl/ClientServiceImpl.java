package GreetGo.CRUDtelephony.service.impl;

import GreetGo.CRUDtelephony.dto.ClientEntityDto;
import GreetGo.CRUDtelephony.repository.ClientMongoRepository;
import GreetGo.CRUDtelephony.repository.ClientRepository;
import GreetGo.CRUDtelephony.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    ClientMongoRepository clientMongoRepository;
    ClientRepository clientRepository;
    @Override
    public ClientEntityDto getClientById(Long id) {
        return null;
    }

    @Override
    public ClientEntityDto getClientByPhone(String phone) {
        return null;
    }

    @Override
    public ClientEntityDto updateClientById(Long id) {
        return null;
    }

    @Override
    public ClientEntityDto updateClientByPhone(String phone) {
        return null;
    }

    @Override
    public List<ClientEntityDto> getAllClients(int limit, int offset) {
        return null;
    }

    @Override
    public void deleteClientById(Long id) {

    }

    @Override
    public void deleteClientByPhone(String phone) {

    }
}
