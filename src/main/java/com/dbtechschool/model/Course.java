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
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "START")
	private String start;

	@Column(name = "END")
	private String end;

	@Column(name = "TAGS")
	private String tags;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "DIFFICULTY")
	private char difficulty;

	public Course() {
	}
	
	public Course(Long id, String name, String start, String end, String tags, String description, char difficulty) {
		super();
		this.id = id;
		this.name = name;
		this.start = start;
		this.end = end;
		this.tags = tags;
		this.description = description;
		this.difficulty = difficulty;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
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
