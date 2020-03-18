import java.util.ArrayList;
/**
 * This is Administrator Class that adds and removes branches
 * @author Mustafa Tokgöz 171044077
 *
 */
public class Administrator extends EnteringSystemForAdmin{
		/**
		 * This is branches arraylist
		 * @param branches
		 */
		private ArrayList<Branch> branches=new ArrayList<Branch>();
		/**
		 * This method adding branch to branches arraylist
		 */
		@Override
		public void addBranch(AbstractBranch abranch) {
			branches.add((Branch)abranch);
		}
		/**
		 * getBranch method gets the branch arralist's i'th element
		 * @param index
		 * @return Branch
		 */
		@Override
		public Branch getBranch(int  index) {
			if(index<0 || index>branches.size()-1) {
				 throw new ArrayIndexOutOfBoundsException();
			}
			return branches.get(index);
		}
		/**
		 * This is removeing that index brach
		 * @param index
		 */
		@Override
		public void removeBranch(int index) {
			if(index<0 || index>branches.size()-1) {
				 throw new ArrayIndexOutOfBoundsException();
			}
			branches.remove(index);
		}
		/**
		 * This is getter for branch size
		 * @return
		 */
		@Override
		public int getBranchsize() {
			return branches.size();
		}
		/**
		 * This method works when administrator login the system
		 * @param password
		 * @return true if equal to password
		 */
		@Override
		public boolean login(String pw) {
			if(getPassword().equals(pw)) {
				return true;
			}
			return false;
		}

}
