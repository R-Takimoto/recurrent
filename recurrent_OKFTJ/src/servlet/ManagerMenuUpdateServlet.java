package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.ManagerMenuDeleteLogic;
import bo.ManagerMenuUpdateLogic;
import model.ManagerProduct;
import model.ManagerProducts;
import model.Product;


@WebServlet("/ManagerMenuUpdateServlet")
public class ManagerMenuUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		String process=request.getParameter("process");

		//action属性がnullなら、メニュー編集画面へ
		if(action==null) {
			//編集メニュー番号を受け取り
			int num=Integer.parseInt(request.getParameter("menuNum"));
			//System.out.println("受け取り番号"+num);

			//セッションスコープよりメニュー一覧取得
			HttpSession session=request.getSession();
			ManagerProducts menuAll=(ManagerProducts)session.getAttribute("menuAll");

			//受け取ったメニュー番号メニューをリクエストスコープに格納
			request.setAttribute("alterMenuProduct", menuAll.getManagerProducts().get(num));

		//action属性がreturnなら、「戻る」ボタン処理
		}else if(action.equals("return")) {
			request.setAttribute("action", action);
			request.setAttribute("process", process);
		}

		//フォワード
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/managerMenuUpdate.jsp");
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");

		//リクエストスコープにaction属性を格納
		request.setAttribute("action", action);

		//action属性がnullなら通常処理
		if(action==null) {
			String item=request.getParameter("item");
			String typeCode=request.getParameter("typeCode");
			String productName=request.getParameter("productName");
			int price=Integer.parseInt(request.getParameter("price"));
			int calorie=Integer.parseInt(request.getParameter("calorie"));
			String variety=request.getParameter("variety");
			String image=request.getParameter("image");
			String process=request.getParameter("process");

		    request.setAttribute("process", process);

		    //パラメータで受け取った値（修正内容）をManagerProduct型にいれてセッションスコープに保存
			ManagerProduct alterMenuProductConfirm=new ManagerProduct(item,typeCode,productName,price,calorie,variety,image);
			HttpSession session =request.getSession();
			session.setAttribute("alterMenuProductConfirm", alterMenuProductConfirm);

			//フォワード
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/managerMenuUpdateConfirm.jsp");
			dispatcher.forward(request, response);


		//action属性がdoneの場合（処理確定ボタン押した場合）
		}else if(action.contentEquals("done")) {

			boolean result=false;
			HttpSession session =request.getSession();
			String process=request.getParameter("process");
			request.setAttribute("process", process);

			//修正内容を受け取り
			ManagerProduct alterMenuProductConfirm=(ManagerProduct)session.getAttribute("alterMenuProductConfirm");

			//メニュー修正処理
			if(process.equals("update")) {
				String item=alterMenuProductConfirm.getItem();
				String typeCode=alterMenuProductConfirm.getTypeCode();
				String productName=alterMenuProductConfirm.getProductName();
				int price=alterMenuProductConfirm.getPrice();
				int calorie=alterMenuProductConfirm.getCalorie();
				String variety=alterMenuProductConfirm.getVariety();
				String image=alterMenuProductConfirm.getImage();

				//item_varietyIdを生成
				String item_varietyId=null;
				if(item.equals("和食")&&variety.equals("単品")) {
					item_varietyId="w";
				}else if(item.equals("洋食")&&variety.equals("単品")) {
					item_varietyId="y";
				}else if(item.equals("トッピング")&&variety.equals("単品")) {
					item_varietyId="t";
				}else if(item.equals("飲み物")&&variety.equals("単品")) {
					item_varietyId="d";
				}else if(item.equals("その他")&&variety.equals("単品")) {
					item_varietyId="a";
				}else if(item.equals("和食")&&variety.equals("セット")) {
					item_varietyId="ws";
				}else if(item.equals("洋食")&&variety.equals("セット")) {
					item_varietyId="ys";
				}

				//DB用にProduct型に移し替え
				Product updateProduct=new Product(typeCode,item_varietyId,productName,price,calorie,image);
				//DBに修正内容反映
				ManagerMenuUpdateLogic bo=new ManagerMenuUpdateLogic();
				result=bo.UpdateMenu(updateProduct);
			}

			//メニュー削除処理
			if(process.equals("delete")) {
				//typeCodeを受け取って、DB削除処理
				String typeCode=alterMenuProductConfirm.getTypeCode();
				Product delateProduct=new Product();
				delateProduct.setTypeCode(typeCode);

				ManagerMenuDeleteLogic bo=new ManagerMenuDeleteLogic();
				result=bo.deleteMenuProduct(delateProduct);
			}

			//処理成功
			if(result) {
				request.setAttribute("alterMenuProductConfirm",alterMenuProductConfirm);
				session.removeAttribute("alterMenuProductConfirm");

				//フォワード
				RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/managerMenuUpdateDone.jsp");
				dispatcher.forward(request, response);

			//※失敗時処理、未設定........
			}else {

			}

		}

	}

}
