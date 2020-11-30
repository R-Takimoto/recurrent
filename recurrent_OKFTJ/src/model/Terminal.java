package model;

public class Terminal {
	//フィールド
	int orderId;

	//コンストラクタ
	public Terminal() {};
	public Terminal(int orderId) {
		this.orderId = orderId;
	}

	//ゲッター・セッター
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
