package com.valorantwiki.valorant_maps.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "maps_br")
public class MapPt extends Map {

    @Id
    private String uuid;
}
