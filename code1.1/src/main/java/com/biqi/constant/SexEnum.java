package com.biqi.constant;

public enum SexEnum {

    SEX_MALE(1,"男"),
    SEX_FEMALE(0,"女");

    private final int key;
    private final String value;

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    SexEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }



}
