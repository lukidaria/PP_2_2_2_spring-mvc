package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

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

    @Override
    public List<Car> getCarsByCount(Integer count) {
        if (count != null) {
            List<Car> cars = carList.stream().limit(count).collect(Collectors.toList());
            System.out.println(cars);
            return cars;
        } else {
            return carList;
        }
    }
}
