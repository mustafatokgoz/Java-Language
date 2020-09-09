/**
 * Main Class
 * @author mustafa
 *
 */
public class Main {
	
	public static void main(String[] args) {
		FileSystemTree myFileSystem = new FileSystemTree("root");
		myFileSystem.addDir("root/first_directory");
		myFileSystem.addFile("root/first_directory/new_file.txt");	
		myFileSystem.addDir("root/second_directory");
		myFileSystem.addDir("root/second_directory/new_directory");
		myFileSystem.addFile("root/second_directory/new_directory/new_file.doc");
		myFileSystem.addDir("root/second_directory/new_directory2");
		myFileSystem.addFile("root/second_directory/new_directory/new_file2.doc");
		myFileSystem.printFileSystem();
		myFileSystem.search("new");
		
		myFileSystem.printFileSystem();
		myFileSystem.remove("root/second_directory/new_directory");
		myFileSystem.printFileSystem();
		
	}
}
