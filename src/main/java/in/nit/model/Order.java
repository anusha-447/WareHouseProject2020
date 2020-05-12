package in.nit.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name="ordertab")
public class Order {
	@Id
	@GeneratedValue
	@Column(name="oId")
	private Integer orderId;
	@Column(name="oMode")
	private String orderMode;
	@Column(name="oMethod")
	private String orderMethod;
	@Column(name="oCode")
	private String orderCode;
    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="acpt" ,joinColumns=@JoinColumn(name="oid"))
    @OrderColumn(name="pos")
    @Column(name="oAccept")
	private List<String> orderAccept;
	@Column(name="oDescrpn")
	private String description;

	public Order(Integer orderId) {
		super();
		this.orderId = orderId;
	}

	public Order() {
		super();
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}



	public String getOrderMode() {
		return orderMode;
	}

	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}

	public String getOrderMethod() {
		return orderMethod;
	}

	public void setOrderMethod(String orderMethod) {
		this.orderMethod = orderMethod;
	}



	

	public List<String> getOrderAccept() {
		return orderAccept;
	}

	public void setOrderAccept(List<String> orderAccept) {
		this.orderAccept = orderAccept;
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

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderMode=" + orderMode + ", orderMethod=" + orderMethod
				+ ", orderCode=" + orderCode + ", orderAccept=" + orderAccept + ", description=" + description + "]";
	}

	


}
