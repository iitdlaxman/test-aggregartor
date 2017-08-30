package com.flipkart.crm.core.util;

import com.flipkart.crm.entity.exception.PlatformException;
import com.flipkart.crm.entity.exception.ResponseCode;
import com.flipkart.crm.entity.user.UserIdentifierType;
import com.google.common.base.Strings;

/**
 * Created by laxman.muttineni on 30/08/17.
 */
public class Validator {

    public Validator() {
    }

    public static boolean isValidPasswordFormat(String password) {
        return !Strings.isNullOrEmpty(password);
    }

    public static UserIdentifierType getUserIdentifer(String param) throws PlatformException {
        if (Constants.EMAIL_PATTERN.matcher(param).matches()) {
            return UserIdentifierType.EMAIL;
        }
        else if (Constants.NUMERIC_PATTERN.matcher(param).matches()) {
            return UserIdentifierType.CONTACT;
        }
        else if (Constants.ALPHANUMERIC_PATTERN.matcher(param).matches()){
            return UserIdentifierType.ACCOUNT_ID;
        }
        throw new PlatformException(ResponseCode.INVALID_CREDENTIALS);
    }
}
