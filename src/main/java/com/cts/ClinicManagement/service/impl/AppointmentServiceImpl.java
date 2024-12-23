package com.cts.ClinicManagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ClinicManagement.dto.AppointmentDTO;
import com.cts.ClinicManagement.entity.Appointment;
import com.cts.ClinicManagement.entity.Doctor;
import com.cts.ClinicManagement.entity.Patient;
import com.cts.ClinicManagement.exceptions.ResourceNotFoundException;
import com.cts.ClinicManagement.repository.AppointmentRepository;
import com.cts.ClinicManagement.repository.DoctorRepository;
import com.cts.ClinicManagement.repository.PatientRepository;
import com.cts.ClinicManagement.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper mapper;

    // view all appointments
    @Override
    public List<AppointmentDTO> viewAllAppointments() {
         return appointmentRepository.findAll().stream().map(appointment-> mapToDto(appointment)).collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO viewAppointmentByPatientId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewAppointmentByPatientId'");
    }

    @Override
    public AppointmentDTO addAppointment(Long patientId, Long doctorId,AppointmentDTO appointmentDto) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", patientId));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", doctorId));
        Appointment appointment = mapToEntity(appointmentDto);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        
        Appointment tempAppointment = appointmentRepository.save(appointment);
        AppointmentDTO response = mapToDto(tempAppointment);

        return response;
    }

    @Override
    public AppointmentDTO updateAppointment(AppointmentDTO appointmentdDto, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAppointment'");
    }

    @Override
    public void deleteAppointment(Long id) {
        Appointment appointmentToDelete = appointmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Appointment", "id", id));
        appointmentRepository.delete(appointmentToDelete);
    }

    // to convert dto into entity
    public Appointment mapToEntity(AppointmentDTO appointmentDto) {
        Appointment appointment = mapper.map(appointmentDto, Appointment.class);
        
        return appointment;
    }

    // to convert entity into dto
    public AppointmentDTO mapToDto(Appointment appointment) {
        AppointmentDTO appointmentDTO = mapper.map(appointment, AppointmentDTO.class);

        return appointmentDTO;
    }
    
}
