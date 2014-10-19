package com.onetesthub.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;

import com.onetesthub.dao.UserDao;
import com.onetesthub.model.UserRole;

public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		com.onetesthub.model.User myuser = userDao.findUserByUsername(username);

		List<GrantedAuthority> authorities = buildUserAuthority(myuser
				.getUserRole());

		return buildUserForAuthentication(myuser, authorities);

	}

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.onetesthub.model.User myuser,
			List<GrantedAuthority> authorities) {

		return new User(myuser.getUsername(), myuser.getPassword(),
				myuser.isEnabled(), true, true, true, authorities);
	}

	List<GrantedAuthority> buildUserAuthority(List<UserRole> userRoles) {

		Set<GrantedAuthority> authoroties = new HashSet<GrantedAuthority>();

		for (UserRole userrole : userRoles) {

			authoroties.add(new SimpleGrantedAuthority(userrole.getRole()));

		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				authoroties);

		return Result;

	}

}
