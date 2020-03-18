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
		Administrator admin = new Administrator();
		while(check) {
			choice=menu();
			switch (choice) {
				case 1 : System.out.println("1 : Add Branch");
						 System.out.println("2 : Add Branch Employee");
						 System.out.println("3 : Add Transportation Personel");
						 System.out.println("4 : Remove Branch");
						 System.out.println("5 : Remove Branch Employee");
						 System.out.println("6 : Remove Transportaiton Personel");
						 System.out.println("0 : Back");
						 Scanner scanner = new Scanner(System.in);
							int number = scanner.nextInt();	
						if(number==1) {
								admin.addBranch();
								admin.branches[admin.getBranchsize()-1] = new Branch();
								System.out.println("You added Branch");
						}		
						else if(number==2) {
								if(admin.getBranchsize()==0) {
									System.out.println("There is not any brach so first add a branch");
								}
								else {
										secondchoice = branchmenu(admin);
										if(secondchoice<=admin.getBranchsize() && secondchoice >0) {
											BranchEmployees temp2=new BranchEmployees();
											admin.branches[secondchoice-1].addEmployee(temp2);
											System.out.println("You added a branch employee");
										}
										
								}
						}
						else if(number==3) {
								secondchoice = branchmenu(admin);
								if(secondchoice<=admin.getBranchsize() && secondchoice >0) {
									TransportationPersonel temp2=new TransportationPersonel();
									admin.branches[secondchoice-1].addPersonel(temp2);
									System.out.println("You added a transportation personel");
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
							secondchoice = branchmenu(admin);
							thirdchoice = employeemenu(admin,secondchoice-1);
							if(secondchoice<=admin.getBranchsize() && secondchoice >0 && thirdchoice!=-1) {
								admin.branches[secondchoice-1].removeEmployee(thirdchoice);
								System.out.println("You remove a breanch employee");
							}
						}
						else if(number==6) {
							secondchoice = branchmenu(admin);
							thirdchoice = employeemenu(admin,secondchoice-1);
							if(secondchoice<=admin.getBranchsize() && secondchoice >0  && thirdchoice!=-1) {
								admin.branches[secondchoice-1].removePersonel(secondchoice-1);
								System.out.println("You removed a transportation personel");
							}
						}
						else {
						}
						break;
							 
				case 2 :
						
						secondchoice=branchmenu(admin); 
						if(secondchoice==-1) 
							 break;
						if(secondchoice>0)
							 secondchoice= secondchoice -1;

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
						 Scanner scannertwo = new Scanner(System.in);
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
							 admin.branches[secondchoice].employees[thirdchoice].addCargo(newcargo);
							 System.out.println("Cargo is added");
						 }
						 else if(forthchoice==2) {
							 System.out.println("Enter name and tracking number orderly!");
							 System.out.print("Name :");
							 String name=scannertwo.nextLine();
							 name=scannertwo.nextLine();
							 System.out.print("Tracking number : ");
							 String trackingnum=scannertwo.nextLine();
							 Customer newcustomer = new Customer(name,trackingnum);
							 admin.branches[secondchoice].employees[thirdchoice].addCustomer(newcustomer);
							 System.out.println("Customer is added");
						 }
						 else if(forthchoice==3) {
							
							 try {
								for(int i=0;i<admin.branches[secondchoice].employees[thirdchoice].getCargosize();i++) {
								 System.out.println((i+1)+". Cargo");
								}
								int selection=scannertwo.nextInt();
								if(selection<=admin.branches[secondchoice].employees[thirdchoice].getCargosize() && selection>0) {
								admin.branches[secondchoice].employees[thirdchoice].removeCargo(selection-1);
								 System.out.println("You removed "+selection +". cargo");
								 }
								else {
									System.out.println("There is not any cargo like you select");
								}
							 
							 }
							 catch(NullPointerException e) {
								 System.out.println("There is not any Cargo yet");
							 }
							
						 }
						 else if(forthchoice==4) {
							 try {
							 for(int i=0;i<admin.branches[secondchoice].employees[thirdchoice].getCustomersize();i++) {
								 	System.out.println((i+1)+". Customer");
							 }
							
								 int selection=scannertwo.nextInt();
								 if(selection<=admin.branches[secondchoice].employees[thirdchoice].getCustomersize() && selection>0) {
									 admin.branches[secondchoice].employees[thirdchoice].removeCustomer(selection-1);
									 System.out.println("You removed "+selection +". customer");
								 }
									else {
										System.out.println("There is not any customer like you select");
									}
							 }
							catch(NullPointerException e){
								 System.out.println("There is not any Customer yet");
							 }
						 }
						 else if(forthchoice==5) {
							try {
							 for(int i=0;i<admin.branches[secondchoice].employees[thirdchoice].getCargosize();i++) {
								 System.out.println((i+1)+". Cargo :");
								 System.out.println("Sender : " + admin.branches[secondchoice].employees[thirdchoice].cargos[i].getSenderName());
								 System.out.println("Receiver : "+ admin.branches[secondchoice].employees[thirdchoice].cargos[i].getReceiverName());
								 System.out.println("Tracking Number : "+admin.branches[secondchoice].employees[thirdchoice].cargos[i].getTrackingNumber());
								 System.out.println("Address : "+admin.branches[secondchoice].employees[thirdchoice].cargos[i].getAddress());
								 System.out.print("Current Status : ");
								 if(admin.branches[secondchoice].employees[thirdchoice].cargos[i].isStatus()==false) {
									 System.out.print("In "+(secondchoice+1)+".Branch and "+(thirdchoice+1)+".Employee \n");
									 System.out.println("Cargo is here and hasn't delivered yet!!");
								 }
								 else {
									 System.out.println("Cargo leaved and delivered");
								 }
							 }
							}
							catch(NullPointerException e) {
								System.out.println("There is not any cargo!");
							}
						 }
						 else if(forthchoice==6) {
							 for(int i=0;i<admin.branches[secondchoice].employees[thirdchoice].getCustomersize();i++) {
								 System.out.println((i+1)+". Customer:");
								 System.out.println("Name : " + admin.branches[secondchoice].employees[thirdchoice].customers[i].getName());
								 System.out.println("Tracking number : " + admin.branches[secondchoice].employees[thirdchoice].customers[i].getTrackingnum());
							 }
						 }
						
						 else {
						 }
						 break;
				case 3 : secondchoice=branchmenu(admin); 
						if(secondchoice==-1) 
							break;
						if(secondchoice>0)
								 secondchoice= secondchoice -1;
						 thirdchoice=personelmenu(admin,secondchoice);
						 if(thirdchoice==-1) 
							 break;
						 if(thirdchoice>0)
							 thirdchoice= thirdchoice -1;
						 System.out.println("Select one of branch employees to select their cargo");
						 forthchoice = employeemenu(admin,secondchoice);
						 if(forthchoice ==-1) 
							 break;
						 if(forthchoice >0)
							 forthchoice = forthchoice  -1;
						 	try {
							 System.out.println("Choose one of them");
							 for(int i=0;i<admin.branches[secondchoice].employees[forthchoice].getCargosize();i++) {
								 System.out.println((i+1)+". Cargo");
							 }
						 	}
						 	catch(NullPointerException e) {
						 		 System.out.println("There is not any cargo on that brach employee");
						 		 break;
						 	}
							 TransportationPersonel temp = new TransportationPersonel();
							Scanner scanneranother = new Scanner( System.in );
								int num = scanneranother.nextInt();
								if(num>0 && num <=admin.branches[secondchoice].employees[forthchoice].getCargosize()) {
									temp.updateStatus(admin.branches[secondchoice].employees[forthchoice].cargos[num-1]);
								}
							 
							 admin.branches[secondchoice].personel[thirdchoice]=temp;
							 System.out.println("You update the cargo and cargo is given to its owner");
						 break;
				case 4 : 
						System.out.println("Please enter your tracking number");
						Scanner scannerlast = new Scanner( System.in );
						String tracking= scannerlast.nextLine();
						for(int i=0;i<admin.getBranchsize();i++) {
							for(int j=0;j<admin.branches[i].getEmployeesize();j++) {
								for(int k=0;k<admin.branches[i].employees[j].getCargosize();k++) {
									if(tracking.equals(admin.branches[i].employees[j].cargos[k].getTrackingNumber())) {
										control=1;
										System.out.println("Sender Name : "+admin.branches[i].employees[j].cargos[k].getSenderName());
										System.out.println("Receiver Name :"+ admin.branches[i].employees[j].cargos[k].getReceiverName());
										System.out.print("Current Status : ");
										if(admin.branches[i].employees[j].cargos[k].isStatus()==false) {
											System.out.print("In "+(i+1)+".Branch "+(j+1)+".Employee\n");
										}
										else {
											System.out.print("Cargo leaved "+(i+1)+".Brach and "+(j+1)+".Employee\n");
										}
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
	public static int branchmenu(Administrator admin) {
		
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
	public static int employeemenu(Administrator admin,int index) {
		
		if(admin.branches[index].getEmployeesize()==0) {
			System.out.println("There is not any employee please first add a employee by administrator!");
			return -1;
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose one of them");
		if(admin.branches[index].getEmployeesize()>0) {
			for(int i=0;i<admin.branches[index].getEmployeesize();i++) {
				System.out.println((i+1)+".Employee");
			}
		}
		int another = scanner.nextInt();
		return another;
		
	}
	/**
	 * This is personel menu that you select transportation personel
	 * @param admin
	 * @param index
	 * @return
	 */
	public static int personelmenu(Administrator admin,int index) {
		if(admin.branches[index].getPersonelsize()==0) {
			System.out.println("There is not any personel please first add a personel by administrator!");
			return -1;
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose one of them");
		if(admin.branches[index].getPersonelsize()>0) {
			for(int i=0;i<admin.branches[index].getPersonelsize();i++) {
				System.out.println((i+1)+".Personel");
			}
		}
		int another = scanner.nextInt();
		return another;
	}

}
