package com.example.learning.app.registration;

import com.example.learning.app.user.AppUserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
@NoArgsConstructor
public class RegistrationRequest {
    @NotNull(message = "FirstName cannot be null")
	@Size(min=2, message = "First name should have atleast 2 characters")
	private String firstName;
	
    @NotNull(message = "LastName cannot be null")
	@Size(min=2, message = "Last name should have atleast 2 characters")
	private String lastName;
	@Email(message="Please enter a valid email address")
	private String email;
	@Size(min = 8 ,message="Password should be minimum 8 characters")
	private String password;
	private AppUserRole role=AppUserRole.STUDENT;
	

}
