package com.github.verhagen.serivce.person.impl.repository;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.verhagen.serivce.person.domain.Identifier;
import com.github.verhagen.serivce.person.domain.Person;

public class PersonRepository {
    private static Logger logger = LoggerFactory.getLogger(PersonRepository.class);
    private final Map<Identifier, Person> persons = new HashMap<>();

    public void add(final Person person) {
        persons.put(person.getId(), person);
    }

    public Person getById(final Identifier id) {
        if (! persons.containsKey(id)) {
            logger.info("No person known with id type '" + id.getType().getName() + "' and value '" + id.getValue() + "'.");
        }

        return persons.get(id);
    }

}
