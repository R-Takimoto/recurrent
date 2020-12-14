package bo;

import dao.MenuDAO;
import model.ManagerProducts;

public class ManagerMenuLogic {

	public ManagerProducts execute() {
		MenuDAO md=new MenuDAO();
		ManagerProducts mp=md.findByMenu();
		return mp;
	}
}
