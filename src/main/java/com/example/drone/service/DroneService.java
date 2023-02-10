package com.example.drone.service;

import com.example.drone.dto.DroneBattery;
import com.example.drone.dto.DroneDTO;
import com.example.drone.dto.MedicationDTO;
import com.example.drone.entity.Drone;
import com.example.drone.entity.Medication;
import com.example.drone.entity.enums.State;
import com.example.drone.mapper.DroneMapper;
import com.example.drone.mapper.MedicationMapper;
import com.example.drone.repository.DroneRepository;
import com.example.drone.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private MedicationRepository medicationRepository;

    public void registerDrone(@Valid DroneDTO droneDTO) throws Exception {
        if(droneDTO.getBatteryCapacity() < 25
                &&droneDTO.getState().equals(State.LOADING)){
            throw new Exception("Drone can not be in LOADING state with battery capacity less than 25%");
        }
       Drone drone = DroneMapper.INSTANCE.toDrone(droneDTO);
       droneRepository.save(drone);
    }

    @Transactional
    public void loadingDroneWithMedications(String serialNumber, List<MedicationDTO> medicationDTOs) throws Exception {
       List<Medication> medications = MedicationMapper.INSTANCE.toMedications(medicationDTOs);
        Drone drone = droneRepository.findBySerialNumber(serialNumber);
        Integer weight = 0;
        for(Medication medication : medications){
            weight += medication.getWeight();
            medication.setDrone(drone);
        }

        if(weight > 500){
            throw new Exception("Total weight is more than 500");
        }
        drone.setMedications(medications);
        droneRepository.save(drone);
    }

    public List<MedicationDTO> getLoadedMedicationsForDrone(String serialNumber){
        List<Drone> drones = droneRepository.findAll();
        List<Medication> medications = medicationRepository.findByDroneSerialNumber(serialNumber);
        return MedicationMapper.INSTANCE.toMedicationDTOs(medications);
    }

    public List<DroneDTO> getAvailableDrones(){
        List<Drone> availableDrones = droneRepository.findByWeightLimitLessThan(500);
        return DroneMapper.INSTANCE.toDroneDTOs(availableDrones);
    }

    public DroneBattery checkBatteryLevel(String serialNumber){
        return new DroneBattery(droneRepository.findBySerialNumber(serialNumber).getBatteryCapacity());
    }

}
