package com.nespresso.recruitment.gossip.model.type;

import static com.nespresso.recruitment.gossip.utils.Constants.EMPTY_STRING;
import static com.nespresso.recruitment.gossip.utils.Constants.MESSAGES_SEPARATOR;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.nespresso.recruitment.gossip.model.Person;

public class Agent extends Person {
    private List<String> messages = new ArrayList<>();

    @Override
    public String showGossip() {
        String messageOutPut = messages.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(MESSAGES_SEPARATOR));
        messages.clear();
        return messageOutPut;
    }

    @Override
    public String printMessage() {
        return EMPTY_STRING;
    }

    @Override
    public void addMessage(String message) {
        this.messages.add(message);
    }

    @Override
    public boolean isAbleToSendGossip() {
        return true;
    }

    @Override
    public void clearMessage() {
        this.messages.remove(printMessage());
    }

    public boolean isAbleToReceiveGossip() {
        return true;
    }

    public Agent(String type, String name) {
        super(type, name);
    }
}
