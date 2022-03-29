package com.fest.student.registrationservice.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fest.student.registrationservice.entity.AppUser;
import com.fest.student.registrationservice.entity.UserRole;

public class UserDetailsConfig implements UserDetails {

	private static final long serialVersionUID = 1L;
	private AppUser myUser;

	public UserDetailsConfig(AppUser user) {
		super();
		this.myUser = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<UserRole> roles = myUser.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (UserRole eachRole : roles) {
			authorities.add(new SimpleGrantedAuthority(eachRole.getRoleName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return myUser.getPassword();
	}

	@Override
	public String getUsername() {
		return myUser.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
