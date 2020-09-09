/**
 * Main Class
 * @author mustafa
 *
 */
public class Main {
	public static void main(String args[]) {
		AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();
		ageTree.add(new AgeData(10));
		ageTree.add(new AgeData(20));
		ageTree.add(new AgeData(5));
		ageTree.add(new AgeData(10));
		ageTree.add(new AgeData(15));
		
		System.out.println(ageTree.toString());
		
		System.out.println("Number of old people than 10");
		System.out.println(ageTree.olderThan(10));
		
		System.out.println("Number of young people than 15");
		System.out.println(ageTree.youngerThan(15));
		
		System.out.println("finding age 20 = "+ ageTree.find(new AgeData(20)).toString());
		System.out.println("removing 10 "+ageTree.remove(new AgeData(10)));
		
		System.out.println(ageTree.toString());
	
	}
}
