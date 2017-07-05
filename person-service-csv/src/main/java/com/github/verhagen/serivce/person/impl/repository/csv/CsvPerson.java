package com.github.verhagen.serivce.person.impl.repository.csv;

import com.github.verhagen.serivce.person.domain.IdentifierType;
import com.github.verhagen.serivce.person.domain.Person;

public class CsvPerson {
    private IdentifierType idType = new IdentifierType.Builder().setName("ssn").setRegularExpression("\\d{9}").create();
    private String socialSecurityNumber;
    private String firstName;
    private String familyName;
    private String givenName;


    public Person create() {
        return new Person.Builder(idType)
                .setFirstName(getFirstName())
                .setFamilyName(getFamilyName())
                .setGivenName(getGivenName())
                .setId(getSocialSecurityNumber())
                .create();
    }


    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFamilyName() {
        return familyName;
    }
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
    public String getGivenName() {
        return givenName;
    }
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
    
}
