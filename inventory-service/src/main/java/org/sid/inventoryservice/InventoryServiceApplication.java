package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.saveAll(List.of(
                Product.builder().name("product1").price(1200+Math.random()*10000).quantity(100).build(),
                Product.builder().name("product2").price(1200+Math.random()*10000).quantity(200).build(),
                Product.builder().name("product3").price(1200+Math.random()*10000).quantity(300).build()
              ));
            productRepository.findAll().forEach(System.out::println);
        };
    }

}
