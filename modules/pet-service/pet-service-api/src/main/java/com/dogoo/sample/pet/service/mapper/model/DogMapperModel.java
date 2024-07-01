package com.dogoo.sample.pet.service.mapper.model;

public class DogMapperModel {
    private String name;
    private String title;
    private double weight;
    private String color;
    private String status;
    private long animalGroupId;
    private String[] animalTags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String[] getAnimalTags() {
        return animalTags;
    }

    public void setAnimalTags(String[] animalTags) {
        this.animalTags = animalTags;
    }
}
