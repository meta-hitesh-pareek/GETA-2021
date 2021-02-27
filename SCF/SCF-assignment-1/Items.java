package assignment1;

class Items
{
	 String itemName;
     int itemNo,itemPrice,itemStock;
	
	Items(int itemNo,String itemName,int itemPrice,int itemStock)
	{
	  this.itemNo=itemNo;
	  this.itemName=itemName;
	  this.itemPrice=itemPrice;
      this.itemStock=itemStock;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemStock() {
		return itemStock;
	}

	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}

}