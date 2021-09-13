package com.example.springplayground;

public class Greeting {

    private int id;
    private String name;
    private String message;

    public Greeting(int id, String name){
        this.id = id;
        this.name = name;
        this.message = String.format("Hello, %s!", name);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
