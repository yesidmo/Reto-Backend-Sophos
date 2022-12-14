package com.example.reto.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto.entity.Affiliates;
import com.example.reto.entity.Tests;
import com.example.reto.repository.TestsRepository;
import com.example.reto.service.TestsService;

@Service
public class TestsServiceImpl implements TestsService {
	
	@Autowired
	private TestsRepository testsRepository;
	
	@Override
	public List<Tests> getListTests() {

		List<Tests> testsDataSource= StreamSupport.stream(
				this.testsRepository.findAll().spliterator(), false).collect(Collectors.toList());
		
		return testsDataSource;
	}
	@Override
		public Optional<Tests> getTestById(Long id) {
			return this.testsRepository.findById(id);
	}

	@Override
	public Tests saveTest(Tests test) {
		
		return this.testsRepository.save(test);
	}

	@Override
	public Tests updateTest(Tests test) {
		return this.testsRepository.save(test);
	
	}

	@Override
	public void deleteTest(Long id) {
		this.testsRepository.deleteById(id);
		
	}



}
