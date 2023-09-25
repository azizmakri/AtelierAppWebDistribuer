package com.example.servicemicroservice.controllers;

import com.example.servicemicroservice.entities.serviceEntity;
import com.example.servicemicroservice.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/service")
@RestController
public class serviceController {
    @Autowired
    private IService iService;
    private String title ="Hello , Service Microservice";

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println(title);
        return title;
    }

    @GetMapping("getall")
    public List<serviceEntity> getAllServices(){
        return iService.getAllServices();
    }
    @GetMapping("getById/{id}")
    public serviceEntity getById(@PathVariable int id){
        return iService.getById(id);
    }
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<serviceEntity> updateService(@PathVariable (value = "id") int id ,
                                                       @RequestBody serviceEntity service){
        return new ResponseEntity<>(iService.updateService(id, service),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteService(@PathVariable (value = "id") int id ){
        return new ResponseEntity<>(iService.deleteService(id),HttpStatus.OK);
    }
}
