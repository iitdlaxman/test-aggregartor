package com.flipkart.crm.core.util;

import java.util.regex.Pattern;

/**
 * Created by laxman.muttineni on 30/08/17.
 */
public class Constants {

    public static final Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    public static final Pattern ALPHANUMERIC_PATTERN = Pattern.compile("^[a-zA-Z0-9]*$");

    public static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");

    public static final int SESSION_EXPIRY_HOURS = 1;

    public static final int MAX_SESSION_LIMITS = 10;

}
