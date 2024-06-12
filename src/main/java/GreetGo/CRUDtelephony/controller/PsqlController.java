package GreetGo.CRUDtelephony.controller;

import GreetGo.CRUDtelephony.domain.Response;
import GreetGo.CRUDtelephony.dto.ClientEntityDto;
import GreetGo.CRUDtelephony.service.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static GreetGo.CRUDtelephony.domain.Response.getResponse;
import static java.util.Collections.*;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/psql/client")
public class PsqlController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<Response> createNewClient(@RequestBody ClientEntityDto createClientEntityRequest, HttpServletRequest request) {
        var client = clientService.createClient(createClientEntityRequest);
        return ResponseEntity.ok().body(getResponse(request, Map.of("client", client), "Client created successfully", OK));
    }
    @GetMapping("/get")
    public ResponseEntity<Response> getClientById(@RequestParam("id") Long id, HttpServletRequest request) {
        var client = clientService.getClientById(id);
        return ResponseEntity.ok().body(getResponse(request, Map.of("client", client), "Client Info Retrieved", OK));
    }
    @GetMapping("/get/phone")
    public ResponseEntity<Response> getClientByPhone(@RequestParam("phone") String phone, HttpServletRequest request) {
        var client = clientService.getClientByPhone(phone);
        return ResponseEntity.ok().body(getResponse(request, Map.of("client", client), "Client Info Retrieved", OK));
    }
    @PostMapping("/delete")
    public ResponseEntity<Response> deleteClientById(@RequestParam("id") Long id, HttpServletRequest request) {
        clientService.deleteClientById(id);
        return ResponseEntity.ok().body(getResponse(request, emptyMap(), "Client was deleted", OK));
    }
    @PostMapping("/delete/phone")
    public ResponseEntity<Response> deleteClientByPhone(@RequestParam("phone")String phone, HttpServletRequest request) {
        clientService.deleteClientByPhone(phone);
        return ResponseEntity.ok().body(getResponse(request, emptyMap(), "Client was deleted", OK));
    }
    @GetMapping
    public ResponseEntity<Response> getClientById(@RequestParam int limit, @RequestParam int offset, HttpServletRequest request) {
        var clients = clientService.getAllClients(limit,offset);
        return ResponseEntity.ok().body(getResponse(request, Map.of("clients", clients), "All Clients Retrieved", OK));
    }
    @PostMapping("/update")
    public ResponseEntity<Response> updateClientById(@RequestParam("id") Long id, @RequestBody ClientEntityDto clientEntity, HttpServletRequest request) {
        var client = clientService.updateClientById(id, clientEntity);
        return ResponseEntity.ok().body(getResponse(request, Map.of("client", client), "Client Info Updated", OK));
    }
    @PostMapping("/update/phone")
    public ResponseEntity<Response> updateClientByPhone(@RequestParam("phone") String phone, @RequestBody ClientEntityDto clientEntity, HttpServletRequest request) {
        var client = clientService.updateClientByPhone(phone, clientEntity);
        return ResponseEntity.ok().body(getResponse(request, Map.of("client", client), "Client Info Updated", OK));
    }
}
