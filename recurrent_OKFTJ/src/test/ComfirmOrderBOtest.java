package test;

import bo.ConfirmLogic;
import model.ManagerSlips;

public class ComfirmOrderBOtest {

	public static void main(String[] args) {

		testExcute();

		}
	public static void testExcute(){
		String format="2020-12-02";
		String store_seatId="o16";
		ConfirmLogic cl=new ConfirmLogic();
		ManagerSlips ms=cl.execute(format, store_seatId);
		if(ms!=null) {
			for(int i=0;i<ms.size();i++) {
				System.out.println(ms.get(i).getOrderDate());
				System.out.println(ms.get(i).getProductName());
				System.out.println(ms.get(i).getPrice());
				System.out.println(ms.get(i).getCalorie());
				System.out.println(ms.get(i).getQuantity());
				System.out.println(ms.get(i).getItem());
				System.out.println(ms.get(i).getVariety());
				System.out.println(ms.get(i).getOrderType());

			}
		}else {
			System.out.println("当てはまる注文がありません");
		}

	}

}
