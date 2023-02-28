package com.valorantwiki.valorant_maps.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@MappedSuperclass
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @NotEmpty(message = "The name field is empty")
    private String name;

    @NotEmpty(message = "The description field is empty")
    private String description;

    private String image;

    private String minimap;

    @ElementCollection
    private List<String> gallery;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMinimap() {
        return minimap;
    }

    public void setMinimap(String minimap) {
        this.minimap = minimap;
    }

    public List<String> getGallery() {
        return gallery;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
    }

}
