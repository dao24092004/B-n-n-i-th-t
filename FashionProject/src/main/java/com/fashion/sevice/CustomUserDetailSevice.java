package com.fashion.sevice;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fashion.model.CustomUserDetails;
import com.fashion.model.User;
import com.fashion.model.UserRole;

@Service
public class CustomUserDetailSevice implements UserDetailsService {

	@Autowired
	private UserSevice userSevice;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  userSevice.findByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("sai");
		}
		Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
		Set<UserRole> roles = user.getUserRoles();
		
		for (UserRole userRole : roles) {
			grantedAuthoritySet.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
			
		}
		return new CustomUserDetails(user,grantedAuthoritySet);
	}
	public UserSevice getUserSevice() {
		return userSevice;
	}
	public void setUserSevice(UserSevice userSevice) {
		this.userSevice = userSevice;
	}
	

}
