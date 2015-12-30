package com.snack.social;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

import java.util.Collection;
import java.util.HashSet;

@Getter
public class FrontUserDetail implements SocialUserDetails {

	private static final long serialVersionUID = 5197941260523577515L;

	private SocialUser socialUser;

	public FrontUserDetail(SocialUser socialUser) {
		this.socialUser = socialUser;
	}

	public SocialUser getSocialUser() {
		return socialUser;
	}

	public void setSocialUser(SocialUser socialUser) {
		this.socialUser = socialUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new HashSet<>(1);
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}

	@Override
	public String getPassword() {
		return "";
	}

	@Override
	public String getUsername() {
		return socialUser.getEmail();
	}

	public String getFirstName() {
		return socialUser.getFirstName();
	}

	public String getLastName() {
		return socialUser.getLastName();
	}

	public String getName() {
		return getLastName() + getFirstName();
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

	@Override
	public String getUserId() {
		return Long.toString(socialUser.getId());
	}
}
