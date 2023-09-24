package org.example.courseWork.security;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name = "username", nullable = false, unique = true)
   private String username;
   @Column(name = "password", nullable = false)
   private String password;
   @ManyToMany
   @JoinTable(name = "users_roles",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "role_id"))
   private Collection<Role> roles;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public Collection<Role> getRoles() {
      return roles;
   }

   public void setRoles(Collection<Role> roles) {
      this.roles = roles;
   }
}
