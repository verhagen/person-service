package com.github.verhagen.serivce.person.impl.repository.csv;

import static org.testng.Assert.assertEquals;

import java.io.StringReader;

import org.testng.annotations.Test;

public class CsvPersonRepositoryTest {

    @Test
    public void create() throws Exception {
        CsvPersonRepository repo = CsvPersonRepository.importBy(createPresedents());
        
        assertEquals(repo.getSize(), 2);
//        repo.getById("333224444");
//        repo.getSearchByFirstName("bill");
    }

    
    private StringReader createPresedents() {
        StringBuilder bldr = new StringBuilder();
        add(bldr, new String[] {"social-security-number", "first-name", "family-name", "given-name"});
        add(bldr, new String[] {"333224444", "Bill", "Clinton", ""});
        add(bldr, new String[] {"333224455", "Ronald", "ReaganBill", null});
        
        return new StringReader(bldr.toString());
    }

    private void add(final StringBuilder bldr, final String[] values) {
        if (bldr.length() > 0) {
            bldr.append("\n");
        }
        boolean isFirstValue = true;
        for (String value : values) {
            if (! isFirstValue) {
                bldr.append("; ");
            }
            isFirstValue = false;
            bldr.append(value);
        }
    }

}
