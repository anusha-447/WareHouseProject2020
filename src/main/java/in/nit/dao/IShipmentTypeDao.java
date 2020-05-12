package in.nit.dao;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeDao {
	
	public Integer saveShipment(ShipmentType shipmentType);
    
	public List<ShipmentType> getAllShipmentTypes();
	
	public void deleteShipment(Integer id);
	
	public ShipmentType getOneShipmentType(Integer id);
	
	public void updateShipmentType(ShipmentType shipmentType);
	
	public List<Object[]> getShipmentModeCount();
	    
	public List<Object[]> getShipIdAndShipCode();
}

