package in.nit.service.impl;



import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;
@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private IShipmentTypeDao dao;
	@Override
	@Transactional
	public Integer saveShipment(ShipmentType shipmentType) {
		// TODO Auto-generated method stub
		return dao.saveShipment(shipmentType);
	}
	@Transactional(readOnly=true)
	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		// TODO Auto-generated method stub
		List<ShipmentType> list= dao.getAllShipmentTypes();
		Collections.sort(list,(o1,o2)->o1.getShipmentId()-o2.getShipmentId());
		return list;
		
	}
	@Override
	@Transactional
	public void deleteShipment(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteShipment(id);
	}
	@Override
	@Transactional(readOnly=true)
	public ShipmentType getOneShipmentType(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOneShipmentType(id);
	}
	@Transactional
	public void updateShipmentType(ShipmentType shipmentType) {
		dao.updateShipmentType(shipmentType);
	}
	@Override
	public List<Object[]> getShipmentModeCount() {
		// TODO Auto-generated method stub
		return dao.getShipmentModeCount();
	}
	@Override
	public List<Object[]> getShipIdAndShipCode() {
		// TODO Auto-generated method stub
		return dao.getShipIdAndShipCode();
	}

}
