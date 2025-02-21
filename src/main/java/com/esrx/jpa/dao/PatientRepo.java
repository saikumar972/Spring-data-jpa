package com.esrx.jpa.dao;

import com.esrx.jpa.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient,Integer> {

    List<Patient> findByBillIn(List<Double> price);

    List<Patient> findByBillBetween(double min, double max);

    List<Patient> findByBillGreaterThan(double salary);

    List<Patient> findByBillLessThan(double salary);

    List<Patient> findByNameIgnoreCaseContains(String name);
}
