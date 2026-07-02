package com.iappsan.difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@SessionScope
@JsonIgnoreProperties({"targetSource","advisors"})
public class Invoice {

    @Autowired
    private Client client;
    @Value("${invoice.description}")
    private String description;
    @Autowired
    @Qualifier("itemsInvoiceOficina")
    private List<Item> items;

    @PostConstruct
    public void init() {
        System.out.println("Creando el componente de la factura PostConstruct");
        client.setNombre(client.getNombre() + " O.");
        System.out.println("Descripcion: " + description);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destruyendo el componente de la factura PreDestroy");
    }

    public Invoice() {
        // Todavía son null los valores
        System.out.println("Creando el componente de la factura");
        //System.out.println("Cliente: " + client);
        //System.out.println("Descripcion: " + description);
    }

    public Invoice(Client client, String description, List<Item> items) {
        this.client = client;
        this.description = description;
        this.items = items;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        // int total = 0;
        // for (Item item : items) {
        //     total += item.getImporte().intValue();
        // }
        double total = items.stream()
        .map(x -> x.getImporte())
        .reduce(0.0, Double::sum);
        return total;
    }

}
