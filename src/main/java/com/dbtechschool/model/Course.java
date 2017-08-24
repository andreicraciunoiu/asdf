package com.dbtechschool.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_COURSE")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "START")
	private Date start;

	@Column(name = "END")
	private Date end;

	@Column(name = "TAGS")
	private String tags;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "DIFFICULTY")
	private char difficulty;

	public Course() {
	}
	
	public Course(int id, String name, Date start, Date end, String tags, String description, char difficulty) {
		super();
		this.id = id;
		this.name = name;
		this.start = start;
		this.end = end;
		this.tags = tags;
		this.description = description;
		this.difficulty = difficulty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(char difficulty) {
		this.difficulty = difficulty;
	}
}
