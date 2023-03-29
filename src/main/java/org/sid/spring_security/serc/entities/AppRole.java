package org.sid.spring_security.serc.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AppRole {


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String roleName;
}
