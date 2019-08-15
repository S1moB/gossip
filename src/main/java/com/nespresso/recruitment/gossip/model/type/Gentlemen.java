package com.nespresso.recruitment.gossip.model.type;

import static com.nespresso.recruitment.gossip.utils.Constants.EMPTY_STRING;

import com.nespresso.recruitment.gossip.model.Person;

public class Gentlemen extends Person {

    private String message;

    public Gentlemen(String type, String name) {
        super(type, name);
        this.message = "";
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
    public void clearMessage() {
        this.message = EMPTY_STRING;
    }

    @Override
    public void swapMessages(Person sender) {
        if (!EMPTY_STRING.equals(message)) {
            reverseMessage(sender);
        } else {
            addMessage(sender.printMessage());
            sender.clearMessage();
            sender.gossipSent();
            gossipSent();
        }
    }

    private void reverseMessage(Person sender) {
        StringBuffer reverseString = new StringBuffer(message);
        clearMessage();
        sender.addMessage(reverseString.reverse().toString());
        sender.gossipSent();
        gossipSent();
    }
}
