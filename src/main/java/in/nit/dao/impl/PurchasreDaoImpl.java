package in.nit.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IPurchaseDao;
import in.nit.model.PurchaseDetails;
import in.nit.model.PurchaseOrder;
@Repository
public class PurchasreDaoImpl implements IPurchaseDao {
    @Autowired
    private HibernateTemplate ht;
	@Override
	public Integer savePurchaseOrder(PurchaseOrder purchaseOrder) {
		
		return (Integer) ht.save(purchaseOrder);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrderTypes() {
		
		return ht.loadAll(PurchaseOrder.class);
	}

	@Override
	public void deletePurchaseOrder(Integer id) {
	 ht.delete(new PurchaseOrder(id));
		
	}

	@Override
	public PurchaseOrder getOnePurchaseOrderType(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(PurchaseOrder.class, id);
	}

	@Override
	public void updatePurchaseOrderType(PurchaseOrder purchaseOrderType) {
		// TODO Auto-generated method stub
		 ht.update(purchaseOrderType);
	}

	@Override
	public List<Object[]> getOrderIdAndCode(String mode) {
		String hql=" select orderId,orderCode from in.nit.model.order where orderMode=?0 ";

		List<Object[]> list=(List<Object[]>) ht.find(hql, mode);

		return list;
	}

	@Override
	public Integer savePurchaseDtl(PurchaseDetails puchaseDtl) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(puchaseDtl);
	}

	@Override
	public void updatePoStatus(Integer poId, String status) {
		ht.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) 
					throws HibernateException 
			{
				String hql=" update in.nit.model.PurchaseOrder "
						+" set status=:a "
						+" where purchaseId=:b ";
				int count=session.createQuery(hql)
						.setParameter("a", status)
						.setParameter("b", poId)
						.executeUpdate();
				return count;
			}
		});
		
	}

}
