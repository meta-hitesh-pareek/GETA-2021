import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * For connection establishment with the database
 *
 * @since 20-03-2021
 * @author Hitesh Pareek
 */
public class getDbmsConnection {

	/**
	 * Initializes the connection with the database
	 * 
	 * @return Connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/get2021", "root", "root");
		
		return connection;
	}
}
