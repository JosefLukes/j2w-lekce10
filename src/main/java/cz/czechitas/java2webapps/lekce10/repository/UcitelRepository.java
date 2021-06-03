package cz.czechitas.java2webapps.lekce10.repository;

import cz.czechitas.java2webapps.lekce10.entity.Ucitel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 */
@Repository
public interface UcitelRepository extends JpaRepository<Ucitel, Integer> {
    Optional<Ucitel> findByTridaNazev(String nazevTrida);

}
