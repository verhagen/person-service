package com.github.verhagen.serivce.person.impl.repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.verhagen.serivce.person.domain.IdentifierType;

public class IdentifierTypeRepository {
    private static Logger logger = LoggerFactory.getLogger(IdentifierTypeRepository.class);
    private Map<String, IdentifierType> identifierTypes = new HashMap<>();


    public void add(final IdentifierType type) {
        if (identifierTypes.containsKey(type.getName())) {
            throw new IllegalArgumentException("Argument 'type' with name '" + type.getName() 
                    + "' is already a known IdentifierType.");
        }
        identifierTypes.put(type.getName(), type);
    }
    public void add(final String name) {
        add(new IdentifierType.Builder().setName(name).create());
    }


    public IdentifierType getByName(final String name) {
        
        if (! identifierTypes.containsKey(name)) {
            logger.info("Given argument 'name' with value '" + name + "' is not a known IdentifierType.");
            return null;
        }

        return identifierTypes.get(name);
    }

    public Set<String> getAllByName() {
        return Collections.unmodifiableSet(identifierTypes.keySet());
    }

}
