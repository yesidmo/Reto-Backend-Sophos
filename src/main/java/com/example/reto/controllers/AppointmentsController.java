package com.example.reto.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.reto.entity.Affiliates;
import com.example.reto.entity.Appointments;
import com.example.reto.service.AppointmentsService;

@RestController
@RequestMapping("/api/controller")
public class AppointmentsController {
	@Autowired
	private AppointmentsService appointmentsServiceImpl;

	@GetMapping
	@RequestMapping(value = "getListAppointments", method = RequestMethod.GET)
	public ResponseEntity<?> getListAppointments() {

		List<Appointments> listAppointments = this.appointmentsServiceImpl.getListAppointments();

		return ResponseEntity.ok(listAppointments);

	}

	@GetMapping
	@RequestMapping(value = "getAppointmentById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Appointments> getAppointmentById(@PathVariable Long id) {

		Optional<Appointments> appointment = appointmentsServiceImpl.getAppointmentById(id);

		if (appointment.isPresent()) {
			return ResponseEntity.ok(appointment.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@RequestMapping(value = "saveAppointment", method = RequestMethod.POST)
	public ResponseEntity<?> saveAppointment(@RequestBody Appointments appointment) {


		try {
			Appointments appointmentGuardado = this.appointmentsServiceImpl.saveAppointment(appointment);
			return ResponseEntity.status(HttpStatus.CREATED).body(appointmentGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@PutMapping
	@RequestMapping(value = "updateAppointment", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAppointment(@RequestBody Appointments appointment) {

		try {
			Appointments appointmentActualizado = this.appointmentsServiceImpl.updateAppointment(appointment);
			return ResponseEntity.status(HttpStatus.CREATED).body(appointmentActualizado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@DeleteMapping
	@RequestMapping(value = "deleteAppointment/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAppointment(@PathVariable Long id) {

		try {
			this.appointmentsServiceImpl.deleteAppointment(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

	}

	@GetMapping
	@RequestMapping(value = "ByDate", method = RequestMethod.GET)
	public ResponseEntity<?> getAppointmentByDate(@RequestParam String date) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate localDate = LocalDate.parse(date, formatter);
		List<Appointments> appointment = this.appointmentsServiceImpl.getAppointmentByDate(localDate);

		return ResponseEntity.ok(appointment);
	}

	@GetMapping
	@RequestMapping(value = "ByIdAffiliate/{idAffiliate}", method = RequestMethod.GET)
	public ResponseEntity<?> getAppointmentByIdAffiliate(@PathVariable int idAffiliate) {

		List<Appointments> idAffiliates = this.appointmentsServiceImpl.getAppointmentByIdAffiliate(idAffiliate);

		return ResponseEntity.ok(idAffiliates);
	}
}
