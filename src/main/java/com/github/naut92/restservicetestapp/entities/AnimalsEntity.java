package com.github.naut92.restservicetestapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "animals", schema = "public", catalog = "restservapp")
public class AnimalsEntity {
    private int id;
    private String animalname;
    private String sex;
    private String dateborn;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "animalname", nullable = false, length = -1)
    public String getAnimalname() {
        return animalname;
    }

    public void setAnimalname(String animalname) {
        this.animalname = animalname;
    }

    @Basic
    @Column(name = "sex", nullable = false, length = -1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "dateborn", nullable = true, length = 255)
    public String getDateborn() {
        return dateborn;
    }

    public void setDateborn(String dateborn) {
        this.dateborn = dateborn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimalsEntity that = (AnimalsEntity) o;

        if (id != that.id) return false;
        if (animalname != null ? !animalname.equals(that.animalname) : that.animalname != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (dateborn != null ? !dateborn.equals(that.dateborn) : that.dateborn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (animalname != null ? animalname.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (dateborn != null ? dateborn.hashCode() : 0);
        return result;
    }
}
