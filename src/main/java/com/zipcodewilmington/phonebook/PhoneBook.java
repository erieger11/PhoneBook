package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = new LinkedHashMap<>();
    }
    public PhoneBook() {
        this(null);
    }
    public void add(String name, String phoneNumber) {
        phonebook.put(name,List.of(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name,List.of(phoneNumbers));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        return phonebook.containsKey(name) && phonebook.containsValue(List.of(phoneNumber));
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        Set<String> setofKeys = phonebook.keySet();
        for (String key : setofKeys) {
            List<String> foundNumbers = phonebook.get(key);
            if (foundNumbers.contains(phoneNumber)) {
                return key;
            }
        } return null;
    }
    public List<String> getAllContactNames() {
        return new ArrayList<>(phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
