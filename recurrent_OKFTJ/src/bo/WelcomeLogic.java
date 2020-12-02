package bo;

import dao.OrderIdDAO;
import model.Terminal;

public class WelcomeLogic {

	public boolean login(Terminal terminal) {
		OrderIdDAO dao = new OrderIdDAO();

		boolean judge = dao.login(terminal);

		return judge;
	}
}
