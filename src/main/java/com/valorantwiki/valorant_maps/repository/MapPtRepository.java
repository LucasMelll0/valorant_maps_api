package com.valorantwiki.valorant_maps.repository;

import com.valorantwiki.valorant_maps.model.MapPt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapPtRepository extends CrudRepository<MapPt, String> {

    List<MapPt> findAll();

    MapPt findByUuid(String string);

    int countByUuid(String uuid);

}
