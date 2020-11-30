package bo;

import dao.OrderDAO;
import model.Slips;
import model.Terminal;

public class SlipLogic {

	public Slips payment(Terminal terminal) {
		OrderDAO dao = new OrderDAO();

		Slips slips = dao.reedOrder(terminal);

		return slips;
	}
}
