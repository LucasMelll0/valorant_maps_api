package com.valorantwiki.valorant_maps.repository;

import com.valorantwiki.valorant_maps.model.Map;
import com.valorantwiki.valorant_maps.model.MapEn;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapEnRepository extends CrudRepository<MapEn, String> {


    List<MapEn> findAll();

    MapEn findByUuid(String string);

    int countByUuid(String uuid);
}
