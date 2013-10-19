/**
 * 
 */
package csc7327.analysis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import csc7327.objects.CheckIn;

/**
 * @author luongnv89
 *
 */
public class DataAnalysis {
	/**
	 * The name of the city where the data is collected
	 */
	String cityName;
	/**
	 * The url to get the data source file
	 */
	String dataURL;
	/**
	 * List all the checkins of the city
	 */
	ArrayList<CheckIn> checkInCollections;
	/**
	 * @param cityName
	 * @param dataURL
	 */
	public DataAnalysis(String cityName, String dataURL) {
		this.cityName = cityName;
		this.dataURL = dataURL;
		this.checkInCollections = loadData();
	}
	/**
	 * @param dataURL2
	 * @return
	 */
	private ArrayList<CheckIn> loadData() {
		ArrayList<CheckIn> listAllCheckin = new ArrayList<>();
		
		try {
			InputStream inputs = new FileInputStream(dataURL);
			InputStreamReader inputReader = new InputStreamReader(inputs);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(inputReader);
			String checkInString = br.readLine();
			while(checkInString!=null){
				listAllCheckin.add(new CheckIn(checkInString));
				checkInString = br.readLine();
			}
		} catch (Exception e) {
			System.out.println("Some thing wrong!\n");
			e.printStackTrace();
		}
		
		return listAllCheckin;
	}
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @return the checkInCollections
	 */
	public ArrayList<CheckIn> getCheckInCollections() {
		return checkInCollections;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = "DataSet  of city: " + cityName + "\n dataURL=" + dataURL
				+ "\n All the checkIn:\n";
		for(int i=0;i<checkInCollections.size();i++){
			str+=checkInCollections.get(i).toString();
		}
		return str;
	}
	
	// ANALYSIS PART
	public void getVenueCategoriesTag(){
		
	}
	
}