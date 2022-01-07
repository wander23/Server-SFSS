package com.example.mongodb.model;

public class ResponeObject {
    private Object data;

    public ResponeObject(){}

    public ResponeObject(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
