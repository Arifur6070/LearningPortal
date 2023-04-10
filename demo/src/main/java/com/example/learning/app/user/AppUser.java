package com.example.learning.app.user;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private AppUserRole role;
	private boolean locked;
	private boolean enabled;
	

	public AppUser(String firstName, String lastName, String userName, String email, String password, AppUserRole role,
			boolean locked, boolean enabled) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.locked = locked;
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
		return Collections.singletonList(authority);
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return enabled;
	}

}
