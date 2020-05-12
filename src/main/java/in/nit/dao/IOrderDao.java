package in.nit.dao;

import java.util.List;

import in.nit.model.Order;

public interface IOrderDao {
	
	
	public Integer saveOrder(Order order);
	
	public List<Order> getAllOrders();
	
	public void deleteOrder(Integer id);
	
	public Order getOneOrder(Integer id);
	
	public void updateOrder(Order order);
    
	public List<Object[]> getOrderIdAndCode(String mode);
}
