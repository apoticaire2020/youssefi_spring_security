package org.sid.spring_security.serc.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AppUser {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String userName;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<AppRole> appRoles = new ArrayList<>();
}
