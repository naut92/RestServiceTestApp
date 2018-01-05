package com.github.naut92.restservicetestapp.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "typesanimals", schema = "public", catalog = "restservapp")
public class TypesanimalsEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeanimal;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "typeanimal", nullable = false, length = 255)
    public String getTypeanimal() {
        return typeanimal;
    }

    public void setTypeanimal(String typeanimal) {
        this.typeanimal = typeanimal;
    }
    
}
