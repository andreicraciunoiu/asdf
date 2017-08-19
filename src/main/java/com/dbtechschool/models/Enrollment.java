package com.dbtechschool.models;

/**
 * Created by nicoleta on 8/19/2017.
 */

import javax.persistence.*;

@Entity
@Table(name = "ENROLLMENTS")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ENROLLMENT")
    private Long idEnrollment;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "USERS")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "COURSES")
    private Course course;

    public Long getIdEnrollment() {
        return idEnrollment;
    }

    public Enrollment setIdEnrollment(Long id_enrollment) {
        this.idEnrollment = id_enrollment;
        return this;
    }

    public User getIdUser() {
        return user;
    }

    public Enrollment setIdUser(User user) {
        this.user = user;
        return this;
    }

    public Course getIdCourse() {
        return course;
    }

    public Enrollment setIdCourse(Course course) {
        this.course = course;
        return this;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "idEnrollment=" + idEnrollment +
                ", idUser=" + user.toString() +
                ", idCourse=" + course.toString() +
                '}';
    }
}
