package cz.czechitas.java2webapps.lekce10.service;

import cz.czechitas.java2webapps.lekce10.entity.Rodic;
import cz.czechitas.java2webapps.lekce10.entity.Student;
import cz.czechitas.java2webapps.lekce10.entity.Trida;
import cz.czechitas.java2webapps.lekce10.entity.Ucitel;
import cz.czechitas.java2webapps.lekce10.repository.RodicRepository;
import cz.czechitas.java2webapps.lekce10.repository.StudentRepository;
import cz.czechitas.java2webapps.lekce10.repository.TridaRepository;
import cz.czechitas.java2webapps.lekce10.repository.UcitelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkolaService {

    private final RodicRepository rodicRepository;
    private final StudentRepository studentRepository;
    private final TridaRepository tridaRepository;
    private final UcitelRepository ucitelRepository;

    @Autowired
    public SkolaService(RodicRepository rodicRepository, StudentRepository studentRepository, TridaRepository tridaRepository, UcitelRepository ucitelRepository) {
        this.rodicRepository = rodicRepository;
        this.studentRepository = studentRepository;
        this.tridaRepository = tridaRepository;
        this.ucitelRepository = ucitelRepository;
    }

    public Page<Trida> getSeznamTrid(Pageable pageable) {
        return tridaRepository.findAll(pageable);
    }

    public Page<Student> getSeznamStudentu(String nazevTridy, Pageable pageable) {

        return studentRepository.findAllByTridaNazev(nazevTridy, pageable);
    }

    public Optional<Ucitel> getUcitelTridni(String nazevTridy) {

        return ucitelRepository.findByTridaNazev(nazevTridy);

    }

    public Optional<Student> getStudentDetail(int idStudenta) {
        return studentRepository.findById(idStudenta);

    }

    public Page<Rodic> getRodiceStudenta(Student student, Pageable pageable) {

        return rodicRepository.findRodicByDeti(student, pageable);
    }

}
