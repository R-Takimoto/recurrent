package model;

public class Product {
	//フィールド
	private String typeCode, item, variety, product, orderType;
	private int price, calorie;

	//コンストラクタ
	public Product() {};
	public Product(String typeCode, String item, String variety, String product, int price, int calorie, String orderType) {
		this.typeCode = typeCode;
		this.item = item;
		this.variety = variety;
		this.product = product;
		this.price = price;
		this.calorie = calorie;
		this.orderType = orderType;
	}

	//ゲッター・セッター
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCalorie() {
		return calorie;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

}
