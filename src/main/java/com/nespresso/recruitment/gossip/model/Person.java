package com.nespresso.recruitment.gossip.model;

public abstract class Person {
    protected String name;
    protected String type;
    protected boolean didSendBefore = false;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public abstract String showGossip();

    public abstract String printMessage();

    public abstract void addMessage(String message);

    public abstract void clearMessage();

    public Person(String type, String name) {
        this.name = name;
        this.type = type;
    }

    public void gossipSent() {
        didSendBefore = true;
    }

    public void initGossip() {
        didSendBefore = false;
    }

    public boolean isAbleToReceiveGossip() {
        return !didSendBefore;
    }

    public boolean isAbleToSendGossip() {
        return !didSendBefore;
    }

    public boolean shouldBeDelayed() {
        return false;
    }

    public void swapMessages(Person sender) {
        addMessage(sender.printMessage());
        sender.clearMessage();
        sender.gossipSent();
        gossipSent();
    }
}
