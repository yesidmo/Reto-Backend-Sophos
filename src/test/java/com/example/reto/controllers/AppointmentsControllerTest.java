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

import com.example.reto.entity.Affiliates;
import com.example.reto.entity.Appointments;
import com.example.reto.repository.AffiliatesRepository;
import com.example.reto.repository.AppointmentsRepository;
import com.example.reto.service.impl.AffiliatesServiceImpl;
import com.example.reto.service.impl.AppointmentsServiceImpl;

@ExtendWith(MockitoExtension.class)
class AppointmentsControllerTest {

    @Mock
    private AppointmentsRepository appointmentsRepository;
    
    @InjectMocks
    private AppointmentsServiceImpl appointmentsServiceImpl;
    	
    private Appointments appointment;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        appointment = new Appointments();
        
        appointment.setDate(null);;
        appointment.setId(2l);
        appointment.setHour(null);
        appointment.setIdTest(2l);
        appointment.setIdAffiliate(3);
    }

    @Test
    void getListAppointments() {
        when(appointmentsRepository.findAll()).thenReturn(List.of(appointment)); //findAll()).thenReturn(List.of(affiliate));
        assertNotNull(appointmentsServiceImpl.getListAppointments());
    }
}
