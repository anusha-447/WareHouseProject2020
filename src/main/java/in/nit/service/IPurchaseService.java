package in.nit.service;

import java.util.List;

import in.nit.model.PurchaseDetails;
import in.nit.model.PurchaseOrder;

public interface IPurchaseService {
	

    public Integer savePurchaseOrder(PurchaseOrder purchaseOrder);
    
	public List<PurchaseOrder> getAllPurchaseOrderTypes();
	
	public void deletePurchaseOrder(Integer id);
	
	public PurchaseOrder  getOnePurchaseOrderType(Integer id);
	
	public void updatePurchaseOrderType(PurchaseOrder purchaseOrderType);
	
	public List<Object[]> getOrderIdAndCode(String mode);
	
	public Integer savePurchaseDtl(PurchaseDetails puchaseDtl);
    
	public void updatePoStatus(Integer poId,String status);
}
