package com.esrx.jpa.dao;

import com.esrx.jpa.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient,Integer> {

}
