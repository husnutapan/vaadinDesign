package com.husnu.vaadinDesignTutorial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarService {

	private List<Car> cars = new ArrayList<>();

	public CarService() {
		Car car = new Car(1, "Reault Fluence", "Renault", 45000, CarTypes.Diesel);
		Car car2 = new Car(2, "Megane", "Renault", 45000, CarTypes.Crossover);
		Car car3 = new Car(3, "Reault Fluence 2", "Renault", 45000, CarTypes.Hatchback);
		Car car4 = new Car(4, "Reault Fluence 3", "Renault", 45000, CarTypes.Sedan);
		Car car5 = new Car(5, "Reault Fluence 4", "Renault", 45000, CarTypes.SportsCar);
		Car car6 = new Car(6, "Reault Fluence 5", "Renault", 45000, CarTypes.Wagon);
		cars.add(car);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		cars.add(car5);
		cars.add(car6);
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<Car> getFilterToDataGrid(String filterKeyword) {
		for (Iterator<Car> it = cars.iterator(); it.hasNext();) {
			if (!it.next().getName().contains(filterKeyword)) {
				it.remove();
			}
		}
		return cars;
	}
}
