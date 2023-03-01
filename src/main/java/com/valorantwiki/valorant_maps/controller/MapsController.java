package com.valorantwiki.valorant_maps.controller;


import com.valorantwiki.valorant_maps.model.Map;
import com.valorantwiki.valorant_maps.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MapsController {

    @Autowired
    private MapService service;

    @GetMapping("/")
    public String helloWorld() {
        return "Hello, World!";
    }

    @PostMapping("/api/maps")
    @ResponseBody
    public ResponseEntity<?> createMap(@RequestBody Map map, @RequestParam String language) {
        return service.save(map, language);
    }

    @GetMapping("/api/maps")
    @ResponseBody
    public ResponseEntity<?> findAllMaps(@RequestParam(required = false) String language) {
        return service.findAll(language);
    }

    @GetMapping("api/maps/{uuid}")
    public ResponseEntity<?> findMapByUuid(@PathVariable String uuid, @RequestParam(required = false) String language) {
        return service.findByUuid(uuid, language);
    }
}
