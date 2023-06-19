package feladat2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

public class DbHandle {
	private static String dbName = "ingatlan_db";
	private static String dbUser = "root";
	private static String dbPassword = "";
	private static String dbPort = "3306";
	private static String dbUrl = "localhost";

	private Connection connect() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + dbUrl + ":" + dbPort + "/" + dbName + "", dbUser,
					dbPassword);
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "nem sikerült kapcsolódni");
		}
		return con;

	}

	public void fillList(List<Ingatlan> lista) {
		Statement stmt;

		try (Connection con = connect();) {

			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from ingatlanok");
			while (rs.next()) {
				lista.add(new Ingatlan(rs.getString("tulajdonos"), rs.getString("helyrajzi_szam"),
						rs.getInt("alapterulet"), rs.getInt("becsult_ertek")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteHouseByHsz(String helyrajzi_szam) {
		try (Connection con = connect();) {
			String sql = "DELETE FROM ingatlanok where helyrajzi_szam=?";
			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, helyrajzi_szam);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void modifyPriceByhSz(String helyrajzi_szam,int ujAr) {
		try (Connection con = connect();) {
			String sql = "update ingatlanok set becsult_ertek=? where helyrajzi_szam=?";
			PreparedStatement query = con.prepareStatement(sql);
			query.setInt(1, ujAr);
			query.setString(2, helyrajzi_szam);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
