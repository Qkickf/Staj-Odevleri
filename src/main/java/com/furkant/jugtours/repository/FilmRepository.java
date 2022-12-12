package com.furkant.jugtours.repository;

import com.furkant.jugtours.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Actor,Long> {
    Actor findByName(String name);

}
