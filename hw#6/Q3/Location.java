/**
 * Location class to hold location and status
 * @author mustafa
 *
 */
public class Location {
    private String loc;
    private boolean status;
    /**
     * 2 parameter constructor
     * @param loc
     * @param status
     */
    Location(String loc,boolean status){
        this.loc=loc;
        this.status=status;
    }
    /**
     * getter for location
     * @return
     */
    public String getLoc() {
        return loc;
    }
    /**
     * Setter for location
     * @param loc
     */
    public void setLoc(String loc) {
        this.loc = loc;
    }
    /**
     * getter for status
     * @return
     */
    public boolean isStatus() {
        return status;
    }
    /**
     * Setter for status
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}
