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

public class MenuDAO {

//		 データベース接続に使用する情報
		private final String JDBC_URL = "jdbc:mysql://192.168.10.18:3306/recurrent?characterEncoding=UTF-8&serverTimezone=JST";
		private final String DB_USER = "recurrent";
		private final String DB_PASS = "0000";

		public Map<String, ArrayList<Product>> findAll() {

			ArrayList<String> key = new ArrayList<>();
			key.add("s");
			key.add("w");
			key.add("y");
			key.add("d");
			key.add("t");
			key.add("a");

<<<<<<< HEAD
			Map<String, ArrayList<Product>> productsM = new HashMap<String, ArrayList<Product>>();
=======
			Map<String, Products> productsM = new HashMap<String, Products>();
>>>>>>> takimoto/brach


			// データベースへ接続
			try (Connection conn = DriverManager.getConnection(
					JDBC_URL, DB_USER, DB_PASS)) {

				// SELECT文を準備
				String sql = "SELECT typecode, productname,price,calorie,image FROM product WHERE item_varietyId LIKE ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				String[] it_v = {"_s","w", "y", "d", "t", "a"};
				for(int i = 0; i < it_v.length; i++) {
					pStmt.setString(1,it_v[i]);

					// SELECTを実行し、結果表を取得
					ResultSet rs = pStmt.executeQuery();
<<<<<<< HEAD
					ArrayList<Product> setproducts = new ArrayList<Product>();
=======
					Products setproducts = new Products();
>>>>>>> takimoto/brach
//					Products setproducts = new Products();;
					while (rs.next()) {
						// データを取得 productクラスのインスタンス化
						Product product = new Product();
						product.setTypeCode(rs.getString("TYPECODE"));
						product.setProductName(rs.getString("PRODUCTNAME"));
						product.setPrice(rs.getInt("PRICE"));
						product.setCalorie(rs.getInt("CALORIE"));
						product.setImage(rs.getString("IMAGE"));

<<<<<<< HEAD
						setproducts.add(product);
=======
						setproducts.getProducts().add(product);
>>>>>>> takimoto/brach
					}
					productsM.put(key.get(i), setproducts);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;

			}

			return productsM ;

		}
	}

