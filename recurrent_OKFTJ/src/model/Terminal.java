package model;

public class Terminal {
	//フィールド
	int orderId;
	String store_seatId;

	//コンストラクタ
	public Terminal() {};
	public Terminal(int orderId) {
		this.orderId = orderId;
	}
	public Terminal(String store_seatId) {
		this.store_seatId = store_seatId;
	}

	//ゲッター・セッター
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getStore_seatId() {
		return store_seatId;
	}
	public void setStore_seatId(String store_seatId) {
		this.store_seatId = store_seatId;
	}

}
