import java.util.Scanner;
/**
 * This is Main Class that has menus for all user
 * @author Mustafa Tokgöz 171044077
 *
 */
public class Main {
	/**
	 * This is main method
	 * @param args
	 */
	public static void main(String[] args) {
		boolean check=true;
		int choice;
		int secondchoice;
		int thirdchoice;
		int forthchoice;
		int control=0;
		String password;
		// I assign Administrator class to abstractAdminClass that is EnterignSystemForAdmin Class  
		EnteringSystemForAdmin admin = new Administrator();
		//I set the password for admin with 1234 so You must enter the password to enter the admin system
		admin.setPassword("1234");
		while(check) {
			choice=menu();
			switch (choice) {
				case 1 :  Scanner scanner = new Scanner(System.in);
						System.out.println("Please enter the password!!");
							 password = scanner.nextLine();	
							if(admin.login(password)==false) {
								System.out.println("You enter wrong password!!");
								break;
							}
						 System.out.println("1 : Add Branch");
						 System.out.println("2 : Add Branch Employee");
						 System.out.println("3 : Add Transportation Personel");
						 System.out.println("4 : Remove Branch");
						 System.out.println("5 : Remove Branch Employee");
						 System.out.println("6 : Remove Transportaiton Personel");
						 System.out.println("0 : Back");
							 int number = scanner.nextInt();	
						if(number==1) {
							   //I assign Branch to AbstractBranch and 
								AbstractBranch temp=new Branch();
								//I set the password for every branch with 0000 so You must enter the password to enter the branch system
								temp.setPassword("0000");
								admin.addBranch(temp);
								System.out.println("You added Branch");
						}		
						else if(number==2) {
								if(admin.getBranchsize()==0) {
									System.out.println("There is not any brach so first add a branch");
								}
								else {
										try {
											secondchoice = branchmenu(admin);
											if(secondchoice<=admin.getBranchsize() && secondchoice >0) {
												BranchEmployees temp2=new BranchEmployees();
												admin.getBranch(secondchoice-1).addEmployee(temp2);
												System.out.println("You added a branch employee");
											}
										}
										catch(ArrayIndexOutOfBoundsException e) {
											System.out.println("Array Index Out of Bounds!!");
										}
										
								}
						}
						else if(number==3) {
							try {
								secondchoice = branchmenu(admin);
								if(secondchoice<=admin.getBranchsize() && secondchoice >0) {
									TransportationPersonel temp2=new TransportationPersonel();
									admin.getBranch(secondchoice-1).addPersonel(temp2);
									System.out.println("You added a transportation personel");
								}
							}
							catch(ArrayIndexOutOfBoundsException e) {
								System.out.println("Array Index Out of Bounds!!");
							}
							
						}
						else if(number==4) {
								secondchoice = branchmenu(admin);
								if(secondchoice<=admin.getBranchsize() && secondchoice >0) {
								admin.removeBranch(secondchoice-1);
								System.out.println("You removed a branch");
								}
						}
						else if(number==5) {
							try {
								secondchoice = branchmenu(admin);
								thirdchoice = employeemenu(admin,secondchoice-1);
								if(secondchoice<=admin.getBranchsize() && secondchoice >0 && thirdchoice!=-1) {
									admin.getBranch(secondchoice-1).removeEmployee(thirdchoice);
									System.out.println("You remove a breanch employee");
								}
							}
							catch(ArrayIndexOutOfBoundsException e) {
								System.out.println("Index Out of Bounds!!");
							}
						}
						else if(number==6) {
							try {
								secondchoice = branchmenu(admin);
								thirdchoice = employeemenu(admin,secondchoice-1);
								if(secondchoice<=admin.getBranchsize() && secondchoice >0  && thirdchoice!=-1) {
									admin.getBranch(secondchoice-1).removePersonel(thirdchoice-1);
									System.out.println("You removed a transportation personel");
								}
							}
							catch(ArrayIndexOutOfBoundsException e) {
								System.out.println("Index Out of Bounds!!");
							}
						}
						else {
						}
						break;
							 
				case 2 :Scanner scannertwo = new Scanner(System.in);
						
						secondchoice=branchmenu(admin); 
						if(secondchoice==-1) 
							 break;
						if(secondchoice>0)
							 secondchoice= secondchoice -1;
						System.out.println("Please enter the password!!");
						password = scannertwo.nextLine();
						try {
							if(admin.getBranch(secondchoice).login(password)==false) {
								System.out.println("You enter wrong password!!");
								break;
							}
						}
						catch(ArrayIndexOutOfBoundsException e) {
							System.out.println("Index Out of Bounds!!");
							break;
						}
						 thirdchoice=employeemenu(admin,secondchoice);
						 if(thirdchoice==-1) 
							 break;
						 if(thirdchoice>0)
							 thirdchoice= thirdchoice -1;
						
						
						 System.out.println("1 : Add Cargo");
						 System.out.println("2 : Add Customer");
						 System.out.println("3 : Remove Cargo");
						 System.out.println("4 : Remove Customer");
						 System.out.println("5 : Show Cargo Imformations");
						 System.out.println("6 : Show Customer Imformation");
						 System.out.println("0 : Back");
						 
						 forthchoice = scannertwo.nextInt();
						 if(forthchoice==1) {
							 System.out.println("Enter the imformation about cargo orderly");
							 System.out.print("Sender : ");
							 String sender=scannertwo.nextLine();
							 sender=scannertwo.nextLine();
							 System.out.print("Receiver : ");
							 String receiver=scannertwo.nextLine();
							 System.out.print("Tracking number : ");
							 String trackingnum=scannertwo.nextLine();
							 System.out.print("Address : ");
							 String addr=scannertwo.nextLine();
							 Cargo newcargo = new Cargo(sender,receiver,trackingnum,addr);
							 try {
							 admin.getBranch(secondchoice).getEmployees(thirdchoice).addCargo(admin.getBranch(secondchoice),newcargo);
							 System.out.println("Cargo is added");
							 }
							 catch(ArrayIndexOutOfBoundsException e) {
								System.out.println("Array Index Out of Bounds!!");
							 }
						 }
						 else if(forthchoice==2) {
							 System.out.println("Enter name and tracking number orderly!");
							 System.out.print("Name :");
							 String name=scannertwo.nextLine();
							 name=scannertwo.nextLine();
							 System.out.print("Tracking number : ");
							 String trackingnum=scannertwo.nextLine();
							 Customer newcustomer = new Customer(name,trackingnum);
							 try {
							 admin.getBranch(secondchoice).getEmployees(thirdchoice).addCustomer(admin.getBranch(secondchoice),newcustomer);
							 System.out.println("Customer is added");
							 }
							 catch(ArrayIndexOutOfBoundsException e) {
									System.out.println("Array Index Out of Bounds!!");
							}
						 }
						 else if(forthchoice==3) {
							try {
							 if(admin.getBranch(secondchoice).getCargosize()==0) {
								 System.out.println("There is not any Cargo yet");
							 }
							 else {
							 for(int i=0;i<admin.getBranch(secondchoice).getCargosize();i++) {
								 System.out.println((i+1)+". Cargo");
								 System.out.println("Sender : " + admin.getBranch(secondchoice).getCargo(i).getSenderName());
								 System.out.println("Receiver : "+ admin.getBranch(secondchoice).getCargo(i).getReceiverName());
								 System.out.println("Tracking Number : "+admin.getBranch(secondchoice).getCargo(i).getTrackingNumber());
								 System.out.println("Address : "+admin.getBranch(secondchoice).getCargo(i).getAddress());
								 System.out.print("Current Status : ");
								 if(admin.getBranch(secondchoice).getCargo(i).isStatus()==false) {
									 System.out.print("In "+(secondchoice+1)+".Branch and "+(thirdchoice+1)+".Employee \n");
									 System.out.println("Cargo is here and hasn't delivered yet!!");
								 }
								 else {
									 System.out.println("Cargo leaved and delivered");
								 }
								 System.out.println();
								}
								int selection=scannertwo.nextInt();
								if(selection<=admin.getBranch(secondchoice).getCargosize() && selection>0) {
								admin.getBranch(secondchoice).getEmployees(thirdchoice).removeCargo(admin.getBranch(secondchoice),selection-1);
								 System.out.println("You removed "+selection +". cargo");
								 }
								else {
									System.out.println("There is not any cargo like you select");
								}
							 
							 }
							}
							catch(ArrayIndexOutOfBoundsException e) {
								System.out.println("Index Out of Bounds!!");
							}
						 }
						 else if(forthchoice==4) {
							 try {
								if(admin.getBranch(secondchoice).getCustomersize()==0) {
									System.out.println("There is not any Customer yet");
								}
								else {
									for(int i=0;i<admin.getBranch(secondchoice).getCustomersize();i++) {
										 	System.out.println((i+1)+". Customer");
											 System.out.println("Name : " + admin.getBranch(secondchoice).getCustomer(i).getName());
											 System.out.println("Tracking number : " + admin.getBranch(secondchoice).getCustomer(i).getTrackingnum());
									 }
									
										 int selection=scannertwo.nextInt();
										 if(selection<=admin.getBranch(secondchoice).getCustomersize() && selection>0) {
											 admin.getBranch(secondchoice).getEmployees(thirdchoice).removeCustomer(admin.getBranch(secondchoice),selection-1);
											 System.out.println("You removed "+selection +". customer");
										 }
											else {
												System.out.println("There is not any customer like you select");
											}
								}
							 }
							catch(ArrayIndexOutOfBoundsException e) {
								System.out.println("Index Out of Bounds!!");
							}
						 }
						 else if(forthchoice==5) {
							try { 
								 if(admin.getBranch(secondchoice).getCargosize()==0) {
									 System.out.println("There is not any Cargo yet!!");
								 }
								 else {
									 for(int i=0;i<admin.getBranch(secondchoice).getCargosize();i++) {
										 System.out.println((i+1)+". Cargo :");
										 System.out.println("Sender : " + admin.getBranch(secondchoice).getCargo(i).getSenderName());
										 System.out.println("Receiver : "+ admin.getBranch(secondchoice).getCargo(i).getReceiverName());
										 System.out.println("Tracking Number : "+admin.getBranch(secondchoice).getCargo(i).getTrackingNumber());
										 System.out.println("Address : "+admin.getBranch(secondchoice).getCargo(i).getAddress());
										 System.out.print("Current Status : ");
										 if(admin.getBranch(secondchoice).getCargo(i).isStatus()==false) {
											 System.out.print("In "+(secondchoice+1)+".Branch \n");
											 System.out.println("Cargo is here and hasn't delivered yet!!");
										 }
										 else {
											 System.out.println("Cargo leaved and delivered");
										 }
										 System.out.println();
									 }
								 }
							}
							catch(ArrayIndexOutOfBoundsException e) {
									System.out.println("Index Out of Bounds!!");
								}

						 }
						 else if(forthchoice==6) {
							try { 
							 for(int i=0;i<admin.getBranch(secondchoice).getCustomersize();i++) {
								 System.out.println((i+1)+". Customer:");
								 System.out.println("Name : " + admin.getBranch(secondchoice).getCustomer(i).getName());
								 System.out.println("Tracking number : " + admin.getBranch(secondchoice).getCustomer(i).getTrackingnum());
							 }
							}
							catch(ArrayIndexOutOfBoundsException e) {
								System.out.println("Index Out of Bounds!!");
							}
						 }
						
						 else {
						 }
						 break;
				case 3 : 
					try {
						Scanner scanneranother = new Scanner( System.in );
						secondchoice=branchmenu(admin); 
						if(secondchoice==-1) 
							break;
						if(secondchoice>0)
								 secondchoice= secondchoice -1;
						
						System.out.println("Please enter the password!!");
						password = scanneranother.nextLine();	
							if(admin.getBranch(secondchoice).login(password)==false) {
								System.out.println("You enter wrong password!!");
								break;
						 }
						
						 thirdchoice=personelmenu(admin,secondchoice);
						 if(thirdchoice==-1) 
							 break;
						 if(thirdchoice>0)
							 thirdchoice= thirdchoice -1;
						 if(admin.getBranch(secondchoice).getCargosize()>0) {
							 System.out.println("Choose one of them");
							 for(int i=0;i<admin.getBranch(secondchoice).getCargosize();i++) {
								 System.out.println((i+1)+". Cargo");
								 System.out.println("Sender : " + admin.getBranch(secondchoice).getCargo(i).getSenderName());
								 System.out.println("Receiver : "+ admin.getBranch(secondchoice).getCargo(i).getReceiverName());
								 System.out.println("Tracking Number : "+admin.getBranch(secondchoice).getCargo(i).getTrackingNumber());
								 System.out.println("Address : "+admin.getBranch(secondchoice).getCargo(i).getAddress());
								 System.out.print("Current Status : ");
								 if(admin.getBranch(secondchoice).getCargo(i).isStatus()==false) {
									 System.out.print("In "+(secondchoice+1)+".Branch \n");
									 System.out.println("Cargo is here and hasn't delivered yet!!");
								 }
								 else {
									 System.out.println("Cargo leaved and delivered");
								 }
								 System.out.println();
							 }
						

								int num = scanneranother.nextInt();
								if(num>0 && num <=admin.getBranch(secondchoice).getCargosize()) {
									admin.getBranch(secondchoice).getPersonel(thirdchoice).updateStatus(admin.getBranch(secondchoice).getCargo(num-1));
								}
							 System.out.println("You update the cargo and cargo is given to its owner");
						 }	
						 else
							 System.out.println("There is not any Cargo yet!!");
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Index Out of Bounds!!");
					}
						 break;
				case 4 : 
					try {
						System.out.println("Please enter your tracking number");
						Scanner scannerlast = new Scanner( System.in );
						String tracking= scannerlast.nextLine();
						for(int i=0;i<admin.getBranchsize();i++) {
								for(int k=0;k<admin.getBranch(i).getCargosize();k++) {
									if(tracking.equals(admin.getBranch(i).getCargo(k).getTrackingNumber())) {
										control=1;
										System.out.println("Sender Name : "+admin.getBranch(i).getCargo(k).getSenderName());
										System.out.println("Receiver Name :"+ admin.getBranch(i).getCargo(k).getReceiverName());
										System.out.print("Current Status : ");
										if(admin.getBranch(i).getCargo(k).isStatus()==false) {
											System.out.print("In "+(i+1)+".Branch \n");
										}
										else {
											System.out.print("Cargo leaved "+(i+1)+".Brach \n");
										}
									}
								}
							
						}
						if(control==0) {
							System.out.println("There is not any Cargo");
						}
						else {
							control=0;
						}
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Index Out of Bounds!!");
					}
						break;
				case 0 : break;
						 
			}
			if(choice==0)
				check =false;
			
		}

	}
	/**
	 * This is menu print method and selecting menu
	 * @return
	 */
	public static int menu() {
		int number=0;
			System.out.println("Welcome Your Automation System");
			System.out.println("1 : Administrator");
			System.out.println("2 : Branch Employee");
			System.out.println("3 : Transportation Personel ");
			System.out.println("4 : Customer");
			System.out.println("0 : Exit");
			Scanner scanner = new Scanner(System.in);
			number = scanner.nextInt();

		return number;
	}
	/**
	 * This is branch menu that you select branch
	 * @param admin
	 * @return
	 */
	public static int branchmenu(EnteringSystemForAdmin admin) {
		
		if(admin.getBranchsize()==0) {
			System.out.println("There is not any branch ,Please first add a branch by administrator!");
			return -1;
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose one of them");
		for(int i=0;i<admin.getBranchsize();i++) {
			System.out.println((i+1)+". Branch");
		}
		int another = scanner.nextInt();
		return another;
	}
	/**
	 * This is employee menu that you select employee
	 * @param admin
	 * @param index
	 * @return
	 */
	public static int employeemenu(EnteringSystemForAdmin admin,int index) {
	  try {
		if(admin.getBranch(index).getEmployeesize()==0) {
			System.out.println("There is not any employee please first add a employee by administrator!");
			return -1;
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose one of them");
		if(admin.getBranch(index).getEmployeesize()>0) {
			for(int i=0;i<admin.getBranch(index).getEmployeesize();i++) {
				System.out.println((i+1)+".Employee");
			}
		}
		int another = scanner.nextInt();
		return another;
	  }
	  catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index Out of Bounds!!");
			return -1;
	  } 
	}
	/**
	 * This is personel menu that you select transportation personel
	 * @param admin
	 * @param index
	 * @return
	 */
	public static int personelmenu(EnteringSystemForAdmin admin,int index) {
		try {
			if(admin.getBranch(index).getPersonelsize()==0) {
				System.out.println("There is not any personel please first add a personel by administrator!");
				return -1;
			}
			Scanner scanner = new Scanner(System.in);
			System.out.println("Choose one of them");
			if(admin.getBranch(index).getPersonelsize()>0) {
				for(int i=0;i<admin.getBranch(index).getPersonelsize();i++) {
					System.out.println((i+1)+".Personel");
				}
			}
			int another = scanner.nextInt();
			return another;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index Out of Bounds!!");
			return -1;
		}
	}

}
