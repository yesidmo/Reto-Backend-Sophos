package com.example.reto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.reto.entity.Tests;
@Repository
public interface TestsRepository extends CrudRepository<Tests, Long> {

}
