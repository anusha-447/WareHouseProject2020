package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IOrderDao;
import in.nit.model.Order;
import in.nit.model.ShipmentType;
import in.nit.service.IOrderService;
@Service
public class OrderServiceImpl implements IOrderService {
      @Autowired
      private IOrderDao dao;

	@Override
	@Transactional
	public Integer saveOrder(Order order) {
		// TODO Auto-generated method stub
		return dao.saveOrder(order);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		List<Order> list= dao.getAllOrders();
		Collections.sort(list,(o1,o2)->o1.getOrderId()-o2.getOrderId());
		return list;
		
	}

	@Override
	@Transactional
	public void deleteOrder(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteOrder(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Order getOneOrder(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOneOrder(id);
	}

	@Override
	@Transactional
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		dao.updateOrder(order);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getOrderIdAndCode(String mode) {
		// TODO Auto-generated method stub
		return dao.getOrderIdAndCode(mode);
	}

	
}
