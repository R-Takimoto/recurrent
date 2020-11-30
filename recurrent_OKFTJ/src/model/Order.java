package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
	//フィールド
//	private Date orderDate;
	private int orderId, orderbranch, quantity, ordertypeId, cancel;
	private String orderDate, typeCode;

	//コンストラクタ
	public Order() {};
	public Order(String typeCode, int orderId, int orderbranch, int quantity, int ordertypeId) {
		//日付処理
		LocalDateTime now = LocalDateTime.now();//現在時刻
		 DateTimeFormatter Format = DateTimeFormatter.ofPattern("yyyy-MM-dd");//フォーマット指定
		 String format = now.format(Format);//現在時刻をフォーマットに適用
		 this.orderDate = format;
		 this.typeCode = typeCode;
		 this.orderId = orderId;
		 this.orderbranch = orderbranch;
		 this.quantity = quantity;
		 this.ordertypeId = ordertypeId;
	}

	//ゲッター・セッター
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderbranch() {
		return orderbranch;
	}
	public void setOrderbranch(int orderbranch) {
		this.orderbranch = orderbranch;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getOrdertypeId() {
		return ordertypeId;
	}
	public void setOrdertypeId(int ordertypeId) {
		this.ordertypeId = ordertypeId;
	}
	public int getCancel() {
		return cancel;
	}
	public void setCancel(int cancel) {
		this.cancel = cancel;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}


}
