package com.example.reto.service.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.reto.entity.Affiliates;
import com.example.reto.entity.Appointments;

import com.example.reto.repository.AppointmentsRepository;
import com.example.reto.service.AppointmentsService;

@Service
public class AppointmentsServiceImpl implements AppointmentsService {
	
	@Autowired
	@Qualifier("appointmentsRepository")
	private AppointmentsRepository appointmentsRepository;
	
	@Override
	public List<Appointments> getListAppointments() {
		List<Appointments> appointmentsDataSource= StreamSupport.stream(
				this.appointmentsRepository.findAll().spliterator(), false).collect(Collectors.toList());
		
		return appointmentsDataSource;
	}

	@Override
	public Optional<Appointments> getAppointmentById(Long id) {
		
		return this.appointmentsRepository.findById(id);
	}
	@Override
	public Appointments saveAppointment(Appointments appointment) {
		return this.appointmentsRepository.save(appointment);
	}

	@Override
	public Appointments updateAppointment(Appointments appointment) {
		return this.appointmentsRepository.save(appointment);
	}

	@Override
	public void deleteAppointment(Long id) {
		this.appointmentsRepository.deleteById(id);
	}

	@Override
	public List<Appointments> getAppointmentByDate(LocalDate date) {
		List<Appointments> filtroByDate= StreamSupport.stream(
				this.appointmentsRepository.findByDateAppointment(date).spliterator(), false).collect(Collectors.toList());
		return filtroByDate;
	}

	@Override
	public List<Appointments> getAppointmentByIdAffiliate(int idAffiliate) {
		List<Appointments> filtroByIdAffiliate= StreamSupport.stream(
				this.appointmentsRepository.findByIdAffiliates(idAffiliate).spliterator(), false).collect(Collectors.toList());
		return filtroByIdAffiliate;	
	}

}
