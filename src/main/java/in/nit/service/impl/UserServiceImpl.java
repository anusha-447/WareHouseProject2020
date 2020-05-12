package in.nit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUserDao;
import in.nit.model.User;
import in.nit.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
    private IUserDao dao;
	@Override
	@Transactional
	public Integer saveUser(User user) {
		// TODO Auto-generated method stub
		return dao.saveUser(user);
	}

}
