package GreetGo.CRUDtelephony.controller;

import GreetGo.CRUDtelephony.domain.Response;
import GreetGo.CRUDtelephony.dto.ClientDocumentDto;
import GreetGo.CRUDtelephony.dto.ClientEntityDto;
import GreetGo.CRUDtelephony.service.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static GreetGo.CRUDtelephony.domain.Response.getResponse;
import static java.util.Collections.emptyMap;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/mongo/client")
public class MongoDBController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<Response> createNewClient(@RequestBody ClientDocumentDto documentDto, HttpServletRequest request) {
        var client = clientService.createClient(documentDto);
        return ResponseEntity.ok().body(getResponse(request, Map.of("client", client), "Client created successfully", OK));
    }
    @GetMapping("/get")
    public ResponseEntity<Response> getClientById(@RequestParam String id, HttpServletRequest request) {
        var client = clientService.getDocumentById(id);
        return ResponseEntity.ok().body(getResponse(request, Map.of("client", client), "Client Info Retrieved", OK));
    }
    @GetMapping("/get/phone")
    public ResponseEntity<Response> getClientByPhone(@RequestParam String phone, HttpServletRequest request) {
        var client = clientService.getDocumentById(phone);
        return ResponseEntity.ok().body(getResponse(request, Map.of("client", client), "Client Info Retrieved", OK));
    }
    @PostMapping("/delete")
    public ResponseEntity<Response> deleteClientById(@RequestParam String id, HttpServletRequest request) {
        clientService.deleteDocumentById(id);
        return ResponseEntity.ok().body(getResponse(request, emptyMap(), "Client was deleted", OK));
    }
    @PostMapping("/delete/phone")
    public ResponseEntity<Response> deleteClientByPhone(@RequestParam String phone, HttpServletRequest request) {
        clientService.deleteClientByPhone(phone);
        return ResponseEntity.ok().body(getResponse(request, emptyMap(), "Client was deleted", OK));
    }
    @GetMapping
    public ResponseEntity<Response> getClientById(@RequestParam int limit, @RequestParam int offset, HttpServletRequest request) {
        var clients = clientService.getAllDocuments(limit,offset);
        return ResponseEntity.ok().body(getResponse(request, Map.of("clients", clients), "All Clients Retrieved", OK));
    }
    @PostMapping("/update")
    public ResponseEntity<Response> updateClientById(@RequestParam String id, @RequestBody ClientDocumentDto documentDto, HttpServletRequest request) {
        var client = clientService.updateDocumentById(id, documentDto);
        return ResponseEntity.ok().body(getResponse(request, Map.of("client", client), "Client Info Updated", OK));
    }
    @PostMapping("/update/phone")
    public ResponseEntity<Response> updateClientByPhone(@RequestParam String phone, @RequestBody ClientDocumentDto documentDto, HttpServletRequest request) {
        var client = clientService.updateDocumentByPhone(phone, documentDto);
        return ResponseEntity.ok().body(getResponse(request, Map.of("client", client), "Client Info Updated", OK));
    }
}
