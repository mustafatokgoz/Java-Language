/**
 * Main Class
 * @author mustafa
 *
 */
public class Main {
	public static void main(String[] args) {
		MaxHeap<AgeData> obj = new MaxHeap<AgeData>();
		obj.add(new AgeData(10));
		obj.add(new AgeData(5));
		obj.add(new AgeData(70));
		obj.add(new AgeData(10));
		obj.add(new AgeData(50));
		obj.add(new AgeData(5));
		obj.add(new AgeData(15));
		
		System.out.println(obj.toString());
		System.out.println("Number of people that is older than 10");
		System.out.println(obj.olderThan(10));
		
		System.out.println("After removing 10");
		obj.remove(new AgeData(10));
		String heapstr=obj.toString();
		System.out.println(heapstr);
		System.out.println("Number of people that is younger than 13");
		System.out.println(obj.youngerThan(13));
		System.out.println("finding ageData(10) "+ obj.find(new AgeData(10)).toString());
		
	}
}
