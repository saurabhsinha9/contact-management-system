package com.ssoft.cms.controller;

import com.ssoft.cms.entity.Contact;
import com.ssoft.cms.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactRestController {

    @Autowired
    private ContactService service;

    @PostMapping("/addContact")
    public Contact addProduct(@RequestBody Contact contact) {
        return service.saveContact(contact);
    }

    @PostMapping("/addContacts")
    public List<Contact> addContacts(@RequestBody List<Contact> contacts) {
        return service.saveContacts(contacts);
    }

    @GetMapping("/contacts")
    public List<Contact> findAllContacts() {
        return service.getContacts();
    }

    @GetMapping("/contactById/{id}")
    public Contact findProductById(@PathVariable int id) {
        return service.getContactById(id);
    }

    @GetMapping("/contact/{name}")
    public Contact findContactByName(@PathVariable String name) {
        return service.getContactByName(name);
    }

    @PutMapping("/update")
    public Contact updateProduct(@RequestBody Contact contact) {
        return service.updateContact(contact);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteContact(@PathVariable int id) {
        return service.deleteContact(id);
    }

}
