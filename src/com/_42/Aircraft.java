package com._42;

abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter;

    Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId(){
        idCounter += 1;
        return idCounter;
    }
}