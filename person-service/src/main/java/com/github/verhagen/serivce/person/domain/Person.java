package com.github.verhagen.serivce.person.domain;

import org.apache.commons.lang3.StringUtils;

public class Person {
    private final Identifier id;
    private final String givenName;
    private final String firstName;
    private final String familyName;

    public Person(final Builder bldr) {
        final String givenNameCln = StringUtils.trimToNull(bldr.getGivenName());
        final String firstNameCln = StringUtils.trimToNull(bldr.getFirstName());
        final String familyNameCln = StringUtils.trimToNull(bldr.getFamilyName());
        if (bldr.getId() == null) {
            throw new IllegalArgumentException("Argument 'id' should not be null.");
        }
        if (givenNameCln == null) {
            //throw new IllegalArgumentException("Argument 'givenName' should not be null.");
        }
        if (firstNameCln == null) {
            throw new IllegalArgumentException("Argument 'firstName' should not be null.");
        }
        if (familyNameCln == null) {
            throw new IllegalArgumentException("Argument 'familyName' should not be null.");
        }
        
        this.id = bldr.getId();
        this.givenName = givenNameCln;
        this.firstName = firstNameCln;
        this.familyName = familyNameCln;
    }

    
    public Identifier getId() {
        return id;
    }

    public String getGivenName() {
        if (givenName == null) {
            return firstName;
        }
        return givenName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }



//    private final List<String> ldapAttributes = Arrays.asList(new String[] {
//            "sAMAccountName", "description", "company", "mail", "department", "displayName", "givenName", "mobile", "roomNumber"
//            , "physicalDeliveryOfficeName", "postalCode", "streetAddress", "title", "telephoneNumber"
//            , "manager", "distinguishedName"
//    });
    
    public static class Builder {
        private final IdentifierType idType;
        private Identifier id;
        private String givenName;
        private String firstName;
        private String familyName;


        public Builder(final IdentifierType idType) {
            this.idType = idType;
        }


        public Person create() {
            return new Person(this);
        }

        public Identifier getId() {
            return id;
        }
        public Builder setId(final Identifier id) {
            this.id = id;
            return this;
        }
        public Builder setId(final String idStr) {
            return setId(new Identifier.Builder(idType).setValue(idStr).create());
        }

        public String getGivenName() {
            return givenName;
        }
        public Builder setGivenName(final String givenName) {
            this.givenName = givenName;
            return this;
        }

        public String getFirstName() {
            return firstName;
        }
        public Builder setFirstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public String getFamilyName() {
            return familyName;
        }
        public Builder setFamilyName(final String familyName) {
            this.familyName = familyName;
            return this;
        }
    }

}
