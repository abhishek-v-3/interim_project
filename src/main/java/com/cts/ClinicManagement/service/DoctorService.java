package com.cts.ClinicManagement.service;

import org.springframework.stereotype.Service;

import com.cts.ClinicManagement.entity.Doctor;
import com.cts.ClinicManagement.repository.DoctorRepository;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> viewAllDoctors(){
        
        return doctorRepository.findAll();
    }

    public Doctor viewDoctorsById(int id){
        Doctor doctor=  doctorRepository.findById(id).get();
        return doctor;
    }

    public void addDoctor(Doctor doctor) {

        doctorRepository.save(doctor);
    }

    public void updateDoctor(Doctor doctor) {
        // Optional<Patient> patientToUpdate = DoctorRepository.findById(id);

        doctorRepository.save(doctor);
    }

    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }

}
