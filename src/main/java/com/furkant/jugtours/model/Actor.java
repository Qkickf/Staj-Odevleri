package com.furkant.jugtours.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Actor")
public class Actor {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    private String surname;
    @ManyToMany
    private Set<Film> attendees;

}
