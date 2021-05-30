package com.javacourse.project.hibernateAndJpa.Entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="city")
public class City {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="countrycode")
    private String countryCode;

    @Column(name="district")
    private String district;

    @Column(name="population")
    private int population;
}
