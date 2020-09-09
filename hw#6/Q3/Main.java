import java.util.Random;
import java.util.Scanner;
/**
 * Main class 
 * @author mustafa
 *
 */
public class Main {
    public static void main(String[] args){
        boolean check = true;
        int choice;
        Administartor admin =  new Administartor();
        System.out.println("Welcome to Library System");
        while(check){
            System.out.println();
            System.out.println("Choose one of them to continue");
            System.out.println("1 : Enter the system as a Administrator");
            System.out.println("2 : Search book by author name");
            System.out.println("3 : Search book by title");
            System.out.println("0 : Exit");
            System.out.println();
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch (choice){
                case 1 : System.out.println("Enter password");
                    if(scan.next().equals("1234")==true){
                        System.out.println();
                        System.out.println("1 : Add Book");
                        System.out.println("2 : Delete Book");
                        System.out.println("3 : Update Information");
                        int choice2=scan.nextInt();
                        Scanner scan2 = new Scanner(System.in);
                        switch (choice2){
                            case 1 :
                                System.out.println("Enter Author  : ");
                                String author=scan2.nextLine();
                                System.out.println("Enter Title  : ");
                                String title=scan2.nextLine();
                                System.out.println("Enter Shelf  : ");
                                Integer shelf=scan.nextInt();
                                System.out.println("Enter Corridor  : ");
                                Integer coridor=scan.nextInt();
                                Random rand = new Random();
                                Integer random=rand.nextInt(5000);
                                String location='c'+coridor.toString()+'s'+shelf.toString()+'.'+ random.toString();
                                Book newBook=new Book(author,title,location);
                                admin.addBook(newBook);
                                break;
                            case 2 : System.out.println("Select a book to delete");
                                admin.showBooks();
                                int number=scan.nextInt();
                                admin.deleteBook(number);
                                break;
                            case 3 :
                                System.out.println("1 : Update Author");
                                System.out.println("2 : Update Title");
                                System.out.println("3 : Update Location");
                                System.out.println("4 : Update Status");
                                int update=scan.nextInt();
                                admin.showBooks();
                                if(update == 1){
                                    System.out.println("Enter name of an author");
                                    String old_name=scan2.nextLine();
                                    System.out.println("Enter new name of the author");
                                    String name = scan2.nextLine();
                                    admin.updateAuthor(old_name,name);
                                }
                                else if(update == 2){

                                    System.out.println("Enter number of book");
                                    number=scan.nextInt();
                                    System.out.println("Enter new name of the book");
                                    String name=scan2.nextLine();
                                    admin.updateName(number,name);
                                }
                                else if(update == 3){
                                    System.out.println("Enter number of the book ");
                                    number=scan.nextInt();
                                    System.out.println("Enter Shelf  : ");
                                    shelf=scan.nextInt();
                                    System.out.println("Enter Corridor  : ");
                                    coridor=scan.nextInt();
                                    System.out.println("Enter number that is random after point");
                                    String temp=scan2.nextLine();
                                    String new_location='c'+coridor.toString()+'s'+shelf.toString()+'.'+ temp;
                                    admin.updateLocation(number,new_location);
                                }
                                else if(update == 4){
                                    System.out.println("Enter number of the book ");
                                    number=scan.nextInt();
                                    admin.updateStatus(number);
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
                    System.out.println("Enter author name");
                    String name=scan2.nextLine();
                    admin.showLocation(name);
                    break;
                case 3 : Scanner scan3=new Scanner(System.in);
                    System.out.println("Enter book name");
                    String book_name=scan3.nextLine();
                    admin.showBook(book_name);
                    break;
                case 0 : check=false;
                    break;
                default: break;
            }
        }
    }
}
