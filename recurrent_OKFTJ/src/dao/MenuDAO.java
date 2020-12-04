package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Product;
import model.Products;

public class MenuDAO {

//		 データベース接続に使用する情報
		private final String JDBC_URL = "jdbc:mysql://192.168.10.18:3306/recurrent?characterEncoding=UTF-8&serverTimezone=JST";
		private final String DB_USER = "recurrent";
		private final String DB_PASS = "0000";

		public Map<String, Products> findAll() {

			ArrayList<String> key = new ArrayList<>();
			key.add("s");
			key.add("w");
			key.add("y");
			key.add("d");
			key.add("t");
			key.add("a");

			Map<String, Products> productsM = new HashMap<String, Products>();
			Products setproducts = new Products();

//			AllProducts allProduct = new AllProducts();
//			ArrayList<AllProducts> allproducts = new ArrayList<AllProducts>();
//			ArrayList<ArrayList<Product>> allProducts = new ArrayList<ArrayList<Product>>();
//
//			Products products = new Products();
//			ArrayList<Product> setproducts = new ArrayList<Product>();
//			ArrayList<Product> japanproducts = new ArrayList<Product>();
//			ArrayList<Product> westernproducts = new ArrayList<Product>();
//			ArrayList<Product> drinkproducts = new ArrayList<Product>();
//			ArrayList<Product> toppingproducts = new ArrayList<Product>();
//			ArrayList<Product> anotherproducts = new ArrayList<Product>();


			// データベースへ接続
			try (Connection conn = DriverManager.getConnection(
					JDBC_URL, DB_USER, DB_PASS)) {

				// SELECT文を準備
				String sql = "SELECT productname,price,calorie,image FROM product WHERE item_varietyId LIKE ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				String[] it_v = {"_s","w", "y", "d", "t", "a"};
				for(int i = 0; i < it_v.length; i++) {
					pStmt.setString(1,it_v[i]);

					// SELECTを実行し、結果表を取得
					ResultSet rs = pStmt.executeQuery();

					while (rs.next()) {
						// データを取得 productクラスのインスタンス化
						Product product = new Product();
						product.setProductName(rs.getString("PRODUCTNAME"));
						product.setPrice(rs.getInt("PRICE"));
						product.setCalorie(rs.getInt("CALORIE"));
						product.setImage(rs.getString("IMAGE"));

						setproducts.getProducts().add(product);


					}
					productsM.put(key.get(i), setproducts);

				}
//
//				String sql2 = "SELECT productname,price,calorie,image FROM product WHERE item_varietyId=? ";
//				PreparedStatement pStmt2 = conn.prepareStatement(sql2);
//				String[] it_v2 = {"w","y","d","t","a"};
//				for(int j = 0; j < 5; j++) {
//					pStmt2.setString(1,it_v2[j]);
//
//					// SELECTを実行し、結果表を取得
//					ResultSet rs2 = pStmt.executeQuery();
//
//					while (rs2.next()) {
//						// データを取得
//						Product product = new Product();
//						product.setProductName(rs2.getString("PRODUCTNAME"));
//						product.setPrice(rs2.getInt("PRICE"));
//						product.setCalorie(rs2.getInt("CALORIE"));
//						product.setImage(rs2.getString("IMAGE"));
//
//						if(j == 0) {
//							japanproducts.add(product);
//							allProducts.add(japanproducts);
//							productsM.put(key.get(j+1), japanproducts);
//
//						}else if(j == 1){
//							westernproducts.add(product);
//							allProducts.add(westernproducts);
//							productsM.put(key.get(j+1), westernproducts);
//						}else if(j == 2) {
//							drinkproducts.add(product);
//							allProducts.add(drinkproducts);
//							productsM.put(key.get(j+1), drinkproducts);
//						}else if(j == 3) {
//							toppingproducts.add(product);
//							allProducts.add(toppingproducts);
//							productsM.put(key.get(j+1), toppingproducts);
//						}else if(j == 4) {
//							anotherproducts.add(product);
//							allProducts.add(anotherproducts);
//							productsM.put(key.get(j+1), anotherproducts);
//						}
//					}
//
//
//				}


			} catch (SQLException e) {
				e.printStackTrace();
				return null;

			}

			return productsM ;

		}
	}

