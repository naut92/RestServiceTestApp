package com.github.naut92.restservicetestapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "typesanimals", schema = "public", catalog = "restservapp")
public class TypesanimalsEntity {
    private int id;
    private String typeanimal;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypesanimalsEntity that = (TypesanimalsEntity) o;

        if (id != that.id) return false;
        if (typeanimal != null ? !typeanimal.equals(that.typeanimal) : that.typeanimal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typeanimal != null ? typeanimal.hashCode() : 0);
        return result;
    }
}
