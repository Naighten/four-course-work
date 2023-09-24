package org.example.courseWork.ApplicationService;

import org.example.courseWork.domaine.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
   List<Car> findByModelContainingIgnoreCase(String model);
}
