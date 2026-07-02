package com.iappsan.difactura;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.iappsan.difactura.models.Item;
import com.iappsan.difactura.models.Product;

@Configuration
@PropertySources({
    @PropertySource("classpath:data.properties")
})
public class AppConfig {

    @Bean("itemsInvoiceSports")
    // Se puede usar @Primary también para indicar que es el bean principal, pero en este caso se usa un nombre específico para diferenciarlo.
    List<Item> itemsInvoiceSports() {
        Product p1 = new Product("Camara Sony", 100);
        Product p2 = new Product("Bicicleta 26", 1700);
        Product p3 = new Product("Balon", 250);
        return List.of(new Item(p1, 2), new Item(p2, 1), new Item(p3, 4));
    }

    @Bean("itemsInvoiceOficina")
    List<Item> itemsInvoiceOficina() {
        Product p1 = new Product("Monitor Asus", 2300);
        Product p2 = new Product("Notebook", 11700);
        Product p3 = new Product("Teclado", 350);
        Product p4 = new Product("Escritorio doble", 7100);
        return List.of(new Item(p1, 2), new Item(p2, 1), new Item(p3, 4), new Item(p4, 1));
    }
}
