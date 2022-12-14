package com.example.reto.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.reto.entity.Appointments;

@Repository
public interface AppointmentsRepository extends CrudRepository<Appointments, Long> {


	@Query(value="select * from appointments where appointments.date=:dateA", nativeQuery = true )
	List<Appointments>findByDateAppointment(@Param("dateA") LocalDate date);
	
	@Query(value="select * from appointments where appointments.id_affiliate=:dateIdA", nativeQuery = true )
	List<Appointments>findByIdAffiliates(@Param("dateIdA")int idAffiliate);
	
}
