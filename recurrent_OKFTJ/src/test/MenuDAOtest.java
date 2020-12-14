package test;

import dao.MenuDAO;
import model.ManagerProducts;
import model.Product;

public class MenuDAOtest {

	public static void main(String[] args) {
		//daoTest();
		//isMenuDupulacateTest();
		//updateMenu();
		//deleteMenuTest();
		newMenuTest();

	}

	public static void daoTest() {
		MenuDAO md=new MenuDAO();
		ManagerProducts result=md.findByMenu();

		if(result!=null) {
			for(int i=0;i<result.getManagerProducts().size();i++) {

				System.out.println(result.getManagerProducts().get(i).getItem());
				System.out.println(result.getManagerProducts().get(i).getTypeCode());
				System.out.println(result.getManagerProducts().get(i).getProductName());
				System.out.println(result.getManagerProducts().get(i).getPrice());
				System.out.println(result.getManagerProducts().get(i).getCalorie());
				System.out.println(result.getManagerProducts().get(i).getVariety());
				System.out.println(result.getManagerProducts().get(i).getImage());



			}
		}else{
			System.out.println("当てはまる注文がありません");
		}
	}

	public static void isMenuDupulacateTest() {
		Product p=new Product();
		p.setTypeCode("a-002");
		MenuDAO md=new MenuDAO();
		boolean result=md.isDuplicate(p);
		if(result) {
			System.out.println("一致する商品コードはありません");
		}else {
			System.out.println("商品コードが重複しています");
		}
	}

	public static void updateMenu() {
		Product p=new Product("ws-005","w","だし巻き卵",300,250,"wasyoku-005.jpg");
		MenuDAO md=new MenuDAO();
		boolean result=md.UpdateMenu(p);
		if(result) {
			System.out.println("更新完了");
		}else {
			System.out.println("更新失敗");
		}

	}

	public static void deleteMenuTest() {
		Product p=new Product();
		p.setTypeCode("ws-005");
		MenuDAO md=new MenuDAO();
		boolean result=md.deleteMenu(p);
		if(result) {
			System.out.println("消去完了");
		}else {
			System.out.println("消去失敗");
		}
	}
	public static void newMenuTest() {
		Product p=new Product("ws-005","w","だし巻き卵セット",300,250,"wasyoku-005.jpg");
		MenuDAO md=new MenuDAO();
		boolean result=md.registerNewProduct(p);
		if(result) {
			System.out.println("登録成功");
		}else {
			System.out.println("登録失敗");
		}
	}


}
