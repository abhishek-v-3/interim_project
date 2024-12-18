package com.cts.ClinicManagement.service.impl;

import org.springframework.stereotype.Service;

import com.cts.ClinicManagement.entity.Doctor;
import com.cts.ClinicManagement.repository.DoctorRepository;
import com.cts.ClinicManagement.service.DoctorService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<Doctor> viewAllDoctors(){
        
        return doctorRepository.findAll();
    }

    @Override
    public Doctor viewDoctorById(int id){
        Doctor doctor=  doctorRepository.findById(id).get();
        return doctor;
    }

    @Override
    public void addDoctor(Doctor doctor) {

        doctorRepository.save(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        // Optional<Patient> patientToUpdate = DoctorRepository.findById(id);

        doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }

}
