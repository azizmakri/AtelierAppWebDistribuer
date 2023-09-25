package com.example.servicemicroservice.repositories;

import com.example.servicemicroservice.entities.serviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends JpaRepository<serviceEntity,Integer> {
    @Query("select s from serviceEntity s where s.nomService like :name")
    public Class<serviceEntity> serviceBynom(@Param("name") String n );
}
