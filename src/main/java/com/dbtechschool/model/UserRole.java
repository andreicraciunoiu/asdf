package com.dbtechschool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="user_roles")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_role_id")
	private Long id;
	
//	@Column(name="id_user")
//	private Long userid;
	
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "ID_USER")
	private User user;
	
	@Column(name="role")
	private String role;

	public Long getUserroleid() {
		return id;
	}

	public void setUserroleid(Long userroleid) {
		this.id = userroleid;
	}

//	public Long getUserid() {
//		return userid;
//	}
//
//	public void setUserid(Long userid) {
//		this.userid = userid;
//	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
