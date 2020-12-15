package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.ManagerMenuCodeCheckLogic;
import bo.ManagerMenuRegisterLogic;
import model.ManagerProduct;
import model.Product;


@WebServlet("/ManagerMenuRegistrationServlet")
public class ManagerMenuRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//actionパラメータの受け取り,リクエストスコープに保存
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		request.setAttribute("action", action);
		if(action==null) {
			//newMenuProductセッションスコープ情報が残っている場合消去
			HttpSession session=request.getSession();
			session.removeAttribute("newMenuProduct");
		}
		//フォワード
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/managerMenuCreate.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//パラメータの受け取り,Managerクラスに格納
			request.setCharacterEncoding("utf-8");
			String action=request.getParameter("action");

			//リクエストスコープにaction属性を格納
			request.setAttribute("action", action);

			String fowardpath=null;

			//action属性がNullなら（return（戻るボタン）の時ではない）DB登録前チェック
			if(action==null) {
				String item=request.getParameter("item");
				String typeCode=request.getParameter("typeCode");
				String productName=request.getParameter("productName");
				int price=Integer.parseInt(request.getParameter("price"));
				int calorie=Integer.parseInt(request.getParameter("calorie"));
				String variety=request.getParameter("variety");
				String image=request.getParameter("image");
				System.out.println(item);
				System.out.println(typeCode);
				System.out.println(productName);
				System.out.println(price);
				System.out.println(calorie);
				System.out.println(variety);
				System.out.println(image);


				//パラメータで受け取った値（登録内容）をManagerProduct型にいれてセッションスコープに保存
				ManagerProduct newMenuProduct=new ManagerProduct(item,typeCode,productName,price,calorie,variety,image);
				HttpSession session =request.getSession();




				//エラーメッセージ用Mapを用意
				Map<String,String>errMsg=new HashMap<String,String>();

				//入力情報チェック
				if(typeCode!=null&&typeCode.length()>15) {
					//エラーメッセージをMapに格納
					errMsg.put("typeCode","※15文字以内にしてください");
					//エラーメッセージを格納したMapをリクエストスコープに保存
					request.setAttribute("errMsg", errMsg);
					//入力値が15文字以上場合は入力値を再表示させない
					newMenuProduct.setTypeCode(null);
					//フォワードバスは入力画面
					fowardpath="/WEB-INF/jsp/managerMenuCreate.jsp";
				}else if(productName!=null&&productName.length()>15) {
					errMsg.put("productName","※15文字以内にしてください");
					request.setAttribute("errMsg", errMsg);
					newMenuProduct.setProductName(null);
					fowardpath="/WEB-INF/jsp/managerMenuCreate.jsp";
				}



				//商品コード重複チェック
				Product product=new Product();
				product.setTypeCode(newMenuProduct.getTypeCode());
				ManagerMenuCodeCheckLogic bo=new ManagerMenuCodeCheckLogic();
				boolean checkIdResult=bo.checkTypeCode(product);
				//重複がなければ
				if(checkIdResult&&newMenuProduct.getItem()!=null&&newMenuProduct.getTypeCode()!=null&&newMenuProduct.getProductName()!=null&&newMenuProduct.getVariety()!=null&&newMenuProduct.getImage()!=null) {
					//セッションスコープに入力情報（新規メニュー情報）を保存
					session.setAttribute("newMenuProduct", newMenuProduct);
					//フォワードパスは確認画面
					fowardpath="/WEB-INF/jsp/managerMenuCreateConfirm.jsp";
				}else if(checkIdResult==false){
					//ID重複していればエラーメッセージを生成、格納、入力画面にフォワード
					String idDuplicateMsg="商品コードはすでに使用されています";
					request.setAttribute("idDuplicateMsg", idDuplicateMsg);
					newMenuProduct.setTypeCode(null);
					newMenuProduct.setImage(null);
					session.setAttribute("newMenuProduct", newMenuProduct);
					fowardpath="/WEB-INF/jsp/managerMenuCreate.jsp";
				}


			//action属性がdoneの場合（登録ボタン押した場合）
			}else if(action.equals("done")) {
				HttpSession session =request.getSession();
				ManagerProduct registerProduct =(ManagerProduct)session.getAttribute("newMenuProduct");


				String item=registerProduct.getItem();
				String typeCode=registerProduct.getTypeCode();
				String productName=registerProduct.getProductName();
				int price=registerProduct.getPrice();
				int calorie=registerProduct.getCalorie();
				String variety=registerProduct.getVariety();
				String image=registerProduct.getImage();

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
				Product newProduct=new Product(typeCode,item_varietyId,productName,price,calorie,image);

				//DBに新規アカウント登録
				ManagerMenuRegisterLogic bo=new ManagerMenuRegisterLogic();
				bo.newMenu(newProduct);


				//リクエストスコープに登録メニュー情報を格納してセッションスコープのメニュー情報は破棄
				request.setAttribute("newMenu", registerProduct);
				session.removeAttribute("newMenuProduct");

				fowardpath="/WEB-INF/jsp/managerMenuCreateDone.jsp";
			}

			//フォワード
			RequestDispatcher dispatcher=request.getRequestDispatcher(fowardpath);
			dispatcher.forward(request, response);
	}

}
