package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.ManagerMenuLogic;
import bo.ManagerSalesLogic;
import model.ManagerProducts;
import model.ManagerSlips;


@WebServlet("/ManagerSalesServlet")
public class ManagerSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//メニュー取得
		ManagerMenuLogic bo=new ManagerMenuLogic();
		ManagerProducts menuSales=bo.execute();

		//セッションスコープに保存
		HttpSession session=request.getSession();
		session.setAttribute("menuSales", menuSales);

		//フォワード
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/managerSales.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String store=request.getParameter("store");
		String fromDate=request.getParameter("fromDate");
		String toDate=request.getParameter("toDate");
		String productName=request.getParameter("productName");

		System.out.println(store);
		System.out.println(fromDate);
		System.out.println(toDate);
		System.out.println(productName);

		HttpSession session=request.getSession();
		//ManagerProducts menuSales=(ManagerProducts)session.getAttribute("menuSales");
		//DBよりメニュー情報（Productテーブル）を取得
		ManagerMenuLogic mmbo=new ManagerMenuLogic();
		ManagerProducts menuAll=mmbo.execute();


		String storeId=store+"%";
		String typeCode=null;
		if(productName.equals("allProduct")) {
			typeCode="%";
		}else {
			typeCode=productName.substring(0)+"%";
		}

		ManagerSalesLogic bo=new ManagerSalesLogic();
		ManagerSlips salesProduct=bo.execute(storeId, typeCode, fromDate, toDate);
		int totalSalesPrice=0;
		if(salesProduct!=null) {
//			for(int i=0;i<salesProduct.size();i++) {
//				System.out.println(salesProduct.get(i).getOrderDate());
//				System.out.println(salesProduct.get(i).getProductName());
//				System.out.println(salesProduct.get(i).getPrice());
//				System.out.println(salesProduct.get(i).getCalorie());
//				System.out.println(salesProduct.get(i).getQuantity());
//				System.out.println(salesProduct.get(i).getItem());
//				System.out.println(salesProduct.get(i).getVariety());
//				System.out.println(salesProduct.get(i).getOrderType());
//			}
			request.setAttribute("salesProduct", salesProduct);
			for(int i=0;i<salesProduct.getManagerSlips().size();i++) {
				totalSalesPrice+=salesProduct.getManagerSlips().get(i).getPrice();
			}
			request.setAttribute("totalSalesPrice",totalSalesPrice);
		}


		if(store.equals("k")) {
			request.setAttribute("store", "神戸店");
		}else {
			request.setAttribute("store", "大阪店");
		}

		request.setAttribute("fromDate", fromDate);
		request.setAttribute("toDate", toDate);


		int num=0;
		for(int i=0;i<menuAll.getManagerProducts().size();i++) {
			if(productName.equals(menuAll.getManagerProducts().get(i).getTypeCode())) {
				num=i;
			}
		}

		if(productName.equals("allProduct")) {
			request.setAttribute("productName", "全商品");
		}else {
			request.setAttribute("productName", menuAll.getManagerProducts().get(num).getProductName());
		}








		//フォワード
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/managerSalesTable.jsp");
		dispatcher.forward(request, response);


	}

}
