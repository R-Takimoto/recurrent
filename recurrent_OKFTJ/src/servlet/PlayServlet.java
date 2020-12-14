package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.Products;


@WebServlet("/PlayServlet")
public class PlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータ受取
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		//action属性の有無によりフォワード先変更
		if(action ==null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/play.jsp");
			dispatcher.forward(request,response);

		//action属性が"gatya"の場合（「ガチャる」「もう一回ガチャる」ボタン押した場合）
		}else if(action.equals("gatya")){

			//sessionスコープからメニュー取得
			HttpSession session=request.getSession();
			Map<String, Products> menu=(Map<String, Products>) session.getAttribute("menu");

			//（仮）Welcomeサーブレットを通さずmenu取得用
//			WelcomeMenuLogic wml=new WelcomeMenuLogic();
//			Map<String, Products> menu=wml.execute();

			//---------------ガチャ用コード---------------------------------------------
			//初期値設定
			int gatyaPriceTotal=0;
			int gatyaCalorieTotal=0;

			//ガチャメニューの入れ物用意
			Products gatyaMenu=new Products();
			Products gatya50yenMenu=new Products();
			Product rdmProduct=new Product();

			//menuのMapのキーを取り出して配列に格納
			String[] keys=menu.keySet().toArray(new String[menu.size()]);
//			キーの中身確認
//			for(int i=0;i<keys.length;i++) {
//				System.out.println(keys[i]);
//			}

			//合計金額が800円になるまでループ
			while(gatyaPriceTotal<800) {
				//ランダム値
				int num=new java.util.Random().nextInt(keys.length);
				int num2=menu.get(keys[num]).getProducts().size();

				//キーが”a”の場合のみ（商品が1つしかないため）
				if(keys[num].equals("a")) {
					rdmProduct=menu.get(keys[num]).getProducts().get(0);
					//System.out.println("ランダム商品は"+rdmProduct.getProductName()+"　価格："+rdmProduct.getPrice());

				//その他のキーの場合
				}else {
					int num3=num2-1;
					int num4=new java.util.Random().nextInt(num3);
					rdmProduct=menu.get(keys[num]).getProducts().get(num4);
					//System.out.println("ランダム商品は"+rdmProduct.getProductName()+"　価格："+rdmProduct.getPrice());
				}

				//ランダムで選択商品の価格を合計金額に足す
				gatyaPriceTotal+=rdmProduct.getPrice();
				gatyaCalorieTotal+=rdmProduct.getCalorie();
				//System.out.println("とりあえずの合計"+gatyaPriceTotal);

				//この時点で合計金額が800円を超えていたら引く
				if(gatyaPriceTotal>800) {
					gatyaPriceTotal-=rdmProduct.getPrice();
					gatyaCalorieTotal-=rdmProduct.getCalorie();
					//System.out.println("とりあえずの合計が800円以上なのでこの商品は引きました");

				//800円以内ならガチャメニューに加える
				}else {
					gatyaMenu.getProducts().add(rdmProduct);
				}

				//この時点で合計金額が750円なら50円の商品をガチャメニューに加える
				if(gatyaPriceTotal==750){
					//50円商品が複数ある場合、50円メニューをランダムで取り出し
//					for(int i=0;i<keys.length;i++) {
//						for(int r=0;r<menu.get(keys[i]).getProducts().size();r++) {
//							if(menu.get(keys[i]).getProducts().get(r).getPrice()<=50) {
//								gatya50yenMenu.getProducts().add(menu.get(keys[i]).getProducts().get(r));
//							}
//						}
//					}
//					int num5=new java.util.Random().nextInt(gatya50yenMenu.getProducts().size());
//					rdmProduct=gatya50yenMenu.getProducts().get(num5);
					//50円商品が1つ（チーズ）の場合、チーズ
					rdmProduct=menu.get("t").getProducts().get(1);
					//System.out.println("50円商品"+menu.get("t").getProducts().get(1).getProductName());
					gatyaPriceTotal+=rdmProduct.getPrice();
					gatyaCalorieTotal+=rdmProduct.getCalorie();
					gatyaMenu.getProducts().add(rdmProduct);
				}

				//System.out.println("現在は"+gatyaPriceTotal);
				//System.out.println("-------------------------------------");
			}
			//---------------ガチャ用コードここまで---------------------------------------------

			//ガチャメニュー、合計金額、カロリーをリクエストスコープに保存
			request.setAttribute("gatyaPriceTotal", gatyaPriceTotal);
			request.setAttribute("gatyaCalorieTotal", gatyaCalorieTotal);

			session.setAttribute("gatyaMenu", gatyaMenu);

			//カート用にリクエストスコープに保存
//			for(int i=0;i<gatyaMenu.getProducts().size();i++) {
//				request.setAttribute("typeCode", gatyaMenu.getProducts().get(i).getTypeCode());
//				request.setAttribute("productName", gatyaMenu.getProducts().get(i).getProductName());
//				request.setAttribute("image", gatyaMenu.getProducts().get(i).getImage());
//				request.setAttribute("quantity", 1);
//				request.setAttribute("price", gatyaMenu.getProducts().get(i).getPrice());
//				request.setAttribute("calorie", gatyaMenu.getProducts().get(i).getCalorie());
//				request.setAttribute("orderTypeId", 4);
//			}



			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/played.jsp");
			dispatcher.forward(request,response);
		}
	}



}


