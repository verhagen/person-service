package com.github.verhagen.serivce.person.domain;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.verhagen.serivce.person.domain.IdentifierType;
import com.github.verhagen.serivce.person.domain.Person;

public class PersonTest {

    @Test
    public void create() throws Exception {
        IdentifierType ssnType = new IdentifierType.Builder().setName("social-security-number").setRegularExpression("[0-9]{9}").create();
        Person person = new Person.Builder(ssnType).setId("333224444").setFirstName("Bill").setFamilyName("Clinton").create();
        
        assertEquals(person.getFirstName(), "Bill");
        assertEquals(person.getFamilyName(), "Clinton");
        assertEquals(person.getGivenName(), "Bill");
        assertEquals(person.getId().getValue(), "333224444");
    }

}
