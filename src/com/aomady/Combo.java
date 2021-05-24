package com.aomady;

public class Combo {
    private Item object;
    private Item subject;
    private Item result;
    private String message;
    private String error;

    public Combo(Item object, Item subject, Item result, String message, String error){
        this.object = object;
        this.subject = subject;
        this.result = result;
        this.message = message;
        this.error = error;
    }

    public Item getObject(){
        return object;
    }
    public Item getSubject(){
        return subject;
    }
    public Item getResult(){
        return result;
    }

    public String getMessage(){
        return message;
    }
    public String getError(){
        return error;
    }
}
