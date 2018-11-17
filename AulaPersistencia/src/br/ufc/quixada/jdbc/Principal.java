package br.ufc.quixada.jdbc;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Principal {
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			//System.out.println("Conectado");
			PreparedStatement ps = 
					con.prepareStatement("insert into contato" + 
									"values (default, 'mayke', 22, '1234567', 'Jucas')");
			ps.executeUpdate();
			if(1==1) throw new SQLException();
			ps = con.prepareStatement("insert into contato;");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("FIM jdbc");
	}
}
