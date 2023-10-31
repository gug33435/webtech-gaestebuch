package de.berlin.webtech.gaestebuch.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EintragController {

    @Autowired
    EintragService service;

    @PostMapping("/eintrag")
    public Eintrag createEintrag(@RequestBody Eintrag eintrag) {
        return service.save(eintrag);
    }

    @GetMapping("/eintrag/{id}")
    public Eintrag getEintrag(@PathVariable String id) {
        Long thingId = Long.parseLong(id);
        return service.get(thingId);
    }

    @GetMapping("/eintrag/all")
    public Iterable getAllEintrag() {
        return service.getallEintrag();
    }
}
