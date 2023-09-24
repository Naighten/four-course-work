package org.example.courseWork.controllers;

import org.example.courseWork.ApplicationService.CarService;
import org.example.courseWork.domaine.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

   @Autowired
   private CarService carService;

   @PostMapping("/add")
   @Secured("ROLE_ADMIN")
   public String addCar(@RequestBody Car car) {
      carService.addCar(car);
      return "Car added successfully";
   }

   @GetMapping("/all")
   @Secured({"ROLE_ADMIN", "ROLE_USER"})
   public List<Car> getAllCars() {
      return carService.getAllCars();
   }

   @DeleteMapping("/{id}")
   @Secured("ROLE_ADMIN")
   public String deleteCar(@PathVariable Long id) {
      if (carService.getCarById(id) == null) {
         return "Error";
      }
      carService.deleteCar(id);
      return "car deleted successfully";
   }

   @GetMapping("/search/{model}")
   @Secured({"ROLE_ADMIN", "ROLE_USER"})
   public List<Car> searchCarsOfModel(@PathVariable String model) {
      return carService.searchCarsOfModel(model);
   }

   @GetMapping("/{id}")
   @Secured({"ROLE_ADMIN", "ROLE_USER"})
   public Car getCarById(@PathVariable Long id) {
      if (carService.getCarById(id) == null) return null;
      return carService.getCarById(id);
   }
}
