/**
 * This is Book class 
 * @author mustafa
 *
 */
public class Book {
    private String author;
    private String name;
    private Location location;
    /**
     * 3 parameter constructor 
     * @param author
     * @param name
     * @param location
     */
    public Book(String author,String name ,String location ) {
        this.location= new Location(location,false);
        this.author = author;
        this.name = name;
    }
    /**
     * getter for author
     * @return
     */
    public String getAuthor() {
        return author;
    }
	/**
	 * getter for location
	 * @return
	 */
    public String getLocation() {
        return location.getLoc();
    }
    /**
     * getter for book name
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * getter for status
     * @return
     */
    public boolean isStatus() {
        return this.location.isStatus();
    }
    /**
     * Setter for status
     * @param status
     */
    public void setStatus(boolean status) {
        this.location.setStatus(status);
    }
    /**
     * setter for author
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * setter for location 
     * @param location
     */
    public void setLocation(String location) {
        this.location.setLoc(location);
    }
    /**
     * getter for location object
     * @return
     */
    public Location getLocationObject(){
        return this.location;
    }
    /**
     * Setter for  location object
     * @param location
     */
    public void setLocationObject(Location location) {
        this.location = location;
    }
    /**
     * Setter for book name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * ToString method
     */
    @Override
    public String toString() {
        String temp = "available";
        String temp2 = "not available";
        if(location.isStatus()!=true)
            temp=temp2;
        return "Book{" +
                "author='" + author + '\'' +
                ", location='" + location.getLoc() + '\'' +
                ", name='" + name + '\'' + "status : " + temp +
                '}';
    }
}
