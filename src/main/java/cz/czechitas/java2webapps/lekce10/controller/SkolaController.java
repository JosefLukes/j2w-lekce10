package cz.czechitas.java2webapps.lekce10.controller;


import cz.czechitas.java2webapps.lekce10.repository.RodicRepository;
import cz.czechitas.java2webapps.lekce10.repository.StudentRepository;
import cz.czechitas.java2webapps.lekce10.repository.TridaRepository;
import cz.czechitas.java2webapps.lekce10.repository.UcitelRepository;
import cz.czechitas.java2webapps.lekce10.service.SkolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class SkolaController {

 private final SkolaService skolaService;

     public SkolaController(SkolaService skolaService) {
        this.skolaService = skolaService;
    }
}
