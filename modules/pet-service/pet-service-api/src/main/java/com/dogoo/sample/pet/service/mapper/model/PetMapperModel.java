package com.dogoo.sample.pet.service.mapper.model;

import java.util.Date;

public class PetMapperModel {
    private String name;
    private String description;
    private String brief;
    private double weight;
    private int gender;
    private boolean vaccine;
    private Date birthOfDate;
    private String status;
    private long animalGroupId;
    private long [] animalTags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public boolean isVaccine() {
        return vaccine;
    }

    public void setVaccine(boolean vaccine) {
        this.vaccine = vaccine;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getAnimalGroupId() {
        return animalGroupId;
    }

    public void setAnimalGroupId(long animalGroupId) {
        this.animalGroupId = animalGroupId;
    }

    public long[] getAnimalTags() {
        return animalTags;
    }

    public void setAnimalTags(long[] animalTags) {
        this.animalTags = animalTags;
    }
}
