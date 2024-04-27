package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Autowired
   private CarService carService;

   @Transactional
   @Override
   public void add(User user) {
      if(user.getCar() == null) {
         userDao.add(user);
         return;
      }
      Car car = user.getCar();
      userDao.add(user);
      carService.add(car);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }
}
