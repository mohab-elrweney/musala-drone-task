package com.example.drone.scheduler;

import com.example.drone.entity.Drone;
import com.example.drone.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class BatteryCapacityScheduler {

    @Autowired
    private DroneRepository droneRepository;

    @Scheduled(fixedDelay = 10000)
    public void checkBatteryLevel(){

       System.out.println("Battery Scheduler Started !!");
       List<Drone> drones = droneRepository.findAll();
       drones.forEach(drone -> {
           System.out.println("Battery level for drone "  +drone.getSerialNumber() + " is " + drone.getBatteryCapacity());
       });
       System.out.println("Battery Scheduler Ended !!");

    }
}
