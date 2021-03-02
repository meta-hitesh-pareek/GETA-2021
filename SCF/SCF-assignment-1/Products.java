package assignment1;

import assignment1.Items;

/**Class for Storing the details of products available in the store
 * 
 * @author Hitesh Pareek
 *
 */
class Products
{
   static Items item1=new Items(1,"oil",20,10);
   static Items item2=new Items(2,"sugar",10,10);
   static Items item3=new Items(3,"toothPaste",40,10);
   static Items item4=new Items(4,"Salt",5,10);
   static Items allProducts[]= {item1,item2,item3,item4};
   
  /**Method to show products available in Store
   * @param void
   * @return void 
   */
   public static void showProducts()
   {
	for(int productIndex=0;productIndex<allProducts.length;productIndex++)
	{
	 System.out.print("Id "+allProducts[productIndex].itemNo+" Name: "+allProducts[productIndex].itemName+" price: "+allProducts[productIndex].itemPrice+" stock: "+allProducts[productIndex].itemStock);
	}
   }
}