package com.github.naut92.restservicetestapp.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sms", schema = "public", catalog = "restservapp")

public class ClientSMSEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @NonNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "fromwhom")
    @NonNull
    private String fromwhom;

    @Basic
    @Column(name = "totf")
    @NonNull
    private String totf;

    @Basic
    @Column(name = "textsms")
    @NonNull
    private String textsms;

}
