package com.nespresso.recruitment.gossip.model.type;

import static com.nespresso.recruitment.gossip.utils.Constants.DOCTOR;
import static com.nespresso.recruitment.gossip.utils.Constants.EMPTY_STRING;

import com.nespresso.recruitment.gossip.model.Person;

public class Lady extends Person {
    private String message;
    private boolean propagate = false;

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

    public Lady(String type, String name) {
        super(type, name);
        message = EMPTY_STRING;
    }

    @Override
    public void swapMessages(Person sender) {
        if (DOCTOR.equalsIgnoreCase(sender.getType())) {
            propagate = true;
        }
        addMessage(sender.printMessage());
        sender.clearMessage();
        sender.gossipSent();
        gossipSent();
    }

    @Override
    public void clearMessage() {
        this.message = EMPTY_STRING;
    }

    @Override
    public boolean isAbleToSendGossip() {
        return propagate && !didSendBefore;
    }
}
