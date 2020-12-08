package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ManagerSlip;
import model.ManagerSlips;
import model.Products;

public class MenuDAO {

//		 データベース接続に使用する情報
		private final String JDBC_URL = "jdbc:mysql://192.168.10.18:3306/recurrent?characterEncoding=UTF-8&serverTimezone=JST";
		private final String DB_USER = "recurrent";
		private final String DB_PASS = "0000";


		//(管理画面)登録メニュー表示--------------------------------------------------
		public Products findByMenu() {

		  //初期値にnullをセット
		  ManagerSlips managerSlips=null;

		  // データベースへ接続
		  try (Connection conn = DriverManager.getConnection(
		      JDBC_URL, DB_USER, DB_PASS)) {
			  // SQL文を準備
		      String sql = "select item,typecode,productname,price,calorie,variety\r\n" +
		      		"from product\r\n" +
		      		"join item_variety\r\n" +
		      		"on product.item_varietyId=item_variety.item_varietyId\r\n" +
		      		"join item\r\n" +
		      		"on item_variety.itemId=item.itemId\r\n" +
		      		"join variety\r\n" +
		      		"on item_variety.varietyId=variety.varietyId";
		      PreparedStatement pStmt = conn.prepareStatement(sql);


		      //リザルト
		      ResultSet rs = pStmt.executeQuery();

		      //表全てをManagerSlipsクラスに格納（NullでなければManagerSlipsクラスをnewする）
	    	  while(rs.next()){
	    		  if(managerSlips==null) {
	    			  managerSlips = new ManagerSlips();
	    		  }
	    		  String orderDate=rs.getString("orderdate");
		    	  String productName = rs.getString("productname");
		    	  int price = rs.getInt("price");
		    	  int calorie = rs.getInt("calorie");
		    	  int quantity = rs.getInt("quantity");
		    	  String item=rs.getNString("item");
		    	  String variety=rs.getString("variety");
		    	  String ordertype=rs.getString("ordertype");


		    	  ManagerSlip managerSlip=new ManagerSlip(orderDate,productName,price,calorie,quantity,item,variety,ordertype);


		    	  managerSlips.getManagerSlips().add(managerSlip);

			  }
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return null;

		    }
		    return managerSlips;
	  }


}

