package test;

import dao.OrderDAO;
import model.ManagerSlips;

public class OrderDAOtest {

	public static void main(String[] args) {
		confirmOrder("2020-12-02","o16");
	}

	public static void confirmOrder(String format,String storeSeatId) {
		OrderDAO oo=new OrderDAO();

		ManagerSlips result=oo.findByOrder(format, storeSeatId);

		if(result!=null) {
			for(int i=0;i<result.size();i++) {

				System.out.println(result.get(i).getOrderDate());
				System.out.println(result.get(i).getProductName());
				System.out.println(result.get(i).getPrice());
				System.out.println(result.get(i).getCalorie());
				System.out.println(result.get(i).getQuantity());
				System.out.println(result.get(i).getItem());
				System.out.println(result.get(i).getVariety());
				System.out.println(result.get(i).getOrderType());

			}
		}else{
			System.out.println("当てはまる注文がありません");
		}

	}
}
