package com.example.damxat.Model;

import java.util.ArrayList;

public class XatGroup {
    String name;
    ArrayList<String> users;
    ArrayList<Xat> xats;

    //Para instanciar un grupo se necesita un nombre de grupo
    public XatGroup(String name) {
        this.name = name;

    }
    //O no
    public XatGroup() {
    }

    //Devuelve el nombre del grupo
    public String getName() {
        return name;
    }
    //Desvuelve los usuarios del grupo
    public ArrayList<String> getUsers() {
        return users;
    }
    //Devuelve los chats del grupo
    public ArrayList<Xat> getXats() {
        return xats;
    }
}
