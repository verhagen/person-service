package com.github.verhagen.serivce.person.impl.repository.csv;

import java.io.Reader;
import java.util.List;

import org.csveed.api.CsvClient;
import org.csveed.api.CsvClientImpl;

import com.github.verhagen.serivce.person.impl.repository.PersonRepository;

public class CsvPersonRepository extends PersonRepository {

    public static CsvPersonRepository importBy(final Reader reader) {
        final CsvPersonRepository repo = new CsvPersonRepository();
        final CsvClient<CsvPerson> csvReader = new CsvClientImpl<>(reader, CsvPerson.class);
        final List<CsvPerson> beans = csvReader.readBeans();
        
        for (CsvPerson bean : beans) {
            repo.add(bean.create());
        }
        
        return repo;
    }

}
