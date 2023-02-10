package com.example.drone.controller;

import com.example.drone.dto.DroneBattery;
import com.example.drone.dto.DroneDTO;
import com.example.drone.dto.MedicationDTO;
import com.example.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DroneController {

    @Autowired
    private DroneService droneService;

    @PostMapping("/register")
    public void registerDrone(@Valid @RequestBody DroneDTO droneDTO) throws Exception {
        droneService.registerDrone(droneDTO);
    }

    @PostMapping("/load-medications/{serialNumber}")
    public void loadingDroneWithMedications(@PathVariable String serialNumber, @Valid @RequestBody List<MedicationDTO> medicationDTOs) throws Exception {
        droneService.loadingDroneWithMedications(serialNumber, medicationDTOs);
    }

    @GetMapping("/get-medications/{serialNumber}")
    public List<MedicationDTO> getLoadedMedicationsForDrone(@PathVariable String serialNumber){
       return droneService.getLoadedMedicationsForDrone(serialNumber);
    }

    @GetMapping("/drones/available")
    public List<DroneDTO> getAvailableDrones(){
        return droneService.getAvailableDrones();
    }

    @GetMapping("/{serialNumber}/battery-level")
    public DroneBattery checkBatteryLevel(@PathVariable String serialNumber) {
        return droneService.checkBatteryLevel(serialNumber);
    }

}
