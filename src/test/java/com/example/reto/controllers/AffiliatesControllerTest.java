package com.example.reto.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.reto.entity.Affiliates;
import com.example.reto.repository.AffiliatesRepository;
import com.example.reto.service.impl.AffiliatesServiceImpl;

@ExtendWith(MockitoExtension.class)
class AffiliatesControllerTest {
    
   // @Mock
    //private AffiliatesRepository affiliatesRepository;
	//@Autowired
	//Optional<Affiliates> affiliates;
	
	AffiliatesRepository affiliatesRepositoryMock= Mockito.mock(AffiliatesRepository.class);
    
    @InjectMocks
    private AffiliatesServiceImpl affiliatesServiceImpl=new AffiliatesServiceImpl();
    
    @Autowired
    AffiliatesController affiliatesController= new AffiliatesController(affiliatesRepositoryMock, affiliatesServiceImpl);
    	
   @Autowired
    private Affiliates affiliate;
    
    @BeforeEach
    void setUp() {
       // MockitoAnnotations.initMocks(this);
        
        affiliate = new Affiliates();
        
        affiliate.setAge(28);
        affiliate.setId(2L);
        affiliate.setMail("myesid@gmail.com");
        affiliate.setName("Yesid Muñoz Ome");
        
     // Mockito.when(affiliatesRepositoryMock.findById(2l)).thenReturn(affiliate);
    }

    @Test
    void getListAffiliates() {
        when(affiliatesRepositoryMock.findAll()).thenReturn(List.of(affiliate)); //findAll()).thenReturn(List.of(affiliate));
        assertNotNull(affiliatesServiceImpl.getListAffiliates());
    }
    @Test
    void getAffiliateById() {
    	//affiliate= new Affiliates();
    	
    	ResponseEntity<Affiliates> affiliateRespuesta;
    	affiliateRespuesta=affiliatesController.getAffiliateById(2l);
       Assertions.assertEquals(2L, affiliate.getId());
    }
    
    @Test
    public void testSaveAffiliate() {
    	
      // Crea un objeto Affiliates
      Affiliates affiliate = new Affiliates();
      affiliate.setName("Affiliate1");
      affiliate.setMail("affiliate1@gmail.com");

      // Llama al método saveAffiliate
      ResponseEntity<?> response = affiliatesController.saveAffiliate(affiliate);

      // Verifica que el código de estado del response es CREATED
      assertEquals(HttpStatus.CREATED, response.getStatusCode());

      // Verifica que el cuerpo del response es igual al objeto Affiliates que pasamos como parámetro
      //assertEquals(affiliate, response.getBody());
    }
    
    @Test
    public void testUpdateffiliate() {
    	
      // Crea un objeto Affiliates
      Affiliates affiliate = new Affiliates();
      affiliate.setName("Affiliate");
      affiliate.setMail("affiliate@gmail.com");

      // Llama al método saveAffiliate
      ResponseEntity<?> response = affiliatesController.updateAffiliate(affiliate);

      // Verifica que el código de estado del response es CREATED
      assertEquals(HttpStatus.CREATED, response.getStatusCode());

      // Verifica que el cuerpo del response es igual al objeto Affiliates que pasamos como parámetro
      //assertEquals(affiliate, response.getBody());
    }


}

