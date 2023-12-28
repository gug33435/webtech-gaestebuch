package de.berlin.webtech.gaestebuch.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
public class EintragService {

    @Autowired
    EintragRepository repo;

    public Eintrag save(Eintrag eintrag) {
        return repo.save(eintrag);
    }

    public Eintrag get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public Iterable getallEintrag () {
        Iterable test = repo.findAll();
        System.out.println(test.toString());
        return test;
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
