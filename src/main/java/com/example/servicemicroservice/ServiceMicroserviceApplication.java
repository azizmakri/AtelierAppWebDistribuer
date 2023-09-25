package com.example.servicemicroservice;

import com.example.servicemicroservice.entities.serviceEntity;
import com.example.servicemicroservice.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMicroserviceApplication.class, args);
    }
    @Autowired
    private ServiceRepository serviceRepository;

     @Bean
    ApplicationRunner init(){
        return (args) -> {
            //Sava
            serviceRepository.save(new serviceEntity(1,"CRM"));
           serviceRepository.save(new serviceEntity(2,"Reservation"));
            serviceRepository.save(new serviceEntity(3,"Vente"));
            //fetch
            serviceRepository.findAll().forEach(System.out::println);
        };
    }

}
