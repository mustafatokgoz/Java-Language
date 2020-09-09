/**
 * Software Class
 * @author mustafa
 *
 */
public class Software implements Comparable<Software>{
		private String name;
		private int quantity;
		private double price;
		/**
		 * 3 parameter constructor
		 * @param name
		 * @param quantity
		 * @param price
		 */
		Software(String name , int quantity, double price){
			this.name=name;
			this.quantity=quantity;
			this.price=price;
		}
		/**
		 * getter for name
		 * @return
		 */
		public String getName() {
			return name;
		}
		/**
		 * setter for name
		 * @param name
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * getter for quantity
		 * @return
		 */
		public int getQuantity() {
			return quantity;
		}
		/**
		 * setter for quantity
		 * @param quantity
		 */
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		/**
		 * getter for price 
		 * @return
		 */
		public double getPrice() {
			return price;
		}
		/**
		 * setter for price
		 * @param price
		 */
		public void setPrice(double price) {
			this.price = price;
		}
		/**
		 * ToString method
		 */
		@Override
		public String toString() {
			return "Name : " + this.name + "  " + "Quantity : " + this.quantity + "  " + "Price : " + this.price;  
		}
		/**,
		 * Compare to method
		 */
		@Override
		public int compareTo(Software arg0) {
			if(this.name.compareTo(arg0.name)>0)
				return 1;
			else if (this.name.compareTo(arg0.name)<0)
				return -1;
			else
				return 0;
		}
		
}
