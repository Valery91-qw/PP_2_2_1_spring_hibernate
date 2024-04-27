package hiber.service;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;

@Service
public class CarServiceImp implements CarService{
    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Transactional
    @Override
    public User getUserByModelAndSeries(String model, int series) {
        return carDao.getUserByModelAndSeries(model ,series);
    }
    
}
