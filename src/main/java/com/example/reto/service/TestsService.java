package com.example.reto.service;

import java.util.List;
import java.util.Optional;


import com.example.reto.entity.Tests;

public interface TestsService {

	List<Tests> getListTests();
	
	Optional<Tests> getTestById(Long id);
	
	Tests saveTest(Tests test);
	
	Tests updateTest(Tests test);
	
	void deleteTest(Long id);
}
