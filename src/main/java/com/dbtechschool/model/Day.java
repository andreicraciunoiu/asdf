package com.dbtechschool.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "days")
public class Day {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_DAY")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DATE")
	private String date;

	@ManyToOne
	@JoinColumn(name = "ID_COURSE", referencedColumnName = "ID_COURSE")
	private Course course;
	
	public Long getId() {
		return id;
	}

	public Day setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Day setName(String name) {
		this.name = name;
		return this;
	}

	public String getDate() {
		return date;
	}

	public Day setDate(String date) {
		this.date = date;
		return this;
	}

	public Course getCourse() {
		return course;
	}

	public Day setCourse(Course course) {
		this.course = course;
		return this;
	}

	@Override
	public String toString() {
		return "Day [id=" + id + ", name=" + name + ", date=" + date + ", course=" + course + "]";
	}
}
