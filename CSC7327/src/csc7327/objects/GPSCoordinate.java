/**
 * 
 */
package csc7327.objects;

/**
 * The {@link GPSCoordinate} present the information about GPS coordinate of a checkin
 * @author luongnv89
 *
 */
public class GPSCoordinate {
	/**
	 * The latitude of GPS
	 */
	float latitude;
	/**
	 * The longitude of GPS
	 */
	float longitude;
	/**
	 * @param latitude
	 * @param longitude
	 */
	public GPSCoordinate(float latitude, float longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	/**
	 * @return the latitude
	 */
	public float getLatitude() {
		return latitude;
	}
	/**
	 * @return the longitude
	 */
	public float getLongitude() {
		return longitude;
	}
	
}
