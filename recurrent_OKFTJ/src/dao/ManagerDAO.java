package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Login;
import model.Manager;

public class ManagerDAO {
	// データベース接続に使用する情報
		  private final String JDBC_URL = "jdbc:mysql://192.168.10.18:3306/recurrent?characterEncoding=UTF-8&serverTimezone=JST";
		  private final String DB_USER = "recurrent";
		  private final String DB_PASS = "0000";

//		  public void findAll() {
		  public Manager findByLogin(Login login) {

			Manager manager = null;

		    // データベースへ接続
		    try (Connection conn = DriverManager.getConnection(
		        JDBC_URL, DB_USER, DB_PASS)) {

		      // SELECT文を準備
		      String sql = "SELECT managers_Id,pass FROM manager where managers_id=? and pass=?";
		      PreparedStatement pStmt = conn.prepareStatement(sql);
		      pStmt.setString(1, login.getId());
		      pStmt.setString(2, login.getPass());

		      // SELECTを実行し、結果表を取得
		      ResultSet rs = pStmt.executeQuery();

		      // 一致したユーザーが存在した場合
		      // そのユーザーを表すAccountインスタンスを生成
		      if (rs.next()) {
		        // 結果表からデータを取得
//		        String code = rs.getString("typecode");
		        String id = rs.getString("managers_Id");
		        String pass = rs.getString("pass");
		        manager = new Manager(id,pass);
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return null;
		    }
		    return manager;
		  }

		//登録アカウント一覧表示--------------------------------------------------
			public List<Manager> findByAccount() {

				//初期値にnullをセット
				List<Manager> managers=null;

				// データベースへ接続
				try (Connection conn = DriverManager.getConnection(
			      JDBC_URL, DB_USER, DB_PASS)) {
				  // SQL文を準備
			      String sql = "select managers_id,pass,name from manager";
			      PreparedStatement pStmt = conn.prepareStatement(sql);

			      //リザルト
			      ResultSet rs = pStmt.executeQuery();

			      //表全てをManagerクラスのArrayListに格納（NullでなければArrayListをnewする）
		    	  while(rs.next()){
		    		  if(managers==null) {
		    			  managers = new ArrayList<Manager>();
		    		  }
		    		  String id = rs.getString("managers_Id");
		    		  String pass = rs.getString("pass");
				      String name = rs.getString("name");

			    	  Manager manager=new Manager(id,pass,name);

			    	  managers.add(manager);

				  }
			    } catch (SQLException e) {
			      e.printStackTrace();
			      return null;

			    }
			    return managers;
			}


			  //ManagerアカウントID重複がないか確認----------------------------------------------------
			  public boolean isDuplicate(Manager manager) {

					boolean b=false;
					//DB接続
				try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

					//SQL文
					String sql="SELECT managers_id FROM manager WHERE managers_id=?";
					PreparedStatement pStmt=conn.prepareStatement(sql);
					pStmt.setString(1,manager.getId());
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

			//DBに新規ユーザー登録----------------------------------------------------
			public boolean registerNewManager(Manager manager) {
				boolean b=false;
				//DB接続
				try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
					//SQL文
					String sql="INSERT INTO manager(managers_id,pass,name) VALUES(?,?,?)";
					PreparedStatement pStmt=conn.prepareStatement(sql);
					pStmt.setString(1,manager.getId());
					pStmt.setString(2,manager.getPass());
					pStmt.setString(3,manager.getName());

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



