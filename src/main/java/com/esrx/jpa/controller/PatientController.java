package com.esrx.jpa.controller;

import com.esrx.jpa.entity.Patient;
import com.esrx.jpa.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    //jpa queries
    @PostMapping("/salaryRange")
    public List<Patient> getPatientsBySalaryRange(@RequestBody List<Double> price){
        return patientService.getPatientsBySalaryRange(price);
    }
    @GetMapping("/getSalaryInBetween/{min}/{max}")
    public List<Patient> getPatientListInSalaryRange(@PathVariable double min,@PathVariable double max){
        return patientService.getPatientListInSalaryRange(min,max);
    }
    @GetMapping("/salaryGreaterThan/{salary}")
    public List<Patient> getPatientSalaryGreaterThan(@PathVariable double salary){
        return patientService.getPatientSalaryGreaterThan(salary);
    }
    @GetMapping("/salaryLesserThan/{salary}")
    public List<Patient> getPatientSalaryLessThan(@PathVariable double salary){
        return patientService.getPatientSalaryLessThan(salary);
    }
    @GetMapping("/patientUsingNames/{name}")
    public List<Patient> getPatientsHavingNameIn(@PathVariable String name){
        return patientService.getPatientsHavingNameIn(name);
    }

    //sorting
    @GetMapping("/soring/{fieldName}")
    public List<Patient> getPatientListSortByName(@PathVariable String fieldName){
        return patientService.getPatientListSortByName(fieldName);
    }

    //pagination
    @GetMapping("/pages/{offset}/{limit}")
    public Page<Patient> getPatientListByPages(@PathVariable int offset,@PathVariable int limit){
        return patientService.getPatientListByPages(offset, limit);
    }

    //pagination and sorting
    @GetMapping("/paginationAndSorting/{fieldName}/{offset}/{limit}")
    public Page<Patient> getPatientDataInPagesSortInNames(@PathVariable String fieldName,@PathVariable int offset,@PathVariable int limit){
        return patientService.getPatientDataInPagesSortInNames(fieldName,offset,limit);
    }
}
