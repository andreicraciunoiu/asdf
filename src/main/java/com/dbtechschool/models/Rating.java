package com.dbtechschool.models;

import javax.persistence.*;

@Entity
@Table(name = "RATINGS")
public class Rating {

	@Id
	@Column(name = "ID_RATING")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRating;

	@Column(name = "RATING")
	private int rating;

	@ManyToOne
	@JoinColumn(name = "ID_SECTION")
	private Section section;

	@ManyToOne
	@JoinColumn(name = "ID_ENROLLMENT")
	private Enrollment enrollment;

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	@Override
	public String toString() {
		return "Rating{" + "idRating=" + idRating + ", rating=" + rating + ", section=" + section + ", enrollment="
				+ enrollment + '}';
	}
}
