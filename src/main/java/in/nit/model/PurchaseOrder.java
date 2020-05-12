package in.nit.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class PurchaseOrder {
	@Id
	@Column(name="pid")
	@GeneratedValue
	private Integer purchaseId;
	@Column(name="orCode")
	private String orderCode;
	@Column(name="refNum")
	private  String referenceNum;
	@Column(name="qCheck")
	private  String qualityCheck;
	@Column(name="dstate")
	private String status;
	@Column(name="description")
	private String description;
	@ManyToOne
	@JoinColumn(name="shipIdfk")
	private ShipmentType shipOb;
	@ManyToOne 
	@JoinColumn(name="vendorIdfk")
	private WhUserType vendor;
	@OneToMany(mappedBy = "po",fetch = FetchType.EAGER)
	private List<PurchaseDetails> childs;
	public PurchaseOrder() {
		super();
	}
	
	public List<PurchaseDetails> getChilds() {
		return childs;
	}

	public void setChilds(List<PurchaseDetails> childs) {
		this.childs = childs;
	}

	public PurchaseOrder(Integer purchaseId) {
		super();
		this.purchaseId = purchaseId;
	}
	public Integer getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getReferenceNum() {
		return referenceNum;
	}
	public void setReferenceNum(String referenceNum) {
		this.referenceNum = referenceNum;
	}
	public String getQualityCheck() {
		return qualityCheck;
	}
	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public ShipmentType getShipOb() {
		return shipOb;
	}
	public void setShipOb(ShipmentType shipOb) {
		this.shipOb = shipOb;
	}
	public WhUserType getVendor() {
		return vendor;
	}
	public void setVendor(WhUserType vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [purchaseId=" + purchaseId + ", orderCode=" + orderCode + ", referenceNum=" + referenceNum
				+ ", qualityCheck=" + qualityCheck + ", status=" + status + ", description=" + description + ", shipOb="
				+ shipOb + ", vendor=" + vendor + ", childs=" + childs + "]";
	}
	
	
	
	
	
	
}
