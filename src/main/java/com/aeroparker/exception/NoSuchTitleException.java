package com.aeroparker.exception;

import com.aeroparker.db.entity.customer.CustomerTitle;

public class NoSuchTitleException extends RuntimeException {
    public NoSuchTitleException(String str) {
        super("No such Enum value: " + str +
                "\nAccepted values are: " + CustomerTitle.getMsgForException());
    }
}
