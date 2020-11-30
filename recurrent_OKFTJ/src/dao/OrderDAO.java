package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Order;
import model.Orders;
import model.Slip;
import model.Slips;
import model.Terminal;

public class OrderDAO {
	// データベース接続に使用する情報
		  private final String JDBC_URL = "jdbc:mysql://192.168.10.18:3306/recurrent?characterEncoding=UTF-8&serverTimezone=JST";
		  private final String DB_USER = "recurrent";
		  private final String DB_PASS = "0000";

		  //注文処理-----------------------------------------------------
		  public void registerOreder(Orders orders) {
			  // データベースへ接続
			  try (Connection conn = DriverManager.getConnection(
			      JDBC_URL, DB_USER, DB_PASS)) {
				  ArrayList<Order> orderList = orders.getOrders();

				  // SQL文を準備
			      String sql = "INSERT INTO orders SET orderdate=?, orderId=?, orderbranch=?, typecode=?, quantity=?, ordertypeId=?";
			      PreparedStatement pStmt = conn.prepareStatement(sql);

			      for(int i = 0; i < orderList.size(); i ++) {
			    	  pStmt.setString(1, orderList.get(i).getOrderDate());
			    	  pStmt.setInt(2, orderList.get(i).getOrderId());
			    	  pStmt.setInt(3, orderList.get(i).getOrderbranch());
			    	  pStmt.setString(4, orderList.get(i).getTypeCode());
				      pStmt.setInt(5, orderList.get(i).getQuantity());
				      pStmt.setInt(6, orderList.get(i).getOrdertypeId());

				      int a = pStmt.executeUpdate();
				      System.out.println(a);
			      }

			    } catch (SQLException e) {
			      e.printStackTrace();

			    }
		  }
		  //伝票処理--------------------------------------------------
		  public Slips reedOrder(Terminal terminal) {
			  Slips slips = new Slips();
			// データベースへ接続
			  try (Connection conn = DriverManager.getConnection(
			      JDBC_URL, DB_USER, DB_PASS)) {
				  // SQL文を準備
			      String sql = "SELECT product, quantity, price, calorie FROM orders JOIN product ON orders.typecode = product.typecode WHERE orderId = ?";
			      PreparedStatement pStmt = conn.prepareStatement(sql);

			      pStmt.setInt(1, terminal.getOrderId());
			      //リザルト
			      ResultSet rs = pStmt.executeQuery();
//			      Slip slip = null;

			      while(rs.next()) {
			    	  String product = rs.getString("product");
			    	  int quantity = rs.getInt("quantity");
			    	  int price = rs.getInt("price");
			    	  int calorie = rs.getInt("calorie");
			    	  Slip slip = new Slip(product, price, quantity, calorie);
			    	  slips.getSlips().add(slip);
//			    	  System.out.println(slips.getSlips().get(0).getProduct());
					}
			      return slips;

			    } catch (SQLException e) {
			      e.printStackTrace();

			    }

			  return null;
		  }
}
