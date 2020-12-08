package test;

import bo.ManagerIdCheckLogic;
import bo.ManagerRegisterLogic;
import model.Manager;

public class ManagerRegisterLogicTest {

	public static void main(String[] args) {
		//logicTest();
		registerTest();

	}

	public static void logicTest() {
		Manager m=new Manager("koube-k","1234","山田");
		ManagerIdCheckLogic mr=new ManagerIdCheckLogic();
		boolean result=mr.checkId(m);
		if(result) {
			System.out.println("重複するIDはありません");
		}else {
			System.out.println("重複しています");
		}

	}

	public static void registerTest() {
		Manager m=new Manager("koube-b","7777","川谷史郎");
		ManagerRegisterLogic mrl=new ManagerRegisterLogic();
		boolean result=mrl.newAccount(m);
		if(result) {
			System.out.println("登録成功");
		}else {
			System.out.println("登録失敗");
		}

	}

}
