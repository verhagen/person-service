package com.github.verhagen.serivce.person.impl;

import com.github.verhagen.serivce.person.domain.Identifier;
import com.github.verhagen.serivce.person.domain.Person;
import com.github.verhagen.serivce.person.impl.repository.PersonRepository;

public class PersonService {
    private PersonRepository repo;

    public PersonService(final PersonRepository repo) {
        this.repo = repo;
    }

    public void getById(final Identifier id) {
        repo.getById(id);
    }

    public Person getByMail(final String mail) {
        return null;
    }

}
