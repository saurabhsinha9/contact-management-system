package com.ssoft.cms.repository;

import com.ssoft.cms.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {
    Contact findByName(String name);
}
