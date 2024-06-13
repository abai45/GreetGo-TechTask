package GreetGo.CRUDtelephony.service;

import GreetGo.CRUDtelephony.entity.ClientEntity;
import GreetGo.CRUDtelephony.repository.psql.ClientRepository;
import GreetGo.CRUDtelephony.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetClientById() {
        Long clientId = 1L;
        ClientEntity mockClient = new ClientEntity();
        mockClient.setId(clientId);
        mockClient.setFirstName("John");
        mockClient.setLastName("Doe");

        when(clientRepository.findById(clientId)).thenReturn(Optional.of(mockClient));

        var result = clientService.getClientById(clientId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("John", result.getFirstName());
        Assertions.assertEquals("Doe", result.getLastName());

        verify(clientRepository, times(1)).findById(clientId);
    }
}
