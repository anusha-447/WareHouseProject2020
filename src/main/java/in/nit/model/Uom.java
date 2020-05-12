package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uomtab")
public class Uom {
	
	@Id
	@GeneratedValue
	@Column(name="uoid")
	private Integer uomId;
	@Column(name="uotype")
	private String uomType;
	@Column(name="umodel")
	private String uomModel;
	@Column(name="uodes")
	private String description;
	
	
	public Uom() {
		super();
	}
	public Uom(Integer uomId) {
		super();
		this.uomId = uomId;
	}
	public String getUomModel() {
		return uomModel;
	}
	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}
	
	public Integer getUomId() {
		return uomId;
	}
	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}
	public String getUomType() {
		return uomType;
	}
	public void setUomType(String uomType) {
		this.uomType = uomType;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Uom [uomId=" + uomId + ", uomType=" + uomType + ", description=" + description + ", uomModel="
				+ uomModel + "]";
	}
	
	
	

}
