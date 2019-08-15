package com.nespresso.recruitment.gossip;

import static com.nespresso.recruitment.gossip.utils.Constants.EMPTY_STRING;
import static com.nespresso.recruitment.gossip.utils.Constants.GENTLEMEN;
import static com.nespresso.recruitment.gossip.utils.Constants.NO_PERSON_FOUND;
import static com.nespresso.recruitment.gossip.utils.Constants.TYPE_AND_NAME_SEPARATOR;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nespresso.recruitment.gossip.model.Person;
import com.nespresso.recruitment.gossip.utils.PersonFactory;

public class Gossips {

    private List<Person> persons;
    private GossipLink currentGossip;
    private List<String> messagesContent;
    private int messageIterator = 0;

    {
        persons = new ArrayList<>();
        messagesContent = new ArrayList<>();
        currentGossip = new GossipLink();
    }

    public Gossips(String... persons) {
        for (String person : persons) {
            String[] typeAndName = person.split(TYPE_AND_NAME_SEPARATOR, 2);
            this.persons.add(PersonFactory.createNewPerson(typeAndName[0], typeAndName[1]));
        }
    }

    public Gossips say(String message) {
        messagesContent.add(message);
        return this;
    }

    public String ask(final String personName) {
        Optional<Person> person = getPersonByName(personName);
        return person.isPresent() ? person.get().showGossip() : NO_PERSON_FOUND;
    }

    public void spread() {
        List<Person> senders = currentGossip.getSenders();
        List<Person> receivers = currentGossip.getReceivers();
        for (int personIndex = 0; personIndex < senders.size(); personIndex++)
            swap_Message_From_Sender_To_Receiver(senders.get(personIndex), receivers.get(personIndex));
        persons.forEach(Person::initGossip);
    }

    public Gossips from(String personName) {
        Optional<Person> person = getPersonByName(personName);
        person.ifPresent(person1 -> currentGossip.addSender(person1));
        return this;
    }

    public Gossips to(String personName) {
        getPersonByName(personName).ifPresent(this::add_Receiver_Or_Attach_Message);
        return this;
    }

    private void swapMessage(String senderName, String receiverName, String message) {
        Optional<Person> sender = persons.stream().filter(p -> senderName.equalsIgnoreCase(p.getName()) && p.isAbleToSendGossip()).findFirst();
        Optional<Person> receiver = persons.stream().filter(p -> receiverName.equalsIgnoreCase(p.getName()) && p.isAbleToReceiveGossip()).findFirst();

        if (sender.isPresent()
            && receiver.isPresent()
            && (!EMPTY_STRING.equals(message) || GENTLEMEN.equalsIgnoreCase(receiver.get().getType()))) {
            if (sender.get().shouldBeDelayed()) {
                return;
            }
            receiver.get().swapMessages(sender.get());
        }
    }

    private void swap_Message_From_Sender_To_Receiver(Person sender, Person reciever) {
        String senderName = sender.getName();
        String receiverName = reciever.getName();
        String message = sender.printMessage();
        swapMessage(senderName, receiverName, message);
    }

    private void add_Receiver_Or_Attach_Message(Person person) {
        if (currentGossip.getReceivers().size() != currentGossip.getSenders().size())
            currentGossip.addReceiver(person);
        else if (messagesContent.size() > 0 && !messagesContent.get(0).isEmpty())
                person.addMessage(messagesContent.get(messageIterator++));
    }

    private Optional<Person> getPersonByName(String name) {
        return persons.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst();
    }
}
