package com.tech.ass.ass.domain;
import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "user_ass")
@Data
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "user_ass_id", nullable = false)
	private Long userId;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "password")
	private String password;

}
