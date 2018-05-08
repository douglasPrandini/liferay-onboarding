package com.liferay.docs.amf.registration.sb.enums;

public enum ActionType {

    LOGIN("LOGIN"),
    LOGOUT("LOGOUT"),
    REGISTRATION("REGISTRATION");

    private final String text;

    ActionType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}