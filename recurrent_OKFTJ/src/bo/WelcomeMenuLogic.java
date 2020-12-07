package bo;

import java.util.ArrayList;
import java.util.Map;

import dao.MenuDAO;
import model.Product;

public class WelcomeMenuLogic {

	public Map<String, ArrayList<Product>> execute() {

		MenuDAO dao = new MenuDAO();

		return dao.findAll();
	}
}
