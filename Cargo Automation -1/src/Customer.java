/**
 * This is Customer Class
 * @author Mustafa Tokgöz 171044077
 *
 */
public class Customer {
	private String name;
	private String trackingnum;
	/**
	 * This is no parameter constructer
	 */
	Customer(){
		this.name="";
		this.trackingnum="";
	}
	/**
	 * This is constructer 
	 * @param Name
	 * @param trackingNumber
	 */
	Customer(String Name,String trackingNumber){
		this.name=Name;
		this.trackingnum=trackingNumber;
	}
	/**
	 * This is getter for name
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * This is setter for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This is getter for trackingnum
	 * @return
	 */
	public String getTrackingnum() {
		return trackingnum;
	}
	/**
	 * This is setter for trakingnum
	 * @param trackingnum
	 */
	public void setTrackingnum(String trackingnum) {
		this.trackingnum = trackingnum;
	}
	
}
