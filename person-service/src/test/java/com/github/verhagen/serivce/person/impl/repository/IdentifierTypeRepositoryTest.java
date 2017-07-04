package com.github.verhagen.serivce.person.impl.repository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.util.Set;

import org.testng.annotations.Test;

import com.github.verhagen.serivce.person.domain.IdentifierType;
import com.github.verhagen.serivce.person.impl.repository.IdentifierTypeRepository;

public class IdentifierTypeRepositoryTest {

    @Test
    public void getByName() throws Exception {
        IdentifierTypeRepository repo = new IdentifierTypeRepository();
        repo.add(new IdentifierType.Builder().setName("social-security-number").setRegularExpression("[0-9]{9}").create());

        IdentifierType type = repo.getByName("social-security-number");

        assertEquals(type.getName(), "social-security-number");
    }

    @Test
    public void getByNameNotKnown() throws Exception {
        IdentifierTypeRepository repo = new IdentifierTypeRepository();
        repo.add("social-security-number");
        
        IdentifierType type = repo.getByName("ssn");

        assertNull(type);
    }

    @Test
    public void getAllByName() throws Exception {
        IdentifierTypeRepository repo = new IdentifierTypeRepository();
        repo.add("social-security-number");
        repo.add("ssn");
        
        Set<String> names = repo.getAllByName();

        assertNotNull(names);
        assertEquals(names.size(), 2);
    }

}
