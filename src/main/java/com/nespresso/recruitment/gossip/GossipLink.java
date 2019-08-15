package com.nespresso.recruitment.gossip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.nespresso.recruitment.gossip.model.Person;

public class GossipLink {

    private List<Person> sender;
    private List<Person> receiver;

    public GossipLink() {
        sender = new ArrayList<>();
        receiver = new ArrayList<>();
    }

    public List<Person> getSenders() {
        return Collections.unmodifiableList(sender);
    }

    public List<Person> getReceivers() {
        return Collections.unmodifiableList(receiver);
    }

    public void addSender(Person from) {
        this.sender.add(from);
    }

    public void addReceiver(Person to) {
        this.receiver.add(to);
    }
}
