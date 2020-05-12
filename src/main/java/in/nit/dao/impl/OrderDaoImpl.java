package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IOrderDao;
import in.nit.model.Order;
@Repository
public class OrderDaoImpl implements IOrderDao {
    @Autowired
    private HibernateTemplate ht;
	@Override
	
	public Integer saveOrder(Order order) {
		// TODO Auto-generated method stub
		return (Integer)ht.save(order);
	}
	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return ht.loadAll(Order.class);
	}
	@Override
	public void deleteOrder(Integer id) {
		// TODO Auto-generated method stub
		ht.delete(new Order(id));
	}
	@Override
	public Order getOneOrder(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(Order.class, id);
	}
	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		ht.update(order);
	}
	@Override
	public List<Object[]> getOrderIdAndCode(String mode) {
		String hql=" select orderId,orderCode from in.nit.model.Order where orderMode=?0 ";

		List<Object[]> list=(List<Object[]>) ht.find(hql, mode);

		return list;
		
	}

}
