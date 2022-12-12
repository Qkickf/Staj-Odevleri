package com.furkant.jugtours.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Actor,Long> {
    Actor findByName(String name);

}
