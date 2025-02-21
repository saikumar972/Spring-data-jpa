package com.esrx.jpa.service;

import com.esrx.jpa.dao.PatientRepo;
import com.esrx.jpa.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    //jpa queries
    public List<Patient> getPatientsBySalaryRange(List<Double> price){
        return patientRepo.findByBillIn(price);
    }

    public List<Patient> getPatientListInSalaryRange(double min,double max){
        return patientRepo.findByBillBetween(min,max);
    }

    public List<Patient> getPatientSalaryGreaterThan(double salary){
        return patientRepo.findByBillGreaterThan(salary);
    }

    public List<Patient> getPatientSalaryLessThan(double salary){
        return patientRepo.findByBillLessThan(salary);
    }

    public List<Patient> getPatientsHavingNameIn(String name){
        return patientRepo.findByNameIgnoreCaseContains(name);
    }

    //sorting
    public List<Patient> getPatientListSortByName(String patientName){
        return patientRepo.findAll(Sort.by(Sort.Direction.DESC,patientName));
    }

    //pagination
    public Page<Patient> getPatientListByPages(int offset, int limit){
        return patientRepo.findAll(PageRequest.of(offset, limit));
    }

    //pagination and sorting
    public Page<Patient> getPatientDataInPagesSortInNames(String name,int offset,int limit){
        return patientRepo.findAll(PageRequest.of(offset,limit, Sort.by(Sort.Direction.DESC,name)));
    }
}
