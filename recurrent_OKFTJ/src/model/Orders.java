package model;

import java.util.ArrayList;

public class Orders {
	//フィールド
	ArrayList<Order> orders = new ArrayList<Order>();

	//コンストラクタ
	public Orders() {
		this.orders = new ArrayList<Order>();
	}

	//ゲッター
	public ArrayList<Order> getOrders() {
		return orders;
	};




}
