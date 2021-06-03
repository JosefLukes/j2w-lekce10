package cz.czechitas.java2webapps.lekce10.controller;


import cz.czechitas.java2webapps.lekce10.entity.Student;
import cz.czechitas.java2webapps.lekce10.repository.RodicRepository;
import cz.czechitas.java2webapps.lekce10.repository.StudentRepository;
import cz.czechitas.java2webapps.lekce10.repository.TridaRepository;
import cz.czechitas.java2webapps.lekce10.repository.UcitelRepository;
import cz.czechitas.java2webapps.lekce10.service.SkolaService;
import net.bytebuddy.implementation.bind.annotation.DefaultMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SkolaController {

    private final SkolaService skolaService;

    @Autowired
    public SkolaController(SkolaService skolaService) {
        this.skolaService = skolaService;
    }

    @GetMapping("/")
    public ModelAndView seznamTrid(@PageableDefault(sort = {"nazev"},size = 30) Pageable pageable) {

        return new ModelAndView("index")
                .addObject("tridy", skolaService.getSeznamTrid(pageable));
    }

    @GetMapping("/{nazevTridy}")
    public ModelAndView nahledTrida(@PathVariable String nazevTridy, @PageableDefault(sort = {"prijmeni","jmeno"}, size = 30) Pageable pageable) {

        return new ModelAndView("detail")
                .addObject("ucitel", skolaService.getUcitelTridni(nazevTridy).get())
                .addObject("studenti", skolaService.getSeznamStudentu(nazevTridy, pageable))
                .addObject("trida", nazevTridy);

    }

    @GetMapping("/{nazevTridy}/{idStudenta}")
    public ModelAndView nahledStudent(@PathVariable String nazevTridy, @PathVariable int idStudenta,@PageableDefault(sort = {"prijmeni","jmeno"}) Pageable pageable) {

        Student student = skolaService.getStudentDetail(idStudenta).get();

        return new ModelAndView("detailstudent")
                .addObject("student", student)
                .addObject("rodice", skolaService.getRodiceStudenta(student, pageable))
                .addObject("trida", nazevTridy);

    }





}

