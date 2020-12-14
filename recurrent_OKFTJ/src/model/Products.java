<<<<<<< HEAD
package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Products implements Serializable {
	//フィールド
	private ArrayList<Product> products;

	//コンストラクタ
	public Products() {
		this.products = new ArrayList<Product>();
	}
	public Products(ArrayList<Product> products) {
		this.products = products;
	}

	//ゲッター・セッター
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products.add(products) ;
	}

}
=======
package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Products implements Serializable {
	//フィールド
	private ArrayList<Product> products;

	//コンストラクタ
	public Products() {
		this.products = new ArrayList<Product>();
	}
	public Products(ArrayList<Product> products) {
		this.products = products;
	}

	//ゲッター・セッター
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

}
>>>>>>> 3ea5ce325bd1e006a0b2d3bca4822f9e48c36b00
