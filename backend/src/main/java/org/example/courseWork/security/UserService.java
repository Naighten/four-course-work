package org.example.courseWork.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserService {
   @Autowired
   private UserRepository userRepository;
   @Autowired
   private RoleRepository roleRepository;
   @Autowired
   private PasswordEncoder passwordEncoder;

   public User findByUsername(String username) {
      return userRepository.findByUsername(username);
   }

   public User registerUser(UserDto userDto) {
      User user = new User();
      user.setUsername(userDto.getUsername());
      user.setPassword(passwordEncoder.encode(userDto.getPassword()));
      Collection<Role> roles = new ArrayList<>();
      for (String roleName : userDto.getRoles().split(",")) {
         Role role = roleRepository.findByName(roleName);

         if (role == null) {
            roleRepository.save(new Role(roleName));
            role = roleRepository.findByName(roleName);
         }
         roles.add(role);
      }
      user.setRoles(roles);
      userRepository.save(user);
      return user;
   }
}
