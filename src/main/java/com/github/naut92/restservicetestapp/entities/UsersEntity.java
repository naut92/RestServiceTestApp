package com.github.naut92.restservicetestapp.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "public", catalog = "restservapp")
public class UsersEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @NonNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "firstname")
    private String firstname;

    @Basic
    @Column(name = "lastname")
    private String lastname;

    @Basic
    @Column(name = "email")
    @NonNull
    private String email;

    @Basic
    @Column(name = "dateborn")
    private Date dateborn;
}