package com.college.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 101;
    private String name = "Java Programming";
    private String dateOfCompletion = "10-Feb-2026";

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDateOfCompletion() {
        return dateOfCompletion;
    }

    @Override
    public String toString() {
        return "Certification [id=" + id + 
               ", name=" + name + 
               ", dateOfCompletion=" + dateOfCompletion + "]";
    }
}
