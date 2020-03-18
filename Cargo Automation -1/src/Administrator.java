/**
 * This is Administrator Class that adds and removes branches
 * @author Mustafa Tokgöz 171044077
 *
 */
public class Administrator {
		/**
		 * This is branches array
		 * @param branches
		 */
		 Branch branches[];
		 /**
		  * These are size of branch and capacity of branch
		  * @param branchsize @param branchcapacity
		  */
		private int branchsize;
		private int branchcapacity;
		

		/**
		 * This is no parameter Contructer
		 */
		Administrator(){
			branches = new Branch[10];
			this.branchsize=0;
			this.branchcapacity=10;
		}
		/**
		 * This is adding a new Branch to branches
		 */
		public void addBranch() {

			if(branchsize==branchcapacity) {
				Branch[] temp = new Branch[branchcapacity*2];
				for(int i=0;i<branchcapacity;i++) {
					temp[i]=branches[i];
				}
				branches = temp;
				branchcapacity = branchcapacity*2;
			}
			branchsize++;
		}
		/**
		 * This is removeing that index brach
		 * @param index
		 */
		public void removeBranch(int index) {
			for(int j=index;j<branchsize;j++) {
				branches[j]=branches[j+1];
			}
			branchsize--;
		}
		/**
		 * This is getter for branch size
		 * @return
		 */
		public int getBranchsize() {
			return branchsize;
		}
		/**
		 * This is setter for branch size
		 * @param branchsize
		 */
		public void setBranchsize(int branchsize) {
			this.branchsize = branchsize;
		}
		/**
		 * This is getter for branch capacity
		 * @return
		 */
		public int getBranchcapacity() {
			return branchcapacity;
		}
		/**
		 * This is setter for branch capacity
		 * @param branchcapacity
		 */
		public void setBranchcapacity(int branchcapacity) {
			this.branchcapacity = branchcapacity;
		}
}
