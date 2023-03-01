package com.valorantwiki.valorant_maps.service;

import com.valorantwiki.valorant_maps.model.Map;
import com.valorantwiki.valorant_maps.model.MapEn;
import com.valorantwiki.valorant_maps.model.MapPt;
import com.valorantwiki.valorant_maps.model.Message;
import com.valorantwiki.valorant_maps.repository.MapEnRepository;
import com.valorantwiki.valorant_maps.repository.MapPtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MapService {

    final String PT_BR = "pt-BR";
    final String EN_US = "en-US";

    @Autowired
    private Message message;

    @Autowired
    private MapPtRepository ptRepository;

    @Autowired
    private MapEnRepository enRepository;


    public ResponseEntity<?> save(Map map, String language) {
        if (map.getName().isEmpty()) {
            message.setMessage("The name field is empty!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (map.getDescription().isEmpty()) {
            message.setMessage("The description field is empty!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            if (language.equals(PT_BR)) {
                MapPt mapPt = new MapPt();
                mapPt.setName(map.getName());
                mapPt.setDescription(map.getDescription());
                mapPt.setImage(map.getImage());
                mapPt.setMinimap(map.getMinimap());
                mapPt.setGallery(map.getGallery());
                return new ResponseEntity<>(ptRepository.save(mapPt), HttpStatus.CREATED);
            } else if (language.equals(EN_US)) {
                MapEn mapEn = new MapEn();
                mapEn.setName(map.getName());
                mapEn.setDescription(map.getDescription());
                mapEn.setImage(map.getImage());
                mapEn.setMinimap(map.getMinimap());
                mapEn.setGallery(map.getGallery());
                return new ResponseEntity<>(enRepository.save(mapEn), HttpStatus.CREATED);
            } else {
                message.setMessage("Invalid language!");
                return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
            }
        }
    }

    public ResponseEntity<?> findAll(String language) {
        if (language == null) {
            return new ResponseEntity<>(enRepository.findAll(), HttpStatus.OK);
        } else if (language.equals(PT_BR)) {
            return new ResponseEntity<>(ptRepository.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(enRepository.findAll(), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> findByUuid(String uuid, String language) {
        if (language == null) {
            if (enRepository.countByUuid(uuid) > 0) {
                return new ResponseEntity<>(enRepository.findByUuid(uuid), HttpStatus.OK);
            } else {
                message.setMessage("Not Found");
                return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
            }
        } else if (language.equals(PT_BR)) {
            if (ptRepository.countByUuid(uuid) > 0) {
                return new ResponseEntity<>(ptRepository.findByUuid(uuid), HttpStatus.OK);
            } else {
                message.setMessage("Not Found");
                return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
            }
        } else {
            if (enRepository.countByUuid(uuid) > 0) {
                return new ResponseEntity<>(enRepository.findByUuid(uuid), HttpStatus.OK);
            } else {
                message.setMessage("Not Found");
                return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
            }
        }
    }

}
