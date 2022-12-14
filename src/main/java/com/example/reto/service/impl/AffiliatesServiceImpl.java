package com.example.reto.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto.entity.Affiliates;
import com.example.reto.repository.AffiliatesRepository;
import com.example.reto.service.AffiliatesService;


@Service
public class AffiliatesServiceImpl implements AffiliatesService {
	
	@Autowired
	private AffiliatesRepository affiliatesRepository;
	
	@Override
	public List<Affiliates> getListAffiliates() {
		
		List<Affiliates> affiliatesDataSource= StreamSupport.stream(
				this.affiliatesRepository.findAll().spliterator(), false).
				collect(Collectors.toList());
		
		return affiliatesDataSource;	
	}
	
	@Override
	public Optional<Affiliates> getAffiliateById(Long id) {
		
		return this.affiliatesRepository.findById(id);
	}


	@Override
	public Affiliates saveAffiliate(Affiliates affiliate) {
		
		return this.affiliatesRepository.save(affiliate);
	}

	@Override
	public Affiliates updateAffiliate(Affiliates affiliate) {
		return this.affiliatesRepository.save(affiliate);
	}

	@Override
	public void deleteAffiliate(Long id) {
		this.affiliatesRepository.deleteById(id);
		
	}




}
