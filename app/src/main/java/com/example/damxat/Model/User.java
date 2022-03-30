package com.example.damxat.Model;

public class User {
    String id;
    String username;
    String status;
    //Para un usuario se necesita un id, un nombre, y un estado
    public User(String id, String username, String status) {
        this.id = id;
        this.username = username;
        //El estado no se completa
    }
    //O no
    public User() {
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getStatus(){
        return status;
    }
    //Cambia el estado
    public void setStatus(String status) {
        this.status = status;
    }
}
