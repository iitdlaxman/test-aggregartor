package com.flipkart.crm.entity.user;

/**
 * Created by laxman.muttineni on 30/08/17.
 */
public enum UserIdentifierType {
    ACCOUNT_ID("accountId"),
    EMAIL("email"),
    CONTACT("contact");

    private final String value;

    private UserIdentifierType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
