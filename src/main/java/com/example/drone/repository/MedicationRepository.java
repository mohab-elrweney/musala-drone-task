package com.example.drone.repository;

import com.example.drone.entity.Drone;
import com.example.drone.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    List<Medication> findByDroneSerialNumber(String serialNumber);
}
