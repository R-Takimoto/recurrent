package bo;

import dao.ManagerDAO;
import model.Manager;

public class ManagerIdCheckLogic {
	//Idが重複していないかチェック
	public boolean checkId(Manager manager) {
		ManagerDAO md=new ManagerDAO();
		boolean result=md.isDuplicate(manager);
		return result;
	}

}
