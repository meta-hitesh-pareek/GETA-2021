package assignment1;

import assignment1.Products;

/**Class to store items added to the cart
 * 
 * @author Hitesh Pareek
 *@since 26-02-2021
 */
public class Cart {
	
	static int totalItems=0;
	static float totalPrice=0;
	static Items cartItems[]=new Items[4];
  
	/**Method to display cart items
	 * 
	 * @return Print all items which are in the cart
	 */
	public void showCartItems()
	{
		int index=0;
		while(cartItems[index]!=null)
		{ 
			if(cartItems[index].itemStock>0)
			{
			System.out.print(cartItems[index].itemName+" "+cartItems[index].itemStock);
			System.out.println();
			}
		    index++;
		}
	}
	
	/**Method to generate bill of the cart items
	 * 
	 * @return total price
	 */
	public void generateBill()
	{
		System.out.println("Thanks for shopping, your total bill is "+totalPrice);	
	}
	
	/**Method to add item to the cart
	 * @param Id of the item to be added
	 */
	public void addItemToCart(int id)
	{
	  int cartIndex=0;
	  int productIndex=0;
	  
      while(cartItems[cartIndex]!=null)	
      {
    	if(cartItems[cartIndex].itemNo==id)
    	{
    	  int cartItemNo=cartItems[cartIndex].itemNo;
    	  
    	  for(productIndex=0;productIndex<Products.allProducts.length;productIndex++)
    	  {
    		  if(Products.allProducts[productIndex].itemNo==cartItemNo)
    		  {
    			  if(Products.allProducts[productIndex].itemStock>=1)
    			  {
    				  Products.allProducts[productIndex]=new Items(Products.allProducts[productIndex].itemNo,Products.allProducts[productIndex].itemName, Products.allProducts[productIndex].itemPrice,Products.allProducts[productIndex].itemStock-1);
    				  cartItems[cartIndex]=new Items( cartItems[cartIndex].itemNo,cartItems[cartIndex].itemName,cartItems[cartIndex].itemPrice,cartItems[cartIndex].itemStock+1);
    				  totalPrice+=cartItems[cartIndex].itemPrice;
    				  System.out.println("item added to the cart");
    				  return;
    			  }
    			  else
    			  {
    				  System.out.println("No more item of this type available\n");
    				  return;
    			  }
    		  }
    	  }
    	}
    	cartIndex++;
      }
      for(productIndex=0;productIndex<Products.allProducts.length;productIndex++)
      {
    	  if(Products.allProducts[productIndex].itemNo==id)
    	  {
    		  cartItems[cartIndex]=Products.allProducts[productIndex];
    		  Products.allProducts[productIndex]=new Items(Products.allProducts[productIndex].itemNo,Products.allProducts[productIndex].itemName, Products.allProducts[productIndex].itemPrice,Products.allProducts[productIndex].itemStock-1);
    		  cartItems[cartIndex]=new Items(Products.allProducts[productIndex].itemNo,Products.allProducts[productIndex].itemName, Products.allProducts[productIndex].itemPrice,1);
    		  totalPrice+=cartItems[cartIndex].itemPrice;
    	  }
      }
	}
	
	/**Method to remove item from Cart
	 * 
	 * @param Id of the item to be removed
	 * @return Remove the specific item
	 */
	public void removeItemFromCart(int id)
	{
		  int cartIndex=0;
		  int productIndex=0;
		  
		 while(cartItems[cartIndex]!=null)	
	      {
	    	if(cartItems[cartIndex].itemNo==id)
	    	{
	    		int cartItemNo=cartItems[cartIndex].itemNo;
	    	  for(productIndex=0;productIndex<Products.allProducts.length;productIndex++)
	    	  {
	    		  if(Products.allProducts[productIndex].itemNo==cartItemNo)
	    		  {
	    			  if( cartItems[cartIndex].itemStock>=1)
	    			  {
	    				  Products.allProducts[productIndex]=new Items(Products.allProducts[productIndex].itemNo,Products.allProducts[productIndex].itemName, Products.allProducts[productIndex].itemPrice,Products.allProducts[productIndex].itemStock+1);
	    				  cartItems[cartIndex]=new Items( cartItems[cartIndex].itemNo,cartItems[cartIndex].itemName,cartItems[cartIndex].itemPrice,cartItems[cartIndex].itemStock-1);
	    				  totalPrice-=cartItems[cartIndex].itemPrice;
	    				  System.out.println("1 item of this type removed from the cart");
	    				  return;
	    			  }
	    			  else
	    			  {
	    				  System.out.println("You no more have item of this type");
	    				  return;
	    			  }
	    		  }
	    	  }
	    	}
	    	cartIndex++;
	      }
	}
}
