package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

public interface CarDao {
    void add(Car car);

    User getUserByModelAndSeries(String model, int series);
}
