package model;

public class Terminal {
	//フィールド
	int orderID;
	String storeSeatID;

	//コンストラクタ
	public Terminal() {};
	public Terminal(String storeSeatID) {
		this.storeSeatID = storeSeatID;
	}

	//ゲッター・セッター
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getStoreSeatID() {
		return storeSeatID;
	}
	public void setStoreSeatID(String storeSeatID) {
		this.storeSeatID = storeSeatID;
	};


}
