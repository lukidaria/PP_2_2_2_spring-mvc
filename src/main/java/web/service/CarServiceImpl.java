package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl {

    private List<Car> carList;
    private static int CARS_COUNT;

    {
        carList = new ArrayList<>();

        carList.add(new Car(++CARS_COUNT, "BMV", "X2"));
        carList.add(new Car(++CARS_COUNT, "Mersedes", "C5"));
        carList.add(new Car(++CARS_COUNT, "Ford", "Focus"));
        carList.add(new Car(++CARS_COUNT, "Audi", "A5"));
        carList.add(new Car(++CARS_COUNT, "Opel", "Kadett"));

    }

    public List<Car> getCars(){
        return carList;

    }

    public List<Car> getCarsByCount(int count) {
        List<Car> cars = carList.stream().limit(count).collect(Collectors.toList());
        System.out.println(cars);
        return cars;
    }






}
