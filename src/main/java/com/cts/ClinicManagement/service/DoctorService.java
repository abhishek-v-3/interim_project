package com.cts.ClinicManagement.service;
import java.util.List;

import com.cts.ClinicManagement.dto.DoctorDTO;


public interface DoctorService {
    List<DoctorDTO> viewAllDoctors();
    DoctorDTO viewDoctorById(Long id);
    DoctorDTO addDoctor(DoctorDTO doctorDto);
    DoctorDTO updateDoctor(DoctorDTO doctorDto,Long id);
    void deleteDoctor(Long id);
}
