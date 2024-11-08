package com.hitesh.studentmanagement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
 
public class HiteshStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Enables auto-generated IDs
    private Integer id;
    private String name;
    private Integer roll;
    private String qualification;
    private String course;
    private Integer year;
    private Integer hallticketno;

    public HiteshStudent() {
        super();
    }

    public HiteshStudent(Integer id, String name, Integer roll, String qualification, String course, Integer year,
                         Integer hallticketno) {
        super();
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.qualification = qualification;
        this.course = course;
        this.year = year;
        this.hallticketno = hallticketno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getHallticketno() {
        return hallticketno;
    }

    public void setHallticketno(Integer hallticketno) {
        this.hallticketno = hallticketno;
    }

    @Override
    public String toString() {
        return "HiteshStudent [id=" + id + ", name=" + name + ", roll=" + roll + ", qualification=" + qualification
                + ", course=" + course + ", year=" + year + ", hallticketno=" + hallticketno + "]";
    }
}
