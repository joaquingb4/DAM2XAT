package com.example.damxat.Model;
//
public class Xat {

    String sender;//Remitente
    String receiver;//Destinatario
    String message;//Menssaje
    //Un chat necesita el remitente y el mensaje.
    public Xat(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    //O no
    public Xat() {

    }

    //o también solo el remitente, el destinatario y el mensaje
    public Xat(String sender, String receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }
    //Devuelve el remitente
    public String getSender() {
        return sender;
    }
    //Devuelve el destinatario
    public String getReceiver() {
        return receiver;
    }
    //Devuelve el mensaje del chat
    public String getMessage() {
        return message;
    }
}
