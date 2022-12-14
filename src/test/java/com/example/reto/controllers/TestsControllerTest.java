package com.example.reto.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.reto.entity.Appointments;
import com.example.reto.entity.Tests;
import com.example.reto.repository.AppointmentsRepository;
import com.example.reto.repository.TestsRepository;
import com.example.reto.service.impl.AppointmentsServiceImpl;
import com.example.reto.service.impl.TestsServiceImpl;

@ExtendWith(MockitoExtension.class)
class TestsControllerTest {

    @Mock
    private TestsRepository testsRepository;
    
    @InjectMocks
    private TestsServiceImpl testsServiceImpl;
    	
    private Tests test;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        test = new Tests();
        
        test.setName("COVID");
        test.setId(2l);
        test.setDescription("Detectar coronavirus");
    }

    @Test
    void getListTests() {
        when(testsRepository.findAll()).thenReturn(List.of(test)); //findAll()).thenReturn(List.of(affiliate));
        assertNotNull(testsServiceImpl.getListTests());
    }
}