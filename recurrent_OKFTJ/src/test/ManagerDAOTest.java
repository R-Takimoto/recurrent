package test;

import dao.ManagerDAO;
import model.Manager;

public class ManagerDAOTest {

	public static void main(String[] args) {
		//isDupulacateTest();
		registerTest();

	}

	public static void isDupulacateTest() {
		Manager m=new Manager("koube-m","1234","管理者");
		ManagerDAO md=new ManagerDAO();
		boolean result=md.isDuplicate(m);
		if(result) {
			System.out.println("一致するユーザーはいません");
		}else {
			System.out.println("重複しています");
		}
	}

	public static void registerTest() {
		Manager m=new Manager("osaka-q","2222","山本三郎");
		ManagerDAO md=new ManagerDAO();
		boolean result=md.registerNewManager(m);
		if(result) {
			System.out.println("登録成功");
		}else {
			System.out.println("登録失敗");
		}
	}

}
