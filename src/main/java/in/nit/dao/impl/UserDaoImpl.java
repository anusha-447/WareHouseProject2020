package in.nit.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IUserDao;
import in.nit.model.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveUser(User user) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(user);
	}

}
