package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IPurchaseDao;
import in.nit.model.PurchaseDetails;
import in.nit.model.PurchaseOrder;
import in.nit.service.IPurchaseService;
@Service
public class PurchaseOrderServiceImpl implements IPurchaseService {
    
	@Autowired
	private IPurchaseDao dao;
 
	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder purchaseOrder) {
		// TODO Auto-generated method stub
		return dao.savePurchaseOrder(purchaseOrder);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PurchaseOrder> getAllPurchaseOrderTypes() {
		// TODO Auto-generated method stub
		List<PurchaseOrder> list= dao.getAllPurchaseOrderTypes();
		Collections.sort(list, (o1,o2)->o1.getPurchaseId()-o2.getPurchaseId());
		return list;
	}

	@Override
	@Transactional
	public void deletePurchaseOrder(Integer id) {
		// TODO Auto-generated method stub
		dao.deletePurchaseOrder(id);
	}

	
	@Transactional(readOnly=true)
	public PurchaseOrder getOnePurchaseOrderType(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOnePurchaseOrderType(id);
	}

	
	@Transactional
	public void updatePurchaseOrderType(PurchaseOrder purchaseOrderType) {
		// TODO Auto-generated method stub
		dao.updatePurchaseOrderType(purchaseOrderType);
	}

	@Transactional(readOnly = true)
	public List<Object[]> getOrderIdAndCode(String mode) {
		
		return dao.getOrderIdAndCode(mode);
	}

	@Transactional
	public Integer savePurchaseDtl(PurchaseDetails puchaseDtl) {
		// TODO Auto-generated method stub
		return dao.savePurchaseDtl(puchaseDtl);
	}

	@Override
	public void updatePoStatus(Integer poId, String status) {
		dao.updatePoStatus(poId, status);
		
	}

}
