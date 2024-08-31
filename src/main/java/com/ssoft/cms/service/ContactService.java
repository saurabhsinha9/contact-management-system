package com.ssoft.cms.service;

import com.ssoft.cms.entity.Contact;
import com.ssoft.cms.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
	@Autowired
	private ContactRepository repository;

	public Contact saveContact(Contact contact) {
		return repository.save(contact);
	}

	public List<Contact> saveContacts(List<Contact> contacts) {
		return repository.saveAll(contacts);
	}

	public List<Contact> getContacts() {
		return repository.findAll();
	}

	public Contact getContactById(int id) {
		return repository.findById(id).orElse(null);
	}

	public Contact getContactByName(String name) {
		return repository.findByName(name);
	}

	public Contact updateContact(Contact contact) {
		Contact existingContact = repository.findById(contact.getId()).orElse(null);
		existingContact.setName(contact.getName());
		existingContact.setEmail(contact.getEmail());
		existingContact.setPhone(contact.getPhone());
		existingContact.setStatus(contact.getStatus());
		return repository.save(existingContact);
	}

	public String deleteContact(int id) {
		repository.deleteById(id);
		return "contact removed !! " + id;
	}
}
