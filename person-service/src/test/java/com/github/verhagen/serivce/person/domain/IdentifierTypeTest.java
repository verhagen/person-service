package com.github.verhagen.serivce.person.domain;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.verhagen.serivce.person.domain.IdentifierType;

public class IdentifierTypeTest {

    @Test
    public void identifierType() throws Exception {
        IdentifierType idType = new IdentifierType.Builder().setName("bsn").create();
        assertEquals(idType.getName(), "bsn");
    }

    @Test
    public void identifierTypeWithSeparator() throws Exception {
        IdentifierType idType = new IdentifierType.Builder().setName("burger-service-number").create();
        assertEquals(idType.getName(), "burger-service-number");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void identifierTypeNull() throws Exception {
        new IdentifierType.Builder().setName(null).create();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void identifierTypeEmpty() throws Exception {
        new IdentifierType.Builder().setName(" \t").create();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void identifierTypeNoLegalChararcters() throws Exception {
        new IdentifierType.Builder().setName("no-legal?id").create();
    }

}
