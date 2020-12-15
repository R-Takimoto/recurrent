package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.ManagerProduct;
import model.ManagerProducts;
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
					Products setproducts = new Products();
					while (rs.next()) {
						// データを取得 productクラスのインスタンス化
						Product product = new Product();
						product.setTypeCode(rs.getString("TYPECODE"));
						product.setProductName(rs.getString("PRODUCTNAME"));
						product.setPrice(rs.getInt("PRICE"));
						product.setCalorie(rs.getInt("CALORIE"));
						product.setImage(rs.getString("IMAGE"));

						setproducts.setProducts(product);
					}
					productsM.put(key.get(i), setproducts);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;

			}

			return productsM ;

		}

		//(管理画面)登録メニュー表示--------------------------------------------------
				public ManagerProducts findByMenu() {

				  //初期値にnullをセット
				  ManagerProducts managerProducts=null;

				  // データベースへ接続
				  try (Connection conn = DriverManager.getConnection(
				      JDBC_URL, DB_USER, DB_PASS)) {
					  // SQL文を準備
				      String sql = "select item,typecode,productname,price,calorie,variety,image\r\n" +
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
			    		  if(managerProducts==null) {
			    			  managerProducts = new ManagerProducts();
			    		  }
			    		  String item=rs.getString("item");
				    	  String typeCode = rs.getString("typecode");
				    	  String productName = rs.getString("productname");
				    	  int price = rs.getInt("price");
				    	  int calorie = rs.getInt("calorie");
				    	  String variety=rs.getString("variety");
				    	  String image=rs.getString("image");


				    	  ManagerProduct managerProduct=new ManagerProduct(item,typeCode,productName,price,calorie,variety,image);

				    	  managerProducts.getManagerProducts().add(managerProduct);

					  }
				    } catch (SQLException e) {
				      e.printStackTrace();
				      return null;

				    }
				    return managerProducts;
				}

				//(管理画面)メニュー登録用・typeCode重複チェック--------------------------------------------------
				public boolean isDuplicate(Product product) {
					boolean b=false;
					//DB接続
					try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

						//SQL文
						String sql="SELECT typeCode FROM product WHERE typeCode=?";
						PreparedStatement pStmt=conn.prepareStatement(sql);
						pStmt.setString(1,product.getTypeCode());
						//SQL文実行結果、返ってくる表を受け取る
						ResultSet rs=pStmt.executeQuery();

						//IDが一致するアカウントがなければtrue,重複していればfalse(初期値)を返す
						if(!rs.next()) {
							b= true;
						}
					}catch(SQLException e) {
						e.printStackTrace();
						return false;
					}
					return b;

				}
				//(管理画面)メニュー内容更新--------------------------------------------------
				public boolean UpdateMenu(Product product) {
					boolean b=false;
					//DB接続
					try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
						//SQL文
						String sql="UPDATE product SET typecode=?,item_varietyId=?, productname=?,price=?,calorie=?,image=? WHERE typecode=?";
						PreparedStatement pStmt=conn.prepareStatement(sql);
						pStmt.setString(1,product.getTypeCode());
						pStmt.setString(2,product.getItem_varietyId());
						pStmt.setString(3,product.getProductName());
						pStmt.setInt(4,product.getPrice());
						pStmt.setInt(5,product.getCalorie());
						pStmt.setString(6,product.getImage());
						pStmt.setString(7,product.getTypeCode());
						//SQL文実行結果、返ってくる値を受け取る
						int result=pStmt.executeUpdate();
						//成功＝1、失敗＝0が返ってくる
						if(result==1) {
							b= true;
						}
					}catch(SQLException e) {
						e.printStackTrace();
						return false;
					}
					return b;
				}

				//(管理画面)メニュー削除--------------------------------------------------
				public boolean deleteMenu(Product product) {
					boolean b=false;
					//DB接続
					try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
						//SQL文
						String sql="delete from product WHERE typecode=?";
						PreparedStatement pStmt=conn.prepareStatement(sql);
						pStmt.setString(1,product.getTypeCode());

						//SQL文実行結果、返ってくる値を受け取る
						int result=pStmt.executeUpdate();
						//成功＝1、失敗＝0が返ってくる
						if(result==1) {
							b= true;
						}
					}catch(SQLException e) {
						e.printStackTrace();
						return false;
					}
					return b;
				}

				//(管理画面)DBに新規メニュー登録--------------------------------------------------
				public boolean registerNewProduct(Product product) {
					boolean b=false;
					//DB接続
					try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
						//SQL文
						String sql="INSERT INTO product(typecode,item_varietyId,productname,price,calorie,image) VALUES(?,?,?,?,?,?)";
						PreparedStatement pStmt=conn.prepareStatement(sql);
						pStmt.setString(1,product.getTypeCode());
						pStmt.setString(2,product.getItem_varietyId());
						pStmt.setString(3,product.getProductName());
						pStmt.setInt(4,product.getPrice());
						pStmt.setInt(5,product.getCalorie());
						pStmt.setString(6,product.getImage());


						//SQL文実行結果、返ってくる値を受け取る
						int result=pStmt.executeUpdate();

						//成功＝1、失敗＝0が返ってくる
						if(result==1) {
							b= true;
						}
					}catch(SQLException e) {
						e.printStackTrace();
						return false;
					}
					return b;
				}
	}

