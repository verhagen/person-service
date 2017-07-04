package com.github.verhagen.serivce.person.domain;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class Identifier {
    private final IdentifierType type;
    private final String value;
    
    
    public Identifier(final Builder bldr) {
        final String valueCln = StringUtils.trimToNull(bldr.getValue());
        if (valueCln == null) {
            throw new IllegalArgumentException("Argument 'value' should not be null.");
        }
        final String valueRegExpStr = bldr.getType().getValueRegExpStr();
        if (valueRegExpStr != null) {
            if (! Pattern.matches(valueRegExpStr, valueCln)) {
                throw new IllegalArgumentException("Argument 'value' with value '"
                        + valueCln + "' should match regular expression '" + valueRegExpStr + "'.");
            }
        }

        this.type = bldr.getType();
        this.value = valueCln;
    }


    public IdentifierType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }


    public static class Builder {
        private final IdentifierType type;
        private String value;


        public Builder(final IdentifierType type) {
            this.type = type;
        }

        public Identifier create() {
            return new Identifier(this);
        }

        public String getValue() {
            return value;
        }
        public Builder setValue(final String value) {
            this.value = value;
            return this;
        }

        public IdentifierType getType() {
            return type;
        }
    }

}
