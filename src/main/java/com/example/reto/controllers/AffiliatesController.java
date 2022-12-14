package com.example.reto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.example.reto.entity.Affiliates;
import com.example.reto.repository.AffiliatesRepository;
import com.example.reto.service.AffiliatesService;

@RestController
@RequestMapping("/api/controller")
public class AffiliatesController {

	Optional<Affiliates> affiliates;
	@Autowired
	private AffiliatesService affiliatesServiceImpl;

	@Autowired
	private AffiliatesRepository affiliateRepository;

	public AffiliatesController(AffiliatesRepository affiliateRepository, AffiliatesService affiliatesServiceImpl) {
		this.affiliateRepository = affiliateRepository;
		this.affiliatesServiceImpl = affiliatesServiceImpl;
	}

	@GetMapping
	@RequestMapping(value = "getListAffiliates", method = RequestMethod.GET)
	public ResponseEntity<?> getListAffiliates() {

		List<Affiliates> afiliadosConsultados = this.affiliatesServiceImpl.getListAffiliates();

		return ResponseEntity.ok(afiliadosConsultados);
	}

	@GetMapping
	@RequestMapping(value = "getAffiliateById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Affiliates> getAffiliateById(@PathVariable Long id) {

		Optional<Affiliates> affiliate = affiliatesServiceImpl.getAffiliateById(id);

		if (affiliate.isPresent()) {
			return ResponseEntity.ok(affiliate.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@RequestMapping(value = "saveAffiliate", method = RequestMethod.POST)
	public ResponseEntity<?> saveAffiliate(@RequestBody Affiliates affiliate) {

		try {
		Affiliates affiliateGuardado = this.affiliatesServiceImpl.saveAffiliate(affiliate);
		return ResponseEntity.status(HttpStatus.CREATED).body(affiliateGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@PutMapping
	@RequestMapping(value = "updateAffiliate", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAffiliate(@RequestBody Affiliates affiliate) {
		try {
		Affiliates affiliateActualizado = this.affiliatesServiceImpl.updateAffiliate(affiliate);
		return ResponseEntity.status(HttpStatus.CREATED).body(affiliateActualizado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping
	@RequestMapping(value = "deleteAffiliate/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAffiliate(@PathVariable Long id) {
		try {
			this.affiliatesServiceImpl.deleteAffiliate(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

	}
}
