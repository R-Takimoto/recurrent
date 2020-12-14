package bo;

import dao.ManagerDAO;
import model.Manager;

public class ManagerRegisterLogic {
	//新規アカウントをDBに登録
	public boolean newAccount(Manager manager) {
		ManagerDAO md=new ManagerDAO();
		boolean result=md.registerNewManager(manager);
		return result;
	}
}
