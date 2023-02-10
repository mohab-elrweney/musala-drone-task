package com.example.drone.mapper;

import com.example.drone.dto.DroneDTO;
import com.example.drone.entity.Drone;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DroneMapper {

    DroneMapper INSTANCE = Mappers.getMapper(DroneMapper.class);

    DroneDTO toDroneDTO(Drone drone);

    List<DroneDTO> toDroneDTOs(List<Drone> drones);

    Drone toDrone(DroneDTO droneDTO);

    List<Drone> toDrones(List<DroneDTO> droneDTOs);
}
