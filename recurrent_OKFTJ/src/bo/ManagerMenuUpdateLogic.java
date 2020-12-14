package bo;

import dao.MenuDAO;
import model.Product;

public class ManagerMenuUpdateLogic {
	public boolean UpdateMenu(Product product) {
		MenuDAO dao=new MenuDAO();
		boolean result=dao.UpdateMenu(product);
		return result;
	}

}
