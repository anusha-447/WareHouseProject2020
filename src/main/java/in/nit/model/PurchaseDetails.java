package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="purchasedtl")
public class PurchaseDetails {
    @Id
    @GeneratedValue
    @Column(name="pdid")
	private Integer pid;
    @Column(name="pqty")
	private String qty;
    @Transient
	private Integer slno; 
    @ManyToOne
	@JoinColumn(name="dtl_part_fk")
    private  Part part;
    @ManyToOne
	@JoinColumn(name="dtl_po_fk")
	private PurchaseOrder po;
	public PurchaseDetails() {
		super();
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public Integer getSlno() {
		return slno;
	}
	public void setSlno(Integer slno) {
		this.slno = slno;
	}
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	public PurchaseOrder getPo() {
		return po;
	}
	public void setPo(PurchaseOrder po) {
		this.po = po;
	}
	@Override
	public String toString() {
		return "PurchaseDetails [pid=" + pid + ", qty=" + qty + ", slno=" + slno + ", part=" + part + ", po=" + po
				+ "]";
	}
	
	
}
