package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IPartDao;
import in.nit.model.Part;
@Repository
public class PartDaoImpl implements IPartDao{
    @Autowired
    private HibernateTemplate ht;
	@Override
	public Integer savePart(Part part) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(part);
	}

	@Override
	public List<Part> getAllParts() {
		// TODO Auto-generated method stub
		return ht.loadAll(Part.class);
	}

	@Override
	public void deletePart(Integer id) {
		// TODO Auto-generated method stub
		ht.delete(new Part(id));
	}

	@Override
	public Part getOnePart(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(Part.class, id);
	}

	@Override
	public void updatePartType(Part part) {
		// TODO Auto-generated method stub
		ht.update(part);
	}

	@Override
	public List<Object[]> getOrderIdAndCode() {
		String hql=" select pid,pcode from in.nit.model.Part ";
		@SuppressWarnings("unchecked")
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		
		return list;
	}

	
	
}