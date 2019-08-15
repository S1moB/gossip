package com.nespresso.recruitment.gossip.model.type;

import static com.nespresso.recruitment.gossip.utils.Constants.EMPTY_STRING;
import static com.nespresso.recruitment.gossip.utils.Constants.MESSAGES_SEPARATOR;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.nespresso.recruitment.gossip.model.Person;

public class Doctor extends Person {
    private List<String> messages = new ArrayList<>();
    private List<String> messagesHistory = new ArrayList<>();

    @Override
    public String showGossip() {
        return String.join(MESSAGES_SEPARATOR, messagesHistory.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList()));
    }

    @Override
    public String printMessage() {
        if (!messages.isEmpty()) {
            return this.isAbleToReceiveGossip() ? messages.get(messages.size() - 1) : messages.get(0);
        }
        return EMPTY_STRING;
    }

    @Override
    public void addMessage(String message) {
        this.messages.add(message);
        this.messagesHistory.add(message);
    }

    @Override
    public boolean isAbleToSendGossip() {
        return messages.size() > 1 || !didSendBefore;
    }

    public Doctor(String type, String name) {
        super(type, name);
    }

    @Override
    public void clearMessage() {
        this.messages.remove(printMessage());
    }
}
