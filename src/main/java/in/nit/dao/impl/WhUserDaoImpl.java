package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IWhUserDao;
import in.nit.model.WhUserType;
@Repository
public class WhUserDaoImpl implements IWhUserDao {
    @Autowired
    private HibernateTemplate ht;
	@Override
	public Integer saveWhUser(WhUserType user) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(user);
	}
	@Override
	public List<WhUserType> getAllWhUsers() {
		// TODO Auto-generated method stub
		return ht.loadAll(WhUserType.class);
	}
	@Override
	public void deleteWhUser(Integer id) {
		// TODO Auto-generated method stub
		
		ht.delete(new WhUserType(id));
	}
	@Override
	public WhUserType getOneWhUser(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(WhUserType.class, id);
	}
	
	public void updateWhuser(WhUserType user) {
		
		ht.update(user);
	}

	public List<Object[]> getUserTypeAndCode(String user) {
		String hql=" select userId,userCode from " +WhUserType.class.getName()+ " where userType=?0 ";
		return (List<Object[]>) ht.find(hql,user);
	}

}
