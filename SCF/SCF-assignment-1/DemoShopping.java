package assignment1;

import java.util.Scanner;

/**Main class to start shopping
 * @since 26-02-2021
 * @author Hitesh Pareek
 *
 */
public class DemoShopping {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		Cart cart=new Cart();
		boolean option=true;
		
		while(option==true)
		{
			 Products.showProducts();
			 System.out.println("\nEnter 0 to end shopping\n"
				 		+ "Enter 1 to add item to the cart\n"
				 		+ "Enter 2 to remove item from the cart\n"
				 		+ "Enter 3 to display cart items\n"
				 		+ "Enter 4 to exit and generate bill\n");
			 
			 char userOption=sc.next().charAt(0);
			 switch(userOption)
			 {
			   case '0':
			   {
				   System.out.println("Thank You for shopping");
				   option=false;
				   break;
			   }
			   case '1':
			   {
				   System.out.println("enter id of the item");
				   int id=sc.nextInt();
				   cart.addItemToCart(id);
				   break;
			   }
			   case '2':
			   {
				   System.out.println("enter item id to remove");
				   int id=sc.nextInt();
				   cart.removeItemFromCart(id);
				   break;
			   }
			   case '3':
			   {
				   cart.showCartItems();
				   break;
			   }
			   case '4':
			   {
				   cart.generateBill();
				   option=false;
				   break;
			   }
			 }
		}
		sc.close();
	}
}