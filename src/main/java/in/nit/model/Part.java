package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="partTab")
public class Part {
	
	@Id
	@GeneratedValue
	@Column(name="partId")
	private Integer pid;
	@Column(name="pcode")
	private String pcode;
	@Column(name="pwidth")
	private String width;
	@Column(name="plength")
	private String length;
	@Column(name="pheight")
	private String height;
	@Column(name="cost")
	private String baseCost;
	@Column(name="currency")
	private String baseCurrency;
	@Column(name="pDescription")
	private String description;
	@ManyToOne
	@JoinColumn(name="uomIdFk")
	private Uom uomObj;
	@ManyToOne
    @JoinColumn(name="orderSaleIdFk")
    private Order omSaleOb; //HAS-A
	@ManyToOne
	@JoinColumn(name="orderPurchaseIdFk")
	private Order omPurcasheOb;
	public Part(Integer pid) {
		super();
		this.pid = pid;
	}
	public Part() {
		super();
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(String baseCost) {
		this.baseCost = baseCost;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	
	
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Uom getUomObj() {
		return uomObj;
	}
	public void setUomObj(Uom uomObj) {
		this.uomObj = uomObj;
	}
	public Order getOmSaleOb() {
		return omSaleOb;
	}
	public void setOmSaleOb(Order omSaleOb) {
		this.omSaleOb = omSaleOb;
	}
	public Order getOmPurcasheOb() {
		return omPurcasheOb;
	}
	public void setOmPurcasheOb(Order omPurcasheOb) {
		this.omPurcasheOb = omPurcasheOb;
	}
	@Override
	public String toString() {
		return "Part [pid=" + pid + ", pcode=" + pcode + ", width=" + width + ", length=" + length + ", height="
				+ height + ", baseCost=" + baseCost + ", baseCurrency=" + baseCurrency + ", description=" + description
				+ ", uomObj=" + uomObj + ", omSaleOb=" + omSaleOb + ", omPurcasheOb=" + omPurcasheOb + "]";
	}
	
	
	
	
	
	
	
	

}
