/**
 * This is interface of File System Tree Class
 * @author mustafa
 *
 */
public interface InterfaceFileSystem {
	/**
	 * addDire method
	 * @param path
	 * @return
	 */
	public boolean addDir(String path);
	/**
	 * addFile method
	 * @param path
	 * @return
	 */
	public boolean addFile(String path);
	/**
	 * search method
	 * @param word
	 */
	public void search(String word);
	/**
	 * printFileSystem method
	 */
	public void printFileSystem();
	/**
	 * remove method
	 * @param path
	 * @return
	 */
	public boolean  remove(String path);
}
