package com.example.reto.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import java.util.Optional;

import com.example.reto.entity.Appointments;

public interface AppointmentsService {
	
	List<Appointments> getListAppointments();
	Optional<Appointments> getAppointmentById (Long id);

	Appointments saveAppointment(Appointments appointment);
	
	Appointments updateAppointment(Appointments appointment);
	
	void deleteAppointment( Long id);

	List<Appointments> getAppointmentByDate(LocalDate date);
	
	List<Appointments> getAppointmentByIdAffiliate(int id);
}
