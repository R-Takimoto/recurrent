package dao;

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
			String productName = "カツ丼";
			int price = 800;
			int calorie = 1200;
			Product product = new Product();

			product.setProductName(productName);
			product.setPrice(price);
			product.setCalorie(calorie);

			setproducts.getProducts().add(product);

			productsM.put(key.get(0), setproducts);
			// データベースへ接続
//			try (Connection conn = DriverManager.getConnection(
//					JDBC_URL, DB_USER, DB_PASS)) {
//
//				// SELECT文を準備
//				String sql = "SELECT productname,price,calorie,image FROM product WHERE item_varietyId LIKE ?";
//				PreparedStatement pStmt = conn.prepareStatement(sql);
//				String[] it_v = {"_s","w", "y", "d", "t", "a"};
//				for(int i = 0; i < it_v.length; i++) {
//					pStmt.setString(1,it_v[i]);
//
//					// SELECTを実行し、結果表を取得
//					ResultSet rs = pStmt.executeQuery();
//
//					while (rs.next()) {
//						// データを取得 productクラスのインスタンス化
//						Product product = new Product();
//						product.setProductName(rs.getString("PRODUCTNAME"));
//						product.setPrice(rs.getInt("PRICE"));
//						product.setCalorie(rs.getInt("CALORIE"));
//						product.setImage(rs.getString("IMAGE"));
//
//						setproducts.getProducts().add(product);
//					}
//					productsM.put(key.get(i), setproducts);
//				}
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//				return null;
//
//			}

			return productsM ;

		}
	}

