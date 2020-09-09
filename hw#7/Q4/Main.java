import java.util.Scanner;
/**
 * Main Class to test
 * @author mustafa
 *
 */
public class Main {
	 public static void main(String[] args){
	        boolean check = true;
	        int choice;
	        Administrator admin =  new Administrator();
	        admin.add(new Software("AdobePhotoshop 6.0",1,0));
	        admin.add(new Software("AdobePhotoshop 6.2",1,0));
	        admin.add(new Software("Norton 4.5",1,0));
	        admin.add(new Software("Norton 5.5",1,0));
	        admin.add(new Software("AdobeFlash 3.3",1,0));
	        admin.add(new Software("AdobeFlash 4.0",1,0));
	        System.out.println("Welcome to Software Store System");
	        while(check){
	            System.out.println();
	            System.out.println("Choose one of them to continue");
	            System.out.println("1 : Enter the system as a Administrator");
	            System.out.println("2 : Search software by  name");
	            System.out.println("3 : Look Softwares");
	            System.out.println("0 : Exit");
	            System.out.println();
	            Scanner scan = new Scanner(System.in);
	            choice = scan.nextInt();
	            switch (choice){
	                case 1 : System.out.println("Enter password");
	                    if(scan.next().equals("1234")==true){
	                        System.out.println();
	                        System.out.println("1 : Add Software");
	                        System.out.println("2 : Delete Software");
	                        System.out.println("3 : Update Informations");
	                        int choice2=scan.nextInt();
	                        Scanner scan2 = new Scanner(System.in);
	                        Scanner scan3 = new Scanner(System.in);
	                        switch (choice2){
	                            case 1 :
	                                System.out.println("Enter Name of Software : ");
	                                String name=scan2.nextLine();
	                                System.out.println("Enter Price of Software : ");
	                                double price = scan3.nextDouble();
	                                Software temp=new Software(name,1,price);
	                                admin.add(temp);
	                                break;
	                            case 2 : System.out.println("Enter name of the Software to delete");
	                                admin.showSoftwares();
	                                String name2=scan2.nextLine();
	                                admin.delete(new Software(name2,0,0));
	                                break;
	                            case 3 :
	                                System.out.println("1 : Update Name");
	                                System.out.println("2 : Increase Quantity of Software");
	                                System.out.println("3 : Sell Software");
	                                System.out.println("4 : Change price of the Software");
	                                int update=scan.nextInt();
	                                admin.showSoftwares();
	                                if(update == 1){
	                                    System.out.println("Enter name of an Software");
	                                    String old_name=scan2.nextLine();
	                                    System.out.println("Enter new name of the Software");
	                                    String new_name = scan2.nextLine();
	                                    admin.setNameofSoftware(old_name, new_name);
	                                }
	                                else if(update == 2){

	                                    System.out.println("Enter the name of the Software");
	                                    String nameOfSoftware=scan2.nextLine();
	                                    admin.increaseQuantity(nameOfSoftware);
	                                }
	                                else if(update == 3){
	                                    System.out.println("Enter name of the Software ");
	                                    String nameOfSoftware=scan2.nextLine();
	                                    admin.decreaseQuantity(nameOfSoftware);
	                                }
	                                else if(update == 4){
	                                    System.out.println("Enter name of the Software ");
	                                    String nameOfSoftware=scan2.nextLine();
	                                    System.out.println("Enter new price of this Software");
	                                    double price2=scan3.nextDouble();
	                                    admin.setPriceofSoftware(nameOfSoftware, price2);
	                                }
	                                else{
	                                    System.out.println("There is no changing");
	                                }
	                                break;
	                            default: break;

	                        }
	                    }
	                    break;
	                case 2 : Scanner scan2=new Scanner(System.in);
	                    System.out.println("Enter Software name");
	                    String name=scan2.nextLine();
	                    admin.showSoftware(name);
	                    break;
	                case 3: 
	                		admin.showSoftwares();
	                		break;
	                case 0 : check=false;
	                    break;
	                default: break;
	            }
	        }
	    }
}
