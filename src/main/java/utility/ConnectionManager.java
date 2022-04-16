package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	private static final String driverClass;
	private static final String url;
	private static final String username;
	private static final String password;
	static {
		driverClass = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost/dbname";
		username = "root";
		password = "examly";
	}
	static { 
        try { 
            Class.forName(driverClass); 
        } catch (ClassNotFoundException e) { 
            e.printStackTrace(); 
        } 
    }

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	public static void closeAll(ResultSet rs, Statement st, Connection con) {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

