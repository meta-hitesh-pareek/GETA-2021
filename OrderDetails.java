import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Stores the order details
 * 
 * @since 20-03-2021
 * @author Hitesh Pareek
 */
public class OrderDetails {

	static List<OrderDetails> ordersList = new LinkedList<OrderDetails>();
	String orderId;
	Date orderTime;
	int orderTotal;

	/**
	 * Initializes the order details
	 * 
	 * @param orderId
	 * @param orderTime
	 * @param orderTotal
	 */
	OrderDetails(String orderId, Date orderTime, int orderTotal) {
		if (orderId == null || orderTime == null) {
			throw new NullPointerException("orderId,orderTime can not be null");
		}if(orderTotal<0) {
			throw new IllegalArgumentException("Order toal can no be negative value");
		}
		this.orderId = orderId;
		this.orderTime = orderTime;
		this.orderTotal = orderTotal;
	}

	/**
	 * Get the order id
	 * 
	 * @return orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * Set the order id
	 * 
	 * @param orderId
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * Get the time when the order was placed
	 * 
	 * @return orderTime
	 */
	public Date getOrderTime() {
		return orderTime;
	}

	/**
	 * Set the order time
	 * 
	 * @param orderTime
	 */
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	/**
	 * Get the total amount of the order
	 * 
	 * @return orderTotal
	 */
	public int getOrderTotal() {
		return orderTotal;
	}

	/**
	 * Set the order total
	 * 
	 * @param orderTotal
	 */
	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}
}
