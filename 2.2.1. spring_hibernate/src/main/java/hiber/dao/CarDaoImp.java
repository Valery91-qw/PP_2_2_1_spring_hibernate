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
		String hql = "FROM User user JOIN FETCH user.car car WHERE car.model = :model AND car.series = :series";
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql, User.class);
		query.setParameter("model", model);
		query.setParameter("series", series);
		return query.setMaxResults(1).getSingleResult();
	}
    
}
