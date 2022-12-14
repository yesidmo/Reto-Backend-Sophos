package com.example.reto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.reto.entity.Affiliates;
@Repository
public interface AffiliatesRepository extends CrudRepository<Affiliates, Long> {

}
