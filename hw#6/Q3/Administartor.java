import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.util.Iterator;

public class Administartor implements AdministratorInterface {
    private Map<String,Map<String,Set<Location>>> books;
    /**
     * no parameter constructor
     */
    public Administartor() {
        books = new HashMap<>();
    }
    /**
     * adding book to map
     */
    @Override
    public void addBook(Book newBook){
        int check=0;
            if(books.containsKey(newBook.getAuthor())==true){
                    Map<String, Set<Location>> already = books.get(newBook.getAuthor());
                    for(Map.Entry<String,Set<Location>> entry : already.entrySet()){
                        if(entry.getKey().equals(newBook.getName())){
                            check=1;
                        }
                    }
                    if(check==1) {
                        Set<Location> book = already.get(newBook.getName());
                        if (book != null) {

                            book.add(newBook.getLocationObject());
                            already.replace(newBook.getName(), book);
                            books.replace(newBook.getAuthor(), already);
                        } else {
                            Set<Location> temploc = new HashSet<>();
                            temploc.add(newBook.getLocationObject());
                            already.replace(newBook.getName(), temploc);
                            books.replace(newBook.getAuthor(), already);
                        }
                    }
                    else{
                        Set<Location> temploc = new HashSet<>();
                        temploc.add(newBook.getLocationObject());
                        already.put(newBook.getName(), temploc);
                        books.replace(newBook.getAuthor(), already);

                    }

            }
            else {
                Set<Location> temp1 = new HashSet<Location>();
                temp1.add(newBook.getLocationObject());
                Map<String,Set<Location>>  came = new HashMap<>();
                came.put(newBook.getName(),temp1);
                books.put(newBook.getAuthor(),came);
            }
    }
    /**
     * deleting book
     */
    @Override
    public void deleteBook(Book deletingBook){
        if(books.containsKey(deletingBook.getAuthor())==true){
            Map<String,Set<Location>> already = books.get(deletingBook.getAuthor());
            Set<Location> temp= already.get(deletingBook.getName());
            if(temp.size()==1) {
                already.remove(deletingBook.getName());
                books.replace(deletingBook.getAuthor(), already);
                if (already.size() == 0) {
                    books.remove(deletingBook.getAuthor());
                }
            }
            else{
                Iterator<Location> it=temp.iterator();
                for(int i=0;i<temp.size()-2;i++){
                    it.next();
                }
                temp.remove(it.next());
                already.replace(deletingBook.getName(),temp);
                books.replace(deletingBook.getAuthor(),already);
            }
        }
    }
    /**
     * showing books
     */
    @Override
    public void showBooks(){
        int count=1;
        for (Map.Entry<String,Map<String,Set<Location>>> entry : books.entrySet()) {
            System.out.println("Author Name : " + entry.getKey());
            Map<String,Set<Location>> temp = entry.getValue();
            for(Map.Entry<String,Set<Location>> entry2 : temp.entrySet()) {
                System.out.println("Name of the book is :" + entry2.getKey());
                    Iterator<Location> temp2 = entry2.getValue().iterator();
                    System.out.println("Locations are : ");
                    while(temp2.hasNext()){
                        
                        Location a = temp2.next();
                         System.out.print(count+" . ");
                        System.out.print(a.getLoc() + " " +" Status : "  );
                        if(a.isStatus()==false)
                            System.out.print("available");
                        else
                            System.out.print("not available");
                        System.out.println();
                        count++;
                    }
                    System.out.println();
            }
        }
    }
    /**
     * update status
     */
    @Override
    public void updateStatus(int choice){
        int count=1;
        for (Map.Entry<String,Map<String,Set<Location>>> entry : books.entrySet()) {
            Map<String,Set<Location>> temp = entry.getValue();
            for(Map.Entry<String,Set<Location>> entry2 : temp.entrySet()) {
                Iterator<Location> temp2 = entry2.getValue().iterator();
                while(temp2.hasNext()){
                    Location deleting=temp2.next();
                    if(count==choice){
                        Location adding = new Location(deleting.getLoc(),true);
                        books.get(entry.getKey()).get(entry2.getKey()).remove(deleting);
                        books.get(entry.getKey()).get(entry2.getKey()).add(adding);
                        return;
                    }
                    count++;
                }
            }
        }
    }
    /**
     * update location
     */
    @Override
    public void updateLocation(int choice,String locate){
        int count=1;
        for (Map.Entry<String,Map<String,Set<Location>>> entry : books.entrySet()) {
            Map<String,Set<Location>> temp = entry.getValue();
            for(Map.Entry<String,Set<Location>> entry2 : temp.entrySet()) {
                Iterator<Location> temp2 = entry2.getValue().iterator();
                while(temp2.hasNext()){
                    Location deleting=temp2.next();
                    if(count==choice){
                        Location adding = new Location(locate,deleting.isStatus());
                        books.get(entry.getKey()).get(entry2.getKey()).remove(deleting);
                        books.get(entry.getKey()).get(entry2.getKey()).add(adding);
                        return;
                    }
                    count++;
                }
            }
        }
    }
    /**
     * deleting books
     */
    @Override
    public boolean deleteBook(int choice){
        int count=1;
        for (Map.Entry<String,Map<String,Set<Location>>> entry : books.entrySet()) {
            Map<String,Set<Location>> temp = entry.getValue();
            for(Map.Entry<String,Set<Location>> entry2 : temp.entrySet()) {
                Iterator<Location> temp2 = entry2.getValue().iterator();
                while(temp2.hasNext()){
                    Location a = temp2.next();
                    if(count==choice){
                        Book deleting = new Book(entry.getKey(),entry2.getKey(),a.getLoc());
                        deleting.setStatus(a.isStatus());
                        deleteBook(deleting);
                        return true;
                    }
                    count++;
                }
            }
        }
        return false;
    }
    /**
     * updates title of the book
     */
    @Override
    public void updateName(int choice,String name){
        int count=1;
        for (Map.Entry<String,Map<String,Set<Location>>> entry : books.entrySet()) {
            Map<String,Set<Location>> temp = entry.getValue();
            for(Map.Entry<String,Set<Location>> entry2 : temp.entrySet()) {
                Iterator<Location> temp2 = entry2.getValue().iterator();
                while(temp2.hasNext()){
                    temp2.next();
                    if(count==choice){
                        books.get(entry.getKey()).put(name,entry2.getValue());
                        books.get(entry.getKey()).remove(entry2.getKey());
                        return;
                    }
                    count++;
                }
            }
        }
    }
    /**
     * showing book with respect to given name
     * @param name
     */
    public void showBook(String name){
        for (Map.Entry<String,Map<String,Set<Location>>> entry : books.entrySet()) {
            Map<String,Set<Location>> temp = entry.getValue();
            for(Map.Entry<String,Set<Location>> entry2 : temp.entrySet()) {
                Iterator<Location> temp2 = entry2.getValue().iterator();
                if(entry2.getKey().equals(name)){
                    System.out.println("Author Name : " + entry.getKey());
                    System.out.println("Title : "+entry2.getKey());
                     System.out.println("Locations are : ");
                     while(temp2.hasNext()){
                       Location a= temp2.next();
                             System.out.print(a.getLoc() + " " +" Status : "  );
                             if(a.isStatus()==false)
                                 System.out.print("available");
                             else
                                 System.out.print("not available");
                             System.out.println();

                     }
                }
            }
        }
    }
    /**
     * updates author names
     */
    @Override
    public void updateAuthor(String oldAuthor ,String newAuthor){
        for (Map.Entry<String,Map<String,Set<Location>>> entry : books.entrySet()) {
            if(entry.getKey().equals(oldAuthor)){
                    Map<String,Set<Location>> obj=books.get(entry.getKey());
                    books.remove(entry.getKey());
                    books.put(newAuthor,obj);
                    return;
            }
        }

    }
    /**
     * showing locations 
     */
    @Override
    public void showLocation(String author_name){
        int count=1;
        for (Map.Entry<String,Map<String,Set<Location>>> entry : books.entrySet()) {
            Map<String,Set<Location>> temp = entry.getValue();
                if(author_name.equals(entry.getKey())) {
                    System.out.println("Author Name : " + entry.getKey());
                    for(Map.Entry<String,Set<Location>> entry2 : temp.entrySet()){
                        System.out.println(count +" . "+entry2.getKey());
                        count++;
                    }
                    System.out.println("Select one of book");
                    Scanner scan = new Scanner(System.in);
                    int choice=scan.nextInt();
                    count=1;
                    for(Map.Entry<String,Set<Location>> entry2 : temp.entrySet()){
                        if(count==choice){
                            Iterator<Location> temp2 = entry2.getValue().iterator();
                            if(count>2)
                                System.out.print(count+" . ");
                            System.out.print("Locations are : \n");
                            while(temp2.hasNext()){
                                count++;
                                Location a = temp2.next();
                                System.out.print(a.getLoc() + " " +" Status : "  );
                                if(a.isStatus()==false)
                                    System.out.print("available");
                                else
                                    System.out.print("not available");
                                System.out.println();
                            }
                            System.out.println();
                            return;
                        }
                        count++;
                    }

                }
        }
    }

}
