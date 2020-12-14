package bo;

import dao.MenuDAO;
import model.Product;

public class ManagerMenuCodeCheckLogic {

	//商品コードが重複していないかチェック
	public boolean checkTypeCode(Product product) {
		MenuDAO dao=new MenuDAO();
		boolean result=dao.isDuplicate(product);
		return result;
	}



}
