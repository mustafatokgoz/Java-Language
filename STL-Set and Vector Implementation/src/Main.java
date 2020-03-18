import java.lang.IllegalArgumentException;
/**
 * This is Main Class for testing GTUSet GTUVector and GTUContainer Classes
 * @author Mustafa Tokgöz
 *
 */
public class Main {
	/**
	 * This is testing all of Classes that I wrote
	 * @param args
	 */
	public static void main(String[] args) {
		GTUSet<String> object = new GTUSet<String>();
		GTUContainer<String>.GTUIterator iterator;
		System.out.println("I will insert respectivly to GTUSet 1,2,3,4 as string and I will clear the set");
        try{
        object.insert("1");
        object.insert("2");
        object.insert("3");
        object.insert("4");
        object.clear();
       
        System.out.println("Then I insert respectivly 5,6,7,7 as string so This throws an exeption becouse it is set and I try to insert 7 two times");

        object.insert("5");
        object.insert("6");
        object.insert("7");
        object.insert("7");
        }
        catch(IllegalArgumentException e){
            System.out.println(e);
        } 
        
        System.out.println("This object's size is  "+object.size());
        System.out.println("I use method iterator here to show inside the set");
        iterator=object.iterator();  
        System.out.printf("Set= ");
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println("I erase 5 from GTUSet object now");
        object.erase("5");
        System.out.println("I use method iterator here to show inside the set");
        iterator=object.iterator();  
        System.out.printf("Set= ");
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println("This object's size is  "+object.size());
        System.out.println("This object's maximum size is  "+object.max_size());
        if(object.empty()==false)
        	System.out.println("This object is NOT Empty");
        else
        	 System.out.println("This object is Empty");
        System.out.println("This object contains a string that is 6 is "+object.contains("6"));
        System.out.println("This object contains a string that is 3 is "+object.contains("3"));
        
        
        GTUVector<Integer> obje = new GTUVector<Integer>();
    	GTUContainer<Integer>.GTUIterator iterator2;
    	System.out.println("Now I try to insert respectivly to GTUVector 1,2,3,4 as integer and I clear the Vector");
        try{
        	obje.insert(1);
            obje.insert(2);
            obje.insert(3);
            obje.insert(4);
            obje.clear();
        	System.out.println("Then try to insert respectivly to GTUVector 5,6,7,7 as integer so This is not a problem becouse This is vector and 7 can use two or more times");

            obje.insert(5);
            obje.insert(6);
            obje.insert(7);
            obje.insert(7);
            }
            catch(IllegalArgumentException e){
                System.out.println(e);
            }
        	System.out.println("I use method iterator here to show inside the vector");
            iterator2=obje.iterator();  
            System.out.printf("Vector= ");
            while(iterator2.hasNext()){
                System.out.print(iterator2.next() + " ");
            }
            System.out.println();
            System.out.println("This object's size is  "+obje.size());
            System.out.println("This object's maximum size is  "+obje.max_size());
            System.out.println("I erase 7 from GTUVector obje now");
            obje.erase(7);
        	System.out.println("I use method iterator here to show inside the vector");
            iterator2=obje.iterator();  
            System.out.printf("Vector= ");
            while(iterator2.hasNext()){
                System.out.print(iterator2.next() + " ");
            }
            System.out.println();
            System.out.println("This object's size is  "+obje.size());
            System.out.println("This object's maximum size is  "+obje.max_size());
            if(obje.empty()==false)
            	System.out.println("This object is NOT Empty");
            else
            	System.out.println("This object is  Empty");
            System.out.println("This object contains a integer that is 6 is "+obje.contains(6));
            System.out.println("This object contains a integer that is 3 is "+obje.contains(3)); 
        
	}

}
