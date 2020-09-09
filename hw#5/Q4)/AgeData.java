/**
 * This is AgeData Class to handle ages
 * @author mustafa
 *
 */
public class AgeData implements Comparable<AgeData>{
		/**
	 	* age and counter of number of people in that age
	 	*/
		private int age;
		private int numOfpeople;
		
		/**
		 * 1 parameter constructor 
		 * @param age
		 */
		AgeData(int age){
			if(age>0) {
			this.age=age;
			numOfpeople=1;
			}
			else {
				this.age=0;
				numOfpeople=0;
			}
		}
		
		/**
		 * getter for age
		 * @return
		 */
		public int getAge() {
			return age;
		}
		
		/**
		 * setter for age
		 * @param age
		 */
		public void setAge(int age) {
			this.age = age;
		}
		/**
		 * adding one person to number of people
		 */
		public void increaseNumOfPeople() {
			numOfpeople++;
		}
		/**
		 * decreases one person from number of people
		 */
		public void decreaseNumOfPeople() {
			numOfpeople--;
		}
		/**
		 * getter for number of people
		 * @return
		 */
		public int getNumOfpeople() {
			return numOfpeople;
		}
		
		/**
		 * setter for number of people
		 * @param numOfpeople
		 */
		public void setNumOfpeople(int numOfpeople) {
			this.numOfpeople = numOfpeople;
		}
		
		/**
		 * CompateTo method to compare number of people in that age
		 */
		@Override
		public int compareTo(AgeData obj) {
				if(obj.numOfpeople<this.numOfpeople)
					return 1;
				if(obj.numOfpeople>this.numOfpeople) 
					return -1;
				else
					return 0;
		}
		/**
		 * toString method to show age and number of people in that age
		 */
		@Override
		public String toString() {
			
			return  String.format("%s - %s",this.age,this.numOfpeople);
		}
		
}

