import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) throws Exception{
		int check=0;
		FileHandler handler = new FileHandler("mustafa.log", true);
		Logger logger=Logger.getLogger("");
		logger.addHandler(handler);

		logger.info("Firstly,I use same file and methods with same way to measure all times then I use other file to test");
		SimpleTextEditor object=new SimpleTextEditor();
		
		long start = System.nanoTime();
		long stop;
		try {
			object.read("testfile");
		}
		catch(Exception e) {
			logger.warning("There is no such file");
			check=1;
			//System.out.println("There is no such file");
		}
			stop=System.nanoTime();
			//System.out.printf(stop-start +" Nanosecond past in LinkedList using index structure implementation in read method\n");
			logger.info(stop-start +" Nanosecond past in LinkedList using index structure implementation in read method\n");
			//System.out.println("Read methhod worked  in LinkedList using index structure ");
			if(check==0)
				logger.info("Read methhod worked  in LinkedList using index structure ");
			logger.info(object.toString());
			//System.out.println(object.toString());
			//System.out.println();
			check=0;
			start = System.nanoTime();
			try {
			object.add(26, " add");
			}
			catch(Exception e) {
				logger.warning("Index out of bound in add method");
				check=1;
				//System.out.println("Index is out of bound");
			}
			stop=System.nanoTime();
			//System.out.printf(stop-start +" Nanosecond past in LinkedList using index structure implementation in add method\n");
			//System.out.println("add method added \"add\" word at index 26  in LinkedList using index structure");
			logger.info(stop-start +" Nanosecond past in LinkedList using index structure implementation in add method\n");
			if(check==0)
				logger.info("add method added \"add\" word at index 26  in LinkedList using index structure");
			logger.info(object.toString());
			//System.out.println(object.toString());
			start = System.nanoTime();
			//System.out.println(object.findWithListIterator("171")+" is index of \"171\" ");
			logger.info(object.findWithListIterator("171")+" is index of \"171\" ");
			stop=System.nanoTime();
			logger.info(stop-start +" Nanosecond past in LinkedList using index structure implementation in find method\n");
			logger.info("find method worked for \"171\" in LinkedList using index structure");
			//System.out.printf(stop-start +" Nanosecond past in LinkedList using index structure implementation in find method\n");
			//System.out.println("find method worked for \"171\" in LinkedList using index structure");
			//System.out.println();
			
			start = System.nanoTime();
			object.replace('a','z');
			stop=System.nanoTime();
			logger.info(stop-start +" Nanosecond past in LinkedList using index structure implementation in replace method\n");
			logger.info("replace method changed  all 'a' charater to 'z' in LinkedList using index structure");
			//System.out.printf(stop-start +" Nanosecond past in LinkedList using index structure implementation in replace method\n");
			//System.out.println("replace method changed  all 'a' charater to 'z' in LinkedList using index structure");
			
			logger.info(object.toString());
			//System.out.println(object.toString());
			
		//System.out.println();
		
		SimpleTextEditor object2=new SimpleTextEditor();
		
		start=System.nanoTime();
		try {
		object2.readWithListIterator("testfile");
		}
		catch(Exception e) {
			logger.warning("There is no such file");
			check=1;
			//System.out.println("There is no such file");
		}
		stop=System.nanoTime();
		logger.info(stop-start +" Nanosecond past in LinkedList using ListIterator implementation in read method\n");
		//System.out.printf(stop-start +" Nanosecond past in LinkedList using ListIterator implementation in read method\n");
		if(check==0)
			logger.info("Read methhod worked  in LinkedList using ListIterator ");
		//System.out.println("Read methhod worked  in LinkedList using ListIterator ");
		//System.out.println();
		logger.info(object2.toString());
		//System.out.println(object2.toString());
		check=0;
		start=System.nanoTime();
		try {
		object2.addWithListIterator(26, "add");
		}
		catch(Exception e) {
			logger.warning("Index out of bound in add method");
			check=1;
			//System.out.println("Index is out of bound");
		}
		stop=System.nanoTime();
		//System.out.printf(stop-start +" Nanosecond past in LinkedList using ListIterator implementation in add method\n");
		//System.out.println("add method added \"add\" word at index 26  in LinkedList using ListIterator");
		logger.info(stop-start +" Nanosecond past in LinkedList using ListIterator implementation in add method\n");
		if(check==0)
			logger.info("add method added \"add\" word at index 26  in LinkedList using  ListIterator");
		logger.info(object2.toString());
		//System.out.println(object2.toString());
		check=0;
		start=System.nanoTime();
		//System.out.println(object2.findWithListIterator("171")+" is index number of 171");
		logger.info(object2.findWithListIterator("171")+" is index of \"171\" ");
		stop=System.nanoTime();
		
		logger.info(stop-start +" Nanosecond past in LinkedList using ListIterator implementation in find method\n");
		logger.info("find method worked for \"171\" in LinkedList using  ListIterator");
		//System.out.printf(stop-start +" Nanosecond past in LinkedList using index structure implementation in find method\n");
		//System.out.println("find method worked for \"171\" in LinkedList using index structure");
		//System.out.println();
		
		start=System.nanoTime();
		object2.replaceWithListIterator('a','z');
		stop=System.nanoTime();
		logger.info(stop-start +" Nanosecond past in LinkedList using ListIterator implementation in replace method\n");
		logger.info("replace method changed  all 'a' charater to 'z' in LinkedList using ListIterator");
		//System.out.printf(stop-start +" Nanosecond past in LinkedList using ListIterator implementation in replace method\n");
		//System.out.println("replace method changed  all 'a' charater to 'z' in LinkedList using ListIterator");
		logger.info(object2.toString());
		//System.out.println(object2.toString());
		
		
		SimpleTextEditorWithArrayList object3=new SimpleTextEditorWithArrayList();
		//System.out.println();
		check=0;
		start=System.nanoTime();
		try {
			object3.read("testfile");
		}
		catch(Exception e) {
				logger.warning("There is no such file");
				check=1;
				//System.out.println("There is no such file");
		}
		stop=System.nanoTime();
		//System.out.printf(stop-start +" Nanosecond past in ArrayList using index structure implementation in read method\n");
		logger.info(stop-start +" Nanosecond past in ArrayList using index structure implementation in read method\n");
		//System.out.println("Read methhod worked  in ArrayList using index structure ");
		if(check==0)
			logger.info("Read methhod worked  in ArrayList using index structure ");
		logger.info("\n");
		logger.info(object3.toString());
		//System.out.println(object3.toString());
		//System.out.println();
		start=System.nanoTime();
		check=0;
		try {	
		object3.add(26, "add");
		}
		catch(Exception e) {
			logger.warning("Index out of bound in add method");
			check=1;
			//System.out.println("Index is out of bound");
		}
		stop=System.nanoTime();
		//System.out.printf(stop-start +" Nanosecond past in Arraylist using index structure implementation in add method\n");
		//System.out.println("add method added \"add\" word at index 26  in Arraylist using index structure");
		logger.info(stop-start +" Nanosecond past in Arraylist using index structure implementation in add method\n");
		if(check==0)
			logger.info("add method added \"add\" word at index 26  in Arraylist using index structure");
		logger.info(object3.toString());
		//System.out.println(object3.toString());
		check=0;
		start=System.nanoTime();
		//System.out.println(object3.find("171")+" is index number of 171");
		logger.info(object3.find("171")+" is index of \"171\" ");
		stop=System.nanoTime();
		logger.info(stop-start +" Nanosecond past in ArrayList using index structure implementation in find method\n");
		logger.info("find method worked for \"171\" in ArrayList using index structure");
		//System.out.printf(stop-start +" Nanosecond past in ArrayList using index structure implementation in find method\n");
		//System.out.println("find method worked for \"171\" in ArrayList using index structure");
		//System.out.println();
		
		start=System.nanoTime();
		object3.replace('a','z');
		stop=System.nanoTime();
		logger.info(stop-start +" Nanosecond past in  ArrayList using index structure implementation in replace method\n");
		logger.info("replace method changed  all 'a' charater to 'z' in  ArrayList using index structure");
		//System.out.printf(stop-start +" Nanosecond past in  ArrayList using index structure implementation in replace method\n");
		//System.out.println("replace method changed  all 'a' charater to 'z' in  ArrayList using index structure");
		logger.info(object3.toString());
		//System.out.println(object3.toString());
		//System.out.println();
		check=0;
		
		SimpleTextEditorWithArrayList object4=new SimpleTextEditorWithArrayList();
		start=System.nanoTime();
		try {
			object4.readWithListIterator("testfile");
		}
		catch(Exception e) {
				logger.warning("There is no such file");
				check=1;
				//System.out.println("There is no such file");
		}
		stop=System.nanoTime();
		logger.info(stop-start +" Nanosecond past in ArrayList using ListIterator implementation in read method\n");
		//System.out.printf(stop-start +" Nanosecond past in ArrayList using ListIterator implementation in read method\n");
		if(check==0)
			logger.info("Read methhod worked  in ArrayList using ListIterator ");
		//System.out.println("Read methhod worked  in LinkedList using ArrayList ");
		//System.out.println();
		logger.info(object4.toString());
		//System.out.println(object4.toString());
		check=0;
		start=System.nanoTime();
		try {
			object4.addWithListIterator(26, "add");
		}
		catch(Exception e) {
			logger.warning("Index out of bound in add method");
			check=1;
			//System.out.println("Index is out of bound");
		}
		stop=System.nanoTime();
		//System.out.printf(stop-start +" Nanosecond past in LinkedList using ListIterator implementation in add method\n");
		//System.out.println("add method added \"add\" word at index 26  in LinkedList using ListIterator");
		logger.info(stop-start +" Nanosecond past in ArrayList using ListIterator implementation in add method\n");
		if(check==0)
			logger.info("add method added \"add\" word at index 26  in ArrayList using  ListIterator");
		logger.info(object4.toString());
		//System.out.println(object4.toString());
		
		start=System.nanoTime();
		//System.out.println(object4.findWithListIterator("171")+" is index number of 171");
		logger.info(object4.findWithListIterator("171")+" is index of \"171\" ");
		stop=System.nanoTime();
		logger.info(stop-start +" Nanosecond past in ArrayList using ListIterator implementation in find method\n");
		logger.info("find method worked for \"171\" in ArrayList using  ListIterator");
		//System.out.printf(stop-start +" Nanosecond past in ArrayList using index structure implementation in find method\n");
		//System.out.println("find method worked for \"171\" in ArrayList using index structure");
		//System.out.println();
		
		start=System.nanoTime();
		object4.replaceWithListIterator('a','z');
		stop=System.nanoTime();
		logger.info(stop-start +" Nanosecond past in ArrayList using ListIterator implementation in replace method\n");
		logger.info("replace method changed  all 'a' charater to 'z' in ArrayList using ListIterator");
		//System.out.printf(stop-start +" Nanosecond past in LinkedList using ArrayList implementation in replace method\n");
		//System.out.println("replace method changed  all 'a' charater to 'z' in ArrayList using ListIterator");
		logger.info(object4.toString());
		//System.out.println(object4.toString());
			
		SimpleTextEditor object5=new SimpleTextEditor();
		start=System.nanoTime();
		try {
			object5.read("testfile2");
		}
		catch(Exception e) {
			logger.warning("There is no such file");
			System.out.println("There is no such file");
		}
		stop=System.nanoTime();
		logger.info(stop-start+" This read is from tesfile2 that has long text than testfile");
		logger.info(object5.toString());
		
		
		try {
			object5.add(0, "adding");
		}
		catch(Exception e) {
			logger.warning("Index out of bound in add method");
			//System.out.println("Index is out of bound");
		}
		logger.info("add method added \"adding\" word at 0 index if it is not index out ");
		logger.info(object5.toString());
		
		logger.info(object5.find("adding")+" is index of adding word");
		object5.replace('d', 'e');
		logger.info("all 'd' is now  'e' in text");
		logger.info(object5.toString());
	}
	
	
	
}
