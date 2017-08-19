package com.dbtechschool.models;

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
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DATE")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "ID_COURSE")
	private Course course;
}
