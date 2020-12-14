package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ManagerProducts implements Serializable {
	//フィールド
	private ArrayList<ManagerProduct> managerProducts;

	//コンストラクタ
	public ManagerProducts() {
		this.managerProducts = new ArrayList<ManagerProduct>();
	}
	public ManagerProducts(ArrayList<ManagerProduct> managerProducts) {
		this.managerProducts = managerProducts;
	}

	//ゲッターセッター
	public ArrayList<ManagerProduct> getManagerProducts() {
		return managerProducts;
	}
	public void setManagerProducts(ArrayList<ManagerProduct> managerProducts) {
		this.managerProducts = managerProducts;
	}



}
