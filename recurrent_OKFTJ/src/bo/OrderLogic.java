package bo;

import dao.OrderDAO;
import model.Orders;

public class OrderLogic {

	public void newOrder(Orders orders) {
		OrderDAO dao = new OrderDAO();
		dao.registerOreder(orders);
	}
}
