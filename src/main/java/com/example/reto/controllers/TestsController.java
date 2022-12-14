package com.example.reto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.reto.entity.Affiliates;
import com.example.reto.entity.Appointments;
import com.example.reto.entity.Tests;
import com.example.reto.service.TestsService;

@RestController
@RequestMapping(value="api/controller")
public class TestsController {
	
	@Autowired
	private TestsService testsServiceImpl;
	
	@GetMapping
	@RequestMapping(value="getListTests", method = RequestMethod.GET)
	public ResponseEntity<?> getListTests(){
		
		List<Tests> testsConsultados= this.testsServiceImpl.getListTests();
		
		return ResponseEntity.ok(testsConsultados);
	}
	@GetMapping
	@RequestMapping(value="getTestById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tests> getTestById(@PathVariable Long id) {
		
        Optional<Tests> test = testsServiceImpl.getTestById(id);
        
        if (test.isPresent()) {
            return ResponseEntity.ok(test.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	@PostMapping
	@RequestMapping(value="saveTest", method = RequestMethod.POST)
	public ResponseEntity<?> saveTest(@RequestBody Tests test){

		try {
			Tests testGuardado = this.testsServiceImpl.saveTest(test);
			return ResponseEntity.status(HttpStatus.CREATED).body(testGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	@PutMapping
	@RequestMapping(value="updateTest", method = RequestMethod.PUT)
	public ResponseEntity<?> updateTest(@RequestBody Tests test){
		

		try {
			Tests testActualizado = this.testsServiceImpl.updateTest(test);
			return ResponseEntity.status(HttpStatus.CREATED).body(testActualizado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	@DeleteMapping
	@RequestMapping(value="deleteTest/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteTest(@PathVariable Long id){
		
		try {
			this.testsServiceImpl.deleteTest(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

	}

}
