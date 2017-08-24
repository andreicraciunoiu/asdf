package com.dbtechschool.model;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", section=" + section +
                '}';
    }
}
