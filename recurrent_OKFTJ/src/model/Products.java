package model;

import java.util.ArrayList;

public class Products {
	//フィールド
	private ArrayList<Product> products;

	//コンストラクタ
	public Products() {}

	//ゲッター・セッター
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	};
}
