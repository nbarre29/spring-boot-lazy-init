package io.javabrains.springboot.swagger2;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Tag(name = "Address Book", description = "The Address Book API")
@RequestMapping("/api")
@RestController
public class AddressBookResource {

    ConcurrentHashMap<String , Contact> contacts = new ConcurrentHashMap<>();

    @Operation(summary = "Get a contact by its id")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Contact found"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Contact not found")
    })

    @GetMapping("/{id}")
    public Contact getContact(@PathVariable("id")  String id){
        return contacts.get(id);
    }

    @Operation(summary = "Get all contacts")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Contacts found"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Contacts not found")
    })
    @GetMapping("/")
    public List<Contact> getAllContacts(){
        return new ArrayList<Contact>(contacts.values());
    }

    @Operation(summary = "Add a contact")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Contact added"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Contact not added")
    })
    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact){
        contacts.put(contact.getId(),contact);
        return contact;
    }


}
