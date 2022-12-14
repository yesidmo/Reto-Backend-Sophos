package com.example.reto.service;

import java.util.List;
import java.util.Optional;

import com.example.reto.entity.Affiliates;


public interface AffiliatesService {
	
	List<Affiliates> getListAffiliates();
	
	Optional<Affiliates> getAffiliateById(Long id);
	
	Affiliates saveAffiliate(Affiliates affiliates);
	
	Affiliates updateAffiliate(Affiliates affiliates);
	
	void deleteAffiliate( Long id);

}
