package hiber.dao;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hiber.model.Car;
import hiber.model.User;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public void add(Car car) {
		sessionFactory.getCurrentSession().save(car);
	}

	@Override
	public User getUserByModelAndSeries(String model,int series) {
		String hql = "FROM Car WHERE model= :model AND series= :series";
		TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery(hql, Car.class);
		query.setParameter("model", model);
		query.setParameter("series", series);
		Car car = query.getResultList().get(0);
		String hql2 = "FROM User WHERE car_id = :id";
		TypedQuery<User> userQuery = sessionFactory.getCurrentSession().createQuery(hql2, User.class);
		userQuery.setParameter("id", car.getId());
		return userQuery.getResultList().get(0);
	}
    
}
