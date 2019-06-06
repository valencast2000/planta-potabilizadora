package ar.com.jsl.plantapotabilizadora.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.jsl.plantapotabilizadora.model.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Long> {

}
