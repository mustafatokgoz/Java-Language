/**
 * This Abstract Class for Administrator
 * @author Mustafa Tokgöz 171044077
 *
 */
public abstract class EnteringSystemForAdmin extends EnteringSystem{
	public abstract void addBranch(AbstractBranch abranch);
	public abstract Branch getBranch(int  index);
	public abstract void removeBranch(int index);
	public abstract int getBranchsize();
}
