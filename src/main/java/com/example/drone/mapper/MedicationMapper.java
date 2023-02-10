package com.example.drone.mapper;

import com.example.drone.dto.DroneDTO;
import com.example.drone.dto.MedicationDTO;
import com.example.drone.entity.Drone;
import com.example.drone.entity.Medication;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicationMapper {

    MedicationMapper INSTANCE = Mappers.getMapper(MedicationMapper.class);

    Medication toMedication(MedicationDTO medicationDTO);

    List<Medication> toMedications(List<MedicationDTO> medicationDTOs);

    MedicationDTO toMedicationDTO(Medication medication);

    List<MedicationDTO> toMedicationDTOs(List<Medication> medications);
 }
