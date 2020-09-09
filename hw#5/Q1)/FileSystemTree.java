import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * File System Tree Class 
 * implemets InterfaceFileSystem
 * @author mustafa
 *
 */
public class FileSystemTree implements InterfaceFileSystem{
		/**
		 * this is root node of the tree
		 */
		private FileNode root;
		
		/**
		 * 1 parameter constructor 
		 * @param name
		 * @throws InvalidParameterException if paramter is not okay
		 */
		FileSystemTree(String name){
			if(name.contains("/")==false && name!=null) {
				root=new FileNode(name,true,name);
			}
			else 
				throw new InvalidParameterException();
		}
		/**
		 * Adding directory to the root
		 * It finds files of path then if it it okay to add then it adds
		 * @return true -If it is okay to add
		 * @return false - If path is not okay or when you try to add directory under file 
		 * @param longname - path of file
		 */
		@Override
		public boolean addDir(String longname) {
			FileNode temp=root;
			String[] words=longname.split("/");
			int num=0;
			
			if(words.length==0 || words.length==1)
				return false;
			
			if(words.length==2 && words[0].equals(root.getName())==true) {
				FileNode newNode= new FileNode(words[1],true,longname);
				root.addChild(newNode);
				return true;
			}
			while(true) {
				if(num==words.length-1) {
					if(temp.isDirectory()==true) {
						FileNode newNode= new FileNode(words[num],true,longname);
						temp.addChild(newNode);
						return true;
					}
					else {
						System.out.println("Your path is not valid becouse of file");
						return false;
					}
				}
				if(temp.getName().equals(words[num])==true) {
					ArrayList<FileNode> children=temp.getChildren();
					if(children.size()!=0){
						int check=0;
						
						for(int i=0;i<children.size();i++) {
							if(children.get(i).getName().equals(words[num+1])==true) {
								temp=children.get(i);
								check=1;
								break;
							}
						}
						if(check==0) {
							if(num+1==words.length-1) {
								if(temp.isDirectory()==true) {
									FileNode newNode= new FileNode(words[num+1],true,longname);
									temp.addChild(newNode);
									return true;
								}
								else {
									System.out.println("Your path is not valid becouse of file");
									return false;
								}
							}
							System.out.println("Your path is not valid becouse of file");
							return false;
						}
					}
				 }
				num++;
			}
		}
		/**
		 * It finds files of path then if it it okay to add then it adds
		 * @return true -If it is okay to add
		 * @return false - If path is not okay or when you try to add file under file 
		 * @param longname - path of file
		 */
		@Override
		public boolean addFile(String longname) {
			FileNode temp=root;
			String[] words=longname.split("/");
			int num=0;
			
			if(words.length==0 || words.length==1)
				return false;
			
			if(words.length==2 && words[0].equals(root.getName())==true) {
				FileNode newNode= new FileNode(words[1],false,longname);
				root.addChild(newNode);
				return true;
			}
			while(true) {
				if(num==words.length-1) {
					if(temp.isDirectory()==true) {
						FileNode newNode= new FileNode(words[num],false,longname);
						temp.addChild(newNode);
						return true;
					}
					else {
						System.out.println("Your path is not valid becouse of file");
						return false;
					}
				}
				if(temp.getName().equals(words[num])==true) {
					ArrayList<FileNode> children=temp.getChildren();
					
					if(children.size()!=0){
						int check=0;
						
						
						for(int i=0;i<children.size();i++) {
							if(children.get(i).getName().equals(words[num+1])==true) {
								temp=children.get(i);
								check=1;
								break;
							}
						}
						if(check==0) {
							if(num+1==words.length-1) {
								if(temp.isDirectory()==true) {
									FileNode newNode= new FileNode(words[num+1],false,longname);
									temp.addChild(newNode);
									return true;
								}
								else {
									System.out.println("Your path is not valid becouse of file");
									return false;
								}
							}
							System.out.println("Your path is not valid becouse of file");
							return false;
						}
					}
				 }
				num++;
			}
		}
		/**
		 * It searchs word and if it finds it shows path of file
		 */
		@Override
		public void search(String word) {
			FileNode temp=root;
			int index=0;
			int num=temp.getSizeOfChildren();
			
			ArrayList<FileNode> traverse=new ArrayList<FileNode>();
			if(root.getName().contains(word))
				System.out.println("dir - "+root.getName());
			while(true) {
				ArrayList<FileNode> children=temp.getChildren();
				
				for(int i=0;i<num;i++) {
					traverse.add(children.get(i));
					if(children.get(i).getName().contains(word)) {
						if(children.get(i).isDirectory()==true)
							System.out.println("dir - "+children.get(i).getPath());
						else
							System.out.println("file - "+children.get(i).getPath());
					}
				}
				if(index==traverse.size())
					return;
				temp=traverse.get(index);
				
				index++;
				num=temp.getSizeOfChildren();
			}
			
			
		}
		/**
		 * This method is for recursive
		 */
		@Override
		public void printFileSystem() {
			System.out.println("---------------------");
			this.printFileSystem(this.root);
			System.out.println("---------------------");
		}
		
