import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



class Products
{
	public static Map<Integer,Item> allitems=new HashMap<Integer,Item>();
	public void addItemsToStore()
	{
		allitems.put(1, new Item(1,"soap",20,10));
		allitems.put(2,new Item(2,"toothpaste",40,6));
		allitems.put(3,new Item(3,"sugar",60,4));
		allitems.put(4,new Item(4,"oil",60,6));
		
	}
	public void displayItem()
	{
		System.out.println("choose from below options");
		for(Map.Entry<Integer, Item> entry:allitems.entrySet())
		{
		 System.out.println(entry.getKey()+" "+entry.getValue().itemname+" "+entry.getValue().itemprice+" " +entry.getValue().itemstock);
		}
		
		
	}
		
}
class Item
{
	String itemname;
	int itemno,itemprice,itemstock;
	
	Item(int itemno,String itemname,int itemprice,int itemstock)
	{
	  this.itemno=itemno;
	  this.itemname=itemname;
	  this.itemprice=itemprice;
      this.itemstock=itemstock;
	}
	
		
}
public class DemoShopping {
	static int totalprice=0;
	static Map<Integer,Item> cartitems=new HashMap<Integer,Item>();
	
	public static void geneateBill(Map<Integer,Item> cartitems)
	{
		for(Map.Entry<Integer,Item> map:cartitems.entrySet())
		{
			totalprice=totalprice+(map.getValue().itemstock * map.getValue().itemprice);
			
		}
		System.out.println(totalprice);
		
	}
	public static void displayCart(Map<Integer,Item> cartmap)
	{
		for(Map.Entry<Integer,Item> map:cartmap.entrySet())
		{
			System.out.println(map.getKey()+" "+map.getValue().itemname+" "+map.getValue().itemprice+" "+map.getValue().itemstock);
			
		}
		
	}
	
	public static void main(String args[])
	{
	 Scanner sc=new Scanner(System.in);
     Products p=new Products();
     
     p.addItemsToStore();
     
	 boolean flag=true;
	
	 
	 
	 while(flag)
	 {
		 System.out.println();
		 p.displayItem();
		 System.out.println();
		 
		 System.out.println("Enter 0 to end shopping\n"
		 		+ "Enter 1 to add item to the cart\n"
		 		+ "Enter 2 to remove item from the cart\n"
		 		+ "Enter 3 to display cart items\n"
		 		+ "Enter 4 to exit and generate bill\n");
		 
		 char option=sc.next().charAt(0);
		 if(option=='1')
		 {
			 System.out.println("enter item number that you want to add");
     		 int itemnumber=sc.nextInt();
     		 System.out.println("how many items you want to add");
     		 int quantity=sc.nextInt();
     		 if(p.allitems.containsKey(itemnumber) && p.allitems.get(itemnumber).itemstock>=quantity)
     		 {
     			 cartitems.put(itemnumber, new Item(itemnumber, p.allitems.get(itemnumber).itemname, p.allitems.get(itemnumber).itemprice, quantity));
     		   p.allitems.put(itemnumber,  new Item(itemnumber, p.allitems.get(itemnumber).itemname, p.allitems.get(itemnumber).itemprice, (p.allitems.get(itemnumber).itemstock)-quantity)); 
     		 }
     		 else if(!p.allitems.containsKey(itemnumber))
     			 System.out.println("no such item available");
     		 else
     			 System.out.println("item out of stock");
		
		
	 }
		 else if(option =='2')
		 {
			 System.out.println("enter item number that you want to remove");
     		 int itemnumber=sc.nextInt();
     		 System.out.println("how many items you want to remove");
     		 int quantity=sc.nextInt();
     		 if(cartitems.containsKey(itemnumber) && cartitems.get(itemnumber).itemstock>=quantity)
     		 {
     			 cartitems.put(itemnumber, new Item(itemnumber, p.allitems.get(itemnumber).itemname, p.allitems.get(itemnumber).itemprice,cartitems.get(itemnumber).itemstock-quantity));
     		     p.allitems.put(itemnumber,  new Item(itemnumber, p.allitems.get(itemnumber).itemname, p.allitems.get(itemnumber).itemprice, (p.allitems.get(itemnumber).itemstock)+quantity)); 
     		 }
     		 else if(!cartitems.containsKey(itemnumber))
     			 System.out.println("no such item available");
     		 else
     			 System.out.println("So much items not present in your cart");
		
			 
		 }
		 else if(option=='4')
		 {
			 System.out.print("Your Total bill generated is:-");
		geneateBill(cartitems);
		    System.out.println("Thank you for shopping");
		    flag=false;
		 } 
		 else if(option=='3')
		 {
			 displayCart(cartitems);
		 }
		 else if(option==0)
		 {
			 flag=false;
		 }
		 
	 }
	 
   }
}