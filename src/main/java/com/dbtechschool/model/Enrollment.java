package com.dbtechschool.model;

import javax.persistence.*;

@Entity
@Table(name = "ENROLLMENTS")
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ENROLLMENT")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_USER")
	private User user;

	@ManyToOne
	@JoinColumn(name = "ID_COURSE")
	private Course course;

	public Long getIdEnrollment() {
		return id;
	}

	public Enrollment setIdEnrollment(Long id_enrollment) {
		this.id = id_enrollment;
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
}
