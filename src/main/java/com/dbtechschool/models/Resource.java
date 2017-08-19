package com.dbtechschool.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resources")
public class Resource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_RESOURCE")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "LINK")
	private String link;

	@ManyToOne
	@JoinColumn(name = "ID_SECTION")
	private Section section;

}
