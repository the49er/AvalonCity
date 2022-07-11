package com.aeroparker.test.db.entity.customer;

import com.aeroparker.test.exception.NoSuchTitleException;

public enum CustomerTitle {
    MR("Mr"),
    MRS("Mrs"),
    MS("Ms"),
    MISS("Miss");
    String title;

    CustomerTitle(String title){
        this.title = title;
    }

    public String getTitleValue() {
        return title;
    }

    public static CustomerTitle getEnumFromString(String enteredTitle) {
        for (CustomerTitle customerTitle: CustomerTitle.values()) {
            if (customerTitle.title.equalsIgnoreCase(enteredTitle)) {
                return customerTitle;
            }
        }
        throw new NoSuchTitleException(enteredTitle);
    }


    public static String getMsgForException() {
        StringBuilder sb = new StringBuilder();

        for (CustomerTitle ct : CustomerTitle.values()) {
            sb.append(ct.getTitleValue());
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

}
