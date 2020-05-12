package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipment")
public class ShipmentType {

	@Id
	@GeneratedValue
	@Column(name="sid")
	private Integer shipmentId;
	@Column(name="smode")
	private String shipmentMode;
	@Column(name="scode")
	private String shipCode;
	@Column(name="sgrade")
	private String shipmentGrade;
	@Column(name="eshipment")
	private String enableShipment;
	
	@Column(name="sdes")
	private String shipDescription;
	
	public ShipmentType(Integer shipmentId) {
		super();
		this.shipmentId = shipmentId;
	}
	public ShipmentType() {
		super();
	}
	public Integer getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(Integer shipmentId) {
		this.shipmentId = shipmentId;
	}
	public String getShipmentMode() {
		return shipmentMode;
	}
	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}
	public String getShipCode() {
		return shipCode;
	}
	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}
	public String getShipmentGrade() {
		return shipmentGrade;
	}
	public void setShipmentGrade(String shipmentGrade) {
		this.shipmentGrade = shipmentGrade;
	}
	public String getEnableShipment() {
		return enableShipment;
	}
	public void setEnableShipment(String enableShipment) {
		this.enableShipment = enableShipment;
	}
	public String getShipDescription() {
		return shipDescription;
	}
	public void setShipDescription(String shipDescription) {
		this.shipDescription = shipDescription;
	}
	@Override
	public String toString() {
		return "ShipmentType [shipmentId=" + shipmentId + ", shipmentMode=" + shipmentMode + ", shipCode=" + shipCode
				+ ", shipmentGrade=" + shipmentGrade + ", enableShipment=" + enableShipment + ", shipDescription="
				+ shipDescription + ", getShipmentId()=" + getShipmentId() + ", getShipmentMode()=" + getShipmentMode()
				+ ", getShipCode()=" + getShipCode() + ", getShipmentGrade()=" + getShipmentGrade()
				+ ", getEnableShipment()=" + getEnableShipment() + ", getShipDescription()=" + getShipDescription()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}
