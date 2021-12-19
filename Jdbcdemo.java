package com.mysql;

import java.util.ArrayList;
import java.sql.*;

public class Jdbcdemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb", "root", "root");

		 addrecord(con );
		 deleteRecord(con);
		 updateRecord(con);
         fetchtheRecord(con);

		con.close();

	}

	public static void addrecord(Connection con) throws SQLException {

		if (con != null) {

			String s = "insert into emp values (200,'s','delhi')";

			Statement stmt = con.createStatement();

			stmt.executeUpdate(s);
			System.out.println("added successfully");

		} else
			System.out.println("connection failed");

	}

	public static void deleteRecord(Connection con) throws SQLException {

		if (con != null) {

			String s = "delete from emp where id='102'";

			Statement stmt = con.createStatement();
			System.out.println("record deleted");
			stmt.execute(s);
			// System.out.println("record deleted");
		} else {

			System.out.println("connection failed");

		}

	}

	public static void updateRecord(Connection con) throws SQLException {

		if (con != null) {

			String s = "update emp set name ='ram' where name='s'";

			Statement stmt = con.createStatement();

			stmt.execute(s);
			System.out.println("record updated");
		} else {

			System.out.println("connection failed");
		}

	}

	public static void fetchtheRecord(Connection con) throws SQLException

	{
		if (con != null) {
			String s = "select * from emp where id=200";

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(s);

			while (rs.next()) {
				System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3));

			}
		} else {

			System.out.println("connection failed");
		}

	}

}
