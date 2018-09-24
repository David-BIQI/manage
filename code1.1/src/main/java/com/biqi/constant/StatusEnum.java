package com.biqi.constant;

public enum StatusEnum {

    LOCK_STATUS(2,"锁定状态"),
    NORMAL_STATUS(1,"正常状态");

    private final Integer key;
    private final String value;

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    StatusEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
}
