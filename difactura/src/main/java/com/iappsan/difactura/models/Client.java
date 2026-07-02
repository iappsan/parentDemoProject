package com.iappsan.difactura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Client {

    @Value("${client.name}")
    private String nombre;
    @Value("${client.lastName}")
    private String lastname;

    public Client() {
    }

    public Client(String nombre, String lastname) {
        this.nombre = nombre;
        this.lastname = lastname;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    

}
