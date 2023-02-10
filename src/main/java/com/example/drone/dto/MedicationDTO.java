package com.example.drone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

public class MedicationDTO {

    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$")
    private String name;

    private Integer weight;

    @Pattern(regexp = "^[A-Z0-9_]*$")
    private String code;

    private byte[] image;

    public MedicationDTO(String name, Integer weight, String code, byte[] image) {
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.image = image;
    }

    public MedicationDTO() {
    }

    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getCode() {
        return code;
    }

    public byte[] getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


}
