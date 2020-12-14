package bo;

import dao.MenuDAO;
import model.Product;

public class ManagerMenuDeleteLogic {
	public boolean deleteMenuProduct(Product product) {
		MenuDAO dao=new MenuDAO();
		boolean result=dao.deleteMenu(product);
		return result;
	}
}
