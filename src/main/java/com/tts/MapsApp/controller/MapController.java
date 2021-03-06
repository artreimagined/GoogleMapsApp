package com.tts.MapsApp.controller;

import com.tts.MapsApp.model.Location;
import com.tts.MapsApp.service.MapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MapController {

    @Autowired
    MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping("/")
    public String getDefaultMap(Model model) {
//        Location location = new Location();
//        location.setCity("Atlanta");
//        location.setState("Georgia");
//        mapService.addCoordinates(location);
//        System.out.println(location);
//        log.info("This is my location: {}", location);
        model.addAttribute(new Location());
        return "index.html";
    }

    @PostMapping("/home")
    public String getMapForLocation(Location location, Model model) {
        mapService.addCoordinates(location);
        model.addAttribute(location);
        return "index.html";
    }
}
