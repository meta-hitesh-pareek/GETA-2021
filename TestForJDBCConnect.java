import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

/**
 * Test methods of JDBCConnect
 * 
 * @since 21-03-2021
 * @author Hitesh Pareek
 */
public class TestForJDBCConnect {

	@Test
	public void test_ForFetchOrders_When_CustomerId_DoesNotExists_Expected_SQLException() {
		try {
			String id = "1";
			JDBCConnect test = new JDBCConnect();
			try {
				test.fetchOrders(id);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
	}

	@Test
	public void test_ForFetchOrders_When_ValidIdIsPassed_Expected_Integer() {
		String id = "1";
		JDBCConnect test = new JDBCConnect();

		/*
		 * As we have stored order details in a list we expect the order total
		 * for id="1" is 200 So as we remove last inserted data from orderList,
		 * its order total is 200
		 */
		assertEquals(200, OrderDetails.ordersList.remove(0).orderTotal);
	}

	@Test
	public void test_ForSetImage_Expected_Integer()
			throws FileNotFoundException, SQLException, ClassNotFoundException {
		JDBCConnect test = new JDBCConnect();
		Connection jdbcConnection = getDbmsConnection.getConnection();
		PreparedStatement queryStatement = jdbcConnection
				.prepareStatement("Insert into images values(?,?,?,?)");
		InputStream input = new FileInputStream(
				"C:\\Users\\hitesh.pareek_metacu\\Desktop\\sample.png");
		input = new FileInputStream(
				"C:\\Users\\hitesh.pareek_metacu\\Desktop\\sample5.png");

		queryStatement.setString(1, "5");
		queryStatement.setString(2, "104");
		queryStatement.setString(3, "sampleImage5");
		queryStatement.setBlob(4, input);
		int result = queryStatement.executeUpdate();

		assertEquals(1, result);
	}

	@Test
	public void test_ForRemoveProducts_Expected_Integer() throws SQLException,
			ClassNotFoundException, FileNotFoundException {
		JDBCConnect test = new JDBCConnect();

		assertEquals(1, test.removeProducts());
	}

	@Test
	public void test_ForGetParentCategories_Expected_String()
			throws SQLException, ClassNotFoundException {
		JDBCConnect test = new JDBCConnect();
		test.getParentCategories();

		/*
		 * As we have stored parent categories in a list we expect the last
		 * entered category name as "cosmetics" So as we remove last inserted
		 * data from orderList, the category was cosmetics
		 */
		assertEquals("cosmetics",
				ParentCategories.categoryList.remove(0).categoryName);
	}
}