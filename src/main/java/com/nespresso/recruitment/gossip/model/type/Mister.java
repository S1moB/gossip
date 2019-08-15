package com.nespresso.recruitment.gossip.model.type;

import static com.nespresso.recruitment.gossip.utils.Constants.EMPTY_STRING;

import com.nespresso.recruitment.gossip.model.Person;

public class Mister extends Person {
    private String message;

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

    public Mister(String type, String name) {
        super(type, name);
        this.message = EMPTY_STRING;
    }

    @Override
    public void clearMessage() {
        this.message = EMPTY_STRING;
    }
}
