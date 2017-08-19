package com.dbtechschool.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SECTIONS")
public class Section {
	
	@Id
	@Column(name="ID_SECTION")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSection;
	
	private String name;
	private Date start;
	private Date end;
	private String room;
	private String trainer;
	private String description;
	private double ratingAvg;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "DAYS")
	private Day day;

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

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRatingAvg() {
		return ratingAvg;
	}

	public void setRatingAvg(double ratingAvg) {
		this.ratingAvg = ratingAvg;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Section{" +
				"idSection=" + idSection +
				", name='" + name + '\'' +
				", start=" + start +
				", end=" + end +
				", room='" + room + '\'' +
				", trainer='" + trainer + '\'' +
				", description='" + description + '\'' +
				", ratingAvg=" + ratingAvg +
				", day=" + day +
				'}';
	}
}
