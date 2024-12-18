package com.cts.ClinicManagement.service;
import java.util.List;

import com.cts.ClinicManagement.entity.Doctor;

public interface DoctorService {
    List<Doctor> viewAllDoctors();
    Doctor viewDoctorById(int id);
    void addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(int id);
}
