package com.github.verhagen.serivce.person.domain;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.verhagen.serivce.person.domain.Identifier;
import com.github.verhagen.serivce.person.domain.IdentifierType;

public class IdentifierTest {

    @Test
    public void create() throws Exception {
        IdentifierType ssnType = new IdentifierType.Builder().setName("social-security-number").create(); //.setRegularExpression("[0-9]{9}").create();
        Identifier identifier = new Identifier.Builder(ssnType).setValue("123-45-6789").create();

        assertEquals(identifier.getValue(), "123-45-6789");
    }

}
