package com.github.verhagen.serivce.person.domain;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class IdentifierType {
    private final static String nameRegExp = "[a-z-]+";
    private final String name;
    private final String valueRegExpStr;

    public IdentifierType(final Builder bldr) {
        final String nameCln = StringUtils.trimToNull(bldr.getName());
        if (nameCln == null) {
            throw new IllegalArgumentException("Argument 'name' should not be null.");
        }
        if (! Pattern.matches(nameRegExp, nameCln)) {
            throw new IllegalArgumentException("Argument 'name' with value '"
                    + nameCln + "' should match regular expression '" + nameRegExp + "'.");
        }
        final String valueRegExpStrCln = StringUtils.trimToNull(bldr.getValueRegExpStr());
        if (valueRegExpStrCln != null) {
            Pattern.compile(valueRegExpStrCln);
        }

        this.name = nameCln;
        this.valueRegExpStr = valueRegExpStrCln;
    }

    
    public String getName() {
        return name;
    }
    

    public String getValueRegExpStr() {
        return valueRegExpStr;
    }


    public static class Builder {
        private String name;
        private String valueRegExpStr;

        public IdentifierType create() {
            return new IdentifierType(this);
        }
        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public String getValueRegExpStr() {
            return valueRegExpStr;
        }
        public Builder setRegularExpression(final String valueRegExpStr) {
            this.valueRegExpStr = valueRegExpStr;
            return this;
        }
    }
}
