package aplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {
	
	public static void main(String[] args) {
		
		
		
	
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
		
			conn = DB.getConnection();
			st = conn.prepareStatement(
				"UPDATE seller " 
				+ "SET BaseSalary = BaseSalary - ? "
				+ "WHERE "
				+ "(DepartmentId = ? )", Statement.RETURN_GENERATED_KEYS);
		
			st.setDouble(1, 200);
			st.setInt(2, 2);
			
			/*int row = st.executeUpdate();
			
			System.out.println("Done! AffectRow: " + row);
			*/
			ResultSet rs = st.getGeneratedKeys();
			
				while(rs.next()) {
					System.out.println(rs.getString("DepartmentId"));
				}
		

			
		
		}catch(SQLException e){
			e.printStackTrace();
			
		}/*catch (ParseException e) {
			e.printStackTrace();
		}*/
		
		
		finally {
		DB.closeStatament(st);
		DB.closeConnection();
		
		}
		
		
		

		}
		
	}

