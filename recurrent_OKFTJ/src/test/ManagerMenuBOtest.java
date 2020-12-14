package test;

import bo.ManagerMenuCodeCheckLogic;
import bo.ManagerMenuDeleteLogic;
import bo.ManagerMenuLogic;
import bo.ManagerMenuRegisterLogic;
import bo.ManagerMenuUpdateLogic;
import model.ManagerProducts;
import model.Product;

public class ManagerMenuBOtest {

	public static void main(String[] args) {

		//menuBOtest();
		//logicTest();
		//updateTest();
		//deleteTest();
		newTest();
	}

	public static void menuBOtest() {
		ManagerMenuLogic mml=new ManagerMenuLogic();
		ManagerProducts result=mml.execute();

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

	public static void logicTest() {
		Product p=new Product();
		p.setTypeCode("d-002");
		ManagerMenuCodeCheckLogic bo=new ManagerMenuCodeCheckLogic();

		boolean result=bo.checkTypeCode(p);
		if(result) {
			System.out.println("一致する商品コードはありません");
		}else {
			System.out.println("商品コードが重複しています");
		}

	}

	public static void updateTest() {
		Product p=new Product("ws-005","w","だし巻き卵",400,250,"wasyoku-005.jpg");
		ManagerMenuUpdateLogic bo=new ManagerMenuUpdateLogic();
		boolean result=bo.UpdateMenu(p);
		if(result) {
			System.out.println("更新完了");
		}else {
			System.out.println("更新失敗");
		}

	}

	public static void deleteTest() {
		Product p=new Product();
		p.setTypeCode("w-007");
		ManagerMenuDeleteLogic bo=new ManagerMenuDeleteLogic();
		boolean result=bo.deleteMenuProduct(p);

		if(result) {
			System.out.println("削除成功");
		}else {
			System.out.println("削除失敗");
		}

	}
	public static void newTest() {
		Product p=new Product("ws-007","ws","ソーセージセット",800,1000,"wasyoku-007.jpg");
		ManagerMenuRegisterLogic mm=new ManagerMenuRegisterLogic();
		boolean result=mm.newMenu(p);
		if(result) {
			System.out.println("登録成功");
		}else {
			System.out.println("登録失敗");
		}

	}

}
