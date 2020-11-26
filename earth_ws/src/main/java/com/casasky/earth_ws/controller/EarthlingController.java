package com.casasky.earth_ws.controller;


import java.util.List;

import com.casasky.earth_ws.entity.Earthling;
import com.casasky.earth_ws.service.EarthlingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("earthlings")
public class EarthlingController {

    private final EarthlingService earthlingService;

    private final Logger LOG = LogManager.getLogger(getClass());


    public EarthlingController(EarthlingService earthlingService) {
        this.earthlingService = earthlingService;
    }


    @PostMapping
    public ResponseEntity<?> create(Earthling earthling) {

        earthlingService.persist(earthling);
        return ResponseEntity.noContent().build();

    }


    @GetMapping
    public ResponseEntity<List<Earthling>> earthlings() {

        return ResponseEntity.ok(earthlingService.findAll(Earthling.class));

    }


    @GetMapping("sentry")
    public ResponseEntity<?> sentry() {

        LOG.error("Sentry event simulation", new RuntimeException("Outch! This is a bug simulation."));

        return ResponseEntity.noContent().build();

    }

}
