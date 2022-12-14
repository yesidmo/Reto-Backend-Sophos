package com.example.reto.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import com.example.reto.repository.AffiliatesRepository;
import com.example.reto.service.impl.AffiliatesServiceImpl;

@ExtendWith(MockitoExtension.class)
class AffiliatesServiceTest {
    
    @Mock
    private AffiliatesRepository affiliatesRepository;
    
    @InjectMocks
    private AffiliatesServiceImpl affiliatesServiceImpl;
    	
    private Affiliates affiliate;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        affiliate = new Affiliates();
        
        affiliate.setAge(28);
        affiliate.setId(2l);
        affiliate.setMail("myesid@gmail.com");
        affiliate.setName("Yesid Muñoz Ome");
    }

    @Test
    void getListAffiliates() {
        when(affiliatesRepository.findAll()).thenReturn(List.of(affiliate)); //findAll()).thenReturn(List.of(affiliate));
        assertNotNull(affiliatesServiceImpl.getListAffiliates());
    }
}
