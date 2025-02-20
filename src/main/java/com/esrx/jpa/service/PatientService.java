package com.esrx.jpa.service;

import com.esrx.jpa.dao.PatientRepo;
import com.esrx.jpa.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepo patientRepo;

    public Patient savePatient(Patient patient){
        return patientRepo.save(patient);
    }

    public List<Patient> saveAllPatients(List<Patient> patientList){
        return patientRepo.saveAll(patientList);
    }

    public Patient findPatientById(int id){
        return patientRepo.findById(id).orElseThrow(()->new IllegalArgumentException("patient not found"));
    }

    public List<Patient> getAllPatients(){
        return patientRepo.findAll();
    }

    public Patient updatePatient(Patient patient){
        Patient existingPatient=findPatientById(patient.getId());
        existingPatient.setName(patient.getName());
        existingPatient.setBill(patient.getBill());
        existingPatient.setJoiningDate(patient.getJoiningDate());
        patientRepo.save(existingPatient);
        return existingPatient;
    }

    public String deletePatientById(int id){
        patientRepo.deleteById(id);
        return "patient with the id "+id+" is successfully deleted";
    }
}
