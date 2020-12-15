package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.ManagerAccountLogic;
import model.Manager;


@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//newManagerセッションスコープ情報が残っている場合消去
		HttpSession session=request.getSession();
		session.removeAttribute("newManager");

		//DBよりアカウント一覧呼び出し
		ManagerAccountLogic bo=new ManagerAccountLogic();
		List<Manager> managersAll=bo.execute();


//		//店名を生成
//		String storeName=null;
//		for(int i=0;i<managersAll.size();i++) {
//			if(managersAll.get(i).getId().matches("koube.*")) {
//				storeName="神戸店";
//				break;
//			}else if(managersAll.get(i).getId().matches("osaka.*")) {
//				storeName="大阪店";
//				break;
//			}else {
//				storeName="　　　";
//			}
//		}
//
//		//店名をセッションスコープに保存
//		session.setAttribute("storeName", storeName);


		//セッションスコープに保存
		session.setAttribute("managersAll", managersAll);

		//フォワード
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/account.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
