package ruandao.bookstore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Order {
	private String code;
	private String account;
	private String consignee;
	private String address;
	private String email;
	private String phone;
	private boolean isDelivered;
	private Date orderDate;
	private BigDecimal totalPrice;
	
	private ArrayList<OrderDetail> details;
	public ArrayList<OrderDetail> getDetails(){
		if( this.details==null ){
			this.details = new ArrayList<OrderDetail>();
		}
		return this.details;
	}
	
	public String getCode() {
		return code;
	}
	public void setId(String code) {
		this.code = code;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isDelivered() {
		return isDelivered;
	}
	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
