package hi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	private void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void getClose() {

		try {

			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<String> select(String name) {
		ArrayList<String> list = new ArrayList<String>();

		try {
			getConnection();

			String sql = "select nutrient from nutrients where nutrition_classification = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();

			while (rs.next()) {

				String nutrient = rs.getString("nutrient"); // 컬림이름 or 몇번째 컬럼인지

				list.add(nutrient);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return list;
	}

	public String select_efficacy(String efficacy) {
		String efficacy1 = "";

		try {
			getConnection();

			String sql = "select efficacy from nutrients where nutrient LIKE ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + efficacy + "%");
			rs = psmt.executeQuery();

			if (rs.next()) {
				efficacy1 = rs.getString(1);

//				String nutrient = rs.getString(2); // 컬림이름 or 몇번째 컬럼인지
//				System.out.println(nutrient);
//				list.add(nutrient);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return efficacy1;
	}

	public String select_precautions(String precautions) {
		String precautions1 = "";
		try {
			getConnection();

			String sql = "select precautions from nutrients where nutrient LIKE ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + precautions + "%");
			rs = psmt.executeQuery();

			if (rs.next()) {
				precautions1 = rs.getString("precautions"); // 컬림이름 or 몇번째 컬럼인지

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return precautions1;
	}
	
	public String select_title(String title) {
		String title1 = "";
		try {
			getConnection();

			String sql = "select nutrient from nutrients where nutrient LIKE ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + title + "%");
			rs = psmt.executeQuery();

			if (rs.next()) {
				title1 = rs.getString("nutrient"); // 컬림이름 or 몇번째 컬럼인지

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return title1;
	}

}
