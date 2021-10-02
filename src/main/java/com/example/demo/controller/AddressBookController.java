package com.example.demo.controller;

import com.example.demo.model.Contact;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/address-book/")
public class AddressBookController {
    
    ConcurrentMap<String, Contact> contactList = new ConcurrentHashMap<>();

    @GetMapping("hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("get/{id}")
    @ApiOperation(
            value = "Find a contact by ID",
            notes = "Provide an ID to look up a specific Contact from the Address Book",
            response = Contact.class
    )
    public Contact getSingleContact(
            @ApiParam(value = "ID of the contact you want to retrieve", required = true)
            @PathVariable String id
    ) {
        return contactList.get(id);
    }

    @PostMapping("insert")
    public Contact insertAddressBook(@RequestBody Contact contact) {
        contactList.put(contact.getId(), contact);
        return contact;
    }

    @GetMapping("get")
    public List<Contact> getAllContact() {
        return new ArrayList<>(contactList.values());
    }


}
