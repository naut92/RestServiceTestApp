package com.github.naut92.restservicetestapp.entities;

import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "animals", schema = "public", catalog = "restservapp")
public class AnimalsEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "animalname")
    @NonNull
    private String animalname;

    @Basic
    @Column(name = "sex")
    @NonNull
    private String sex;

    @Basic
    @Column(name = "dateborn")
    private String dateborn;

}