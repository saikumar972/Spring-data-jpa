package com.esrx.jpa.controller;

import com.esrx.jpa.entity.Patient;
import com.esrx.jpa.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @PostMapping("/save")
    public Patient savePatient(@RequestBody Patient patient){
        return patientService.savePatient(patient);
    }
    @PostMapping("/saveAll")
    public List<Patient> saveAllPatients(@RequestBody List<Patient> patientList){
        return patientService.saveAllPatients(patientList);
    }
    @GetMapping("/id/{id}")
    public Patient findPatientById(@PathVariable int id){
        return patientService.findPatientById(id);
    }
    @GetMapping("/getAll")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }
    @PutMapping("/updatePatient")
    public Patient updatePatient(@RequestBody Patient patient){
       return patientService.updatePatient(patient);
    }
    @DeleteMapping("/deleteById/{id}")
    public String deletePatientById(@PathVariable int id){
        return patientService.deletePatientById(id);
    }
}
