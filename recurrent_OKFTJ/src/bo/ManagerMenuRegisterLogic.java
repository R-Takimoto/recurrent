package bo;

import dao.MenuDAO;
import model.Product;

public class ManagerMenuRegisterLogic {

	public boolean newMenu(Product product) {
		MenuDAO dao=new MenuDAO();
		boolean result=dao.registerNewProduct(product);
		return result;
	}

}
