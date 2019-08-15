package com.nespresso.recruitment.gossip.model.type;

import static com.nespresso.recruitment.gossip.utils.Constants.EMPTY_STRING;

import com.nespresso.recruitment.gossip.model.Person;

public class Professor extends Person {
    private boolean isDelayed = false;
    private String message;

    public Professor(String type, String name) {
        super(type, name);
        this.message = EMPTY_STRING;
    }

    @Override
    public String showGossip() {
        return this.message;
    }

    @Override
    public String printMessage() {
        return this.message;
    }

    @Override
    public void addMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean shouldBeDelayed() {
        return isDelayed = !isDelayed;
    }

    @Override
    public void clearMessage() {
        this.message = EMPTY_STRING;
    }
}
