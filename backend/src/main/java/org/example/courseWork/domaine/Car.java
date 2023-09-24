package org.example.courseWork.domaine;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name = "brand")
   private String brand;
   @Column(name = "model")
   private String model;
   @Column(name = "gearbox") // A M
   private String gearbox;
   @Column(name = "driveUnit") // front back full
   private String driveUnit;
   @Column(name = "body")
   private String body;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getBrand() {
      return brand;
   }

   public void setBrand(String brand) {
      this.brand = brand;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public String getGearbox() {
      return gearbox;
   }

   public void setGearbox(String gearbox) {
      this.gearbox = gearbox;
   }

   public String getDriveUnit() {
      return driveUnit;
   }

   public void setDriveUnit(String driveUnit) {
      this.driveUnit = driveUnit;
   }

   public String getBody() {
      return body;
   }

   public void setBody(String body) {
      this.body = body;
   }

   @Override
   public String toString() {
      return "Car{" +
              "id=" + id +
              ", brand='" + brand + '\'' +
              ", model='" + model + '\'' +
              ", gearbox='" + gearbox + '\'' +
              ", driveUnit='" + driveUnit + '\'' +
              ", body='" + body + '\'' +
              '}';
   }
}

