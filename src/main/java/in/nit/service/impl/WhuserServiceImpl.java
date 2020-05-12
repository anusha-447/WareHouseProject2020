package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IWhUserDao;
import in.nit.model.WhUserType;
import in.nit.service.IWhUserService;
@Service
public class WhuserServiceImpl implements IWhUserService {
    @Autowired
    private IWhUserDao dao;
	@Override
	@Transactional
	public Integer saveWhUser(WhUserType user) {
		// TODO Auto-generated method stub
		return dao.saveWhUser(user);
	}
	@Override
	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhUsers() {
		// TODO Auto-generated method stub
		List<WhUserType> list= dao.getAllWhUsers();
		Collections.sort(list,(o1,o2)->o1.getUserId()-o2.getUserId());
		return list;
	}
	@Override
	@Transactional
	public void deleteWhUser(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteWhUser(id);
		
	}
	@Override
	@Transactional(readOnly=true)
	public WhUserType getOneWhUser(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOneWhUser(id);
	}
	@Override
	@Transactional
	public void updateWhuser(WhUserType user) {
		// TODO Auto-generated method stub
		dao.updateWhuser(user);
	}
	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getUserTypeAndCode(String user) {
		// TODO Auto-generated method stub
		return dao.getUserTypeAndCode(user);
	}
	
	

}
