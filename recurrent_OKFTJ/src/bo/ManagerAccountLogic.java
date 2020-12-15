package bo;

import java.util.List;

import dao.ManagerDAO;
import model.Manager;

public class ManagerAccountLogic {
	public List<Manager> execute(){
		ManagerDAO dao= new ManagerDAO();
		List<Manager> managers=dao.findByAccount();
		return managers;
	}

}
