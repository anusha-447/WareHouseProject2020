package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IUomDao;
import in.nit.model.Uom;
@Repository
public class UomDaoImpl implements IUomDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveUom(Uom uom) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(uom);
		
	}
	@Override
	public List<Uom> getAllUoms() {
		// TODO Auto-generated method stub
		return ht.loadAll(Uom.class);
	}
	@Override
	public void deleteUom(Integer id) {
		// TODO Auto-generated method stub
		ht.delete(new Uom(id));
	}
	@Override
	public Uom getOneUom(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(Uom.class, id);
	}
	@Override
	public void updateUom(Uom uom) {
		// TODO Auto-generated method stub
		ht.update(uom);
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getUomIdAndModel() {
		// TODO Auto-generated method stub
		String hql =" select uomId,uomModel from in.nit.model.Uom ";
		List<Object[]>  list=(List<Object[]>) ht.find(hql);
		return list;
	}

}
