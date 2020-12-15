package bo;

import dao.OrderDAO;
import model.ManagerSlips;

public class ManagerSalesLogic {
	public ManagerSlips execute(String storeId,String typeCode,String fromDate,String toDate) {
		OrderDAO dao=new OrderDAO();
		ManagerSlips ms=dao.findBySalesMenu(storeId, typeCode, fromDate, toDate);
		return ms;
	}
}
