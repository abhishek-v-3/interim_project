package com.cts.ClinicManagement.service.impl;

import org.springframework.stereotype.Service;

import com.cts.ClinicManagement.dto.DoctorDTO;
import com.cts.ClinicManagement.entity.Doctor;
import com.cts.ClinicManagement.exceptions.ResourceNotFoundException;
import com.cts.ClinicManagement.repository.DoctorRepository;
import com.cts.ClinicManagement.service.DoctorService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    private ModelMapper mapper; 

    // method to view all doctors
    @Override
    public List<DoctorDTO> viewAllDoctors(){
        
        return doctorRepository.findAll().stream().map(doctor->mapToDto(doctor)).collect(Collectors.toList());
    }

    @Override
    public DoctorDTO viewDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Doctor", "id", id));
        return mapToDto(doctor);
    }

    // method to add a new doctor
    @Override
    public DoctorDTO addDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = mapToEntity(doctorDTO);
        Doctor tempDoctor = doctorRepository.save(doctor);
        DoctorDTO response = mapToDto(tempDoctor);
        return response;
    }

    // method to update a doctor
    @Override
    public DoctorDTO updateDoctor(DoctorDTO doctorDTO,Long id) {
        Doctor updatedDoctor = mapToEntity(doctorDTO);
        Doctor existingDoctor = doctorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", id));

        // Update only the provided fields
        if (updatedDoctor.getName() != null) {
            existingDoctor.setName((updatedDoctor.getName()));
        }
        
        if (updatedDoctor.getAge() != 0) { // Assuming age is not null but can be zero
            existingDoctor.setAge(updatedDoctor.getAge());
        }
        if (updatedDoctor.getDept() != null) {
            existingDoctor.setDept(updatedDoctor.getDept());
        }
        if (updatedDoctor.getSpecialization() != null) {
            existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
        }

        // Save the updated doctor entity
        DoctorDTO savedDoctorDTO = mapToDto(doctorRepository.save(existingDoctor));

        return savedDoctorDTO;

    }

    @Override
    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor", "id", id));
        doctorRepository.delete(doctor);
    }

     public Doctor mapToEntity(DoctorDTO doctorDto) {
        Doctor doctor = mapper.map(doctorDto, Doctor.class);
        
        return doctor;
    }

    // to convert entity into dto
    public DoctorDTO mapToDto(Doctor doctor) {
        DoctorDTO doctorDTO = mapper.map(doctor, DoctorDTO.class);

        return doctorDTO;
    }

}
