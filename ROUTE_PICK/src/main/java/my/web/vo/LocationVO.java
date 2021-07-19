package my.web.vo;

public class LocationVO {
	String latitude, longitude, address;

	public LocationVO() {
		super();
	}
	
	public LocationVO(String address) {
		super();
		setAddress(address);
		//setLatitude(latitude);
		//setLongitude(longitude);
	}
	
	public LocationVO(String latitude, String longitude) {
		super();
		setLatitude(latitude);
		setLongitude(longitude);
	}

	public LocationVO(String latitude, String longitude, String address) {
		super();
		setLatitude(latitude);
		setLongitude(longitude);
		setAddress(address);
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
