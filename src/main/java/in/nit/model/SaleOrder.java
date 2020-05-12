package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="saleorder")

public class SaleOrder {
	@Id
	@GeneratedValue
	@Column(name="soid")
	private Integer saleId;
	@Column(name="ocode")
	private String sorderCode;
	@Column(name="referNumber")
	private String RefNumber;
	@Column(name="smode")
	private String stockMode;
	@Column(name="source")
	private String stockSource;
	@Column(name="dstatus")
	private String  defaultStatus;
	@Column(name="sdesc")
	private String sdescription;
	public SaleOrder() {
		super();
	}
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public String getSorderCode() {
		return sorderCode;
	}
	public void setSorderCode(String sorderCode) {
		this.sorderCode = sorderCode;
	}
	public String getRefNumber() {
		return RefNumber;
	}
	public void setRefNumber(String refNumber) {
		RefNumber = refNumber;
	}
	public String getStockMode() {
		return stockMode;
	}
	public void setStockMode(String stockMode) {
		this.stockMode = stockMode;
	}
	public String getStockSource() {
		return stockSource;
	}
	public void setStockSource(String stockSource) {
		this.stockSource = stockSource;
	}
	public String getDefaultStatus() {
		return defaultStatus;
	}
	public void setDefaultStatus(String defaultStatus) {
		this.defaultStatus = defaultStatus;
	}
	public String getSdescription() {
		return sdescription;
	}
	public void setSdescription(String sdescription) {
		this.sdescription = sdescription;
	}
	@Override
	public String toString() {
		return "SaleOrder [saleId=" + saleId + ", sorderCode=" + sorderCode + ", RefNumber=" + RefNumber
				+ ", stockMode=" + stockMode + ", stockSource=" + stockSource + ", defaultStatus=" + defaultStatus
				+ ", sdescription=" + sdescription + "]";
	}
	

}
