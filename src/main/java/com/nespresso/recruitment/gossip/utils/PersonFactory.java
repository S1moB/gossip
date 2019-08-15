package com.nespresso.recruitment.gossip.utils;

import static com.nespresso.recruitment.gossip.utils.Constants.*;

import com.nespresso.recruitment.gossip.model.Person;
import com.nespresso.recruitment.gossip.model.type.Agent;
import com.nespresso.recruitment.gossip.model.type.Doctor;
import com.nespresso.recruitment.gossip.model.type.Gentlemen;
import com.nespresso.recruitment.gossip.model.type.Lady;
import com.nespresso.recruitment.gossip.model.type.Mister;
import com.nespresso.recruitment.gossip.model.type.Professor;

public class PersonFactory {
    public static Person createNewPerson(String type, String name) {
        Person person;
        switch (type.toLowerCase()) {
            case MISTER:
                person = new Mister(type, name);
                break;
            case DOCTOR:
                person = new Doctor(type, name);
                break;
            case AGENT:
                person = new Agent(type, name);
                break;
            case PROFESSOR:
                person = new Professor(type, name);
                break;
            case LADY:
                person = new Lady(type, name);
                break;
            case GENTLEMEN:
                person = new Gentlemen(type, name);
                break;
            default:
                throw new RuntimeException("Could'nt find the person");
        }
        return person;
    }
}
