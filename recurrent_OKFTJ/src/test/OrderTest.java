package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import bo.OrderLogic;
import dao.MenurDAO;
import model.Orders;

public class OrderTest {

	public static void main(String[] args) {

		MenurDAO menu = new MenurDAO();

		menu.findAll();

		LocalDateTime now = LocalDateTime.now();
		 DateTimeFormatter Format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 // 日時情報を指定フォーマットの文字列で取得
		 String format = now.format(Format);
		 System.out.println(format);

		System.out.println(now);
		String typeCode = "a-001";
		int orderId = 50;
		int orderbranch = 1;
		int quantity = 1;
		int ordertypeId = 1;
		Order order = new Order(typeCode, orderId, orderbranch, quantity, ordertypeId);

		String typeCode2 = "a-001";
		int orderId2 = 50;
		int orderbranch2 = 1;
		int quantity2 = 1;
		int ordertypeId2 = 1;
		Order order2 = new Order(typeCode2, orderId2, orderbranch2, quantity2, ordertypeId2);

		Orders orders = new Orders();

		orders.getOrders().add(order);
		orders.getOrders().add(order2);

		OrderLogic lo = new OrderLogic();
		lo.newOrder(orders);
	}



}
