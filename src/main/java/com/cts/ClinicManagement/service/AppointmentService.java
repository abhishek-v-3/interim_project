package com.cts.ClinicManagement.service;

import java.util.List;

import com.cts.ClinicManagement.dto.AppointmentDTO;

public interface AppointmentService {

    List<AppointmentDTO> viewAllAppointments();
    AppointmentDTO viewAppointmentByPatientId(Long id);
    AppointmentDTO addAppointment(Long patientId, Long doctorId,AppointmentDTO appointmentDto);
    AppointmentDTO updateAppointment(AppointmentDTO appointmentDto,Long id);
    void deleteAppointment(Long id);

}
