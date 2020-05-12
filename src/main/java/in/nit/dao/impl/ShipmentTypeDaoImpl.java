package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveShipment(ShipmentType shipmentType) {
		// TODO Auto-generated method stub
		return (Integer)ht.save(shipmentType);
	}
	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		// TODO Auto-generated method stub
		return ht.loadAll(ShipmentType.class);
	}
	@Override
	public void deleteShipment(Integer id) {
		// TODO Auto-generated method stub
		 ht.delete(new ShipmentType(id));
	}
	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(ShipmentType.class, id);
	}
	@Override
	public void updateShipmentType(ShipmentType shipmentType) {
		// TODO Auto-generated method stub
		ht.update(shipmentType);
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Object[]> getShipmentModeCount() {
		// TODO Auto-generated method stub
		String hql="  select shipmentMode,count(shipmentMode)  "
				    + " from in.nit.model.ShipmentType "
						+ " group by shipmentMode ";
						
		return (List<Object[]>) ht.find(hql);
	}
	public List<Object[]> getShipIdAndShipCode() {
	String hql=" select shipmentId,shipCode from "+ShipmentType.class.getName()+ " where enableShipment= 'YES'";
	
		return (List<Object[]>) ht.find(hql);
	}

}
