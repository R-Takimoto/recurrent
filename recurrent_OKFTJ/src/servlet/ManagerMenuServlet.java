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
import model.ManagerProducts;


@WebServlet("/ManagerMenuServlet")
public class ManagerMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//DBよりメニュー情報（Productテーブル）を取得
		ManagerMenuLogic bo=new ManagerMenuLogic();
		ManagerProducts menuAll=bo.execute();

//		if(menuAll!=null) {
//			for(int i=0;i<menuAll.getManagerProducts().size();i++) {
//
//				System.out.println(menuAll.getManagerProducts().get(i).getItem());
//				System.out.println(menuAll.getManagerProducts().get(i).getTypeCode());
//				System.out.println(menuAll.getManagerProducts().get(i).getProductName());
//				System.out.println(menuAll.getManagerProducts().get(i).getPrice());
//				System.out.println(menuAll.getManagerProducts().get(i).getCalorie());
//				System.out.println(menuAll.getManagerProducts().get(i).getVariety());
//				System.out.println(menuAll.getManagerProducts().get(i).getImage());
//			}
//		}else{
//			System.out.println("当てはまる注文がありません");
//		}


		//Productテーブルがnullでないならセッションスコープに取得したメニュー情報を格納
		if(menuAll!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("menuAll", menuAll);
		}


		//フォワード
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/managerMenu.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