		/**
		 * This shows files or directories recursively
		 * @param node
		 */
		private void printFileSystem(FileNode node) {
			
			if(node.isDirectory()==true)
				System.out.print(node.getName()+" --->> ");
			for(int i=0;i<node.getSizeOfChildren();i++) {
				System.out.print(" "+node.getChildren().get(i).getName()+" ");
			}
			
			System.out.println();
			for(int i=0;i<node.getSizeOfChildren();i++) {
				this.printFileSystem(node.getChildren().get(i));
			}
		}
		
		/**
		 * This is removing file or directory
		 * If you try to remove directory then it ask you if you remove or not
		 * @return true if it removes
		 * @return false, If remove is not okay	
		 */
		@Override
		public boolean  remove(String longname){
			FileNode temp=root;
			String[] words=longname.split("/");
			int num=0;
			if(words.length==0)
				return false;
			if(words.length==1 && words[0].equals(root.getName())==true) {
				return false;
			}
			while(true) {
				if(num==words.length-1) {
					if(temp.getSizeOfChildren()!=0) {
						System.out.println("\""+temp.getName()+"\" Directory has these files or directories, Still Do you want to remove? Enter Yes or No");
						for(int i=0;i<temp.getSizeOfChildren();i++)
							System.out.print(" "+temp.getChildren().get(i).getName());
						System.out.println();
						Scanner response=new Scanner(System.in);
						String str=response.nextLine();
						if(str.equals("Yes")) {
							temp.getParent().removeChild(temp);
							return true;
						}
						else
							return false;
					}
					else {
						temp.getParent().removeChild(temp);
						return true;
					}
				}
				if(temp.getName().equals(words[num])==true) {
					ArrayList<FileNode> children=temp.getChildren();
					
					if(children.size()!=0){
						int check=0;
						
						
						for(int i=0;i<children.size();i++) {
							if(children.get(i).getName().equals(words[num+1])==true) {
								temp=children.get(i);
								check=1;
								break;
							}
						}
						if(check==0) {
							if(num==words.length-1) {
								if(temp.getSizeOfChildren()!=0) {
									System.out.println("\""+temp.getName()+"\" Directory has these files or directories, Still Do you want to remove? Enter Yes or No");
									for(int i=0;i<temp.getSizeOfChildren();i++)
										System.out.print(" "+temp.getChildren().get(i));
									Scanner response=new Scanner(System.in);
									String str=response.nextLine();
									if(str.equals("Yes")) {
										temp.getParent().removeChild(temp);
										return true;
									}
									else
										return false;
								}
								else {
									temp.getParent().removeChild(temp);
									return true;
								}
							}
							System.out.println("Your path is not valid becouse of file");
							return false;
						}
					}
				 }
				num++;
			}
		}

		
		
		
		
		
		
	
}
