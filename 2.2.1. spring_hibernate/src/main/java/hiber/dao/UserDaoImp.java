package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public List<User> userFromCar(String model, int series) {
      Query querys = sessionFactory.getCurrentSession().createQuery(
              "SELECT u FROM User u WHERE u.userCar.id IN " +
                      "(SELECT c.id FROM Car c WHERE c.model = :model AND c.series = :series)"
      );
      querys.setParameter("model", model);
      querys.setParameter("series", series);
      return querys.getResultList();
   }
}
