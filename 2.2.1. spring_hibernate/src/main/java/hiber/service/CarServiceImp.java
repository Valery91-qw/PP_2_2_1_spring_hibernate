package hiber.service;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hiber.dao.CarDao;
import hiber.model.Car;

@Service
public class CarServiceImp implements CarService{
    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }
    
}
