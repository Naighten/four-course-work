package org.example.courseWork.ApplicationService;

import org.example.courseWork.domaine.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

   @Autowired
   private CarRepository carRepository;

   public Car addCar(Car car) {
      return carRepository.save(car);
   }

   public void deleteCar(Long id) {
      carRepository.deleteById(id);
   }

   public List<Car> searchCarsOfModel(String query) {
      return carRepository.findByModelContainingIgnoreCase(query);
   }

   public Car getCarById(Long id) {
      return carRepository.findById(id).orElse(null);
   }

   public List<Car> getAllCars() {
      return carRepository.findAll();
   }
}
