import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * Connects with the database and performs multiple queries
 *
 * @since 20-03-2021
 * @author Hitesh Pareek
 */
public class JDBCConnect {

	/**
	 * Fetches orders from the database
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void fetchOrders(String customerId) throws SQLException,
			ClassNotFoundException {

		Connection jdbcConnection = getDbmsConnection.getConnection();
		PreparedStatement queryStatement = jdbcConnection
				.prepareStatement("select customer_order.order_id,customer_order.order_date,customer_order.order_total from customer join customer_order on customer_order.customer_id= customer.customer_id join items on customer_order.order_id =items.order_id where customer_order.customer_id= ? and customer_order.order_id not in(select order_id from items where shipping_status=0) group by order_id order by customer_order.order_date desc;");
		queryStatement.setString(1, customerId);
		ResultSet result = queryStatement.executeQuery();
		
		while (result.next()) {
			OrderDetails orders = new OrderDetails(
					result.getString("order_id"), result.getDate("order_date"),
					result.getInt("order_total"));
			orders.ordersList.add(orders);
		}
	}

	/**
	 * Insert Images into the database table using batch insertion
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public int[] setImage() throws ClassNotFoundException, SQLException,
			FileNotFoundException {
		Connection jdbcConnection = getDbmsConnection.getConnection();
		PreparedStatement queryStatement = jdbcConnection
				.prepareStatement("Insert into images values(?,?,?,?)");
		InputStream input = new FileInputStream(
				"C:\\Users\\hitesh.pareek_metacu\\Desktop\\sample.png");
		
		queryStatement.setString(1, "1");
		queryStatement.setString(2, "102");
		queryStatement.setString(3, "sampleImage1");
		queryStatement.setBlob(4, input);
		queryStatement.addBatch();
		queryStatement.clearParameters();

		input = new FileInputStream(
				"C:\\Users\\hitesh.pareek_metacu\\Desktop\\sample2.png");
		queryStatement.setString(1, "2");
		queryStatement.setString(2, "101");
		queryStatement.setString(3, "sampleImage2");
		queryStatement.setBlob(4, input);
		queryStatement.addBatch();
		queryStatement.clearParameters();

		input = new FileInputStream(
				"C:\\Users\\hitesh.pareek_metacu\\Desktop\\sample3.png");
		queryStatement.setString(1, "3");
		queryStatement.setString(2, "103");
		queryStatement.setString(3, "sampleImage3");
		queryStatement.setBlob(4, input);
		queryStatement.addBatch();
		queryStatement.clearParameters();

		input = new FileInputStream(
				"C:\\Users\\hitesh.pareek_metacu\\Desktop\\sample4.png");
		queryStatement.setString(1, "4");
		queryStatement.setString(2, "104");
		queryStatement.setString(3, "sampleImage4");
		queryStatement.setBlob(4, input);
		queryStatement.addBatch();
		queryStatement.clearParameters();

		input = new FileInputStream(
				"C:\\Users\\hitesh.pareek_metacu\\Desktop\\sample5.png");
		queryStatement.setString(1, "5");
		queryStatement.setString(2, "104");
		queryStatement.setString(3, "sampleImage5");
		queryStatement.setBlob(4, input);
		queryStatement.addBatch();
		queryStatement.clearParameters();

		int[] result=queryStatement.executeBatch();
		
		return result;
	}

	/**
	 * Removes product from database
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 */
	public int removeProducts() throws SQLException, ClassNotFoundException,
			FileNotFoundException {
		Connection jdbcConnection = getDbmsConnection.getConnection();
		Statement queryStatement = jdbcConnection.createStatement();
		int result = queryStatement
				.executeUpdate("delete from product where product_id in(select product_id from items where order_id not in (select order_id from customer_order where datediff(current_timestamp,customer_order.order_date)<360))");
		return result;
	}

	/**
	 * Get the parent categories information present in the database
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void getParentCategories() throws ClassNotFoundException,
			SQLException {
		Connection jdbcConnection = getDbmsConnection.getConnection();
		Statement queryStatement = jdbcConnection.createStatement();
		ResultSet result = queryStatement
				.executeQuery("select t2.category_name,t1.count from category as t2 join (select parent_category,count(*) as count from category where parent_category in(select category_id from category where parent_category is null) group by parent_category) as t1 on t1.parent_category = t2.category_id order by t2.category_name;");
		
		while (result.next()) {
			String categoryName = result.getString("category_name");
			int count = result.getInt("count");
			ParentCategories.categoryList.add(new ParentCategories(
					categoryName, count));
		}
	}
}
