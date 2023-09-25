package com.example.servicemicroservice.services;

import com.example.servicemicroservice.entities.serviceEntity;
import com.example.servicemicroservice.repositories.ServiceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class IServiceIMP implements IService{
    public final ServiceRepository serviceRepo;

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<serviceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public serviceEntity getById(int id) {
        return serviceRepository.findById(id).orElse(null);
    }

    public serviceEntity addService(serviceEntity service){
        return serviceRepository.save(service);
    }
    public serviceEntity updateService(int id ,serviceEntity newService){
        if (serviceRepository.findById(id).isPresent()){
            serviceEntity existinService = serviceRepository.findById(id).get();
            existinService.setNomService(newService.getNomService());
            return  serviceRepository.save(existinService);
        }else
            return null;
    }

    public String deleteService(int id){
        if(serviceRepository.findById(id).isPresent()){
            serviceRepository.deleteById(id);
            return "Service Supprimer";
        }else
            return "Service non supprimer";
    }

}
