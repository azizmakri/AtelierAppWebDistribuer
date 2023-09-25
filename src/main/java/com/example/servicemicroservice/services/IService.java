package com.example.servicemicroservice.services;

import com.example.servicemicroservice.entities.serviceEntity;

import java.util.List;

public interface IService {
    public List<serviceEntity> getAllServices();
    public serviceEntity getById(int  id);
    public serviceEntity addService(serviceEntity service);
    public serviceEntity updateService(int id ,serviceEntity newService);
    public String deleteService(int id);
}
