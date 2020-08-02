import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * SimpleTextEditor with Arraylist
 * @author mustafa
 *
 */
public class SimpleTextEditorWithArrayList {
	private ArrayList <Character> text ;
	/**
	 * This is no parameter constrcuter
	 */
	SimpleTextEditorWithArrayList(){
		text=new ArrayList<Character>();
	}
	/**
	 * This reads characters from file  with index structure
	 * @param file_name
	 * @return
	 * @throws IOException
	 */
	public boolean read(String file_name) throws IOException{
		File f1=new File(file_name); //Creation of File Descriptor for input file
		FileReader fr= new FileReader(f1);
	    BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
	    String s;
	    while((s=br.readLine())!=null) {
	    	for(int i=0;i<s.length();i++) {
	    		text.add(s.charAt(i));
	    	}
	    	text.add('\n');
	    }
	    fr.close();
		return true;
	}
	/**
	 * This adds string to text at index with index structure
	 * @param index
	 * @param str
	 */
	public void add(int index,String str) {
		for(int i=0;i<str.length();i++) {
			text.add(index,str.charAt(i));
			index++;
		}
	}
	/**
	 * This is finding string in text with index structure
	 * @param str
	 * @return
	 */
	public int find(String str) {
		int check=0;
		for(int i=0;i<text.size()-str.length();i++) {
				for(int j=0;j<str.length();j++) {
						if(text.get(i+j)==str.charAt(j))
							check++;
				}
				if(check==str.length())
					return i;
				check=0;
		}
		return -1;
	}
	/**
	 * This replaces characters with index structure
	 * @param replacedchar
	 * @param newchar
	 */
	public void replace(Character replacedchar,Character newchar) {
		for(int i=0;i<text.size();i++) {
			if(text.get(i)==replacedchar) {
				text.set(i,newchar);
			}
		}
	}
	@Override
	public String toString() {
		StringBuilder str=new StringBuilder();
		
		for(int i=0;i<text.size();i++) {
			str.append(text.get(i));
		}
		String rtr=str.toString();
		return String.format(rtr);
		
	}
	/**
	 * This reads characters from file  with list iterator
	 * @param file_name
	 * @return
	 * @throws IOException
	 */
	public boolean readWithListIterator(String file_name) throws IOException{
		File f1=new File(file_name); //Creation of File Descriptor for input file
		FileReader fr= new FileReader(f1);
	    BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
	    String s;
	    ListIterator<Character> it=text.listIterator();
	    while((s=br.readLine())!=null) {
	    	for(int i=0;i<s.length();i++) {
	    		it.add(s.charAt(i));
	    	}
	    	it.add('\n');
	    }
	    fr.close();
		return true;
	}
	/**
	 *  This adds string to text at index with list iterator
	 * @param index
	 * @param str
	 */
	public void addWithListIterator(int index,String str) {
		ListIterator<Character> it=text.listIterator();
		for(int i=0;i<index;i++) {
				it.next();
		}
		for(int i=0;i<str.length();i++) {
			it.add(str.charAt(i));
		}
	}
	/**
	 * This is finding string in text with list iterator
	 * @param str
	 * @return
	 */
	public int findWithListIterator(String str) {
		int check=0;
		int nodenumber=0;
		ListIterator<Character> it=text.listIterator();
		while(it.hasNext()) {
			nodenumber++;
			it.next();
		}
		it=text.listIterator();
		for(int i=0;i<nodenumber-str.length();i++) {
				for(int j=0;j<str.length();j++) {
						if(it.next()==str.charAt(j))
							check++;
				}
				for(int j=0;j<str.length()-1;j++) {
					it.previous();
				}
				if(check==str.length())
					return it.nextIndex()-1;
				check=0;
		}
		return -1;
	}
	/**
	 *  This replaces characters with list iterator
	 * @param replacedchar
	 * @param newchar
	 */
	public void replaceWithListIterator(Character replacedchar,Character newchar) {
		ListIterator<Character> it=text.listIterator();
		while(it.hasNext()){
			if(it.next()==replacedchar) {
				it.set(newchar);
			}
		}
	}

}
