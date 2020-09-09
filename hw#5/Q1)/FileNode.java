import java.util.ArrayList;

/**
 * File Node Class
 * @author mustafa
 *
 */
public class FileNode {
			/**
			 * name
			 * children - keeps arraylist of FileNode Class 
			 * isDirectory - if file is directory then this is true else false
			 * parent- shows parent node
			 * path - shows file path 
			 */
			private String name;
			private ArrayList<FileNode> children;
			private boolean isDirectory;
			private FileNode parent;
			private String path;
			
			/**
			 * 3 parameter Constructor 
			 * @param name
			 * @param isDir
			 * @param path
			 */
			FileNode(String name,boolean isDir,String path){
					this.name=name;
					children=new ArrayList<FileNode>();
					isDirectory=isDir;
					parent=null;
					this.path=path;
			}
			
			/**
			 * getter for path
			 * @return
			 */
			public String getPath() {
				return path;
			}
			
			/**
			 * setter for path
			 * @param path
			 */
			public void setPath(String path) {
				this.path = path;
			}
			/**
			 * getter for size of children
			 * @return
			 */
			public int getSizeOfChildren() {
				return this.children.size();
			}
			/**
			 * getter for children
			 * @return
			 */
			public ArrayList<FileNode> getChildren() {
				return children;
			}
			/**
			 * setter for children
			 * @param children
			 */
			public void setChildren(ArrayList<FileNode> children) {
				this.children = children;
			}
			/**
			 * getter for name
			 * @return
			 */
			public String getName() {
				return name;
			}
		
			/**
			 * setter for name
			 * @param name
			 */
			public void setName(String name) {
				this.name = name;
			}
		
			/**
			 * getter for isDirectory
			 * @return true if it is directory else false
			 */
			public boolean isDirectory() {
				return isDirectory;
			}
		
			/**
			 * setter for isDirectory
			 * @param isDirectory
			 */
			public void setDirectory(boolean isDirectory) {
				this.isDirectory = isDirectory;
			}
		
			/**
			 * getter for parent
			 * @return
			 */
			public FileNode getParent() {
				return parent;
			}
		
			/**
			 * setter for parent
			 * @param parent
			 */
			public void setParent(FileNode parent) {
				this.parent = parent;
			}
		
			/**
			 * Adding child to File node
			 * @param child
			 * @return
			 */
			public boolean addChild(FileNode child) {
					if(this.isDirectory==true) {
						child.setParent(this);
						this.children.add(child);
						return true;
					}
					else {
						return false;
					}
			}
			/**
			 * remove child from FileNode
			 * @param child
			 * @return true if remove is okay
			 */
			public boolean removeChild(FileNode child) {
				return children.remove(child);
			}

}
