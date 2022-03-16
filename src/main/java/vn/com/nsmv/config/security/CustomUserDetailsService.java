package vn.com.nsmv.config.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.com.nsmv.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		vn.com.nsmv.entity.User user = userRepository.findByUserName(username);
		if (user != null) {
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			Set<GrantedAuthority> authorities = new HashSet<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getAuthority()));
			return new User(user.getUserName(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired,
					accountNonLocked, authorities);
		} else {
			throw new UsernameNotFoundException("Username Not Found");
		}
	}

}
