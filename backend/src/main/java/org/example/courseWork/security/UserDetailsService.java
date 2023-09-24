package org.example.courseWork.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
   @Autowired
   private UserRepository userRepository;

   public User findByUsername(String username) {
      return userRepository.findByUsername(username);
   }

   @Override
   @Transactional
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = findByUsername(username);
      if (user == null)
         throw new UsernameNotFoundException(String.format("User '%s' not found", username));

      return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAutorities(user.getRoles()));
   }

   private Collection<? extends GrantedAuthority> mapRolesToAutorities(Collection<Role> roles) {
      return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
   }
}


