
public class Cargo {
	private String senderName;
	private String receiverName;
	private String trackingNumber;
	private String address;
	private boolean status;
	/**
	 * This is no parameter constructer
	 */
	Cargo(){
		this.senderName="";
		this.receiverName="";
		this.trackingNumber="";
		this.address="";
		this.status=false;
	}
	/**
	 * This is constructer 
	 * @param sender
	 * @param receiver
	 * @param trackingnum
	 * @param addres
	 */
	Cargo(String sender,String receiver,String trackingnum,String addres){
		this.senderName=sender;
		this.receiverName=receiver;
		this.trackingNumber=trackingnum;
		this.address=addres;
		this.status=false;
	}
	/**
	 * This is getter for address
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This is setter for address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * This is getter for sender
	 * @return
	 */
	public String getSenderName() {
		return senderName;
	}
	/**
	 * This is setter for sender
	 * @param senderName
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	/**
	 * This is getter for receiver
	 * @return
	 */
	public String getReceiverName() {
		return receiverName;
	}
	/**
	 * This is setter for receiver
	 * @param receiverName
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	/**
	 * This is getter for tracking number
	 * @return
	 */
	public String getTrackingNumber() {
		return trackingNumber;
	}
	/**
	 * This is setter for tracking number
	 * @param trackingNumber
	 */
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	/**
	 * This is getter for status
	 * @return
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * This is setter for status
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
