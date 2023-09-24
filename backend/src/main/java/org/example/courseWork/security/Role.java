package org.example.courseWork.security;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "roles")
public class Role {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   @ManyToMany(mappedBy = "roles")
   private Collection<User> users;

   public Role(String roleName) {
      this.name = roleName;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
