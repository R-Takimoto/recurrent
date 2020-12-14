package model;

import java.io.Serializable;

public class ManagerProduct implements Serializable {
	//フィールド
	private String item,typeCode, productName, variety,image;
	private int price, calorie;


	//コンストラクタ
	public ManagerProduct() {}
	public ManagerProduct(String item,String typeCode,String productName,int price,int calorie,String variety,String image) {
		this.item=item;
		this.typeCode=typeCode;
		this.productName=productName;
		this.price=price;
		this.calorie=calorie;
		this.variety=variety;
		this.image=image;
	}

	//ゲッターセッター
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
